.PHONY: default run docker-run
default: docker-run

run:
	../gradlew --quiet :run

docker-build:
	docker build -f ../Dockerfile -t codiumteam/legacy-training-java .

docker-run:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codiumteam/legacy-training-java make run
