package ${package};

import android.app.Application;

import ${package}.data.DataModule;
import ${package}.ui.UiModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    includes = {
        UiModule.class,
        DataModule.class
    },
    injects = {
        ${applicationName}App.class
    }
)
public final class ${applicationName}Module {
  private final ${applicationName}App app;

  public ${applicationName}Module(${applicationName}App app) {
    this.app = app;
  }

  /**
   * Allow the app context to be injected but require that it be annotated with
   * {@link ForApplication}
   * to explicitly differentiate it from an activity context.
   */
  @Provides @Singleton @ForApplication Application provideApplication() {
    return app;
  }
}
