select distinct et.nom_emptransport, tet.cod_desti, d.ciutat_desti  from empresatransportista et, trasllat_empresatransport tet, desti d
where et.nif_emptransport=tet.nif_emptransport and tet.cod_desti=d.cod_desti and d.ciutat_desti='MADRID' order by 1;


select distinct ep.nif_empresa, ep.nom_empresa from empresaproductora ep, residu_constituent rc
where ep.nif_empresa=rc.nif_empresa and rc.cod_constituent like '992%';

select d.nom_desti, d.ciutat_desti, tet.tipus_transport from desti d, trasllat_empresatransport tet, empresatransportista et
where tet.nif_emptransport=et.nif_emptransport and tet.nif_emptransport='A-22300325' and tet.kms>'4297';

select * from empresatransportista
where nif_emptransport='A-22300325';