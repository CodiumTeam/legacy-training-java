.PHONY: default test docker-test
default: docker-test

test:
	../gradlew :test

docker-test:
	docker run --rm -v ${PWD}:/code/kata -v ${PWD}/../.gradle:/gradle-cache codiumteam/legacy-training-java make test
