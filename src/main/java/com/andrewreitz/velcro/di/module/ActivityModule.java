package com.andrewreitz.velcro.di.module;

import android.app.Activity;
import android.content.Context;

import com.andrewreitz.velcro.di.annotation.ForActivity;
import com.andrewreitz.velcro.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

@Module(
        injects = {
                MainActivity.class
        },
        addsTo = VelcroModule.class,
        library = true
)
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = checkNotNull(activity);
    }

    /**
     * Allow the activity context to be injected but require that it be annotated with
     * {@link com.andrewreitz.velcro.di.annotation.ForActivity } to explicitly
     * differentiate it from application context.
     */
    @Provides @Singleton @ForActivity Context provideActivityContext() {
        return activity;
    }
}
