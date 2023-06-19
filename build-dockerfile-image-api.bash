mvn clean install
cp -R /Users/ievgeniiizrailtenko/Projects/images/ target/images/
docker build --network="host" . -f image-api.Dockerfile -t image-api --no-cache --progress=plain