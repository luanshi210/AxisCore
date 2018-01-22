DROP TABLE ritu_mango_carlocal;
CREATE TABLE ritu_mango_carlocal(
     id INTEGER,
     owner_id INTEGER,
     vehicle_id INTEGER,
     plate_no VARCHAR(250),
     color VARCHAR(250),
     owner_type VARCHAR(250),
     flow_residual INTEGER,
     vehicle_type_name VARCHAR(250),
     vehicle_no VARCHAR(250),
     list_order INTEGER,
     vehicle_logo_url VARCHAR(512),
     vehicle_mode_name VARCHAR(250),
     is_current INTEGER,
     PRIMARY KEY (id)
);
