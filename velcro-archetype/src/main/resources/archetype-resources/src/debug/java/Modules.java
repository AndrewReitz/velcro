package ${package};

final class Modules {
  static Object[] list(${applicationName}App app) {
    return new Object[]{
        new ${applicationName}Module(app),
        new Debug${applicationName}Module()
    };
  }

  private Modules() {
    // No instances.
  }
}
