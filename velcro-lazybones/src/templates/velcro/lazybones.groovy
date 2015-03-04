// Stops handle bar lib from spitting out slf4j warnings.
@Grab(group='org.slf4j', module='slf4j-nop', version='1.7.9')

// Setup for handle bar template engine.
@GrabResolver(name='jcenter', root='http://jcenter.bintray.com/')
@Grab(group='uk.co.cacoethes', module='groovy-handlebars-engine', version='0.2')

import org.apache.commons.io.FileUtils
import uk.co.cacoethes.util.NameType
import uk.co.cacoethes.handlebars.HandlebarsTemplateEngine
import groovy.io.FileType

// Files with this name need to be replaced.
final String FILE_FILTER = "Velcro"

// Set handle bar template engine as the defule engine.
registerDefaultEngine new HandlebarsTemplateEngine()

def props = [:]
props.packageName = ask("Define value for 'package' [com.example]: ", "com.example", "packageName")

String applicationNameInput = ask("Define value for 'applicationName' [ExampleApp]: ", "ExampleApp", "applicationName").capitalize()
String gradleProjectName = transformText(applicationNameInput, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)
String applicationName = transformText(applicationNameInput, from: NameType.HYPHENATED, to: NameType.CAMEL_CASE)

println "packageName: $props.packageName"
println "applicationNameinput: $applicationNameInput"
println "gradleProjectName: $gradleProjectName"
println "applicationName: $applicationName"

props.applicationName = applicationName
props.projectName = gradleProjectName

processTemplates "src/**/*.java", props
processTemplates "src/**/*.xml", props
processTemplates "settings.gradle", props

// Move velcro-app.gradle to build.gradle
File srcFile = new File(projectDir, "velcro-app.gradle")
File destFile = new File(projectDir, "${gradleProjectName}.gradle")
FileUtils.moveFile(srcFile, destFile)

projectDir.eachFileRecurse (FileType.FILES) { file ->
  if (file.name.contains(FILE_FILTER)) {
    destFile = new File(file.parent, file.name.replace(FILE_FILTER, applicationName))
    FileUtils.moveFile(file, destFile)
  }
}

def getPackageDir(String value) { new File(projectDir, "src/$value/java/com/andrewreitz/velcro") }
def getNewPackageDir(String newPackagePath, String value) { new File(projectDir, "src/$value/java/$newPackagePath") }
def getFileToDelete(String value) { new File(projectDir, "src/$value/java/com/andrewreitz") }

String packagePath = props.packageName.replace(".", File.separator)

["debug", "main", "release"].each {
  FileUtils.moveDirectory(getPackageDir(it), getNewPackageDir(packagePath, it))
  FileUtils.deleteDirectory(getFileToDelete(it))
}
