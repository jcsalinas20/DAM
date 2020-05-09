select nombre from bloccases 
where carrer in (
select carrer from vivenda 
where nom_zona = (
select * from zonaurbana
where lower(nom_zona)='plaza nueva_elvira'))
order by 1;