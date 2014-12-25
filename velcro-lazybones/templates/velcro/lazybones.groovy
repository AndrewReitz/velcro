// Stops handle bar lib from spitting out slf4j warnings.
@Grab(group='org.slf4j', module='slf4j-nop', version='1.7.9')

// Setup for handle bar template engine.
@GrabResolver(name='jcenter', root='http://jcenter.bintray.com/')
@Grab(group='uk.co.cacoethes', module='groovy-handlebars-engine', version='0.2')

import org.apache.commons.io.FileUtils
import uk.co.cacoethes.util.NameType
import uk.co.cacoethes.handlebars.HandlebarsTemplateEngine
import groovy.io.FileType

// Set handle bar template engine as the defule engine.
registerDefaultEngine new HandlebarsTemplateEngine()

def props = [:]
props.packageName = ask("Define value for 'package' [com.example]: ", "com.example", "packageName")

def applicationNameInput = ask("Define value for 'applicationName' [ExampleApp]: ", "ExampleApp", "applicationName").capitalize()
def gradleProjectName = transformText(applicationNameInput, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)
def applicationName = transformText(applicationNameInput, from: NameType.HYPHENATED, to: NameType.CAMEL_CASE)
props.applicationName = applicationName
props.projectName = gradleProjectName

processTemplates "src/**/*.java", props
processTemplates "src/**/*.xml", props
processTemplates "settings.gradle", props

// Ask For A Licence Header File
// TODO
enum License {
  APACHE2("", ""),
  MIT("", ""),
  NONE("none", "");

  private final String name;
  private final String header;

  License(String name, String header) {
    this.name = name;
    this.header = header;
  }
}

// Move velcro-app.gradle to build.gradle
FileUtils.moveFile(new File(projectDir, "velcro-app.gradle"), new File(projectDir, "${gradleProjectName}.gradle"))

println "HERE 1"
projectDir.eachFileRecurse (FileType.FILES) { file ->
  println "HERE $file"
  if (file.name.contains("Velcro")) {
    println "Found a match: $file"
    def destFile = new File(file.parent, file.name.replace("Velcro", applicationName))
    FileUtils.moveFile(file, destFile)
  }
}
