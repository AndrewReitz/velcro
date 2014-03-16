package ${package};

import ${package}.data.DebugDataModule;
import ${package}.ui.DebugUiModule;

import dagger.Module;

@Module(
        addsTo = ${applicationName}Module.class,
        includes = {
                DebugUiModule.class,
                DebugDataModule.class
        },
        overrides = true
)
public final class Debug${applicationName}Module {
}
