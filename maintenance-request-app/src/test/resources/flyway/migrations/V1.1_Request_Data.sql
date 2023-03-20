
-- city
INSERT INTO city (city_name) VALUES ('West Fargo');
INSERT INTO city (city_name) VALUES ('Fargo');
INSERT INTO city (city_name) VALUES ('Horace');


-- property
INSERT INTO property SET street_address = '2713 10th st W',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'West Fargo'),
is_rented = (1);

INSERT INTO property SET street_address = '2743 12th st W',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'West Fargo'),
is_rented = (1);

INSERT INTO property SET street_address = '1136 27th ave W',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'West Fargo'),
is_rented = (0);

INSERT INTO property SET street_address = '7469 23rd st S',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'Fargo'),
is_rented = (1);

INSERT INTO property SET street_address = '7416 24th st S',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'Fargo'),
is_rented = (0);

INSERT INTO property SET street_address = '7501 23rd st S',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'Fargo'),
is_rented = (1);

INSERT INTO property SET street_address = '6000 78th ave S',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'Horace'),
is_rented = (0);

INSERT INTO property SET street_address = '6016 78th ave S',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'Horace'),
is_rented = (0);

INSERT INTO property SET street_address = '6048 79th ave S',
city_fk = (SELECT city_pk FROM city WHERE city_name = 'Horace'),
is_rented = (1);

-- maintenance employee
INSERT INTO employee (employee_id, employee_first_name, employee_last_name, employee_phone) VALUES ('WASSERMAN_KEVIN','Kevin', 'Wasserman', '218-888-5654'); 
INSERT INTO employee (employee_id, employee_first_name, employee_last_name, employee_phone) VALUES ('BOWARD_TODD','Todd', 'Boward', '701-888-2124');

