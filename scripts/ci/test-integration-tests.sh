#!/bin/bash

# resource-main-code and resource-test-integration-code are inputs
# APP_ROUTE is an input parameter from pipeline.yml

mkdir ${HOME}/.m2
cp resource-main-code/scripts/ci/settings.xml ${HOME}/.m2
cd resource-test-integration-code

# My integration tests expects serverUrl as an input parameter
mvn test -DserverUrl=$APP_ROUTE