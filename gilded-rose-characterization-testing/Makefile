.PHONY: default test docker-test docker-coverage mutation docker-mutation
default: docker-test

test:
	../gradlew :test

coverage:
	../gradlew :jacocoTestReport
	@printf "\nOpen build/reports/jacoco/test/html/index.html\n"

mutation:
	../gradlew :pitest
	@printf "\nOpen the last report on build/reports/pitest\n"

docker-build:
	docker build -f ../Dockerfile -t codiumteam/legacy-training-java .

docker-test:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codiumteam/legacy-training-java make test

docker-coverage:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codiumteam/legacy-training-java make coverage

docker-mutation:
	docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.gradle:/gradle-cache -w /opt/project codiumteam/legacy-training-java make mutation