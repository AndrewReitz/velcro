package com.andrewreitz.velcro.di.module;

import dagger.Module;

@Module(
        addsTo = VelcroModule.class,
        includes = {
                DebugUiModule.class,
                DebugDataModule.class
        },
        overrides = true
)
public final class DebugVelcroModule {
}
