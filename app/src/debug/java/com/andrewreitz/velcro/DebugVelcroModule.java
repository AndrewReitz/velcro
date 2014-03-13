package com.andrewreitz.velcro;

import com.andrewreitz.velcro.data.DebugDataModule;
import com.andrewreitz.velcro.ui.DebugUiModule;

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
