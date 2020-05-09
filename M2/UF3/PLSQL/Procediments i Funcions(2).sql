set serveroutput on;

--drop procedure ejercicio2;

/*create or replace procedure ejercicio1(rang number)
as
begin
if ( rang>0 ) then
  for i in 1..rang loop
    dbms_output.put_line(i);
  end loop;
else 
  dbms_output.put_line('Numero introducido no valido');
end if;
end ejercicio1;
/*/

/*create or replace procedure ejercicio2(num number)
as
begin
if ( num>0 ) then
  dbms_output.put_line('Numero introducido: '||num);
  dbms_output.put_line('Numero duplicado: '||(num+num));
else
  dbms_output.put_line('Numero introducido invalido');
end if;
end ejercicio2;
/*/

/*create or replace procedure ejercicio3(num number)
as
resultado number:=1;
begin
if ( num>0 ) then
  for i in 1..num loop
    resultado := resultado*i;
  end loop;
  dbms_output.put_line('Factorial de '||num||': '||resultado);
else
  dbms_output.put_line('Numero introducido invalido');
end if;
end ejercicio3;
/*/

create or replace procedure ejercicio4a(numMin number,numMax number,saltos number)
as
vuelta number:=1;
i number:=numMin;
begin
while i < numMax loop
  dbms_output.put_line('Vuelta numero: '||vuelta||' con el numero '||i);
  vuelta := vuelta + 1;
  i:=i+saltos;
end loop;
end ejercicio4a;
/

create or replace procedure ejercicio4b(numMin number,numMax number,saltos number)
as
begin
if ( numMin<0 ) then
  dbms_output.put_line('Error, numMin es mas pequeño que 0.');
elsif ( numMin>numMax ) then
  dbms_output.put_line('Error, numMin es mas grande que numMax.');
elsif ( saltos<1 ) then
  dbms_output.put_line('Error, saltos no puede ser mas pequeño de 1.');
else 
  dbms_output.put_line('Variables introducidas correctamente.');
  ejercicio4a(numMin, numMax, saltos);
end if;
end ejercicio4b;
/
