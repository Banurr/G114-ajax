CREATE TABLE IF NOT EXISTS ACADEMIES
(
    ID     BIGSERIAL PRIMARY KEY NOT NULL,
    NAME   VARCHAR(50) UNIQUE    NOT NULL,
    COURSE VARCHAR(30)           NOT NULL,
    RATING DOUBLE PRECISION
);

INSERT INTO ACADEMIES(NAME,COURSE,RATING) VALUES ('BITLAB','JAVA','10.0'),
                                                 ('OUTPEER','DATA SCIENCE','9.0'),
                                                 ('DECODE','PYTHON','9.0');

