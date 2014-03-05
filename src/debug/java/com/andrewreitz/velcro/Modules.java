package com.andrewreitz.velcro;

import com.andrewreitz.velcro.di.module.VelcroAppModule;

final class Modules {
  static Object[] list(VelcroApp app) {
    return new Object[] {
        new VelcroAppModule(app)
    };
  }

  private Modules() {
    // No instances.
  }
}
