select cars.id, cars.name as car_name, car_bodies.name as body_name, car_engines.name as engine_name, car_transmissions.name as transmission_name
from cars
left join car_bodies on cars.body_id = car_bodies.id
left join car_engines on cars.engine_id = car_engines.id
left join car_transmissions on cars.transmission_id = car_transmissions.id;

select car_bodies.name
from car_bodies
left join cars on car_bodies.id = cars.body_id
where cars.body_id is null;

select car_engines.name 
from car_engines
left join cars on car_engines.id = cars.engine_id
where cars.engine_id is null;

select car_transmissions.name
from car_transmissions
left join cars on car_transmissions.id = cars.transmission_id
where cars.transmission_id is null;



