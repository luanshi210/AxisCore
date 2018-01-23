DROP TABLE ritu_mango_mobilevehicle;
CREATE TABLE ritu_mango_mobilevehicle (
      id INTEGER,
      plate_no VARCHAR(250),
      color VARCHAR(250),
      vin VARCHAR(250),
      vehicle_type_name VARCHAR(250),
      vehicle_model_name VARCHAR(250),
      mileage VARCHAR(250),
      flow_residual INTEGER,
      vehicle_no VARCHAR(250),
      expiry_date VARCHAR(250),
      ower_type INTEGER,
      share_start_time VARCHAR(250),
      share_end_time VARCHAR(250),
      PRIMARY KEY (id)
);
