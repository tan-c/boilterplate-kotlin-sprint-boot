-- CREATE SCHEMA "pet" # This will be able to create schema with 'pet' in lower case

CREATE TABLE "pet"(
    "id" BIGINT IDENTITY(1,1) NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "gender" VARCHAR(100) NOT NULL,
    "species" VARCHAR(100),
    "breed" VARCHAR(100),
    "owner_id" INT
);

CREATE TABLE "owner"(
    "id" BIGINT IDENTITY(1,1) NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "gender" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255)
);

INSERT INTO "owner" ("name", "gender") values ('Owner 1', 'male');
INSERT INTO "owner" ("name", "gender") values ('Owner 2', 'female');

INSERT INTO "pet" ("name", "gender", "owner_id") values ('Wang Cai', 'male', 1);
INSERT INTO "pet" ("name", "gender", "owner_id") values ('Mantou', 'female', 1);
INSERT INTO "pet" ("name", "gender", "owner_id") values ('Huacai', 'female', 2);
