/**
 * Created by cristian on 13/11/17.
 */

package cristianpaciencia.com.basemvpwithtest.app.di.components;

import android.content.Context;

import javax.inject.Singleton;

import cristianpaciencia.com.basemvpwithtest.app.di.module.ApplicationModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by cristian on 13/11/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
