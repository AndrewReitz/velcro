package {{packageName}};

import android.app.Application;
import android.content.Context;
import {{packageName}}.ui.ActivityHierarchyServer;
import dagger.ObjectGraph;
import hugo.weaving.DebugLog;
import javax.inject.Inject;

public class {{applicationName}}App extends Application {

  @Inject ActivityHierarchyServer activityHierarchyServer;
  @Inject {{applicationName}}Initializer initializer;

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

  public static {{applicationName}}App get(Context context) {
    return ({{applicationName}}App) context.getApplicationContext();
  }
}
