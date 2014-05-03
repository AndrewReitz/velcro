package com.andrewreitz.velcro.data.prefs;

import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class BooleanPreference extends AbsPreference<Boolean> {
  public BooleanPreference(@NotNull SharedPreferences preferences, @NotNull String key) {
    this(preferences, key, false);
  }

  public BooleanPreference(@NotNull SharedPreferences preferences, @NotNull String key, boolean defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override
  public Boolean get() {
    return getPreferences().getBoolean(getKey(), getDefaultValue());
  }

  @Override
  public void set(@NotNull Boolean value) {
    getPreferences().edit().putBoolean(getKey(), checkNotNull(value)).apply();
  }
}
