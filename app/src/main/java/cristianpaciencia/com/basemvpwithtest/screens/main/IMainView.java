package cristianpaciencia.com.basemvpwithtest.screens.main;

/**
 * Created by cristian on 13/12/17.
 */

public interface IMainView {

    void setHeader(String username);

    void showError(String erroMessage);

    void setUsername(String username);

    void setPhone(String phone);

    void setWebsite(String website);

    void setAddress(String address);

    void setCompany(String company);

}
