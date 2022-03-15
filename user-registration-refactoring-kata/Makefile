.PHONY: default test docker-build docker-test
default: docker-test

test:
	gradle :clean :test

docker-build:
	docker build -f ../Dockerfile.gradle -t codium-legacytraining:gradle .

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining:gradle make test