# Change Log

# 3.0.3 *(2014-11-03)*

* Setup to work for Lollipop
* Removed need to copy gradle.properties.dist to gradle.properties

# 2.1.0

* Created CHANGELOG
* Updated libraries to there latest
* Updated Android Gradle Plugin
* Added SDK Manager Plugin
* Added VelcroInitializer.java for initializing things in specific builds rather
then using Build.DEBUG. This will allow for easier creation of other build types
that mix and match initializations.
* Removed Guava and IntelliJ Annotations to make boot strap lighter weight
* Added Android Preferences Library in replace of the data/prefs classes
