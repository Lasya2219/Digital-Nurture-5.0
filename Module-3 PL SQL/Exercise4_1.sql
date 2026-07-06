create or replace FUNCTION CalculateAge(
    p_dob DATE
)
return NUMBER
IS
    age NUMBER;
begin
    age := floor(months_between(sysdate, p_dob)/12);
    return age;
end;
/

DECLARE
    age number;
begin
    for cust_rec in(
        select name, dob
        from CUSTOMERS
    )
    loop 
        age := CalculateAge(cust_rec.dob);
        dbms_output.put_line('Age of Customer '|| cust_rec.name || ': '|| age);
    end loop;
end;
/ 

