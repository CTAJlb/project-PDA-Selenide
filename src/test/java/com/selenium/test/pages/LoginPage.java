package com.selenium.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;


/**
 * Страница авторизации - PDA
 */
public class LoginPage {

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
    public InternalPage doMenu() {
        loginButton.click();
        return page(InternalPage.class);
    }


    /**
     * Проверяем то, что мы разлогинены
     */
    public boolean isNotLoggedIn() {
        return page(LoginPage.class).isPageLoaded();
    }

    /**
     * Метод обращается к ensurePageLoaded и возвращает булевское значение,
     * (false - не дождались загрузки стр.; true - дождались) ждет загрузки
     * страницы
     *
     * @return
     */
    public boolean isPageLoaded() {
        try {
            ensurePageLoaded();
            return true;
        } catch (TimeoutException to) {
            return false;
        }
    }

    /**
     * Метод - проверяет, где мы находимся здесь и сейчас, возвращает данную
     * страницу И ждет загрузки страницы
     *
     * @return
     */
    public LoginPage ensurePageLoaded() {
        return this;
    }

}
