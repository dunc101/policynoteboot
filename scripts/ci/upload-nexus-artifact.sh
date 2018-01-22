#!/bin/bash
VERSION=$1

echo "Getting the ARTIFACT_ID"
ARTIFACT_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
echo "Getting the GROUP_ID"
GROUP_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.groupId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`

echo "ARTIFACT_ID is ${ARTIFACT_ID}"
echo "About to upload artifact to Nexus ${ARTIFACT_ID}:${GROUP_ID}:${VERSION}"
curl -v \
-u deployment:infinity \
-F "r=infinity-releases" \
-F "g=${GROUP_ID}" \
-F "a=${ARTIFACT_ID}" \
-F "v=${VERSION}" \
-F "p=jar" \
-F "e=jar" \
-F hasPom=false \
-F "file=@./artifact/*.jar" \
http://maven01.ipacc.com:8081/nexus/service/local/artifact/maven/content
#mvn deploy:deploy-file -DgroupId=${GROUP_ID} \
#  -DartifactId=${ARTIFACT_ID} \
#  -Dversion=${VERSION} \
#  -Dpackaging=jar \
#  -Durl=${NEXUS_REPO}