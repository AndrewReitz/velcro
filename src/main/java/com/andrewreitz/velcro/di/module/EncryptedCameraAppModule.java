package com.andrewreitz.velcro.di.module;

import dagger.Module;

@Module(
        includes = {
                AndroidModule.class,
                ActivityModule.class
        }
)
public class EncryptedCameraAppModule {
}
