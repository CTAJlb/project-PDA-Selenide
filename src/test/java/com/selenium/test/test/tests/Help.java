package com.selenium.test.test.tests;

import com.selenium.test.pages.HelpHtmlPage;
import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.test.data.TestBase;
import com.selenium.test.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.PDA_PAGE_URL;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Помощь
 */
@Listeners({ScreenShotOnFailListener.class})
public class Help extends TestBase {


    /**
     * проверка - Отображение элементов на странице
     */
    @Test(priority = 1)
    public void verifyElementsHelp() throws Exception {
        LoginPage loginPage = open(PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        HelpHtmlPage helpPage = internalPage.goToHelpHtml();

        helpPage.checkPresenceElementsOfAid(); // Проверяем общее количество элементов помощи

        helpPage.visibleElementsTextHelp(); // Проверяем отображение текста в элементах помощи

        internalPage.signOut(); // Выход из системы

    }

}
