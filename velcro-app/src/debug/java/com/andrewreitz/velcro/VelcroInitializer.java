package com.andrewreitz.velcro;

import android.content.Context;

import javax.inject.Inject;

import timber.log.Timber;

final class VelcroInitializer {
  private Context context;

  @Inject VelcroInitializer(Context context) {
    this.context = context;
  }

  /** Init all things debug here */
  void init() {
    Timber.plant(new Timber.DebugTree());
  }
}
