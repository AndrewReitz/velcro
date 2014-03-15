# Maven Archetype

This is the archetype of the velcro app that is uplaoded to Maven Central

TODO: Add instructions here

    mvn archetype:generate \
      -DarchetypeArtifactId=velcro \
      -DarchetypeGroupId=com.andrewreitz \
      -DarchetypeVersion=1.0.0-SNAPSHOT \
      -DgroupId=com.test.testing \
      -DartifactId=test \
      -DapplicationName=Test \
      -Dversion=1.0

    chmod +x gradlew

    mv gradle.properties.dist gradle.properties
