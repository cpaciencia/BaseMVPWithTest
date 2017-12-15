package cristianpaciencia.com.basemvpwithtest.model.remote;

import java.util.List;

import javax.inject.Inject;

import cristianpaciencia.com.basemvpwithtest.api.IUserApiService;
import cristianpaciencia.com.basemvpwithtest.app.App;
import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by cristian on 16/11/17.
 */

public class UserRemoteDataStore {

    @Inject
    Retrofit retrofit;

    public UserRemoteDataStore() {
        retrofit = App.getApplicationComponent().exposeRetrofit();
    }

    public IUserApiService getService() {
        return retrofit.create(IUserApiService.class);
    }

    public Observable<List<User>> getUserServer() {
        return getService().getUsers().asObservable();
    }

    public Observable<List<User>> getUser(String user) {
        return getService().getUser(user).asObservable();
    }
}
