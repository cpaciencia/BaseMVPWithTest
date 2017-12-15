package cristianpaciencia.com.basemvpwithtest.screens.login;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import cristianpaciencia.com.basemvpwithtest.BaseTest;
import cristianpaciencia.com.basemvpwithtest.R;
import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import rx.Observable;

/**
 * Created by cristian on 20/11/17.
 */
public class LoginPresenterImpTest extends BaseTest {

    @Mock
    ILoginView loginView;
    @Mock
    LoginInteractorImpl loginInteractor;
    @Mock
    ILoginInteractor.OnLoginFinishedListener listener;


    LoginPresenterImpl loginPresenter;


    @Override
    public void setup() throws Exception {
        super.setup();
        loginPresenter = new LoginPresenterImpl(loginView, loginInteractor);
    }


    @Test
    public void testEmailCorrect() throws Exception {
        Assert.assertTrue(loginPresenter.isEmailValid("hola@hola.com"));
    }

    @Test
    public void testEmailIncorrect() throws Exception {
        Assert.assertFalse(loginPresenter.isEmailValid("hola"));
    }

    @Test
    public void testEmailNull() throws Exception {
        Assert.assertFalse(loginPresenter.isEmailValid(null));
    }

    @Test
    public void testEmailEmpty() throws Exception {
        Assert.assertFalse(loginPresenter.isEmailValid(""));
    }

    @Test
    public void testPassCorrect() throws Exception {
        Assert.assertTrue(loginPresenter.isPasswordValid("hola@hola.com"));
    }

    @Test
    public void testPassIncorrect() throws Exception {
        Assert.assertFalse(loginPresenter.isPasswordValid("hol"));
    }

    @Test
    public void testPassNull() throws Exception {
        Assert.assertFalse(loginPresenter.isPasswordValid(null));
    }

    @Test
    public void testPassEmpty() throws Exception {
        Assert.assertFalse(loginPresenter.isPasswordValid(""));
    }

    @Test
    public void testLoginCorrect() throws Exception {
        List<User> listaAgentes = new ArrayList<>();
        User user = new User();
        user.setEmail("cristian@hotmail.com");
        User user1 = new User();
        user1.setEmail("otro@hotmail.com");
        listaAgentes.add(user);
        listaAgentes.add(user1);
        Mockito.when(loginInteractor.getUser("hola@hola.com")).thenReturn(Observable.just(listaAgentes));
        loginPresenter.login("hola@hola.com", "");
        Assert.assertNotNull(loginView);
        Mockito.verify(loginView).showProgress(true);
    }

    @Test
    public void testLoginWsReturnResults() throws Exception {
        List<User> listaAgentes = new ArrayList<>();
        User user = new User();
        user.setEmail("cristian@hotmail.com");
        User user1 = new User();
        user1.setEmail("otro@hotmail.com");
        listaAgentes.add(user);
        listaAgentes.add(user1);
        loginPresenter.onNext(listaAgentes);
        Mockito.verify(loginView).showProgress(false);
        Mockito.verify(loginView).goToMainActivity();
    }

    @Test
    public void testLoginWsReturnEmptyResult() throws Exception {
        loginPresenter.onNext(new ArrayList<User>());
        Mockito.verify(loginView).showErrorLogin(R.string.error_invalid_email);
    }

    @Test
    public void testLoginWsReturnNull() throws Exception {
        loginPresenter.onNext(null);
        Mockito.verify(loginView).showErrorLogin(R.string.error_invalid_email);

    }

    @Test
    public void testLoginOnComplet() throws Exception {
        loginPresenter.onCompleted();
        Mockito.verify(loginView).showProgress(false);
    }
}
