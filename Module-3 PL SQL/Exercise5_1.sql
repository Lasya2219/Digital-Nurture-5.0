create or replace trigger UpdateCustonerLastModified
before update on Customers
for each row 
BEGIN
    :NEW.LastModified := Sysdate;
    dbms_output.PUT_LINE('LastModified updated.');
end;
/

UPDATE Customers
set name = 'Jon Snow'
where customerid = 1;