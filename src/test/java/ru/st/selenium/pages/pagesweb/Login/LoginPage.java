package ru.st.selenium.pages.pagesweb.Login;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.logicinterface.UsersLogic;
import ru.st.selenium.model.Users.Department;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.pages.Page;
import ru.st.selenium.pages.pagesweb.Internal.InternalPage;
import ru.st.selenium.pages.pagesweb.Options.PwdPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Стараница авторизации - Web
 */
public class LoginPage extends Page implements UsersLogic {

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
     * Осуществляем вход в систему - клик - Вход (на стр. авторизации)
     *
     * @return results internal page instance
     */
    public InternalPage initializedInsidePage() {
        return page(InternalPage.class);
    }


    /**
     * Авторизация под указанным пользователем
     *
     * @param user
     */
    @Override
    public LoginPage loginAs(Employee user) {
        setLoginField(user.getLoginName());
        setPasswordField(user.getPassword());
        submitButton.click();
        return this;
    }


    /**
     * Проверка истинности загрузки внутренней стр-цы
     *
     * @return InternalPage
     */
    @Override
    public boolean isLoggedIn() {
        return page(InternalPage.class).isPageLoaded();
    }

    /**
     * Проверяем то, что мы разлогинены
     *
     * @return LoginPage
     */
    @Override
    public boolean isNotLoggedIn() {
        return page(LoginPage.class).isPageLoaded();
    }

    /**
     * Проверяем, что мы не только залогинены, но залогинены под конкретным пользователем
     */
    @Override
    public boolean isLoggedInAs(Employee user) {
        return isLoggedIn()
                && getLoggedUser().getLoginName().equals(user.getLoginName());
    }

    private Employee getLoggedUser() {

        PwdPage userProfile = initializedInsidePage().ensurePageLoaded().gotoPwd()
                .gotoFremUserProfilePage().ensurePageLoaded();
        return new Employee().setLastName(userProfile.getLastName())
                .setLoginName(userProfile.getLoginName());

    }

    @Override
    public void passwordChange(Employee user) {

    }

    @Override
    public void beforeAdd() {

    }

    @Override
    public void deleteUser(Employee user) {

    }

    @Override
    public void checkWorkflow() {

    }

    @Override
    public void checkDocflow() {

    }

    @Override
    public void createAliasForDep(Employee user, Department department) {

    }

    @Override
    public void checkIsAlias(Employee user, Department department) {

    }

    @Override
    public void createUser(Employee user) {

    }

    @Override
    public void editUser(Employee editUser, Employee user) {

    }


}
