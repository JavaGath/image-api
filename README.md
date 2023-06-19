# image-api
This project is an image server, which allows operations with stored images in the file systems 

### In Docker-network

You need to create a network for DNS container-names

```
docker run --net javagath  --name image-api -p 8090:8090 -d image-api
docker network inspect javagath
```
