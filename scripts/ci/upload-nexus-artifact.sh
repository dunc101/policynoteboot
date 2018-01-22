#!/bin/bash
POM_DIRECTORY=$1
VERSION=$2
NEXUS_REPO=$3

cd $POM_DIRECTORY
ARTIFACT_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
GROUP_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.groupId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`

echo "About to upload artifact to Nexus ${ARTIFACT_ID}:${GROUP_ID}:${VERSION}"
mvn deploy:deploy-file -DgroupId=${GROUP_ID} \
  -DartifactId=${ARTIFACT_ID} \
  -Dversion=${VERSION} \
  -Dpackaging=jar \
  -Durl=${NEXUS_REPO}