create or replace function HasSufficientBalance(
    balance in number,
    amount in number
)
return boolean
is
begin
    if balance-amount>=0 then
        return true;
    else
        return false;
    end if;
end;
/

declare
    isSufficient boolean;
    amount number := &amount;
begin
    for acc_rec in (
        select balance, accountid
        from Accounts
    )
    loop 
        isSufficient := HasSufficientBalance(acc_rec.balance, amount);
        if isSufficient THEN
            dbms_output.put_line('Account '|| acc_rec.accountid || ' has Sufficient Balance to make transaction of '||amount);
        else
            dbms_output.put_line('Account '|| acc_rec.accountid || ' has Insufficient Balance to make transaction of '||amount);
        end if;

    end loop;
end;
/
