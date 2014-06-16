package com.andrewreitz.velcro;

import butterknife.ButterKnife;
import timber.log.Timber;

final class VelcroInitializer {
  /** Init all things debug here */
  static void init() {
    Timber.plant(new Timber.DebugTree());
    ButterKnife.setDebug(true);
  }
}
