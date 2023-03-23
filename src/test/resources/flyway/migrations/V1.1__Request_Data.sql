
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
INSERT INTO employee (employee_name, employee_phone) VALUES ('Kevin Wasserman', '218-888-5654'); 
INSERT INTO employee (employee_name, employee_phone) VALUES ('Todd Boward', '701-888-2124');

-- test requests
INSERT INTO request SET property_fk = (SELECT property_pk FROM property WHERE street_address = '2713 10th st W'),
employee_fk = (SELECT employee_pk FROM employee WHERE employee_name = 'Todd Boward'),
request_id = 'PLUMBING', request_date = '2023-03-12'; 

INSERT INTO request SET property_fk = (SELECT property_pk FROM property WHERE street_address = '6000 78th ave S'),
employee_fk = (SELECT employee_pk FROM employee WHERE employee_name = 'Kevin Wasserman'),
request_id = 'PLUMBING', request_date = '2023-03-13';
