package com.andrewreitz.velcro.data.prefs;

import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class IntPreference extends AbsPreference<Integer> {
  public IntPreference(@NotNull SharedPreferences preferences, @NotNull String key) {
    this(preferences, key, 0);
  }

  public IntPreference(@NotNull SharedPreferences preferences, @NotNull String key, int defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override public Integer get() {
    return getPreferences().getInt(getKey(), getDefaultValue());
  }

  @Override public void set(@NotNull Integer value) {
    getPreferences().edit().putInt(getKey(), checkNotNull(value)).apply();
  }
}
