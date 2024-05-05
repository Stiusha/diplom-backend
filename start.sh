#!/bin/bash

VOLUME_NAME="pgdata"
# Check if the volume already exists
if ! docker volume ls -q --filter name="$VOLUME_NAME" | grep -q . ; then
    # Volume does not exist, so create it
    docker volume create "$VOLUME_NAME"
    echo "Volume $VOLUME_NAME created."
else
    echo "Volume $VOLUME_NAME already exists."
fi

docker build -t diplom-backend-ms-image "./Dockerfile"
docker-compose -f "./docker-compose.yml" build
docker-compose -f "./docker-compose.yml" up