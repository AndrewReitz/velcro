package ${package}.data.prefs;

import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class StringPreference extends AbsPreference<String> {
    public StringPreference(SharedPreferences preferences, String key) {
        this(preferences, key, null);
    }

    public StringPreference(SharedPreferences preferences, String key, String defaultValue) {
        super(preferences, key, defaultValue);
    }

    public String get() {
        return getPreferences().getString(getKey(), getDefaultValue());
    }

    public void set(@NotNull String value) {
        getPreferences().edit().putString(getKey(), checkNotNull(value)).apply();
    }
}
