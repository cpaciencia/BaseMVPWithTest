/**
 * Created by cristian on 13/11/17.
 */

package cristianpaciencia.com.basemvpwithtest.screens.login.di;


import cristianpaciencia.com.basemvpwithtest.app.di.components.ApplicationComponent;
import cristianpaciencia.com.basemvpwithtest.app.di.scope.PerActivity;
import cristianpaciencia.com.basemvpwithtest.screens.login.LoginActivity;
import dagger.Component;

/**
 * Created by cristian on 13/11/17.
 */
@PerActivity
@Component(modules = LoginModule.class, dependencies = ApplicationComponent.class)
public interface LoginComponent {

    void inject(LoginActivity activity);
}
