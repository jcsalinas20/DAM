/*2.*/
insert into empleats(dni,nom,cognom1,cognom2,sexe) values ('23555333', 'Sergio', 'Vera', 'Castellano', 'H');
insert into empleats(dni,nom,cognom1,cognom2,sexe) values ('45666999', 'Aurora', 'Romero', 'Margolis', 'D');
insert into historial_laboral(empleat_dni,data_inici,supervisor_dni) values ('23555333', '15/02/2016', '45666999');

/*3.*/
--Este comando salta un error porque el dni de empleat_dni no existe en Empleats.
insert into historial_laboral(empleat_dni,data_inici,supervisor_dni) values ('12334567', '20/04/2014', '47854785');

/*4.*/
insert into universitat values ('1', 'Esteve Terrades y Illa', 'Barcelona', 'Cornella', '08760');

/*5.*/

/*6.*/

/*7.*/

/*8.*/

/*9.*/

/*10.*/

/*11.*/

/*12.*/

/*13.*/

/*14.*/

/*15.*/

