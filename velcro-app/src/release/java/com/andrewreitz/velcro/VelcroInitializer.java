package com.andrewreitz.velcro;

import android.app.Application;

import javax.inject.Inject;

final class VelcroInitializer {
  private final Application application;

  @Inject VelcroInitializer(Application application) {
    this.application = application;
  }

  /** Init all things release here */
  void init() {
    /* Ex. Timber.plant(new CrashReportingTree()); */
  }
}

