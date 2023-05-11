#!/bin/bash
ERROR=""
OUTPUT=""
function printStatus() {
  if [ $? -ne 0 ]; then
    echo "Error"
    ERROR="${ERROR} \n\n${OUTPUT}"
  else
    echo "Ok"
  fi
}

function validateKata() {
    echo -n "Validating $1..."
    OUTPUT=$($2 2>&1 && $3 2>&1 && $4 2>&1)
    printStatus
}

function validateDocker() {
    echo -n "Validating docker running..."
    (docker ps) > /dev/null
    if [ $? -ne 0 ]; then
      echo "Error"
      echo "Are you sure that you have docker running?"
      echo "If you don't want to install docker, you can open tennis-refactoring-kata and run the tests using your IDE."
      exit -1
    else
      echo "Ok"
    fi

    echo -n "Creating the docker image..."
    (docker build . -t codiumteam/legacy-training-java) > /dev/null
    if [ $? -ne 0 ]; then
      echo "Error"
      echo "Do you have internet connection?"
      exit -1
    else
      echo "Ok"
    fi

    echo -n "Validating docker mount permissions..."
    (docker run --rm -v ${PWD}:/opt/project -w /opt/project codiumteam/legacy-training-java ls) > /dev/null
    if [ $? -ne 0 ]; then
      echo "Error"
      echo "Are you sure that you have permissions to mount your volumes?"
      exit -1
    else
      echo "Ok"
    fi
}

function validateMake() {
  echo -n "Validating make installed..."
    (make -h) > /dev/null
    if [ $? -ne 0 ]; then
      echo "Error"
      echo "Do you have make installed?"
      echo "If you don't want to install make, you can open tennis-refactoring-kata and run the tests using your IDE."
      exit -1
    else
      echo "Ok"
    fi
}
echo "Without docker"
validateKata web-page-generator-kata "cd web-page-generator-kata" "make run"
validateKata tennis-refactoring-kata "cd tennis-refactoring-kata" "make test"
validateKata user-registration-refactoring-kata "cd user-registration-refactoring-kata" "make test"
validateKata gilded-rose-characterization-testing "cd gilded-rose-characterization-testing" "make docker-coverage" "make mutation"
validateKata weather-kata "cd weather-kata" "make docker-test" "make coverage"
validateKata trip-service-kata "cd trip-service-kata" "make docker-test" "make coverage"
validateKata trivia-golden-master "cd trivia-golden-master" "make run"
validateKata gilded-rose-golden-master "cd gilded-rose-golden-master" "make run"
validateKata print-date "cd print-date" "make test"

echo -n "With docker"
validateDocker
validateMake
validateKata docker-web-page-generator-kata "cd web-page-generator-kata" "make docker-run"
validateKata docker-tennis-refactoring-kata "cd tennis-refactoring-kata" "make docker-test"
validateKata docker-user-registration-refactoring-kata "cd user-registration-refactoring-kata" "make docker-test"
validateKata docker-gilded-rose-characterization-testing "cd gilded-rose-characterization-testing" "make docker-coverage" "make docker-mutation"
validateKata docker-weather-kata "cd weather-kata" "make docker-test" "make docker-coverage"
validateKata docker-trip-service-kata "cd trip-service-kata" "make docker-test" "make docker-coverage"
validateKata docker-trivia-golden-master "cd trivia-golden-master" "make docker-run"
validateKata docker-gilded-rose-golden-master "cd gilded-rose-golden-master" "make docker-run"
validateKata docker-print-date "cd print-date" "make docker-test"

if [ -z "$ERROR" ]; then
  echo "Congratulations! You are ready for the training!"
else
  echo -e "----------------------------------------------------------\n\n$ERROR"
  echo -e "\n\nPlease send an email with the problem you have to info@codium.team\n"
fi
