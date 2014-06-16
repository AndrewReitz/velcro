package com.andrewreitz.velcro;

import android.app.Application;
import android.content.Context;

import com.andrewreitz.velcro.ui.ActivityHierarchyServer;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import timber.log.Timber;

public class VelcroApp extends Application {

  @Inject ActivityHierarchyServer activityHierarchyServer;

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize components
    VelcroInitializer.init();

    buildObjectGraphAndInject();

    registerActivityLifecycleCallbacks(activityHierarchyServer);
  }

  @DebugLog
  public void buildObjectGraphAndInject() {
    objectGraph = ObjectGraph.create(Modules.list(this));
    objectGraph.inject(this);
  }

  public ObjectGraph getObjectGraph() {
    return objectGraph;
  }

  public void inject(Object o) {
    objectGraph.inject(o);
  }

  public static VelcroApp get(Context context) {
    return (VelcroApp) context.getApplicationContext();
  }

}
