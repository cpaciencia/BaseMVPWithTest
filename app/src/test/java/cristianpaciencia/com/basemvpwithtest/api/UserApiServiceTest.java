package cristianpaciencia.com.basemvpwithtest.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import cristianpaciencia.com.basemvpwithtest.BaseTest;
import cristianpaciencia.com.basemvpwithtest.BuildConfig;
import cristianpaciencia.com.basemvpwithtest.model.pojos.User;
import cristianpaciencia.com.basemvpwithtest.model.remote.UserRemoteDataStore;
import rx.observers.TestSubscriber;


/**
 * Created by cristian on 18/11/17.
 * <p>
 * Clase encargada de testear el servicio web de usuarios.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class UserApiServiceTest extends BaseTest {

    IUserApiService service;

    @Override
    public void setup() throws Exception {
        super.setup();
        UserRemoteDataStore userRemoteDataStore = new UserRemoteDataStore();
        service = userRemoteDataStore.getService();


    }


    @Test
    public void testGetListUsersCorrect() throws Exception {

        TestSubscriber<List<User>> testSubscriber = new TestSubscriber<>();
        service.getUsers().subscribe(testSubscriber);
        if (testSubscriber.getOnNextEvents().size() > 0) {
            List<User> l = testSubscriber.getOnNextEvents().get(0);
            System.out.println(l.toString());
            Assert.assertNotNull(l);
            Assert.assertTrue(!l.isEmpty());
            Assert.assertTrue(l.size() > 0);
        } else {
            junit.framework.Assert.fail("ERROR SERVICIO WEB " + testSubscriber.getOnErrorEvents().toString());
        }

    }

    @Test
    public void testGetListUsersIncorrect() throws Exception {
        TestSubscriber<List<User>> testSubscriber = new TestSubscriber<>();
        service.getUsers().subscribe(testSubscriber);
        if (testSubscriber.getOnErrorEvents().size() > 0) {
            System.out.println(testSubscriber.getOnErrorEvents().toString());
            Assert.assertNotNull(testSubscriber.getOnErrorEvents());
            Assert.assertTrue(testSubscriber.getOnErrorEvents().size() > 0);
        }

    }


    @Test
    public void testGetUserCorrect() throws Exception {

        TestSubscriber<List<User>> testSubscriber = new TestSubscriber<>();
        service.getUser("Sherwood@rosamond.me").subscribe(testSubscriber);
        if (testSubscriber.getOnNextEvents().size() > 0) {
            List<User> l = testSubscriber.getOnNextEvents().get(0);
            System.out.println(l.toString());
            Assert.assertNotNull(l);
            Assert.assertTrue(!l.isEmpty());
            Assert.assertTrue(l.size() > 0);
            Assert.assertEquals("Sherwood@rosamond.me", l.get(0).getEmail());
        } else {
            junit.framework.Assert.fail("ERROR SERVICIO WEB " + testSubscriber.getOnErrorEvents().toString());
        }

    }

    @Test
    public void testGetUserIncorrect() throws Exception {

        TestSubscriber<List<User>> testSubscriber = new TestSubscriber<>();
        service.getUser("Sherwoo@rosamond.me").subscribe(testSubscriber);
        if (testSubscriber.getOnNextEvents().size() > 0) {
            List<User> l = testSubscriber.getOnNextEvents().get(0);
            Assert.assertNotNull(l);
            Assert.assertTrue(l.isEmpty());
        } else {
            junit.framework.Assert.fail("ERROR SERVICIO WEB " + testSubscriber.getOnErrorEvents().toString());
        }

    }


}
