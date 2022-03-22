.PHONY: default test docker-test docker-coverage
default: docker-test

test:
	gradle :clean :test

coverage:
	gradle :clean :jacocoTestReport
	@printf "\nOpen build/reports/jacoco/test/html/index.html\n"

docker-build:
	docker build -f ../Dockerfile.gradle -t codium-legacytraining:gradle .

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining:gradle make test

docker-coverage:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project codium-legacytraining:gradle make coverage