package ${package}.data.prefs;

import org.jetbrains.annotations.NotNull;

public interface Preference<T> {
    T get();
    boolean isSet();
    void set(@NotNull T value);
    void delete();
}
