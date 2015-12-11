package ru.st.selenium.test.testPda;


import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.pagespda.HelpHtmlPage;
import ru.st.selenium.pagespda.InternalPage;
import ru.st.selenium.pagespda.LoginPage;
import ru.st.selenium.test.data.BaseObjectCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pagespda.Page;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Помощь
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
public class HelpTest extends BaseObjectCase {


    /**
     * проверка - Отображение элементов на странице
     */
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void verifyElementsHelp() throws Exception {
        LoginPage loginPage = open(Page.PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        HelpHtmlPage helpPage = internalPage.goToHelpHtml();

        helpPage.checkPresenceElementsOfAid(); // Проверяем общее количество элементов помощи

        helpPage.visibleElementsTextHelp(); // Проверяем отображение текста в элементах помощи

        assertEquals(19, helpPage.results().size()); // проверяем кол-во элементов на стр-це ппомочи

        internalPage.logout(); // Выход из системы

    }

}
