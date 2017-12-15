package cristianpaciencia.com.basemvpwithtest.screens.login;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import cristianpaciencia.com.basemvpwithtest.BaseTest;
import cristianpaciencia.com.basemvpwithtest.model.local.UserLocalDataStore;
import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import cristianpaciencia.com.basemvpwithtest.model.remote.UserRemoteDataStore;
import rx.Observable;

/**
 * Created by cristian on 21/11/17.
 */

public class LoginInteractorImplTest extends BaseTest {

    @Mock
    UserRemoteDataStore loginRemoteDataStore;
    @Mock
    UserLocalDataStore userLocalDataStore;

    LoginInteractorImpl loginInteractor;

    @Override
    public void setup() throws Exception {
        super.setup();
        loginInteractor = new LoginInteractorImpl(loginRemoteDataStore, userLocalDataStore);
    }

    @Test
    public void testGetUser() throws Exception {

        List<User> listaAgentes = new ArrayList<>();
        User user = new User();
        user.setEmail("cristian@hotmail.com");
        User user1 = new User();
        user1.setEmail("otro@hotmail.com");
        listaAgentes.add(user);
        listaAgentes.add(user1);
        Mockito.when(loginRemoteDataStore.getUser("hola@hola.com")).thenReturn(Observable.just(listaAgentes));
        Assert.assertNotNull(loginRemoteDataStore.getUser("hola@hola.com"));
        Mockito.verify(loginRemoteDataStore).getUser("hola@hola.com");
    }

    @Test
    public void testGetUserThrowNull() {
        Mockito.when(loginRemoteDataStore.getUser("hola@hola.com")).thenReturn(null);
        Assert.assertEquals(loginRemoteDataStore.getUser("hola@hola.com"), null);
    }
}
