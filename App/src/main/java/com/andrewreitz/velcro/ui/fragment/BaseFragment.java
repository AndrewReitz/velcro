package com.andrewreitz.velcro.ui.fragment;

import android.app.Fragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Release the views injected by butterknife
        ButterKnife.reset(this);
    }
}
