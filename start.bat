docker volume create "pgdata"
docker build -t "diplom-backend-ms-image" .
docker-compose build
docker-compose up