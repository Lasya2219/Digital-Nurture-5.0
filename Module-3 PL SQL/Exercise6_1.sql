declare 
    cursor ApplyAnnualFee is 
        SELECT Accountid
        FROM Accounts;

    v_accountid Accounts.Accountid%TYPE;

    annual_fee number := 500;

begin
    open ApplyAnnualFee;

    loop
        fetch ApplyAnnualFee into v_accountid;

        exit when ApplyAnnualFee%NOTFOUND;

        Update Accounts
        set balance = Balance - annual_fee
        WHERE AccountID = v_accountid;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee deducted from Account ' ||
            v_accountid
        );
    end loop;

    close ApplyAnnualFee;

    commit;
end;
/
