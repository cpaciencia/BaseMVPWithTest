/**
 * Created by cristian on 13/11/17.
 */

package cristianpaciencia.com.basemvpwithtest.api;


import java.util.List;

import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cristian on 16/11/17.
 */
public interface IUserApiService {

    @GET("/users")
    Observable<List<User>> getUser(@Query("email") String email);

    @GET("/users")
    Observable<List<User>> getUsers();


}
