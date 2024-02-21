.PHONY: default test docker-test
default: docker-test

test:
	gradle :test

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codium-legacytraining make test
