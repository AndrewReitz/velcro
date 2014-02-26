package com.andrewreitz.velcro.di.module;

import com.andrewreitz.velcro.VelcroApp;

import dagger.Module;

@Module(
        addsTo = VelcroApp.class,
        includes = {
        },
        overrides = true
)
public final class DebugU2020Module {
}
