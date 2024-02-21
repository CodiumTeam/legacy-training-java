.PHONY: docker-build docker-push docker-remove-images

docker-build:
	docker build -t codiumteam/legacy-training-java .

docker-push:
	docker push codiumteam/legacy-training-java

docker-remove-images:
	docker images codiumteam/legacy-training-java -q | xargs  docker rmi --force $1
