# SHOP-API

## POSTGRES

To run your database you need install Docker 
And do the next sentences:

- cd src/main/docker/
- docker build -t shoptheam .
- docker run --name shoptheam -p 5432:5432 -d shoptheam

Finally you can verify the container with
docker ps