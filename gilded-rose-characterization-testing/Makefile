.PHONY: default test docker-test docker-coverage mutation docker-mutation
default: docker-test

test:
	gradle :test

coverage:
	gradle :jacocoTestReport
	@printf "\nOpen build/reports/jacoco/test/html/index.html\n"

mutation:
	gradle :pitest
	@printf "\nOpen the last report on build/reports/pitest\n"

docker-build:
	docker build -f ../Dockerfile.gradle -t codium-legacytraining .

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codium-legacytraining make test

docker-coverage:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codium-legacytraining make coverage

docker-mutation:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codium-legacytraining make mutation