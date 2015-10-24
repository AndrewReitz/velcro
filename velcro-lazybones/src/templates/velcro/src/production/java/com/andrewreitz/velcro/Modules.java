package {{packageName}};

final class Modules {
    static Object[] list({{applicationName}}App app) {
        return new Object[]{
                new {{applicationName}}Module(app)
        };
    }

    private Modules() {
        // No instances.
    }
}
