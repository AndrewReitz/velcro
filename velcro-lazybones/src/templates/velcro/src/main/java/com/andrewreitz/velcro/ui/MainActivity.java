package {{packageName}}.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Bind;
import {{packageName}}.R;
import {{packageName}}.ui.misc.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
  @Inject AppContainer appContainer;

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.message) TextView message;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ViewGroup container = appContainer.bind(this);
    getLayoutInflater().inflate(R.layout.activity_main, container);

    ButterKnife.bind(this);

    setSupportActionBar(toolbar);
    message.setText("Hello World!");
  }
}
