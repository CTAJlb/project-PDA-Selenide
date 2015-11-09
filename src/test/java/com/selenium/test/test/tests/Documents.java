package com.selenium.test.test.tests;

import com.selenium.test.pages.DocumentsPage;
import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.test.data.TestBase;
import com.selenium.test.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.PAGE_URL;
import static org.testng.Assert.assertTrue;

@Listeners({ScreenShotOnFailListener.class})
public class Documents extends TestBase {

    /**
     * проверка - Отображение грида документа
     */
    @Test(priority = 1)
    public void checkMapGridOfDocuments() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        DocumentsPage documentsPage = internalPage.goToDocuments();


        documentsPage.checkMapGridsDocuments();


        internalPage.homeAndSignOut(); // Выход из системы

    }

}
