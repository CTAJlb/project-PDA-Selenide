package ru.st.selenium.test.testPda;


import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.pages.pagespda.HelpHtmlPagePDA;
import ru.st.selenium.pages.pagespda.InternalPagePDA;
import ru.st.selenium.pages.pagespda.LoginPagePDA;
import ru.st.selenium.test.data.BaseObjectTestCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Помощь
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
public class HelpTest extends BaseObjectTestCase {


    /**
     * проверка - Отображение элементов на странице
     */
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void verifyElementsHelp() throws Exception {
        LoginPagePDA loginPagePDA = open(Page.PDA_PAGE_URL, LoginPagePDA.class);

        // Авторизация
        loginPagePDA.loginAsAdmin(ADMIN);

        InternalPagePDA internalPagePDA = loginPagePDA.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertThat("Check that the displayed menu item 4 (Tasks; Create Task; Today; Document)",
                internalPagePDA.hasMenuUserComplete());

        // Инициализируем стр. формы создание задачи и переходим на нее
        HelpHtmlPagePDA helpPage = internalPagePDA.goToHelpHtml();

        helpPage.checkPresenceElementsOfAid(); // Проверяем общее количество элементов помощи

        helpPage.visibleElementsTextHelp(); // Проверяем отображение текста в элементах помощи

        assertEquals(19, helpPage.results().size()); // проверяем кол-во элементов на стр-це ппомочи

        internalPagePDA.logout(); // Выход из системы
        assertTrue(loginPagePDA.isNotLoggedInPDA());

    }

}
