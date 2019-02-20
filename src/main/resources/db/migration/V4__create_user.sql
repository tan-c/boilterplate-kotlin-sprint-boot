CREATE TABLE "user"(
    name VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

INSERT INTO "user" (name, username, password) values ('User 1', 'user', 'password');
INSERT INTO "user" (name, username, password) values ('User 2', 'user', 'password');
