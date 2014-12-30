package {{packageName}}.ui;

import android.app.Activity;

import {{packageName}}.{{applicationName}}Module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
        MainActivity.class
    },
    addsTo = {{applicationName}}Module.class,
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
