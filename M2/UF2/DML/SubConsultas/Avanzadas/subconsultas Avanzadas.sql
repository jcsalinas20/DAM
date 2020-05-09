select sum(salary), department_id from employees
group by department_id;

select max(salary), job_id from employees
group by job_id;

select department_id, job_id, avg(salary) from employees
group by department_id, job_id
order by 1, 2;

select sum(salary), job_id from employees
group by job_id
having job_id='ST_MAN';

select region_id, count(*) from countries 
group by region_id;

select region_id, region_name from regions where region_id in(
select region_id from countries
group by region_id
having count(*)>6);

select manager_id, count(*) from employees 
group by manager_id
order by 1;