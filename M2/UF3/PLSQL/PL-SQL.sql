set serveroutput on;

/*1.*/
/*variable nom_dep varchar2;
begin
select d.department_name 
into :nom_dep
from departments d, employees e
where e.department_id = d.department_id and e.last_name='Fay';
end;
/
print nom_dep;*/


/*2.*/
/*accept id_emp prompt 'Introduce el id: ';
variable region varchar2;
begin
select r.region_name 
into :region
from departments d, employees e, countries c, regions r, locations l
where e.employee_id=100 and r.region_id=c.region_id and l.country_id = c.country_id and l.location_id=d.location_id and e.department_id = d.department_id;
end;
/
print region;*/


/*3.*/
/*begin
dbms_output.put_line ('HOLA MUNDO');
dbms_output.put_line ('FIN DEL PROGRAMA');
end;
/*/


/*4.*/
/*variable nom_dep varchar2;
begin
select department_name 
into :nom_dep
from departments d, employees e
where e.department_id = d.department_id and e.last_name='Fay';
end;
/
print nom_dep;*/


/*5.*/
/*accept id_emp prompt 'Introduce el id: ';
variable region varchar2;
begin
select r.region_name 
into :region
from departments d, employees e, countries c, regions r, locations l
where e.employee_id=100 and r.region_id=c.region_id and l.country_id = c.country_id and l.location_id=d.location_id and e.department_id = d.department_id;
end;
/
print region;*/


/*6.*/
/*declare
num1 number := 10.2;
num2 number := 20.1;
total number := num1 + num2 ;
begin
dbms_output.put ('LA SUMA TOTAL ES: ');
dbms_output.put_line (total);
end;
/*/


/*7.*/
/*declare
  nombres employees.first_name%type;
  cont number;
  i number:=0;
begin
  select count(employee_id)
  into cont
  from employees;
  while i<=cont loop
    select upper(first_name) 
    into nombres
    from employees
    where employee_id=i+100;
    dbms_output.put_line(nombres);
    i:=i+1;
  end loop;
end;
/*/

/*8.*/
/*accept id_emp prompt 'Introduce el id:';
declare
  porcentage number := 10;
  emp employees%ROWTYPE;
begin
  select *
  into emp
  from employees 
  where employee_id=&id_emp;
  dbms_output.put_line('Se ha realizado un aumento de sueldo a:');
  dbms_output.put_line('El usuario con id: '||emp.employee_id);
  /*dbms_output.put_line('El usuario con Nombre: '||emp.first_name||' y apellido '||emp.last_name||' que pertenece al departamento '||emp.department_name);
  dbms_output.put_line('El salario inicial era: '||emp.salary||' y ahora el nuevo salario es '||emp.salary*porcentage);
end;
/*/
