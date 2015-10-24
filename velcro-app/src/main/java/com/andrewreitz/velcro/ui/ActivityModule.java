package com.andrewreitz.velcro.ui;

import android.app.Activity;

import com.andrewreitz.velcro.VelcroModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
        /* Fragment's Here */
    },
    addsTo = VelcroModule.class,
    library = true
)
public class ActivityModule {
  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides @Singleton Activity provideActivityContext() {
    return activity;
  }
}
