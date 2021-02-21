CREATE USER 'prospring5_a'@'localhost'
    IDENTIFIED BY 'prospring_a';

CREATE SCHEMA MUSICDB_A;
GRANT ALL PRIVILEGES ON MUSICDB_A.* TO 'prospring5_a'@'localhost';

CREATE USER 'prospring5_b'@'localhost'
    IDENTIFIED BY 'prospring_b';

CREATE SCHEMA MUSICDB_B;
GRANT ALL PRIVILEGES ON MUSICDB_B.* TO 'prospring5_b'@'localhost';