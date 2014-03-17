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
    -DarchetypeGroupId=com.andrewreitz.velcro \
    -DarchetypeVersion=1.0.0 \
    -DgroupId={your.package.name.here} \
    -DartifactId={app-name} \
    -DapplicationName={AppName} \
    -Dversion=1.0

Filling in the groupId, artifactId, and applicationName. Where groupId is the package you want for your application, artifactId should be your application name with no spaces (ex. my-test-app), and applicationName is the name of your application all one word (ex. MyTestApp).

cd into the directory that was created and run the following

    chmod +x gradlew
    mv gradle.properties.dist gradle.properties
    
Your application is now ready to be imported into Android Studio or run gradle tasks

## Libraries Included

Before diving in and using this project I suggest you check out and understand these libraries. Most of them will do work for you automatically when you use the BaseActivity or BaseFragment.

* [Dagger](https://github.com/square/dagger) Dependecy Injector
* [Butter Knife](https://github.com/JakeWharton/butterknife) View Injector
* [Icepick](https://github.com/frankiesardo/icepick) Save and Restore State
* [Guava](https://code.google.com/p/guava-libraries/) Core Google Java Libs
* [IntelliJ Annotations](https://www.jetbrains.com/idea/documentation/howto.html) @NotNull and @NotNull
* [Timber](https://github.com/JakeWharton/timber) Better Android Logger
* [Madge](https://github.com/JakeWharton/madge) Asset Debugging
* [Scalpel](https://github.com/JakeWharton/scalpel) View Debugging

## Other Info

The gradle.properties.dist is an example of what your gradle.properties should look like. This helps avoid checking in of release signing passwords. The data in there can be incorrect for debug builds but is still required to be there for gradle to run. The pom.xml is left over from the archetype and my be deleted.

## Contributing

A gradle script has been setup so that all you need to do to add your own code to the starting project is to open up the velcro-app in Android studio and work on it like you would any other Android Project. Assuming you keep the same package and application name (Velcro) you should be able to run `gradle build`. This will copy the files over into their correct location and and archetype variables where required. From this point you can continue on like it's a standard maven archetype for testing and deployment.

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
	
