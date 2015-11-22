package ru.st.selenium.pages;

import com.codeborne.selenide.SelenideElement;
import ru.st.selenium.model.Employee;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

/**
 * Страница авторизации - PDA
 */
public class LoginPage extends Page {

    /*
    Логин
    */
    @FindBy(css = "#login")
    private SelenideElement inputLogin;

    /*
    Пароль
     */
    @FindBy(css = "#pass")
    private SelenideElement inputPassword;

    /*
    Вход
     */
    @FindBy(css = "input[name='logon']")
    private SelenideElement loginButton;


    /**
     * вводим Логин пользователя
     *
     * @param login input text login
     * @param passw input text password
     */
    public void loginAs(String login, String passw) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        inputPassword.clear();
        inputPassword.sendKeys(passw);
    }

    /**
     * Вводим Login пользователя
     * @param login input text login
     * @return
     */
    public LoginPage setLoginField(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    /**
     * Вводим пароль пользователя
     * @param password input text password
     * @return
     */
    public LoginPage setPasswordField(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    /**
     * Авторизация под указанным пользователем
     * @param user
     */
    public LoginPage loginAsAdmin(Employee user) {
        setLoginField(user.getLoginName());
        setPasswordField(user.getPassword());
        return this;
    }

    /**
     * Клик по кнопке - Вход
     */
    public LoginPage loginInSystem() {
        loginButton.click();
        return this;
    }

    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return results Internal page instance
     */
    public InternalPage goToInternalMenu() {
        loginButton.click();
        return page(InternalPage.class);
    }


}
