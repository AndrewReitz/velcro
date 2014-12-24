package com.andrewreitz.velcro;

import android.app.Application;

import javax.inject.Inject;

import timber.log.Timber;

final class VelcroInitializer {
  private Application application;

  @Inject VelcroInitializer(Application application) {
    this.application = application;
  }

  /** Init all things debug here */
  void init() {
    Timber.plant(new Timber.DebugTree());
  }
}
