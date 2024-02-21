.PHONY: default run docker-build docker-run
default: docker-run

run:
	../gradlew --quiet :build :run
	@echo "Webpage generated at html/users.html"

docker-run:
	docker run --rm -v ${PWD}:/code/kata -v ${PWD}/../.gradle:/gradle-cache codiumteam/legacy-training-java make run