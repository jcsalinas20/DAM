select distinct nif_empresa, nom_empresa, ciutat_empresa from empresaproductora 
where ciutat_empresa in (select ciutat_empresa from empresaproductora 
where lower(ciutat_empresa) = 'granada') order by 2;

select sum(cost) "import de transllat"
from trasllat_empresatransport 
where nif_empresa='A-12000466' and
nif_emptransport='A-22300282' and cod_desti='22';

select cod_desti from trasllat where cod_residu in 
(select distinct cod_residu from residu_constituent where cod_constituent in
(select cod_constituent from constituent 
where lower(nom_constituent) like 'bio%'));

/*select
from trasllat_empresatransport tet, desti d, empresatransport et 
where d.cod_desti=tet.cod_desti and tet.nif_empresa=et.nif_empresa and ='BARCELONA' 
and ;*/

select nom_emptransport from empresatransportista where nif_emptransport in (
select distinct nif_emptransport from trasllat_empresatransport where nif_empresa in(
select nif_empresa from empresaproductora where lower(ciutat_empresa)='madrid')) order by 1;

select distinct et.nom_emptransport from empresatransportista et, trasllat_empresatransport tet, empresaproductora ep 
where et.nif_emptransport=tet.nif_emptransport and tet.nif_empresa=ep.nif_empresa
and lower(ep.ciutat_empresa)='madrid' order by 1;


select distinct nif_empresa, nom_empresa from empresaproductora where nif_empresa in(
select nif_empresa from residu_constituent where cod_constituent like '992%');


