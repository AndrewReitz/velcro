package com.andrewreitz.velcro.ui.fragment

import android.app.Fragment;

import butterknife.ButterKnife;

/**
 * @author areitz
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Release the views injects by butterknife
        ButterKnife.reset(this);
    }
}
