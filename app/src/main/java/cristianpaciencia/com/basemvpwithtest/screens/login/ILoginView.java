package cristianpaciencia.com.basemvpwithtest.screens.login;

import cristianpaciencia.com.basemvpwithtest.base.BaseView;

/**
 * Created by cristian on 14/11/17.
 */

public interface ILoginView extends BaseView {
    public void login();

    public void goToMainActivity();

    public void showErrorLogin(String error);

    public void showErrorLogin(int error);

    public void clearErrors();

    public void setPassError(int rStringMessage);

    public void setUserError(int rStringMessage);

    public void showProgress(boolean show);
}