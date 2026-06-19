create or REPLACE PROCEDURE AddNewCustomer(
    customer_id in NUMBER,
    c_name in VARCHAR2,
    c_dob in date,
    c_balance in NUMBER,
    cisvip in VARCHAR2
)
is 
begin
    insert into customers (
        Customerid,
        name,
        dob,
        balance,
        lastmodified,
        isvip
    ) values (
        customer_id,
        c_name,
        c_dob,
        c_balance,
        sysdate,
        cisvip
    );

    commit;
    DBMS_OUTPUT.PUT_LINE('Customer Added Successfully');
exception
    when DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

EXEC AddNewCustomer(3,'Tom',DATE '2000-01-01',5000,'FALSE');