package cristianpaciencia.com.basemvpwithtest.screens.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cristianpaciencia.com.basemvpwithtest.R;
import cristianpaciencia.com.basemvpwithtest.app.App;
import cristianpaciencia.com.basemvpwithtest.screens.login.di.DaggerLoginComponent;
import cristianpaciencia.com.basemvpwithtest.screens.login.di.LoginModule;
import cristianpaciencia.com.basemvpwithtest.screens.main.MainActivity;

/**
 * Created by cristian on 13/11/17.
 * <p>
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {


    @BindView(R.id.btLogin)
    Button btLogin;
    @BindView(R.id.etUser)
    EditText etUser;
    @BindView(R.id.login_form)
    ScrollView mLoginFormView;
    @BindView(R.id.login_progress)
    ProgressBar mProgressView;

    @Inject
    LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //resuelvo las dependencias de dagger
        DaggerLoginComponent.builder()
                .applicationComponent(App.getApplicationComponent())
                .loginModule(new LoginModule(this))
                .build().inject(this);

    }

    @OnClick(R.id.btLogin)
    public void loginClick() {
        login();
    }


    @Override
    public void login() {
        loginPresenter.login(etUser.getText().toString());
    }

    /**
     * Intent a la otra actividad
     */
    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("email", etUser.getText().toString());
        startActivity(intent);
    }

    /**
     * Muestra error login
     *
     * @param error
     */
    @Override
    public void showErrorLogin(String error) {
        Snackbar.make(mLoginFormView, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorLogin(int error) {
        showErrorLogin(getString(error));
    }

    /**
     * Elimina los mensajes de error de los edittext
     */
    @Override
    public void clearErrors() {
        etUser.setError(null);
    }

    /**
     * Muestra en el edittext un mensaje al usuario
     *
     * @param rStringMessage
     */
    @Override
    public void setPassError(int rStringMessage) {
        etUser.setError(getString(rStringMessage));
        etUser.requestFocus();
    }

    /**
     * Muestra en el edittext un mensaje al usuario
     *
     * @param rStringMessage
     */
    @Override
    public void setUserError(int rStringMessage) {
        etUser.setError(getString(rStringMessage));
        etUser.requestFocus();
    }


    /**
     * Metodo copiado del crear login activity
     */
    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}

