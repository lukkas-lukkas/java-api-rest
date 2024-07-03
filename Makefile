build:
	cp .env.example .env
	docker-compose build java-rest-api.api
	echo "Application built!"

run:
	docker-compose up -d
