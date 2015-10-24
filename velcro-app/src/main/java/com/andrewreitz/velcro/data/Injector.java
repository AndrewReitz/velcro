package com.andrewreitz.velcro.data;

import android.content.Context;
import dagger.ObjectGraph;

/**
 * Create a custom service that will return the object graph when queried.
 */
public final class Injector {
  private static final String INJECTOR_SERVICE = "com.andrewreitz.velcro.injector";

  @SuppressWarnings({ "ResourceType", "WrongConstant" }) // Explicitly doing a custom service.
  public static ObjectGraph obtain(Context context) {
    return (ObjectGraph) context.getSystemService(INJECTOR_SERVICE);
  }

  public static boolean matchesService(String name) {
    return INJECTOR_SERVICE.equals(name);
  }

  private Injector() {
    throw new AssertionError("No instances.");
  }
}
