package ${package};

import android.app.Application;
import android.content.Context;

import ${package}.ui.ActivityHierarchyServer;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import timber.log.Timber;

public class ${applicationName}App extends Application {

    @Inject ActivityHierarchyServer activityHierarchyServer;

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        // Logging Setup
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // Place Prod Logging here
        }

        // Setup debugging for butterknife
        ButterKnife.setDebug(BuildConfig.DEBUG);

        buildObjectGraphAndInject();

        registerActivityLifecycleCallbacks(activityHierarchyServer);
    }

    public void buildObjectGraphAndInject() {
        long start = System.nanoTime();

        objectGraph = ObjectGraph.create(Modules.list(this));
        objectGraph.inject(this);

        long diff = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
        Timber.i("Global object graph creation took %sms", diff);
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

    public void inject(@NotNull Object o) {
        objectGraph.inject(o);
    }

    public static ${applicationName}App get(@NotNull Context context) {
        return (${applicationName}App) context.getApplicationContext();
    }

}
