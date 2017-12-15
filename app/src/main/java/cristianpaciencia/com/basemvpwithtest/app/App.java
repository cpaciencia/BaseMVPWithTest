package cristianpaciencia.com.basemvpwithtest.app;

import android.app.Application;

import cristianpaciencia.com.basemvpwithtest.app.di.components.ApplicationComponent;
import cristianpaciencia.com.basemvpwithtest.app.di.components.DaggerApplicationComponent;
import cristianpaciencia.com.basemvpwithtest.app.di.module.ApplicationModule;
import io.realm.Realm;
import timber.log.BuildConfig;
import timber.log.Timber;


/**
 * Created by cristian on 13/11/17.
 */
public class App extends Application {

    private static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {

        initialiseLogger();
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://jsonplaceholder.typicode.com"))
                .build();

    }

    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
