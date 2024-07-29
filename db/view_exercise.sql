create view car_details_summary as
select c.name as car_name, count(cb.name) as body_count, cb.name as body_name, 
       count(ce.name) as engine_count, ce.name as engine_name, 
       count(ct.name) as transmission_count, ct.name as transmission_name
from cars as c
         left join car_bodies cb on c.body_id = cb.id
         left join car_engines ce on c.engine_id = ce.id
         left join car_transmissions ct on c.transmission_id = ct.id
group by c.name, cb.name, ce.name, ct.name
having count(cb.name) > 1 or count(ce.name) > 1 or count(ct.name) > 1;

select *  from car_details_summary;