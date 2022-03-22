.PHONY: default run docker-run
default: docker-run

run:
	gradle --quiet :run

docker-build:
	docker build -f ../Dockerfile.gradle -t codium-legacytraining .

docker-run:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codium-legacytraining make run
