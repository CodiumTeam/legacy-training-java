.PHONY: default test docker-test docker-coverage
default: docker-test

test:
	../gradlew :test

coverage:
	../gradlew :jacocoTestReport
	@printf "\nOpen build/reports/jacoco/test/html/index.html\n"

docker-test:
	docker run --rm -v ${PWD}:/code/kata -v ${PWD}/../.gradle:/gradle-cache codiumteam/legacy-training-java make test

docker-coverage:
	docker run --rm -v ${PWD}:/code/kata -v ${PWD}/../.gradle:/gradle-cache codiumteam/legacy-training-java make coverage