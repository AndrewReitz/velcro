package com.andrewreitz.velcro;

import com.andrewreitz.velcro.di.module.VelcroModule;

final class Modules {
    static Object[] list(U2020App app) {
        return new Object[]{
                new VelcroModule(app)
        };
    }

    private Modules() {
        // No instances.
    }
}
