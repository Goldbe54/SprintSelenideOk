package elements;

import com.codeborne.selenide.SelenideElement;
import commom.BaseComponent;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$x;

public class LoginElements extends BaseComponent {
    private final String USER_NAME_INPUT = "//input[@name='username']";
    private final String PASSPORT_INPUT = "//input[@name='password']";
    private final String LOGIN_BUTTON = "//input[@id='login_button']";

    protected SelenideElement getUserNameField() {
        return $x(USER_NAME_INPUT).shouldBe(interactable);
    }

    protected SelenideElement getPassword() {
        return $x(PASSPORT_INPUT).shouldBe(interactable);
    }

    protected SelenideElement getLoginButton() {
        return $x(LOGIN_BUTTON).shouldBe(interactable);
    }
}