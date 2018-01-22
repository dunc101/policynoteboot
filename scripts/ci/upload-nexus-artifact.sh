#!/bin/bash
VERSION=$1
NEXUS_REPO=$2

ARTIFACT_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
GROUP_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.groupId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`

echo "About to upload artifact to Nexus ${ARTIFACT_ID}:${GROUP_ID}:${VERSION}"
mvn deploy:deploy-file -DgroupId=${project.groupId} \
  -DartifactId=${project.artifactId} \
  -Dversion=${VERSION} \
  -Dpackaging=${project.packaging} \
  -Durl=${NEXUS_REPO}