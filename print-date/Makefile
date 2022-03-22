.PHONY: default test docker-test docker-build
default: docker-test

test:
	gradle :test

docker-build:
	docker build -f ../Dockerfile.gradle -t codium-legacytraining:gradle .

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codium-legacytraining:gradle make test
