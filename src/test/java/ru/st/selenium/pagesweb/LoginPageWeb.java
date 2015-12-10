package ru.st.selenium.pagesweb;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.modelpda.Employee;
import ru.st.selenium.pagespda.Page;
import ru.st.selenium.pagesweb.Internal.InternalPageWeb;

import static com.codeborne.selenide.Selenide.page;

/**
 * Стараница авторизации - Web
 */
public class LoginPageWeb extends Page {

    /**
     * Логин
     */
    @FindBy(css = "#login")
    private SelenideElement loginField;

    /**
     * Пароль
     */
    @FindBy(css = "#pass")
    private SelenideElement passwordField;

    /**
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
    public LoginPageWeb setLoginField(String text) {
        loginField.clear();
        loginField.sendKeys(text);
        return this;
    }

    /**
     * Вводим пароль пользователя
     *
     * @param text
     * @return
     */
    public LoginPageWeb setPasswordField(String text) {
        passwordField.clear();
        passwordField.sendKeys(text);
        return this;
    }

    /**
     * Авторизация под указанным пользователем
     * @param user
     */
    public LoginPageWeb loginAsAdmin(Employee user) {
        setLoginField(user.getLoginName());
        setPasswordField(user.getPassword());
        return this;
    }


    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return results internal page instance
     */
    public InternalPageWeb goToInternalMenu() {
        submitButton.click();
        return page(InternalPageWeb.class);
    }








}
