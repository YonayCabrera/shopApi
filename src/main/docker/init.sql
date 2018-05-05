CREATE TABLE public.customers
(
    id serial PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    image TEXT NOT NULL
);
CREATE UNIQUE INDEX customers_id_uindex ON public.customers (id);

CREATE TABLE public.users
(
    id serial PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL
);
CREATE UNIQUE INDEX users_id_uindex ON public.users (id);
CREATE UNIQUE INDEX users_email_uindex ON public.users (email);