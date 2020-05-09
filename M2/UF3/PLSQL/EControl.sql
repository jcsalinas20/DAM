set serveroutput on;
/*1.*/
/*variable nom varchar2;
accept nom prompt 'Introduce el nombre:';
print nom;*/


/*2.*/
/*3.*/
/*4.*/
/*5.*/
/*accept edat prompt 'Introduce tu edat:';
begin
if &edat < 0 then
  DBMS_OUTPUT.PUT_LINE('error edat no pot ser negativa');
elsif &edat < 18 then
  DBMS_OUTPUT.PUT_LINE('ets menor de edat');
elsif &edat = 18 then
  DBMS_OUTPUT.PUT_LINE('casi ets major de edat');
elsif &edat > 40 then
  DBMS_OUTPUT.PUT_LINE('Ets viejoven');
elsif &edat > 18 then
  DBMS_OUTPUT.PUT_LINE('ja ets major de edat');
end if;
end;
/*/


/*6.*/
/*accept num prompt 'Introduce un numero:';
declare
suma numeric:=4;
resta numeric:=3;
multi numeric:=8;
resultado numeric;
begin
dbms_output.put_line('Numero introducido: '||&num);
resultado:=suma+&num;
dbms_output.put_line('Resultado: '||resultado);
resultado:=&num-resta;
dbms_output.put_line('Resultado: '||resultado);
resultado:=multi*&num;
dbms_output.put_line('Resultado: '||resultado);
end;
/*/


/*7.*/
/*variable resultado numeric:=0;
accept num1 prompt 'Introduce el primer numero:';
accept num2 prompt 'Introduce el segundo numero:';
declare
num3 numeric := &num1;
num4 numeric := &num2;
resultado2 numeric;
begin
if num3 < 0 or num4 < 0 then
  dbms_output.put_line('Error. Numero negativo Introducido');
else
  resultado2:=num3/num4;
  resultado2:=resultado2+num4;
  &resultado:=resultado2;
end if;
end;
/*/


/*8.*/
/*9.*/
/*accept numMax prompt 'Introduce el numero maximo:';
begin
FOR i IN 1..&numMax LOOP
DBMS_OUTPUT.PUT_LINE (i);
END LOOP;
end;
/*/

/*accept numMax prompt 'Introduce el numero maximo:';
declare
i numeric:=1;
begin
WHILE i<=&numMax LOOP
DBMS_OUTPUT.PUT_LINE (i);
i:=i+1;
END LOOP;
end;
/*/

/*10.*/
accept numMin prompt 'Introduce el numero minimo:';
accept numMax prompt 'Introduce el numero maximo:';
accept salto prompt 'Introduce el numero de salto:';
declare
i numeric := &numMin;
begin
WHILE i<&numMax LOOP
DBMS_OUTPUT.PUT_LINE (i);
i:=i+&salto;
END LOOP;
end;
