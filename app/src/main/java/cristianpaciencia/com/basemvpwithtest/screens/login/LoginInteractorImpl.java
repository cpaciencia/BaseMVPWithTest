package cristianpaciencia.com.basemvpwithtest.screens.login;


import java.util.List;

import javax.inject.Inject;

import cristianpaciencia.com.basemvpwithtest.model.local.UserLocalDataStore;
import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import cristianpaciencia.com.basemvpwithtest.model.remote.UserRemoteDataStore;
import rx.Observable;

/**
 * Created by cristian on 16/11/17.
 */

public class LoginInteractorImpl implements ILoginInteractor {


    UserRemoteDataStore loginRemoteDataStore;
    UserLocalDataStore userLocalDataStore;

    @Inject
    public LoginInteractorImpl(UserRemoteDataStore userRemoteDataStore, UserLocalDataStore userLocalDataStore) {
        this.loginRemoteDataStore = userRemoteDataStore;
        this.userLocalDataStore = userLocalDataStore;
    }


    @Override
    public Observable<List<User>> getUser(String user) {
        return loginRemoteDataStore.getUser(user);
    }


    @Override
    public Observable<List<User>> getUserLocal(String user) {
        //TODO cuando no pueda realizar la conexion obtendra de la db los datos
        return null;
    }

    @Override
    public boolean saveUsers(List<User> users) {
        return userLocalDataStore.saveUsers(users);
    }


}
