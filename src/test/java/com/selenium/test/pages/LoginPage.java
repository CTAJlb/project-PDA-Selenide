package com.selenium.test.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenium.test.model.Employee;
import org.openqa.selenium.TimeoutException;
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
     * @param login text for input
     * @param passw text for input
     */
    public void loginAs(String login, String passw) {
        inputLogin.clear();
        inputLogin.sendKeys(login);
        inputPassword.clear();
        inputPassword.sendKeys(passw);
    }

    /**
     * Вводим Login пользователя
     * @param text
     * @return
     */
    public LoginPage setLoginField(String text) {
        inputLogin.sendKeys(text);
        return this;
    }

    /**
     * Вводим пароль пользователя
     * @param text
     * @return
     */
    public LoginPage setPasswordField(String text) {
        inputPassword.sendKeys(text);
        return this;
    }

    /**
     * Авторизация под указанным пользователем
     * @param user
     */
    public void loginAsAdmin(Employee user) {
        setLoginField(user.getLoginName());
        setPasswordField(user.getPassword());
    }

    /**
     * Клик по кнопке - Вход
     */
    public void loginInSystem() {
        loginButton.click();
    }

    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return results page instance
     */
    public InternalPage goToInternalMenu() {
        loginButton.click();
        return page(InternalPage.class);
    }


}
