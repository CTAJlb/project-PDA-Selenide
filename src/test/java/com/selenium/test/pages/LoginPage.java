package com.selenium.test.pages;

import com.codeborne.selenide.SelenideElement;
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
     * @param text text for input
     */
    public void setInputLogin(String text) {
        inputLogin.clear();
        inputLogin.sendKeys(text);
    }

    /**
     * вводим Пароль пользователя
     *
     * @param text text for input
     */
    public void setInputPassword(String text) {
        inputPassword.clear();
        inputPassword.sendKeys(text);
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
