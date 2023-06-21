# image-api
This project is an image server, which allows operations with stored images in the file systems 

### In Docker-network

You need to create a network for DNS container-names
After that you should build and image
By application start it is important to mount content from the host.
@See https://docs.docker.com/storage/bind-mounts/

```
docker build --network="host" . -f image-api.Dockerfile -t image-api --no-cache --progress=plain
docker run --net javagath  --name image-api -p 8090:8090 -v ./mnt/images/:/mnt/images -d image-api
docker network inspect javagath
```
