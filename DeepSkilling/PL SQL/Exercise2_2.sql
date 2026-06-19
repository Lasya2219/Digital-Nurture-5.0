create or replace procedure UpdateSalary(
    employee_id in NUMBER,
    percentage in number
)
is
    p_salary number;
    u_salary number;
    no_employee EXCEPTION;
begin
    if employee_id is NULL then
        raise no_employee;
    end if;

    select salary into p_salary
    from Employees
    where employeeid = employee_id;

    update Employees
    set salary = salary+(salary*percentage/100)
    where employeeid = employee_id;

    select salary into u_salary
    from Employees
    where employeeid = employee_id;

    dbms_output.put_line('Updated Salary from '|| p_salary || ' to ' || u_salary);

EXCEPTION
    when no_employee then
        DBMS_OUTPUT.PUT_LINE('No Employee id passed as parameters');
    when others THEN
        rollback;
        DBMS_OUTPUT.PUT_LINE(sqlerrm);

end;
/

exec UpdateSalary(1, 10);