create or replace PROCEDURE SafeTransferFunds(
    from_account_id in number,
    to_account_id in NUMBER,
    amount in NUMBER
) IS
from_balance NUMBER;
to_balance NUMBER;
no_balance EXCEPTION;
BEGIN
    select Balance into from_balance
    from Accounts
    where accountid = from_account_id;

    select Balance into to_balance
    from Accounts
    where accountid = to_account_id;

    if from_balance-amount<0 then
        raise no_balance;
    end if;

    update Accounts
    set Balance = Balance - from_balance
    where accountid = from_account_id;

    update Accounts
    set Balance = Balance + to_balance
    where accountid = to_account_id;

    commit;

    dbms_output.put_line('Funds transfered');

exception
    when no_balance then
        dbms_output.put_line('Account does not contain sufficient Funds.');

    when others then
        rollback;
        dbms_output.put_line(sqlerrm);

end;
/

    
exec SafeTransferFunds(2,1, 500);     
