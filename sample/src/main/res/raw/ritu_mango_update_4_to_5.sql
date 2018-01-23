
ALTER TABLE ritu_mango_ownervehiclepermission RENAME TO _temp_ritu_mango_ownervehiclepermission;
CREATE TABLE ritu_mango_ownervehiclepermission (
    phone VARCHAR(250),
    owner_id INTEGER,
    vehicle_id INTEGER,
    vin VARCHAR(250),
    plate_no VARCHAR(250),
    permission VARCHAR(1024),
    vehicle_url VARCHAR(512),
    id INTEGER,
    PRIMARY KEY (phone)
);

INSERT INTO ritu_mango_ownervehiclepermission SELECT *, ""  FROM _temp_ritu_mango_ownervehiclepermission;
DROP TABLE _temp_ritu_mango_ownervehiclepermission;

ALTER TABLE ritu_mango_carstatus RENAME TO _temp_ritu_mango_carstatus;
CREATE TABLE ritu_mango_carstatus(
     car_no VARCHAR(250),
     sky_window INTEGER,
     car_boot INTEGER,
     engine INTEGER,
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
     out_temperature INTEGER,
     in_temperature INTEGER,
     driver_door_lock INTEGER,
     passenger_door_lock INTEGER,
     leftAfter_door_lock INTEGER,
     rightAfter_door_lock INTEGER,
     batter_timing_status INTEGER,
     batter_timing_hour INTEGER,
     batter_timing_minute INTEGER,
     carboot_lock INTEGER,
     driver_door_window INTEGER,
     passenger_door_window INTEGER,
     leftAfter_door_window INTEGER,
     rightAfter_door_window INTEGER,
     driver_door INTEGER,
     passenger_door INTEGER,
     leftAfter_door INTEGER,
     rightAfter_door INTEGER,
     flash_status INTEGER,
     clearance_light_status INTEGER,
     dipped_head_light_status INTEGER,
     high_beam_status INTEGER,
     PRIMARY KEY (car_no)
);
INSERT INTO ritu_mango_carstatus SELECT car_no,sky_window,car_boot,engine,ac_status,ac_temperature,ac_mode,ac_wind,tyre_right_front_temp,tyre_right_front_press,tyre_right_after_temp ,tyre_right_after_press ,tyre_left_front_temp ,tyre_left_front_press ,tyre_left_after_temp ,tyre_left_after_press ,battery_charge ,battery_percentage ,battery_residue_time ,battery_mileage ,battery_already_time ,out_temperature ,in_temperature,"","","","","","","","","","","","","","","","","","","","" FROM _temp_ritu_mango_carstatus;
DROP TABLE _temp_ritu_mango_carstatus;
