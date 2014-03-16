package ${package}.ui;

import ${package}.ui.ActivityHierarchyServer;
import ${package}.ui.AppContainer;
import ${package}.ui.debug.DebugAppContainer;
import ${package}.ui.debug.SocketActivityHierarchyServer;

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
