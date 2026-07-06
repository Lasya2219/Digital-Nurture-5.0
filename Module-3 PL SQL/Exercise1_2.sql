BEGIN
    FOR cust_rec IN (
        SELECT CustomerID, Balance
        FROM CUSTOMERS
    )
    LOOP
        IF cust_rec.Balance>10000 THEN
            UPDATE CUSTOMERS
            SET ISVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Customer ' ||  cust_rec.CustomerID || ' marked as VIP');
        ELSE 
            UPDATE CUSTOMERS
            SET ISVIP = 'FALSE'
            WHERE CustomerID = cust_rec.CustomerID;

        END IF;
    END LOOP;

    COMMIT;
END;
/