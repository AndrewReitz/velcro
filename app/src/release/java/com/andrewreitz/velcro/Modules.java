package com.andrewreitz.velcro;

final class Modules {
    static Object[] list(VelcroApp app) {
        return new Object[]{
                new VelcroModule(app)
        };
    }

    private Modules() {
        // No instances.
    }
}
