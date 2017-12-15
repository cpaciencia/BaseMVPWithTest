/**
 * Created by cristian on 13/11/17.
 */
package cristianpaciencia.com.basemvpwithtest.app.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by cristian on 13/11/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
