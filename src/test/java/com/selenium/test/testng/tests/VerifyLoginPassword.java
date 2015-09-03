package com.selenium.test.testng.tests;

import com.codeborne.selenide.Condition;
import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;
import static com.selenium.test.pages.Page.*;


@Listeners({ScreenShotOnFailListener.class})

public class VerifyLoginPassword {

    /**
     * Инициализация входных данных для Логин и Пароль
     *
     */
    @DataProvider(name = "firstFailAuthorization")
    public Object[][] firstNotSuccessfulAuthorizationDataProvider() {
        return new Object[][]{
                {"fail", "admin"},
                {"admin", "fail"},
                {"admin", null},
        };
    }

    @DataProvider(name = "secondFailAuthorization")
    public Object[][] secondNotSuccessfulAuthorizationDataProvider() {
        return new Object[][]{
                {null, "admin"},
                {null, null}
        };
    }

    @DataProvider(name = "successAuthorization")
    public Object[][] successAuthorizationDataProvider() {
        return new Object[][]{
                {"admin", "admin"}
        };
    }


    /**
     * проверка валидации авторизации - авторизация проходит успешно
     */
    @Test(dataProvider = "successAuthorization", priority = 3)
    public void loginSuccess(String login, String pass) throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(login, pass);
        InternalPage internalPage = loginPage.goToInternalMenu(); // Проверяем отображение п.м. системы
        assertTrue(internalPage.hasMenu());
        internalPage.signOut(); // Выход из системы
    }

    /**
     * проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(dataProvider = "firstFailAuthorization", priority = 1)
    public void firstFailAuthorization(String login, String pass) throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(login, pass);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));

    }

    /**
     * 2-я проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(dataProvider = "secondFailAuthorization", priority = 2)
    public void secondFailAuthorization(String login, String pass) throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(login, pass);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
    }


}