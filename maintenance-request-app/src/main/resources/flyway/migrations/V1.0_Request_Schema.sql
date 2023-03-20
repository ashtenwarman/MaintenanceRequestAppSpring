DROP TABLE IF EXISTS request_employee;
DROP TABLE IF EXISTS request;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS property;
DROP TABLE IF EXISTS city;

CREATE TABLE city (
city_pk INT NOT NULL AUTO_INCREMENT,
city_name VARCHAR(32) NOT NULL,
PRIMARY KEY(city_pk)
);

CREATE TABLE property (
property_pk INT NOT NULL AUTO_INCREMENT,
city_fk INT NOT NULL,
street_address VARCHAR(128),
is_rented boolean,
PRIMARY KEY(property_pk),
FOREIGN KEY(city_fk) REFERENCES city(city_pk)
);

CREATE TABLE employee (
employee_pk INT NOT NULL AUTO_INCREMENT,
employee_id VARCHAR(64),
employee_first_name VARCHAR(32),
employee_last_name VARCHAR(32),
employee_phone VARCHAR(15),
PRIMARY KEY(employee_pk)
);

CREATE TABLE request (
request_pk INT NOT NULL AUTO_INCREMENT,
property_fk INT NOT NULL,
employee_fk INT NOT NULL,
request_id enum('PLUMBING', 'ELECTRICAL', 'APPLIANCE', 'AC_HEATING',
				  'GENERAL_REPAIR', 'LAWN_SNOW', 'OTHER'),
request_date DATE NOT NULL,
PRIMARY KEY(request_pk),
FOREIGN KEY(property_fk) REFERENCES property(property_pk) ON DELETE CASCADE,
FOREIGN KEY(employee_fk) REFERENCES employee(employee_pk) ON DELETE CASCADE
);

CREATE TABLE request_employee (
request_fk int NOT NULL,
employee_fk int NOT NULL,
FOREIGN KEY(request_fk) REFERENCES request(request_pk) ON DELETE CASCADE,
FOREIGN KEY(employee_fk) REFERENCES employee(employee_pk) ON DELETE CASCADE
);