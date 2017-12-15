package cristianpaciencia.com.basemvpwithtest.model.local;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import io.realm.Realm;
import rx.Observable;

/**
 * Created by cristian on 16/11/17.
 */

public class UserLocalDataStore {

    Realm realm = Realm.getDefaultInstance();

    @Inject
    public UserLocalDataStore() {
    }

    public Observable<List<User>> getUsers() {
        List<User> listaAgentes = new ArrayList<>();

        User user = new User();
        user.setEmail("cristian@hotmail.com");

        User user1 = new User();
        user1.setEmail("otro@hotmail.com");

        listaAgentes.add(user);
        listaAgentes.add(user1);


        return Observable.just(listaAgentes);
    }


    public boolean saveUsers(List<User> users) {

        realm.beginTransaction();
        realm.insertOrUpdate(users);
        realm.commitTransaction();
        return true;

    }


    public User getUser(String email) {
        User user = null;
        try {
            realm.beginTransaction();
            user = realm.where(User.class).equalTo("email", email).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            realm.commitTransaction();
            realm.close();
            return user;
        }

    }

}
