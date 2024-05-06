#!/bin/bash

docker volume create "pgdata"
docker-compose build
docker-compose up