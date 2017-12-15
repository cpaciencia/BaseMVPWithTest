package cristianpaciencia.com.basemvpwithtest.screens.main;

import javax.inject.Inject;

import cristianpaciencia.com.basemvpwithtest.model.pojos.User;

/**
 * Created by cristian on 14/12/17.
 */

public class MainPresenterImpl implements IMainPresenter {

    IMainView view;
    MainInteractorImpl interactor;
    User user;

    @Inject
    public MainPresenterImpl(IMainView view, MainInteractorImpl interactor) {
        this.view = view;
        this.interactor = interactor;
    }


    @Override
    public void showUserData(String username) {
        try {
            user = interactor.getUser(username);
            view.setHeader(user.getName());
            view.setUsername(user.getUsername());
            view.setPhone(user.getPhone());
            view.setWebsite(user.getWebsite());
            view.setAddress(user.getAddress().toString());
            view.setCompany(user.getCompany().toString());
        } catch (Exception e) {
            e.printStackTrace();
            view.showError(e.getLocalizedMessage());
        }

    }
}
