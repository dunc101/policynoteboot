# Policy Note Pivotal Concourse Demo
This project is to demonstrate a Pivotal Concourse pipeline which checks out java code using maven via **git** and also using **svn**. 
You can find the pipeline scripts in the scripts/ci/ directory with **pipeline.yml** being the main pipeline file for git and **pipeline-svn.yml** being the pipeline for svn.
## Requirements and Assumptions
1. Your application must use Java 8 or above
2. All of your artifacts are compiled via maven.<br /><br />
   Note, if you need to use another language, all you would need to do is find a docker image that supports what you are trying to do and modify the appropriate build scripts.

# Git Pipeline
![alt text](https://github.com/dunc101/policynoteboot/blob/master/scripts/ci/git.pipeline.PNG)
The git pipeline uses the **pipeline.yml** file located in the scripts/ci folder and performs the following:
1. Checks out your code from a git repository of your choice and builds the artifact, runs unit tests, and runs the code against sonarqube.
   The checkout is specified via the **resource-main-code** resource.  You will need to modify the **scripts/ci/build.sh** script which is the bash script
   that controls how to build your artifact(s) that are needed.  
2. The patch version is bumped (i.e.: if your artifact is version 1.0.0 then it will be bumped to 1.0.1) via the semver **version** resource on each build and the artifact that is built is pushed into a maven SNAPSHOT repository.
   Modify the artifact resource to accomidate your needs.  This project stores the version file in the main git repo.  If you do not want to do a **git pull** each 
   time the pipeline builds, then I suggest you create your own separate repository that stores your application version.  In order to do this point the **version.uri** 
   to a separate git repository.
3. The artifact is then uploaded to your nexus repository.  Modify the **artifact** resource which should point to your nexus snapshots.  Note that we
   are not using releases as we upload the release via curl for now.
3. Next, the pipeline deploys the nexus artifact to the first Cloud Foundry environment of your choice.  Modify the **resource-deploy-dev** resource to include your own
   Cloud Foundry environment information.
4. Integration tests are then ran against the first environment via the **scripts/ci/dev-integration-tests.yml**.  Modify this script to properly run the tests that you want.
5. If the dev integration tests pass, then the artifact is deployed to your second environment named **resource-deploy-test**.
6. Your second environment integration tests will now run as specified in the **test-integration-tests** job.  Modify the **scripts/ci/test-integration-tests.yml** file
   to run your test integration tests.
7. Last, if the above passes, then the minor version of the application will be bumped (i.e.: if your artifact was 1.0.1-SNAPSHOT the version will be bumped to 1.1.0) and the SNAPSHOT artifact will be **promoted** to a release.  The exact same snapshot artifact will be used and uploaded to your Nexus **releases**
  repository with the new bumped version that is created in this resource.
  
# SVN Pipeline
![alt text](https://github.com/dunc101/policynoteboot/blob/master/scripts/ci/svn.pipeline.PNG)
The svn pipeline uses the **pipeline-svn.yml** file located in the scripts/ci folder and performs everything that the Git pipeline performs
except that it does NOT bump the version of your application due to the semver resource not supporting SVN.

# How to use this pipeline
1. git clone <this url>
2. Run fly command to add the pipeline
   ```
   fly -t <yourtarget> set-pipeline -c scripts/ci/pipeline.yml -p <yourproject> --load-vars-from credentials.yml
   ```
   Modify the credentials.yml file to include your own credentials.  This file will automatically be merged into your pipeline whenever    you run the above command.
   
   Useful commands to help with debugging that I have found:
   1. How to debug / intercept/ hijack a concourse docker image
   ```
   fly -t <yourtarget> builds
   ```
   The above will list all of the builds.
   ```
   fly -t <yourtarget> intercept -b <buildnumber>
   ```
   The buildnumber is the build you want to intercept from the fly -t <yourtarget> builds command mentioned above.

