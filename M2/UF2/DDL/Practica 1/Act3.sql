/*empleats - salari - universitat - estudis - treball - laboral - departament*/
/*1.
create table EMPLEATS (
dni number(8),
nom varchar2(10) not null,
cognom1 varchar2(15) not null,
cognom2 varchar2(15),
adreça1 varchar2(25),
adreça2 varchar2(20),
ciutat varchar2(20),
provincia varchar2(20),
cod_postal varchar2(5),
sexe varchar2(1),
data_naixament date,
constraint PK_DNI primary key (dni),
constraint SEXES check (sexe='H' or sexe='D' or sexe='O')
);*/

/*2.
create table HISTORIAL_SALARIAL (
empleat_dni number(8),
salari number(9,2) not null,
data_inici date,
data_fi date,
constraint FK_SALARI_DNI foreign key (empleat_dni) references EMPLEATS(dni)
);*/

/*3.
create table UNIVERSITAT (
univ_cod number(5),
nom_univ varchar2(25) not null,
ciutat varchar2(20),
municipi varchar2(20),
cod_postal varchar2(5),
constraint PK_UNIV_COD primary key (univ_cod)
);*/

/*4.
create table ESTUDIS (
empleat_dni number(8),
univ_cod number(8),
año number(4),
grau varchar2(3),
especialitat varchar2(20),
constraint FK_ESTUDIS_DNI foreign key (empleat_dni) references EMPLEATS(dni),
constraint FK_ESTUDIS_UNIV foreign key (univ_cod) references UNIVERSITAT(univ_cod)
);*/

/*5.
create table TREBALL (
treball_cod number(5),
nom_treball varchar2(20) not null,
salari_min number(9,2) not null,
salari_max number(9,2) not null,
constraint PK_TREBALL_COD primary key (treball_cod)
);*/

/*6.
create table DEPARTAMENTS (
dpto_cod number(5),
nom_dpto varchar2(30) not null,
dpto_pare number(5),
presupost number(9,3) not null,
pres_actual number(9,3),
constraint PK_DPTO_COD primary key (dpto_cod)
);*/

/*7.
create table HISTORIAL_LABORAL (
empleat_dni number(8),
treball_cod number(5),
data_inici date,
data_fi date,
dpto_cod number(5),
supervisor_dni number(8),
constraint FK_LABORAL_DNI foreign key (empleat_dni) references EMPLEATS(dni),
constraint FK_LABORAL_TREBALL_COD foreign key (treball_cod) references TREBALL(treball_cod),
constraint FK_LABORAL_DPTO_COD foreign key (dpto_cod) references DEPARTAMENTS(dpto_cod)
);*/