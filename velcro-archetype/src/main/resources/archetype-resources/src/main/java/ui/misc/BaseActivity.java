package ${package}.ui.misc;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import ${package}.${applicationName}App;
import ${package}.ui.ActivityModule;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import icepick.Icepick;

public abstract class BaseActivity extends Activity {

    private ObjectGraph activityGraph;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Restore objects saved with Icepick
        Icepick.restoreInstanceState(this, savedInstanceState);

        // Inject objects into the object graph at the activity level, this is for
        // objects that need values that aren't available until the activity is created.
        ${applicationName}App application = ${applicationName}App.get(this);
        activityGraph = application
                .getObjectGraph()
                .plus(
                        getModules().toArray()
                );

        activityGraph.inject(this);
    }

    @Override protected void onDestroy() {
        // Eagerly clear the reference to the activity graph to allow
        // it to be garbage collected as soon as possible.
        activityGraph = null;
        super.onDestroy();
    }

    @Override public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save out objects annotated with @Icicle
        Icepick.saveInstanceState(this, outState);
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new ActivityModule(this)
        );
    }

    /** Inject the supplied {@code object} using the activity-specific graph. */
    public void inject(Object object) {
        activityGraph.inject(object);
    }

    public static BaseActivity get(Fragment fragment) {
        return (BaseActivity) fragment.getActivity();
    }
}
