package com.andrewreitz.velcro.data.prefs;

import org.jetbrains.annotations.NotNull;

interface Preference<T> {
  T get();
  boolean isSet();
  void set(@NotNull T value);
  void delete();
}
