ALTER TABLE ritu_mango_carlocal RENAME TO _temp_ritu_mango_carlocal;
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
      PRIMARY KEY (id)
);

INSERT INTO ritu_mango_carlocal SELECT *, "" FROM _temp_ritu_mango_carlocal;
DROP TABLE _temp_ritu_mango_carlocal;

ALTER TABLE ritu_mango_ownervehiclepermission RENAME TO _temp_ritu_mango_ownervehiclepermission;
CREATE TABLE ritu_mango_ownervehiclepermission (
    phone VARCHAR(250),
    owner_id INTEGER,
    vehicle_id INTEGER,
    vin VARCHAR(250),
    plate_no VARCHAR(250),
    permission VARCHAR(1024),
    vehicle_url VARCHAR(512),
    PRIMARY KEY (phone)
);
INSERT INTO ritu_mango_ownervehiclepermission SELECT *, ""  FROM _temp_ritu_mango_ownervehiclepermission;
DROP TABLE _temp_ritu_mango_ownervehiclepermission;