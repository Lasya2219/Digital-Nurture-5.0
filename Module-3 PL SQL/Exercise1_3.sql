begin
    FOR loan_rec in (
        select l.loanid, c.name,
        c.customerid, l.enddate
        from Loans l join Customers c on l.customerid = c.customerid
        where l.enddate between sysdate and sysdate+30
    )
    Loop
        dbms_output.put_line('Reminder: Loan ID ' || loan_rec.LoanID ||
            ' for customer ' || loan_rec.Name ||
            ' is due on ' || TO_CHAR(loan_rec.EndDate,'DD-MON-YYYY'));

    end loop;
end;
/