package {{packageName}}.ui.misc;

import android.app.Fragment;
import android.os.Bundle;

import butterknife.ButterKnife;
import {{packageName}}.data.Injector;
import icepick.Icepick;

public abstract class BaseFragment extends Fragment {

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    // Restore objects saved with Icepick
    Icepick.restoreInstanceState(this, savedInstanceState);
    Injector.obtain(getActivity()).inject(this);
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    // Save out objects annotated with @Icicle
    Icepick.saveInstanceState(this, outState);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    // Release the views injected by butterknife
    ButterKnife.unbind(this);
  }
}
