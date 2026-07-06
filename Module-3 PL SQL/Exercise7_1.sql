CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_empid NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_empid NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    );

    FUNCTION CalculateAnnualSalary(
        p_empid NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_empid NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    )
    IS
    BEGIN
        INSERT INTO Employees (
            EmployeeID,
            Name,
            Position,
            Salary,
            Department
        )
        VALUES (
            p_empid,
            p_name,
            p_position,
            p_salary,
            p_department
        );

        DBMS_OUTPUT.PUT_LINE('Employee Hired Successfully');
    END HireEmployee;


    PROCEDURE UpdateEmployee(
        p_empid NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    )
    IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Salary = p_salary,
            Department = p_department
        WHERE EmployeeID = p_empid;

        DBMS_OUTPUT.PUT_LINE('Employee Details Updated');
    END UpdateEmployee;


    FUNCTION CalculateAnnualSalary(
        p_empid NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_empid;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/

BEGIN 
    EmployeeManagement.HireEmployee(103,'Snow','Engineer',50000,'IT'); 
END;
/