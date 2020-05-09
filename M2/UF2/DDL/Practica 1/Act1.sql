/*1. 
create table Localitat (
cod_localitat numeric not null,
nom varchar2(100) not null,
CONSTRAINT PK_COD_LOCALITAT primary key(cod_localitat));*/

/*2.
create table Pub (
cod_pub varchar2(3) not null,
nom varchar2(100) not null,
llicencia varchar2(100) not null,
domicili varchar2(100),
data_apertura numeric not null,
horari varchar2(100) not null,
cod_localitat numeric not null,
CONSTRAINT PK_COD_PUB primary key(cod_pub),
CONSTRAINT HORARIS CHECK (horari='HOR1' OR horari='HOR2' OR horari='HOR3'),
CONSTRAINT FK_PUB_COD_LOCALITAT FOREIGN KEY (cod_localitat) REFERENCES Localitat(cod_localitat));*/

/*3.
create table Titular (
dni_titular varchar2(9) not null,
nom varchar2(30) not null,
domicili varchar2(100),
cod_pub varchar2(3) not null,
constraint PK_DNI_TITULAR primary key (dni_titular),
constraint FK_TITULAR_COD_PUB foreign key (cod_pub) references Pub(cod_pub));*/

/*4.
create table Existencies (
cod_article varchar2(1000) not null,
nom varchar2(30) not null,
quantitat numeric not null,
preu numeric not null,
cod_pub varchar2(3) not null,
constraint PK_COD_ARTICLE primary key (cod_article),
constraint FK_EXISTENCIES_COD_PUB foreign key (cod_pub) references Pub(cod_pub)
);*/

/*5.
create table Empleat (
dni_empleat varchar(9) not null,
nom varchar(30) not null,
domicili varchar2(100),
constraint PK_DNI_EMPLEAT primary key (dni_empleat)
);*/

/*6.
create table pub_empleat (
cod_pub varchar2(3) not null,
dni_empleat varchar(9) not null,
funcio varchar2(100) not null,
constraint FK_PUB_EMPLEAT_COD_PUB foreign key (cod_pub) references Pub(cod_pub),
constraint FK_PUB_EMPLEAT_DNI_EMPLEAT foreign key (dni_empleat) references Empleat(dni_empleat),
constraint FUNCIONS_EMPLEATS check (funcio='cambrer' OR funcio='seguretat' OR funcio='neteja')
);*/