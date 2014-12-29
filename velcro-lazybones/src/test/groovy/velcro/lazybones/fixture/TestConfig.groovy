package velcro.lazybones.fixture

class TestConfig {
  Properties testConfigProperties

  TestConfig() {
    def testConfigResourcePath = "/test-config.properties"
    def testConfigResourceStream = getClass().getResourceAsStream(testConfigResourcePath)
    if (!testConfigResourceStream) {
      throw new RuntimeException(
              "Test config properties resource file not found at $testConfigResourcePath. Run 'writeTestConfig' task to generate it.")
    }
    testConfigProperties = new Properties()
    testConfigProperties.load(testConfigResourceStream)
  }

  File getTemplateDirectory() {
    new File(testConfigProperties["template.path"])
  }
}
