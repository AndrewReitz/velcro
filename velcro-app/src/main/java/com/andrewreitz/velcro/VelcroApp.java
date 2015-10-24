package com.andrewreitz.velcro;

import android.app.Application;
import android.support.annotation.NonNull;
import com.andrewreitz.velcro.data.Injector;
import com.andrewreitz.velcro.ui.ActivityHierarchyServer;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import javax.inject.Inject;

public class VelcroApp extends Application {

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject VelcroInitializer initializer;

  private ObjectGraph objectGraph;

  @Override public void onCreate() {
    super.onCreate();
    buildObjectGraphAndInject();
    registerActivityLifecycleCallbacks(activityHierarchyServer);
    initializer.init();
  }

  @DebugLog public void buildObjectGraphAndInject() {
    objectGraph = ObjectGraph.create(Modules.list(this));
    objectGraph.inject(this);
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name)) {
      return objectGraph;
    }
    return super.getSystemService(name);
  }
}
