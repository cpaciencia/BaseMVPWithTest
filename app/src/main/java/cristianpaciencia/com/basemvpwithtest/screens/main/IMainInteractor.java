package cristianpaciencia.com.basemvpwithtest.screens.main;

import cristianpaciencia.com.basemvpwithtest.model.pojos.User;

/**
 * Created by cristian on 13/12/17.
 */

public interface IMainInteractor {

    User getUser(String username) throws Exception;
}
