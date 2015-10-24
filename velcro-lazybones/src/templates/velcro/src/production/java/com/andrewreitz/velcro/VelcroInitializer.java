package {{packageName}};

import android.app.Application;

import javax.inject.Inject;

final class {{applicationName}}Initializer {
  private final Application application;

  @Inject {{applicationName}}Initializer(Application application) {
    this.application = application;
  }

  /** Init all things release here */
  void init() {
    /* Ex. Timber.plant(new CrashReportingTree()); */
  }
}

