CREATE TABLE public.customers
(
    id serial PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    image TEXT NOT NULL,
    lastChange TEXT NOT NULL,
    createdBy TEXT NOT NULL
);
CREATE UNIQUE INDEX customers_id_uindex ON public.customers (id);

CREATE TABLE public.users
(
    id serial PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    role varchar(20) NOT NULL,
    token TEXT NOT NULL
);
CREATE UNIQUE INDEX users_id_uindex ON public.users (id);
CREATE UNIQUE INDEX users_email_uindex ON public.users (email);

INSERT INTO users (name, email, password, role, token)
VALUES ('yonay', 'yonaycl@gmail.com' , 'c068fb95b8e64b1d775313ed5902efbe32d207e4de7876f8caf838fec6f8d18a', 'admin', 'fdb2f99d23dcd2e4b090dc0005f958b0c59746b60ad99d2c51ade655ea8806e2');

INSERT INTO users (name, email, password, role, token)
VALUES ('jose', 'jose@gmail.com' , 'd705cb47bfe5ea17a25090bc63af957bc52298b4aedfe0f21ecbd67fe643ac8b', 'admin', '21fd1fc86f90c9a76abd0fb67ac6d86288c3c5239e98bbb00ffccebbaf150ff1');
