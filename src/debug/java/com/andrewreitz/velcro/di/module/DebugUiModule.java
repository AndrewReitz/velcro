package com.andrewreitz.velcro.di.module;

import com.andrewreitz.velcro.ui.ActivityHierarchyServer;
import com.andrewreitz.velcro.ui.AppContainer;
import com.andrewreitz.velcro.ui.debug.DebugAppContainer;
import com.andrewreitz.velcro.ui.debug.SocketActivityHierarchyServer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = DebugAppContainer.class,
        complete = false,
        library = true,
        overrides = true
)
public class DebugUiModule {
    @Provides @Singleton AppContainer provideAppContainer(DebugAppContainer debugAppContainer) {
        return debugAppContainer;
    }

    @Provides @Singleton ActivityHierarchyServer provideActivityHierarchyServer() {
        return new SocketActivityHierarchyServer();
    }
}
