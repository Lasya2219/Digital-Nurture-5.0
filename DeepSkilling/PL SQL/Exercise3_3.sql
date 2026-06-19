create or replace procedure TransferFunds (
    from_accountid in NUMBER,
    to_accountid in NUMBER,
    amount in NUMBER
) is
    from_balance NUMBER;
    to_balance number;
begin
    select balance into from_balance
    from accounts
    where accountid = from_accountid;

    select balance into to_balance
    from accounts
    where accountid = to_accountid;

    if from_balance-amount>=0 THEN
        update accounts
        set BALANCE = from_balance-amount
        where accountid = from_accountid;
        
        update accounts
        set BALANCE = to_balance+amount
        where accountid = to_accountid;
    else
        dbms_output.PUT_LINE('Not enough funds to transfer');
    end if;
end;
/

exec TRANSFERFUNDS(1,2, 200);