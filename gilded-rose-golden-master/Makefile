.PHONY: default run docker-run
default: docker-run

run:
	@../gradlew --quiet :run

docker-run:
	@docker run --rm -v ${PWD}:/code/kata -v ${PWD}/../.gradle:/gradle-cache codiumteam/legacy-training-java make run
