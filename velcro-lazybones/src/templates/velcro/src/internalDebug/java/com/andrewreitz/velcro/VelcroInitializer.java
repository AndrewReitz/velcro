package {{packageName}};

import android.app.Application;

import javax.inject.Inject;

import timber.log.Timber;

final class {{applicationName}}Initializer {
  private Application application;

  @Inject {{applicationName}}Initializer(Application application) {
    this.application = application;
  }

  /** Init all things debug here */
  void init() {
    Timber.plant(new Timber.DebugTree());
  }
}
