# Velcro Template Project

To get started, simply create new directories under the `templates` directory
and put the source of the different project templates into them. You can then
package and install the templates locally with the command:

    ./gradlew installAllTemplates

You'll then be able to use Lazybones to create new projects from these templates.
If you then want to distribute them, you will need to set up a Bintray account,
populate the `repositoryUrl`, `repositoryUsername` and `repositoryApiKey` settings
in `build.gradle`, add new Bintray packages in the repository via the Bintray
UI, and finally publish the templates with

    ./gradlew publishAllTemplates
