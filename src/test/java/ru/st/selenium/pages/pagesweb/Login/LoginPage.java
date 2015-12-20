package ru.st.selenium.pages.pagesweb.Login;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.pages.Page;
import ru.st.selenium.pages.pagesweb.Internal.InternalPage;

import static com.codeborne.selenide.Selenide.page;

/**
 * Стараница авторизации - Web
 */
public class LoginPage extends Page {

    /*
     * Логин
     */
    @FindBy(css = "#login")
    private SelenideElement loginField;

    /*
     * Пароль
     */
    @FindBy(css = "#pass")
    private SelenideElement passwordField;

    /*
     * Вход
     */
    @FindBy(css = "#subm")
    private SelenideElement submitButton;

    /**
     * Вводим Login пользователя
     *
     * @param text
     * @return
     */
    public LoginPage setLoginField(String text) {
        loginField.clear();
        loginField.setValue(text);
        return this;
    }

    /**
     * Вводим пароль пользователя
     *
     * @param text
     * @return
     */
    public LoginPage setPasswordField(String text) {
        passwordField.clear();
        passwordField.setValue(text);
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
     * Осуществляем вход в систему - клик - Вход (на стр. авторизации)
     *
     * @return results internal page instance
     */
    public InternalPage goToInternalMenu() {
        submitButton.click();
        return page(InternalPage.class);
    }


    /**
     * Проверяем то, что мы разлогинены - Web-интерфейс
     */
    public boolean isNotLoggedIn() {
        return page(LoginPage.class).isPageLoaded();
    }





}
