package elements;

import com.codeborne.selenide.SelenideElement;
import commom.AbstractBaseComponent;

public class LoginElements extends AbstractBaseComponent {
    private final String USER_NAME_INPUT = "//input[@name='username']";
    private final String PASSPORT_INPUT ="//input[@name='password']";
    private final String LOGIN_BUTTON = "//input[@id='login_button']";

    protected SelenideElement getUserNameField() {
        return waitClickabilityOfElement(USER_NAME_INPUT);
    }

    protected SelenideElement getPassword() {
        return waitClickabilityOfElement(PASSPORT_INPUT);
    }

    protected SelenideElement getLoginButton() {
        return waitClickabilityOfElement(LOGIN_BUTTON);
    }
}
