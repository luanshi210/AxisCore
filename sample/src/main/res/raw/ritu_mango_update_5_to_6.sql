DROP TABLE ritu_mango_carlocatecache;
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