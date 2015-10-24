package {{packageName}}.ui.misc;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import {{packageName}}.data.Injector;
import {{packageName}}.ui.ActivityModule;

import dagger.ObjectGraph;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {

  private ObjectGraph activityGraph;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Restore objects saved with Icepick
    Icepick.restoreInstanceState(this, savedInstanceState);

    // Explicitly reference the application object since we don't want to match our own injector.
    ObjectGraph appGraph = Injector.obtain(getApplication());
    appGraph.inject(this);
    activityGraph = appGraph.plus(new ActivityModule(this));
  }

  @Override protected void onDestroy() {
    // Eagerly clear the reference to the activity graph to allow
    // it to be garbage collected as soon as possible.
    activityGraph = null;
    super.onDestroy();
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    // Save out objects annotated with @Icicle
    Icepick.saveInstanceState(this, outState);
  }

  /** Inject the supplied {@code object} using the activity-specific graph. */
  public void inject(Object object) {
    activityGraph.inject(object);
  }

  @Override public Object getSystemService(@NonNull String name) {
    if (Injector.matchesService(name)) {
      return activityGraph;
    }
    return super.getSystemService(name);
  }
}
