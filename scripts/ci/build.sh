#!/bin/bash 

mkdir ${HOME}/.m2
cp resource-main-code/settings.xml ${HOME}/.m2/
#cd resource-main-code/policynoteboot
#ARTIFACT_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
#GROUP_ID=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.groupId}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
#VERSION=`mvn -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec 2>/dev/null`
#printf "$GROUP_ID.$ARTIFACT_ID-$VERSION" > ${HOME}/VERSION
#cd ..
cd resource-main-code/PolicyNoteServiceDomain
mvn install -DskipTests=true
cd ../policynoteboot
mvn clean package test install pmd:pmd sonar:sonar -Dsonar.host.url=http://sonar01.ipacc.com:9000/ -Dsonar.scm.disabled=True
cd target
#echo "Adding the manifest"
#echo '---' > manifest.yml
#echo 'applications:' >> manifest.yml
#echo '- name: policynoteboot' >> manifest.yml
#echo '  path: /tmp/build/put/out/app.jar' >> manifest.yml
mv *.jar app.jar
#cp manifest.yml ../../../out
echo "Copying the jar file to the output directory."
cp app.jar ../../../out
#curl -v \
#-u snapshotdeploy:snapshotinfinity! \
#-F "r=infinity-snapshots" \
#-F "g=${GROUP_ID}" \
#-F "a=${ARTIFACT_ID}" \
#-F "v=${VERSION}" \
#-F "p=jar" \
#-F "e=jar" \
#-F hasPom=false \
#-F "file=@./app.jar" \
#http://maven01.ipacc.com:8081/nexus/service/local/artifact/maven/content