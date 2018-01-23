DROP TABLE ritu_mango_carsharelocalvo;
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