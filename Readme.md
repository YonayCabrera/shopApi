# SHOP-API

## POSTGRES

To run your database you need install Docker 
And do the next sentences:

- cd src/main/docker/
- docker build -t shopdb .
- docker run --name shopdb -p 5432:5432 -d shopdb

Finally you can verify the container with
docker ps