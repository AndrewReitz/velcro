# Velcro

## Bootstrap for your Android Projects.

Get your Android applications of the ground and running fast with this archetype. This bootstrap should contain everything you need to get going but not so much you \
have to spend time stripping things out. If you find your self deleting something frequently then it should probably be moved. This application is highly based off o\
f Jake Whartons's [U2020](https://github.com/JakeWharton/u2020) and has a debug drawer reading and waiting for more awesomeness.

## Usage

You will need Maven installed to use this archetype

Run:
    mvn archetype:generate \
    -DarchetypeArtifactId=velcro \
    -DarchetypeGroupId=com.andrewreitz \
    -DarchetypeVersion=1.0.0-SNAPSHOT \
    -DgroupId={your.package.name.here} \
    -DartifactId={appName} \
    -DapplicationName={AppName} \
    -Dversion=1.0

Filling in the groupId, artifactId, and applicationName. Where groupId is the package you want for your application, artifactId should be your application name with no spaces and camel cased, and applicationName is the name of your application all one word.

cd into the directory that was created and run the following
    chmod +x gradlew
    mv gradle.properties.dist gradle.properties
    
## Other Info
The gradle.properties.dist is an example of what your gradle.properties should look like. This helps avoid checking in of release signing passwords. The data in there can be incorrect for debug builds but is still required to be there for gradle to run.

## License

  Copyright 2014 Andrew Reitz

  Licensed under the Apache License, Version 2.0 (the "License");
      you may not use this file except in compliance with the License.
	  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

