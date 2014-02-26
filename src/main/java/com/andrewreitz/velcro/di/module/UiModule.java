package com.andrewreitz.velcro.di.module;

import com.andrewreitz.velcro.ui.ActivityHierarchyServer;
import com.andrewreitz.velcro.ui.AppContainer;
import com.andrewreitz.velcro.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
        MainActivity.class
    },
    complete = false,
    library = true
)
public class UiModule {
  @Provides @Singleton AppContainer provideAppContainer() {
    return AppContainer.DEFAULT;
  }

  @Provides @Singleton ActivityHierarchyServer provideActivityHierarchyServer() {
    return ActivityHierarchyServer.NONE;
  }
}
