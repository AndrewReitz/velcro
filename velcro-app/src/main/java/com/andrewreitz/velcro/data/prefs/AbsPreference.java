package com.andrewreitz.velcro.data.prefs;

import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class AbsPreference<T> implements Preference<T> {
    private final SharedPreferences preferences;
    private final String key;
    private final T defaultValue;

    public AbsPreference(@NotNull SharedPreferences preferences, @NotNull String key, @NotNull T defaultValue) {
        this.preferences = checkNotNull(preferences);
        this.key = checkNotNull(key);
        this.defaultValue = checkNotNull(defaultValue);
    }

    public boolean isSet() {
        return getPreferences().contains(key);
    }

    public void delete() {
        getPreferences().edit().remove(key).apply();
    }

    SharedPreferences getPreferences() {
        return preferences;
    }

    String getKey() {
        return key;
    }

    T getDefaultValue() {
        return defaultValue;
    }
}
