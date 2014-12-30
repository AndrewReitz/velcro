package velcro.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class WriteTestConfig extends DefaultTask {

  File generatedTestResourcesDir

  @Input
  Properties testProperties = new Properties()

  @OutputFile
  File getTestConfigPropertiesFile() {
    new File(generatedTestResourcesDir, 'test-config.properties')
  }

  @TaskAction
  def generate() {
    testConfigPropertiesFile.withOutputStream { testProperties.store(it, null) }
  }
}