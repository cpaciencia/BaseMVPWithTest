package cristianpaciencia.com.basemvpwithtest.screens.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cristianpaciencia.com.basemvpwithtest.R;
import cristianpaciencia.com.basemvpwithtest.app.App;
import cristianpaciencia.com.basemvpwithtest.screens.main.di.DaggerMainComponent;
import cristianpaciencia.com.basemvpwithtest.screens.main.di.MainModule;
import cristianpaciencia.com.basemvpwithtest.utils.UiUtils;

public class MainActivity extends AppCompatActivity implements IMainView {

    String email;

    @BindView(R.id.mainView)
    View view;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.etCompany)
    EditText etCompany;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etUsername)
    EditText etUser;
    @BindView(R.id.etWebsite)
    EditText etWebsite;

    @Inject
    MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //resuelvo las dependencias de dagger
        DaggerMainComponent.builder()
                .applicationComponent(App.getApplicationComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);


        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UiUtils.showSnackbar(findViewById(android.R.id.content), "touch button", 2000);
            }
        });

        email = getIntent().getStringExtra("email");

        presenter.showUserData(email);

    }


    @Override
    public void setHeader(String username) {
        setTitle(username);
    }

    @Override
    public void showError(String erroMessage) {
        UiUtils.showSnackbar(findViewById(android.R.id.content), erroMessage, 2000);
    }

    @Override
    public void setUsername(String username) {
        etUser.setText(username);
    }

    @Override
    public void setPhone(String phone) {
        etPhone.setText(phone);
    }

    @Override
    public void setWebsite(String website) {
        etWebsite.setText(website);
    }

    @Override
    public void setAddress(String address) {
        etAddress.setText(address);
    }

    @Override
    public void setCompany(String company) {
        etCompany.setText(company);
    }
}
