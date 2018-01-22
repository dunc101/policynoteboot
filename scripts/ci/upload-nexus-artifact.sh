#!/bin/bash
POM_DIRECTORY=$1
VERSION=$2
PACKAGE_TYPE=$3

# Let's copy the settings.xml file to the correct location so that we have acces to the Infinity jar files
mkdir ${HOME}/.m2
cp resource-main-code/settings.xml ${HOME}/.m2/

# Record my current directory
MAIN_DIRECTORY=`pwd`
cd $POM_DIRECTORY
echo "Getting the ARTIFACT_ID"
ARTIFACT_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
echo "Getting the GROUP_ID"
GROUP_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.groupId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
# Go back to the start directory.... 
cd $MAIN_DIRECTORY
NEW_DIR=`pwd`
echo "Curernt new dir is ${NEW_DIR}"
# Move the jar to a generic name so we can easily upload it
mv artifact/*.jar artifact/app.jar

echo "ARTIFACT_ID is ${ARTIFACT_ID}"
echo "About to upload artifact to Nexus ${ARTIFACT_ID}:${GROUP_ID}:${VERSION}"
curl -v \
-u deployment:infinity \
-F "r=infinity-releases" \
-F "g=${GROUP_ID}" \
-F "a=${ARTIFACT_ID}" \
-F "v=${VERSION}" \
-F "p=${PACKAGE_TYPE}" \
-F "e=${PACKAGE_TYPE}" \
-F hasPom=false \
-F "file=@./artifact/app.jar" \
http://maven01.ipacc.com:8081/nexus/service/local/artifact/maven/content
#mvn deploy:deploy-file -DgroupId=${GROUP_ID} \
#  -DartifactId=${ARTIFACT_ID} \
#  -Dversion=${VERSION} \
#  -Dpackaging=jar \
#  -Durl=${NEXUS_REPO}