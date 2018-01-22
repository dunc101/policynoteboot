#!/bin/bash 

cat resource-main-code/version
# Update the poms version to the file that is created from the semver resource
VERSION=`cat resource-main-code/version`

# Let's copy the settings.xml file to the correct location so that we have acces to the Infinity jar files
mkdir ${HOME}/.m2
cp resource-main-code/settings.xml ${HOME}/.m2/

# First, build any dependent jars
cd resource-main-code/PolicyNoteServiceDomain
mvn install -DskipTests=true

# Now, build the deployable artifact projects
cd ../policynoteboot
echo "Echoign the version"
echo "Version is ${VERSION}"
#echo "Setting the new version to ${VERSION}"
mvn versions:set -DnewVersion=${VERSION}-SNAPSHOT
# Below is needed if you are updating a parent pom
# mvn versions:update-child-modules
mvn clean package test install pmd:pmd sonar:sonar -Dsonar.host.url=http://sonar01.ipacc.com:9000/ -Dsonar.scm.disabled=True

# Copy the jar file to our out directory so that we can upload it to Nexus
cp pom.xml ../../out
cd target
mv *.jar app.jar
echo "Copying the jar file to the output directory."
cp app.jar ../../../out