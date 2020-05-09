create table Pub (
cod_pub varchar2(3) not null,
nom varchar2(100) not null,
llicencia varchar2(100) not null,
domicili varchar2(100),
data_apertura numeric not null,
horari varchar2(100) not null,
cod_localitat numeric not null,
CONSTRAINT COD_PUB_PK primary key(cod_pub),
CONSTRAINT HORARIS CHECK (horari="HOR1" OR horari="HOR2" OR horari="HOR3"),
CONSTRAINT fkpersonas FOREIGN KEY (dep, id) REFERENCES departamentos(dep,id));

/*create table Localitat (
cod_localitat numeric not null,
nom varchar2(100) not null,
CONSTRAINT PK_COD_LOCALITAT primary key(cod_localitat));*/