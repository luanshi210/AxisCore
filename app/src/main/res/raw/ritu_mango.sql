CREATE TABLE ritu_mango_ownerinfo(
     id INTEGER,
     name VARCHAR(250),
     birthday VARCHAR(250),
     email VARCHAR(250),
     email_validate INTEGER,
     card_no VARCHAR(250),
     phone VARCHAR(250),
     is_validate_get INTEGER,
     dictionary_questions TEXT,
     selected_questions TEXT,
     validate INTEGER,
     hozon_id INTEGER,
     PRIMARY KEY (id)
);

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

CREATE TABLE ritu_mango_poi(
     id INTEGER,
     lng DOUBLE,
     lat DOUBLE,
     name VARCHAR(250),
     address VARCHAR(250),
     PRIMARY KEY (id)
);

CREATE TABLE ritu_mango_carlocation (
     direction INTEGER,
     lat DOUBLE,
     lng DOUBLE,
     online_status INTEGER,
     positon_type  INTEGER,
     run_status INTEGER,
     speed DOUBLE,
     vin VARCHAR(250),
     time INTEGER,
     PRIMARY KEY (vin)
);

CREATE TABLE ritu_mango_carstatus(
     car_no VARCHAR(250),
     driver_door_lock INTEGER,
     passenger_door_lock INTEGER,
     leftAfter_door_lock INTEGER,
     rightAfter_door_lock INTEGER,
     carboot_lock INTEGER,
     driver_door_window INTEGER,
     passenger_door_window INTEGER,
     leftAfter_door_window INTEGER,
     rightAfter_door_window INTEGER,
     sky_window INTEGER,
     driver_door INTEGER,
     passenger_door INTEGER,
     leftAfter_door INTEGER,
     rightAfter_door INTEGER,
     car_boot INTEGER,
     engine INTEGER,
     flash_status INTEGER,
     clearance_light_status INTEGER,
     dipped_head_light_status INTEGER,
     high_beam_status INTEGER,
     ac_status INTEGER,
     ac_temperature INTEGER,
     ac_mode INTEGER,
     ac_wind INTEGER,
     tyre_right_front_temp INTEGER,
     tyre_right_front_press INTEGER,
     tyre_right_after_temp INTEGER,
     tyre_right_after_press INTEGER,
     tyre_left_front_temp INTEGER,
     tyre_left_front_press INTEGER,
     tyre_left_after_temp INTEGER,
     tyre_left_after_press INTEGER,
     battery_charge INTEGER,
     battery_percentage INTEGER,
     battery_residue_time INTEGER,
     battery_mileage INTEGER,
     battery_already_time INTEGER,
     batter_timing_status INTEGER,
     batter_timing_hour INTEGER,
     batter_timing_minute INTEGER,
     out_temperature INTEGER,
     in_temperature INTEGER,
     PRIMARY KEY (car_no)
);

CREATE TABLE ritu_mango_mobilevehicle(
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

CREATE TABLE ritu_mango_carsharelocalvo(
    id INTEGER,
    vehicle_id INTEGER,
    owner_id INTEGER,
    owner_name VARCHAR(250),
    owner_account VARCHAR(250),
    plate_no VARCHAR(250),
    vehicle_type_name VARCHAR(250),
    start_time INTEGER,
    end_time INTEGER,
    permission VARCHAR(250),
    hezong_id INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE ritu_mango_ownervehiclepermission (
    id INTEGER,
    phone VARCHAR(250),
    owner_id INTEGER,
    vehicle_id INTEGER,
    vin VARCHAR(250),
    plate_no VARCHAR(250),
    permission VARCHAR(1024),
    vehicle_url VARCHAR(512),
    PRIMARY KEY (phone)
);

CREATE TABLE ritu_mango_message (
    id INTEGER,
    type INTEGER,
    assortment INTEGER,
    title VARCHAR(250),
    content VARCHAR(1024),
    create_time VARCHAR(250),
    read_state INTEGER,
    owner_id INTEGER,
    PRIMARY KEY (id)
);