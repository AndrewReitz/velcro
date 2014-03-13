package ${package};

import org.jetbrains.annotations.NotNull;

final class Modules {
    static Object[] list(@NotNull ${applicationName}App app) {
        return new Object[]{
                new ${applicationName}Module(app),
                new Debug${applicationName}Module()
        };
    }

    private Modules() {
        // No instances.
    }
}
