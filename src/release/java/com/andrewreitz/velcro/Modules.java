package com.andrewreitz.velcro;

//TODO FIX ME!!
final class Modules {
  static Object[] list(U2020App app) {
    return new Object[] {
        new U2020Module(app)
    };
  }

  private Modules() {
    // No instances.
  }
}
