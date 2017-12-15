/**
 * Created by cristian on 13/11/17.
 */
package cristianpaciencia.com.basemvpwithtest.screens.main.di;


import cristianpaciencia.com.basemvpwithtest.app.di.components.ApplicationComponent;
import cristianpaciencia.com.basemvpwithtest.app.di.scope.PerActivity;
import cristianpaciencia.com.basemvpwithtest.screens.main.MainActivity;
import dagger.Component;

/**
 * Created by cristian on 13/11/17.
 */
@PerActivity
@Component(modules = MainModule.class, dependencies = ApplicationComponent.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
