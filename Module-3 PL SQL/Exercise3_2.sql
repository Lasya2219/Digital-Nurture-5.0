create or replace PROCEDURE UpdateEmployeeBonus(
    dept in VARCHAR2,
    bonus in NUMBER
) is
begin
    update Employees
    set salary = salary+(salary*bonus/100)
    where department = dept;

    commit;
    dbms_output.put_line('Employee Salary Updated.');
end;
/

EXEc UPDATEEMPLOYEEBONUS('IT', 10);