package {{packageName}}.ui;

import android.os.Bundle;
import android.view.ViewGroup;

import {{packageName}}.R;
import {{packageName}}.{{applicationName}}App;
import {{packageName}}.ui.misc.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
  @Inject AppContainer appContainer;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    {{applicationName}}App app = {{applicationName}}App.get(this);
    ViewGroup container = appContainer.get(this, app);

    getLayoutInflater().inflate(R.layout.activity_main, container);
  }
}
