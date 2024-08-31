# First step
#SELECT department.name as 'Department', employee.name as 'Employee', employee.salary as 'Salary' FROM department Department INNER JOIN employee Employee on employee.departmentId = department.id

#Second step
#SELECT department.name as 'Department', employee.name as 'Employee', employee.salary as 'Salary', 
#DENSE_RANK() OVER (PARTITION BY department.name ORDER BY employee.salary DESC) rank 
#FROM Employee employee INNER JOIN Department department ON employee.departmentId = department.id

#Third step
#SELECT Department, Employee, Salary FROM   
#(
#   SELECT department.name as 'Department', employee.name as 'Employee', employee.salary as 'Salary',  
#    DENSE_RANK() OVER (PARTITION BY department.name ORDER BY employee.salary DESC) AS mrank FROM Employee employee 
#    INNER JOIN Department department ON employee.departmentId = department.id
#) rankedEmp
#WHERE mrank <  4 ORDER BY Department, mrank

#Solution
WITH rankedEmp AS (
    SELECT department.name as 'Department', employee.name as 'Employee', employee.salary as 'Salary',  
    DENSE_RANK() OVER (PARTITION BY department.name ORDER BY employee.salary DESC) AS mrank FROM Employee employee 
    INNER JOIN Department department ON employee.departmentId = department.id
)
SELECT Department, Employee, Salary FROM rankedEmp WHERE mrank <  4 ORDER BY Department, mrank