package cristianpaciencia.com.basemvpwithtest.screens.login;

import java.util.List;

import javax.inject.Inject;

import cristianpaciencia.com.basemvpwithtest.R;
import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cristian on 16/11/17.
 */
public class LoginPresenterImpl implements ILoginPresenter, Observer<List<User>> {

    ILoginView loginView;
    LoginInteractorImpl loginInteractor;


    @Inject
    public LoginPresenterImpl(ILoginView loginView, LoginInteractorImpl loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }


    public boolean isEmailValid(String email) {
        if (email != null) {
            return email.contains("@");
        }
        return false;
    }

    public boolean isPasswordValid(String password) {
        if (password != null) {
            return password.length() > 4;
        }
        return false;
    }

    @Override
    public void login(String user) {
        loginView.showProgress(true);
        Subscription mSubscription =
                loginInteractor.getUser(user).observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(this);
    }


    @Override
    public void onCompleted() {
        loginView.showProgress(false);
    }

    @Override
    public void onError(Throwable e) {
        loginView.showProgress(false);
        loginView.showErrorLogin(e.getLocalizedMessage());
    }

    @Override
    public void onNext(List<User> users) {
        if (users != null && !users.isEmpty()) {
            loginInteractor.saveUsers(users);
            loginView.showProgress(false);
            loginView.goToMainActivity();
        } else {
            loginView.showErrorLogin(R.string.error_invalid_email);
        }
    }
}
