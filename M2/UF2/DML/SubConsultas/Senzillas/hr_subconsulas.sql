select e.first_name, e.last_name from locations l, employees e, departments d 
where e.department_id = d.department_id and
l.location_id = d.location_id;

select e.first_name, e.last_name, d.department_name from employees e, departments d 
where e.employee_id=d.manager_id;

select distinct d.department_name from departments d, employees e 
where d.department_id=e.department_id;

select e.employee_id, e.first_name, j.job_title  from jobs j, employees e
where j.job_id=e.job_id and e.department_id=80;

select e.first_name, j.job_title from jobs j, employees e
where e.job_id=j.job_id and j.job_title!='Sales Manager';

select d.department_name from departments d, locations l, countries c
where d.location_id=l.location_id and l.country_id=c.country_id;

select e.last_name, j.job_title, d.department_name  from employees e, jobs j, departments d
where d.department_id=e.department_id and lower(last_name) like 'a%' and length (e.last_name)>6;

select e1.last_name, e1.employee_id, e1.manager_id, 
e2.employee_id, e2.last_name from employees e1, employees e2 
where e1.manager_id=e2.employee_id order by 2;

select e1.last_name, e1.employee_id, e1.manager_id, 
e2.employee_id, e2.last_name from employees e1, employees e2 
where e1.manager_id=e2.employee_id and e1.job_id=e2.job_id order by 2;

select distinct last_name, e.department_id from employees e, departments d 
where e.department_id>d.department_id;
