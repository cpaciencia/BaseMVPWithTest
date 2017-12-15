/**
 * Created by cristian on 13/11/17.
 */
package cristianpaciencia.com.basemvpwithtest.base;


import javax.inject.Inject;


/**
 * Created by cristian on 13/11/17.
 */
public class BasePresenter<V extends BaseView> {

    @Inject
    protected V mView;

    protected V getView() {
        return mView;
    }

}
