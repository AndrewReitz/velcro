package {{packageName}};

import android.app.Application;
import android.support.annotation.NonNull;
import {{packageName}}.data.Injector;
import {{packageName}}.ui.ActivityHierarchyServer;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import javax.inject.Inject;

public class {{applicationName}}App extends Application {

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject {{applicationName}}Initializer initializer;

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
