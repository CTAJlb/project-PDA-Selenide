package ru.st.selenium.test.testclass;

import ru.st.selenium.pages.DocumentsPage;
import ru.st.selenium.pages.InternalPage;
import ru.st.selenium.pages.LoginPage;
import ru.st.selenium.test.data.BaseObjectCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Документы
 */
@Listeners({ScreenShotOnFailListener.class})
public class Documents extends BaseObjectCase {

    /**
     * проверка - Отображение грида документа
     */
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void checkMapGridOfDocuments() throws Exception {
        LoginPage loginPage = open(Page.PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

        DocumentsPage documentsPage = internalPage.goToDocuments();

        documentsPage.checkMapGridsDocuments();

        internalPage.signOut(); // Выход из системы

    }

}
