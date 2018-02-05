#!/bin/bash

set -xe

sed "s/APPNAME/$PWS_APP_SUFFIX/" resource-main-code/manifest/manifest.yml > ./app-manifest-output/manifest.yml

cat ./app-manifest-output/manifest.yml