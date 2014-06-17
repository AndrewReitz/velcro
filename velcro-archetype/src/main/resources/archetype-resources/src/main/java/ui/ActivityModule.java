package ${package}.ui;

import android.app.Activity;
import android.content.Context;

import ${package}.${applicationName}Module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

@Module(
    injects = {
        MainActivity.class
    },
    addsTo = ${applicationName}Module.class,
    library = true
)
public class ActivityModule {
  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = checkNotNull(activity);
  }

  /**
   * Allow the activity context to be injected but require that it be annotated with
   * {@link ForActivity } to explicitly
   * differentiate it from application context.
   */
  @Provides @Singleton @ForActivity Context provideActivityContext() {
    return activity;
  }
}
