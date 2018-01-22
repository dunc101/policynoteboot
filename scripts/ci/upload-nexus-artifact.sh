#!/bin/bash
VERSION=$1
NEXUS_REPO=$2

echo "About to upload artifact to Nexus"
mvn deploy-deploy-file deploy:deploy-file -DgroupId=${project.groupId} \
  -DartifactId=${project.artifactId} \
  -Dversion=${VERSION} \
  -Dpackaging=${project.packaging} \
  -Durl=${NEXUS_REPO}