/**
 * Created by cristian on 13/11/17.
 */

package cristianpaciencia.com.basemvpwithtest.screens.login.di;


import cristianpaciencia.com.basemvpwithtest.api.IUserApiService;
import cristianpaciencia.com.basemvpwithtest.app.di.scope.PerActivity;
import cristianpaciencia.com.basemvpwithtest.model.local.UserLocalDataStore;
import cristianpaciencia.com.basemvpwithtest.model.remote.UserRemoteDataStore;
import cristianpaciencia.com.basemvpwithtest.screens.login.ILoginView;
import cristianpaciencia.com.basemvpwithtest.screens.login.LoginInteractorImpl;
import cristianpaciencia.com.basemvpwithtest.screens.login.LoginPresenterImpl;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by cristian on 13/11/17.
 */
@Module
public class LoginModule {

    private ILoginView view;
    private LoginPresenterImpl presenter;

    public LoginModule(ILoginView view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    IUserApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(IUserApiService.class);
    }


    @PerActivity
    @Provides
    public LoginInteractorImpl provideLoginInteractor(UserRemoteDataStore userRemoteDataStore, UserLocalDataStore userLocalDataStore) {
        return new LoginInteractorImpl(userRemoteDataStore, userLocalDataStore);
    }

    @PerActivity
    @Provides
    public LoginPresenterImpl provideLoginPresenter(ILoginView loginView, LoginInteractorImpl interactor) {
        presenter = new LoginPresenterImpl(loginView, interactor);
        return presenter;
    }


    @PerActivity
    @Provides
    public UserRemoteDataStore provideLoginRemoteDataStore() {
        return new UserRemoteDataStore();
    }

    @PerActivity
    @Provides
    ILoginView provideView() {
        return view;
    }

}
