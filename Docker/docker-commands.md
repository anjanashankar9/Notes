### Building a docker image

cd to the parent directory where dockerfile exists, then do a docker build

```shell
docker build parent_dir
```

### List the images in local docker image cache

```shell
docker image ls
```

### Run the image 

Get the <image-id> from the output of the above command
```shell
docker run -p 8080:8080 <image-id>
```
