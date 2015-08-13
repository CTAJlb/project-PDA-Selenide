package com.selenium.test.testng.tests;

import com.codeborne.selenide.Condition;
import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.InternalPage.signOut;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


@Listeners({ScreenShotOnFailListener.class})

public class VerifyLoginPassword {

    public static final String PAGE_URL = "http://pda.johni/";

    /**
     * проверка валидации авторизации - пароль проходит успешно
     */
    @Test(priority = 5)
    public void loginSuccess() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.setInputLogin("admin");
        loginPage.setInputPassword("admin");
        InternalPage resultsPage = loginPage.doMenu(); // Проверяем отображение п.м. системы
        assertTrue(resultsPage.hasResults());
        signOut(); // Выход из системы
    }

    /**
     * проверка невалидного пароля - авторизация не проходит
     */
    @Test(priority = 1)
    public void passwordError() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.setInputLogin("admin");
        loginPage.setInputPassword("fail");
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));

    }

    /**
     * проверка невалидного логина - авторизация не проходит
     */
    @Test(priority = 2)
    public void loginError() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.setInputLogin("fail");
        loginPage.setInputPassword("admin");
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));
    }

    /**
     * проверка невалидного логина - авторизация не проходит
     */
    @Test(priority = 3)
    public void passwordLoginFail() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.setInputLogin("fail");
        loginPage.setInputPassword("fail");
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));
    }

    /**
     * проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(priority = 4)
    public void passwordLoginNull() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.setInputLogin("");
        loginPage.setInputPassword("");
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
    }


}



