package com.selenium.test.testng.tests;

import com.codeborne.selenide.Condition;
import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static com.selenium.test.pages.Page.*;


@Listeners({ScreenShotOnFailListener.class})

public class VerifyLoginPassword {

    String admin = "admin";
    String fail = "fail";


    /**
     * проверка валидации авторизации - пароль проходит успешно
     */
    @Test(priority = 5)
    public void loginSuccess() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(admin, admin);
        InternalPage internalPage = loginPage.goToInternalMenu(); // Проверяем отображение п.м. системы
        assertTrue(internalPage.hasMenu());
        internalPage.signOut(); // Выход из системы
    }

    /**
     * проверка невалидного пароля - авторизация не проходит
     */
    @Test(priority = 1)
    public void passwordFail() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(admin, fail);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));

    }

    /**
     * проверка невалидного логина - авторизация не проходит
     */
    @Test(priority = 2)
    public void loginFail() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(fail, admin);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));
    }

    /**
     * проверка невалидного логина - авторизация не проходит
     */
    @Test(priority = 3)
    public void passwordAndLoginFail() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(fail, fail);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));
    }

    /**
     * проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(priority = 4)
    public void passwordAndLoginNull() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.loginAs(null, null);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
    }


}



