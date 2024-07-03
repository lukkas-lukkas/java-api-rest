build:
	cp .env.example .env
	docker-compose build api
	echo "Application built successfully"

run:
	docker-compose up
