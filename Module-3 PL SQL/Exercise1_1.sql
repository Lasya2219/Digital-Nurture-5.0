DECLARE
    age NUMBER;
BEGIN
    FOR cust_rec in (
        select customerID, DOB
        from CUSTOMERS
    )

    LOOP 
        age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust_rec.DOB)/12);

        IF age>60 THEN
            UPDATE LOANS
            SET INTERESTRATE = INTERESTRATE-1
            WHERE customerID = cust_rec.customerID;

            dbms_output.put_line('Discount Applied For ID: ' || cust_rec.customerID);
        
        END IF;
    END LOOP;

    COMMIT;
END;
/