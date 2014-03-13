package ${package}.ui;

import android.os.Bundle;
import android.view.ViewGroup;

import ${package}.R;
import ${package}.VelcroApp;
import ${package}.ui.AppContainer;
import ${package}.ui.misc.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject AppContainer appContainer;

    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VelcroApp app = VelcroApp.get(this);

        container = appContainer.get(this, app);

        getLayoutInflater().inflate(R.layout.activity_main, container);
    }
}
