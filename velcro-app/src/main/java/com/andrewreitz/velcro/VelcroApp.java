package com.andrewreitz.velcro;

import android.app.Application;
import android.content.Context;
import com.andrewreitz.velcro.ui.ActivityHierarchyServer;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import javax.inject.Inject;

public class VelcroApp extends Application {

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject VelcroInitializer initializer;

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    buildObjectGraphAndInject();
    registerActivityLifecycleCallbacks(activityHierarchyServer);
    initializer.init();
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
