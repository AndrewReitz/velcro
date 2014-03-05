package com.andrewreitz.velcro;

import com.andrewreitz.velcro.di.module.DebugVelcroModule;
import com.andrewreitz.velcro.di.module.VelcroModule;

import org.jetbrains.annotations.NotNull;

final class Modules {
    static Object[] list(@NotNull VelcroApp app) {
        return new Object[]{
                new VelcroModule(app),
                new DebugVelcroModule()
        };
    }

    private Modules() {
        // No instances.
    }
}
