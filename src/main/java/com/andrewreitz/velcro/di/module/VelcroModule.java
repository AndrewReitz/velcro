package com.andrewreitz.velcro.di.module;

import android.app.Application;

import com.andrewreitz.velcro.VelcroApp;
import com.andrewreitz.velcro.di.annotation.ForApplication;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                UiModule.class,
                DataModule.class
        },
        injects = {
                VelcroApp.class
        }
)
public final class VelcroModule {
    private final VelcroApp app;

    public VelcroModule(@NotNull VelcroApp app) {
        this.app = app;
    }

    /**
     * Allow the app context to be injected but require that it be annotated with
     * {@link com.andrewreitz.velcro.di.annotation.ForApplication}
     * to explicitly differentiate it from an activity context.
     */
    @Provides @Singleton @ForApplication Application provideApplication() {
        return app;
    }
}
