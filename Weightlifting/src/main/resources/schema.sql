drop table if exists weightlifting CASCADE;
CREATE TABLE weightlifting (
    id BIGINT AUTO_INCREMENT,
    bench_press INTEGER NOT NULL,
    clean_andj INTEGER NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    snatch INTEGER NOT NULL,
    PRIMARY KEY (id)
);