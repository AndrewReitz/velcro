package com.andrewreitz.velcro.di.module;

import android.content.SharedPreferences;

import com.andrewreitz.velcro.data.prefs.BooleanPreference;
import com.andrewreitz.velcro.data.prefs.IntPreference;
import com.andrewreitz.velcro.di.annotation.AnimationSpeed;
import com.andrewreitz.velcro.di.annotation.PixelGridEnabled;
import com.andrewreitz.velcro.di.annotation.PixelRatioEnabled;
import com.andrewreitz.velcro.di.annotation.ScalpelEnabled;
import com.andrewreitz.velcro.di.annotation.ScalpelWireframeEnabled;
import com.andrewreitz.velcro.di.annotation.SeenDebugDrawer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        complete = false,
        library = true,
        overrides = true
)
public final class DebugDataModule {
    private static final int DEFAULT_ANIMATION_SPEED = 1; // 1x (normal) speed.
    private static final boolean DEFAULT_PIXEL_GRID_ENABLED = false; // No pixel grid overlay.
    private static final boolean DEFAULT_PIXEL_RATIO_ENABLED = false; // No pixel ratio overlay.
    private static final boolean DEFAULT_SCALPEL_ENABLED = false; // No crazy 3D view tree.
    private static final boolean DEFAULT_SCALPEL_WIREFRAME_ENABLED = false; // Draw views by default.
    private static final boolean DEFAULT_SEEN_DEBUG_DRAWER = false; // Show debug drawer first time.

    @Provides @Singleton @AnimationSpeed
    IntPreference provideAnimationSpeed(SharedPreferences preferences) {
        return new IntPreference(preferences, "debug_animation_speed", DEFAULT_ANIMATION_SPEED);
    }

    @Provides @Singleton @PixelGridEnabled
    BooleanPreference providePixelGridEnabled(SharedPreferences preferences) {
        return new BooleanPreference(preferences, "debug_pixel_grid_enabled",
                DEFAULT_PIXEL_GRID_ENABLED);
    }

    @Provides @Singleton @PixelRatioEnabled
    BooleanPreference providePixelRatioEnabled(SharedPreferences preferences) {
        return new BooleanPreference(preferences, "debug_pixel_ratio_enabled",
                DEFAULT_PIXEL_RATIO_ENABLED);
    }

    @Provides @Singleton @SeenDebugDrawer
    BooleanPreference provideSeenDebugDrawer(SharedPreferences preferences) {
        return new BooleanPreference(preferences, "debug_seen_debug_drawer", DEFAULT_SEEN_DEBUG_DRAWER);
    }

    @Provides @Singleton @ScalpelEnabled
    BooleanPreference provideScalpelEnabled(SharedPreferences preferences) {
        return new BooleanPreference(preferences, "debug_scalpel_enabled", DEFAULT_SCALPEL_ENABLED);
    }

    @Provides @Singleton @ScalpelWireframeEnabled
    BooleanPreference provideScalpelWireframeEnabled(SharedPreferences preferences) {
        return new BooleanPreference(preferences, "debug_scalpel_wireframe_drawer",
                DEFAULT_SCALPEL_WIREFRAME_ENABLED);
    }
}
