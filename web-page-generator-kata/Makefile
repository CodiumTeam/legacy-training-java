.PHONY: default run docker-build docker-run
default: docker-run

run:
	gradle :build :run
	@echo "Webpage generated at html/users.html"

docker-build:
	docker build -f ../Dockerfile.gradle -t codium-legacytraining:gradle .

docker-run:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining:gradle make run