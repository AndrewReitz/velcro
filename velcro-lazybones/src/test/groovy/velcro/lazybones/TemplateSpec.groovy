package velcro.lazybones

import org.apache.commons.compress.archivers.ArchiveOutputStream
import org.apache.commons.compress.archivers.ArchiveStreamFactory
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.utils.IOUtils
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.internal.consumer.DefaultGradleConnector
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification
import velcro.lazybones.fixture.TestConfig

import java.util.concurrent.TimeUnit

import static org.apache.commons.compress.archivers.ArchiveStreamFactory.ZIP

class TemplateSpec extends Specification {

  @Rule
  TemporaryFolder projectDirectory = new TemporaryFolder()

  TestConfig testConfig = new TestConfig()

  File testFile = new File(System.getProperty("user.home"),
          ".lazybones/templates/velcro-test-0.0.0-SNAPSHOT.zip")

  def setup() {
    def addFileToZip
    addFileToZip = { ArchiveOutputStream aos, String path, String base ->
      File file = new File(path)
      String entryName = base + file.getName()
      ZipArchiveEntry entry = new ZipArchiveEntry(file, entryName)
      entry.unixMode = Integer.valueOf("777", 8)
      aos.putArchiveEntry(entry)

      if (file.isFile()) {
        InputStream is = new FileInputStream(file);
        IOUtils.copy(is, aos)
        aos.closeArchiveEntry()
        IOUtils.closeQuietly(is)
      } else {
        aos.closeArchiveEntry()
        file.listFiles()?.each { child ->
          addFileToZip(aos, child.getAbsolutePath(), entryName + "/");
        }
      }
    }

    OutputStream os = new FileOutputStream(testFile);
    ArchiveOutputStream aos = new ArchiveStreamFactory()
            .createArchiveOutputStream(ZIP, os)

    testConfig.templateDirectory.listFiles()?.each { child ->
      addFileToZip(aos, child.getAbsolutePath(), "");
    }

    aos.close()
    os.close()
  }

  def cleanup() {
    testFile.delete()
  }

  def "create and compile new project"() {
    given:
      ProcessBuilder processBuilder = new ProcessBuilder("lazybones", "create",
              "velcro-test", "0.0.0-SNAPSHOT", ".", "-PpackageName=com.awesomeapp.test",
              "-PapplicationName=SpockTest")
      processBuilder.directory(projectDirectory.root)
      processBuilder.environment().put("PATH", System.getenv("PATH"))
      def process = processBuilder.start()
      if (process.waitFor() != 0) {
        throw new Exception("Error generating project " +
                "${process.inputStream.readLines().join("\n")} " +
                "\n ${process.errorStream.readLines().join("\n")}")
      }

      DefaultGradleConnector connector = GradleConnector.newConnector() as DefaultGradleConnector
      connector.forProjectDirectory(projectDirectory.root)
    when:
      connector.connect().newBuild().forTasks("clean", "assembleDebug").run()
    then:
    new File(projectDirectory.root, "src/main/java/com/awesomeapp/test/SpockTestApp.java").exists()
      noExceptionThrown()
  }
}