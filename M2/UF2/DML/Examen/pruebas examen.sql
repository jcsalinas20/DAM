--Niños nacidos en zona rural, con mas de 5 hermanos vivos(él incuido), seperados por region y municipio
select r.desc_regio, m.desc_municipi, dm.fill_total, n.data_naixament from dades_mare dm, zona z, municipi m, regio r, nascut n
where lower(z.desc_zona)='rural' and dm.fill_viu>5 and m.cod_mun = dm.cod_mun and r.cod_regio = m.cod_regio and n.cod_nascut=dm.cod_nascut;


--Edad de la madre y el padre del cod_nascut 20
select n.cod_nascut, dm.dni_mare, trunc (months_between(sysdate, dm.data_naix)/12) "Años de la Madre", dp.dni_pare, trunc (months_between(sysdate, dp.data_naix_p)/12) "Años del Padre" from nascut n, dades_mare dm, dades_pare dp
where n.cod_nascut=20 and n.cod_nascut=dm.cod_nascut and n.cod_nascut = dp.cod_nascut;


--nacidos en el primer trimestre
select data_naixament from nascut;


--Saber el el numero del dia elegido
select next_day (sysdate, 'viernes') "sig. jueves" from dual;


--Transformar un numero en fecha
select to_date('01012006') from dual;


--Transformar un numero en fecha y despues saber el nombre
select to_char( to_date ('01012007', 'ddmmyyyy'), 'month') "mes" from dual;


--saber el nombre del usuario y el UID
select user, UID from dual;


--nacidos en el mes de abril con la letra del dni de la madre acabado en U y empezado en 3815
select dm.dni_mare, n.data_naixament from nascut n, dades_mare dm
where n.cod_nascut = dm.cod_nascut and n.data_naixament like '%/04/13' and dm.dni_mare like '%-U' and dm.dni_mare like '3815%';


--Dime todos los datos del padre con dni 79443894-O "Hijos, Nivell, Activitat, Relacio, Categoria"
select dp.dni_pare, dm.fill_total, dm.fill_viu, ne.desc_nivell, act.desc_activitat, rp.desc_relacio, cat.desc_cat from dades_pare dp, dades_mare dm, nivell_estudi ne, activitat act, relacio_professio rp, categoria cat
where dp.dni_pare='79447612-H' and dp.cod_nascut = dm.cod_nascut and ne.cod_nivell = dp.cod_nivell and act.cod_act=dp.cod_act and rp.cod_relacio=dp.cod_relacio and cat.cod_cat=dp.cod_cat;
select dni_pare from dades_pare;


--Dime todos los datos de la madre con dni 38142117-G
select dm.dni_mare, dm.fill_total, trunc(months_between(sysdate, dm.data_naix)/12) "Edat mare", ec.desc_ec, ne.desc_nivell, act.desc_activitat, rp.desc_relacio, cat.desc_cat, z.desc_zona, m.desc_municipi, h.desc_hosp, r.desc_regio
from dades_mare dm, activitat act, categoria cat, estat_civil ec, hospital h, municipi m, nivell_estudi ne, regio r, relacio_professio rp, zona z
where dm.dni_mare='38142117-G' and ec.cod_ec = dm.cod_ec and ne.cod_nivell = dm.cod_nivell and act.cod_act=dm.cod_act and rp.cod_relacio = dm.cod_relacio and cat.cod_act = dm.cod_act and z.cod_zona=dm.cod_zona
and m.cod_mun=dm.cod_mun and h.cod_hosp=dm.cod_hosp and h.cod_regio=r.cod_regio;
select dni_mare from dades_mare;


----Dime todos los datos del nascut con el codi 1023



--De una madre muestrame el DNI_madre, dni_pare, fills_totals, vius, morts, mortinat, data_naixament dels fills
select distinct dm.dni_mare, dp.dni_pare, dm.fill_total, dm.fill_viu, dm.fill_mort, dm.fill_mortinat, n.cod_nascut, n.data_naixament from dades_mare dm, dades_pare dp, nascut n
where dp.cod_nascut = dm.cod_nascut and n.cod_nascut = dm.cod_nascut and dm.dni_mare='38142906-U';

select n.cod_nascut, n.data_naixament from nascut n, dades_mare dm
where dm.cod_nascut=n.cod_nascut and dm.dni_mare='38142906-U';

select n.cod_nascut, n.data_naixament from nascut n, dades_mare dm
where dm.cod_nascut=n.cod_nascut;









select dni_mare, trunc(months_between(sysdate, data_naix)/12) "Edad Mare" from dades_mare
where data_naix = (
select max(data_naix) from dades_mare dm, relacio_professio rp
where dm.cod_relacio=rp.cod_relacio and lower(rp.desc_relacio)='pensionista');


select sum(dm.fill_viu), sum(dm.fill_mortinat + dm.fill_mort), r.desc_regio, round(((dm.fill_mortinat+dm.fill_mort)/dm.fill_viu)*100, '2') from dades_mare dm,municipi m, regio r
where m.cod_mun = dm.cod_mun and m.cod_regio=r.cod_regio and ((dm.fill_mortinat+dm.fill_mort)/dm.fill_viu)*100>15
group by r.desc_regio, ((dm.fill_mortinat+dm.fill_mort)/dm.fill_viu)*100
order by 3;


select r.desc_regio, m.desc_municipi, ta.desc_atencio, h.desc_hosp, n.cod_nascut from nascut n, regio r, municipi m, tipus_atencio ta, hospital h
where r.cod_regio=m.cod_regio and m.cod_mun=h.cod_mun and h.desc_hosp='Hospital Traumatológico' and h.cod_hosp=n.cod_hosp and ta.desc_atencio!='No atenció professional' and ta.desc_atencio!='Desconegut'
group by r.desc_regio, m.desc_municipi, ta.desc_atencio, h.desc_hosp, n.cod_nascut;

select count(*) from nascut n, dades_mare dm, estat_civil ec
where n.cod_nascut=dm.cod_nascut and dm.cod_ec=ec.cod_ec and lower(ec.desc_ec) like '%vid%'
;