drop table if exists author;

CREATE TABLE author (
    id UUID DEFAULT gen_random_uuid(),
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    primary key(id)
);

