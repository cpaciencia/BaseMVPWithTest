package cristianpaciencia.com.basemvpwithtest.screens.main;

import javax.inject.Inject;

import cristianpaciencia.com.basemvpwithtest.model.local.UserLocalDataStore;
import cristianpaciencia.com.basemvpwithtest.model.pojos.User;

/**
 * Created by cristian on 14/12/17.
 */

public class MainInteractorImpl implements IMainInteractor {

    UserLocalDataStore userLocalDataStore;

    @Inject
    public MainInteractorImpl(UserLocalDataStore userLocalDataStore) {
        this.userLocalDataStore = userLocalDataStore;
    }

    @Override
    public User getUser(String username) throws Exception {
        return userLocalDataStore.getUser(username);
    }
}
