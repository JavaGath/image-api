FROM maven:3.9
# Create app-directory and copy the project
ADD . /image-api

WORKDIR /image-api

# Is everything ok?
RUN echo "Show me the content"
RUN ls -a

# Run Maven build
RUN mvn install

RUN echo "jar is ready"
# Remove the build container and just use the build artifact
FROM openjdk:17-jdk

LABEL maintainer="Ievgenii Izrailtenko"

# Add jar to container
COPY --from=0 "/image-api/target/image-api.jar" image-api.jar

# Run jar-artifact
CMD ["java","-jar","/image-api.jar"]