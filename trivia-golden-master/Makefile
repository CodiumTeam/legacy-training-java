.PHONY: default run docker-run
default: docker-run

run:
	@../gradlew --quiet :run

docker-build:
	docker build -f ../Dockerfile -t codiumteam/legacy-training-java ..

docker-run:
	@docker run --rm -v ${PWD}:/code/kata -v ${PWD}/../.gradle:/gradle-cache codiumteam/legacy-training-java make run
