package com.andrewreitz.velcro.di.module;

import android.app.Application;

import com.andrewreitz.velcro.VelcroApp;
import com.andrewreitz.velcro.di.annotation.ForApplication;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

@Module(
        library = true,
        includes = {
        },
        injects = {
        }
)
public class AndroidModule {

    private final VelcroApp app;

    public AndroidModule(@NotNull VelcroApp app) {
        this.app = checkNotNull(app);
    }

    /**
     * Allow the app context to be injected but require that it be annotated with
     * {@link com.andrewreitz.velcro.di.annotation.ForApplication}
     * to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication Application provideApplicationContext() {
        return app;
    }
}
