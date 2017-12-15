package cristianpaciencia.com.basemvpwithtest.screens.login;

import java.util.List;

import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import rx.Observable;

/**
 * Created by cristian on 14/11/17.
 */

public interface ILoginInteractor {

    interface OnLoginFinishedListener {

        void complete();

        void onFail(Throwable e);

        void onSuccess(List<User> user);
    }

    Observable<List<User>> getUser(String user);

    Observable<List<User>> getUserLocal(String user);

    boolean saveUsers(List<User> users);

}
