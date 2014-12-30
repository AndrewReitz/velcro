package {{packageName}};

import android.app.Application;

import {{packageName}}.data.DataModule;
import {{packageName}}.ui.UiModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    includes = {
        UiModule.class,
        DataModule.class
    },
    injects = {
        {{applicationName}}App.class
    }
)
public final class {{applicationName}}Module {
  private final {{applicationName}}App app;

  public {{applicationName}}Module({{applicationName}}App app) {
    this.app = app;
  }

  @Provides @Singleton Application provideApplication() {
    return app;
  }
}
