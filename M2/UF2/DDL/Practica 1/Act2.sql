/*1.
create table RECINTES (
cod_recinte varchar2(100) not null, 
nom varchar2(30) not null, 
adreça varchar2(50) not null, 
ciutat varchar2(20) not null, 
telefon varchar2(9) not null, 
horari varchar2(20) not null,
constraint PK_COD_RECINTE primary key (cod_recinte),
constraint HORARIS check (horari='mati' or horari='tarda')
);*/

/*2.
create table ESPECTADOR (
dni_client varchar2(9) not null,
nom varchar2(30) not null,
adreça varchar2(50) not null, 
telefon varchar2(9) not null,  
ciutat varchar2(20) not null,
ntargeta numeric not null,
constraint PK_DNI_CLIENT primary key (dni_client)
);*/

/*3.
create table ESPECTACLES (
cod_espectacle varchar2(100) not null,
nom varchar2(30) not null,
tipus varchar2(30) not null,
data_inici varchar2(8) not null,
data_final varchar2(8) not null,
interpret varchar2(20) not null,
cod_recinte varchar2(100) not null,
constraint PK_COD_ESPECTACLE primary key (cod_espectacle),
constraint FK_ESPECTACLES_COD_RECINTE foreign key (cod_recinte) references RECINTES(cod_recinte)
);*/

/*4.
create table PREUS_ESPECTACLES (
cod_espectacle varchar2(100) not null,
cod_recient varchar2(100) not null,
zona varchar2(30) not null,
preu numeric not null,
constraint FK_P_ESPEC_COD_ESPECTABLE foreign key (cod_espectacle) references ESPECTACLES(cod_espectacle),
constraint FK_P_ESPEC_COD_RECINTE foreign key (cod_recinte) references RECINTES(cod_recinte)
);*/

/*5.
create table ZONA_RECINTE (
cod_recinte varchar2(100) not null,
zona varchar2(30) not null,
capacitat numeric not null,
constraint FK_Z_RECINTE_COD_RECINTE foreign key (cod_recinte) references RECINTES(cod_recinte)
);*/

/*6.
create table SEIENT (
cod_recinte varchar2(100) not null,
zona varchar2(30) not null,
fila numeric not null,
num numeric not null,
constraint FK_SEIENT_COD_RECINTE foreign key (cod_recinte) references RECINTES(cod_recinte)
);*/

/*7.
create table REPRESENTACI (
cod_espectacle varchar2(100) not null,
data varchar2(10) not null,
hora varchar2(5) not null,
constraint FK_REPRE_COD_ESPECTACLE foreign key (cod_espectacle) references ESPECTACLES(cod_espectacle)
);*/

/*8.
create table ENTRADA (
cod_espectacle varchar2(100) not null,
data varchar2(10) not null,
hora varchar2(5) not null,
cod_recinte varchar2(100) not null,
fila numeric not null,
num numeric not null,
zona varchar2(30) not null,
dni_client varchar2(100) not null,
constraint FK_ENTRADA_COD_ESPECTACLE foreign key (cod_espectacle) references ESPECTACLES(cod_espectacle),
constraint FK_ENTRADA_COD_RECINTE foreign key (cod_recinte) references RECINTES(cod_recinte),
constraint FK_ENTRADA_DNI_CLIENT foreign key (dni_client) references ESPECTADOR(dni_client)
);*/