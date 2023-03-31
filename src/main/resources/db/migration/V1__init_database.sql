CREATE TABLE book (
    id UUID DEFAULT gen_random_uuid (),
    book_title VARCHAR(255) NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
