CREATE TABLE cars.car
(
    id         bigint                            NOT NULL,
    name       text COLLATE pg_catalog."default" NOT NULL,
    engine_id  bigint,
    driver_id  bigint,
    history_id bigint,
    CONSTRAINT car_pkey PRIMARY KEY (id),
    CONSTRAINT driver_fkey FOREIGN KEY (driver_id)
        REFERENCES cars.driver (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,

    CONSTRAINT engine_fkey FOREIGN KEY (engine_id)
        REFERENCES cars.engine (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,

    CONSTRAINT history_fkey FOREIGN KEY (history_id)
        REFERENCES cars.history_owner (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE cars.driver
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT driver_pkey PRIMARY KEY (id)
);

CREATE TABLE cars.engine
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    CONSTRAINT engine_pkey PRIMARY KEY (id)
);

CREATE TABLE cars.history_owner
(
    id bigint NOT NULL,
    history text COLLATE pg_catalog."default" NOT NULL,
    driver_id bigint,
    CONSTRAINT history_owner_pkey PRIMARY KEY (id),
    CONSTRAINT driver_fkey FOREIGN KEY (driver_id)
        REFERENCES cars.driver (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
