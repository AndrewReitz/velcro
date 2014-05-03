package com.andrewreitz.velcro.ui;

import android.app.Activity;
import android.view.ViewGroup;

import com.andrewreitz.velcro.VelcroApp;

import static butterknife.ButterKnife.findById;

/** From https://github.com/JakeWharton/u2020 */

/** An indirection which allows controlling the root container used for each activity. */
public interface AppContainer {
  /** The root {@link android.view.ViewGroup} into which the activity should place its contents. */
  ViewGroup get(Activity activity, VelcroApp app);

  /** An {@link AppContainer} which returns the normal activity content view. */
  AppContainer DEFAULT = new AppContainer() {
    @Override public ViewGroup get(Activity activity, VelcroApp app) {
      return findById(activity, android.R.id.content);
    }
  };
}
