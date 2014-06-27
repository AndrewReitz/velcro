package com.andrewreitz.velcro;

import android.content.Context;

final class VelcroInitializer {
  private final Context context;

  @Inject VelcroInitializer(Context context) {
    this.context = context;
  }

  /** Init all things release here */
  void init() {
    /* Ex. Timber.plant(new CrashReportingTree());
  }
}

