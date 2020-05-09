SET SERVEROUTPUT ON

create or replace procedure Mani_ejercicio1(codigo number)
as
var_cod employees.employee_id%TYPE;
var_nom employees.first_name%TYPE;
var_trabajo employees.job_id%TYPE;
var_salario employees.salary%TYPE;
begin
select employee_id, first_name, job_id, salary
into var_cod, var_nom, var_trabajo, var_salario
from employees
where employee_id=codigo;
dbms_output.put_line('CODIGO   NOMBRE   TRABAJO   SALARIO');
dbms_output.put_line(var_cod||'      '||var_nom||'   '||var_trabajo||'   '||var_salario);
end Mani_ejercicio1;
/