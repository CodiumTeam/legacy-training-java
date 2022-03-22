.PHONY: default run docker-run
default: docker-run

run:
	gradle --quiet :build :run

docker-build:
	docker build -f ../Dockerfile.gradle -t codium-legacytraining:gradle .

docker-run:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining:gradle make run
