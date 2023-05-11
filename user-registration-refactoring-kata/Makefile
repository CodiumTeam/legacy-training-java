.PHONY: default test docker-build docker-test
default: docker-test

test:
	../gradlew :test

docker-build:
	docker build -f ../Dockerfile -t codiumteam/legacy-training-java ..

docker-test:
	docker run --rm -v ${PWD}:/code/kata -v ${PWD}/../.gradle:/gradle-cache codiumteam/legacy-training-java make test