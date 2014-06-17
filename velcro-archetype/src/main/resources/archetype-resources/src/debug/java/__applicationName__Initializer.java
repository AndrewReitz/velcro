package ${package};

import butterknife.ButterKnife;
import timber.log.Timber;

final class ${applicationName}Initializer {
  /** Init all things debug here */
  static void init() {
    Timber.plant(new Timber.DebugTree());
    ButterKnife.setDebug(true);
  }
}
