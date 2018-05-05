CREATE TABLE public.customers
(
    id serial PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    image TEXT NOT NULL
);
CREATE UNIQUE INDEX customers_id_uindex ON public.customers (id);