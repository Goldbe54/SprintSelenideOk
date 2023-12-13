package pages;

import elements.LoginElements;
import io.qameta.allure.Step;

public class LoginPage extends LoginElements {

    @Step("Login to the account")
    public LoginPage logInAtAccount(String login, String password) {

        heagerLoginElement().click();
        getUserNameField().sendKeys(login);
        getPassword().sendKeys(password);
        getLoginButton().click();

        return this;
    }
}
