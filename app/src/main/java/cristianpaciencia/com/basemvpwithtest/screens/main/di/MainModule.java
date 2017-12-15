/**
 * Created by cristian on 13/11/17.
 */

package cristianpaciencia.com.basemvpwithtest.screens.main.di;


import cristianpaciencia.com.basemvpwithtest.api.IUserApiService;
import cristianpaciencia.com.basemvpwithtest.app.di.scope.PerActivity;
import cristianpaciencia.com.basemvpwithtest.model.local.UserLocalDataStore;
import cristianpaciencia.com.basemvpwithtest.screens.main.IMainView;
import cristianpaciencia.com.basemvpwithtest.screens.main.MainInteractorImpl;
import cristianpaciencia.com.basemvpwithtest.screens.main.MainPresenterImpl;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by cristian on 13/11/17.
 */
@Module
public class MainModule {

    private IMainView view;
    private MainPresenterImpl presenter;

    public MainModule(IMainView view) {
        this.view = view;
    }

    @PerActivity
    @Provides
    IUserApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(IUserApiService.class);
    }


    @PerActivity
    @Provides
    public MainInteractorImpl provideLoginInteractor(UserLocalDataStore userLocalDataStore) {
        return new MainInteractorImpl(userLocalDataStore);
    }

    @PerActivity
    @Provides
    public MainPresenterImpl provideMainPresenter(IMainView view, MainInteractorImpl interactor) {
        presenter = new MainPresenterImpl(view, interactor);
        return presenter;
    }


    @PerActivity
    @Provides
    IMainView provideView() {
        return view;
    }

}
