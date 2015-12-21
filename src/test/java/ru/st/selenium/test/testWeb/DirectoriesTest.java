package ru.st.selenium.test.testWeb;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ru.st.selenium.model.Administration.Directories.Directories;
import ru.st.selenium.pages.Page;
import ru.st.selenium.pages.pagesweb.Administration.DirectoriesEditFormPage;
import ru.st.selenium.pages.pagesweb.Administration.TaskTypeListObjectPage;
import ru.st.selenium.pages.pagesweb.Internal.InternalPage;
import ru.st.selenium.pages.pagesweb.Login.LoginPage;
import ru.st.selenium.test.data.ModuleAdministrationObjectTestCase;
import ru.st.selenium.test.data.Retry;


import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Справочники
 */
public class DirectoriesTest extends ModuleAdministrationObjectTestCase {




    // verify create Directories
    @Test(priority = 1, dataProvider = "objectDataDirectories", retryAnalyzer = Retry.class)
    public void createDirectories(Directories directories) throws Exception {
        // Авторизация
        LoginPage loginPage = open(Page.WEB_PAGE_URL, LoginPage.class);
        loginPage.loginAs(ADMIN);
        InternalPage internalPage = loginPage.initializedInsidePage(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertThat("Check that the displayed menu item 8 (Logo; Tasks; Documents; Messages; Calendar; Library; Tools; Details)",
                internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

        // Переход в раздел Администрирование/Справочники
        TaskTypeListObjectPage directoriesPageWeb = internalPage.gotoDirectories();

        // Добавляем объект - Справочник
        directoriesPageWeb.addDirectories(directories);

        // переходим в форму редактирования Справочника
        DirectoriesEditFormPage directoriesEditPage = internalPage.gotoDirectoriesEditPage();

        // Добавляем настройки И поля спр-ка
        directoriesEditPage.addFieldDirectories(directories);

        // Выход из системы
        internalPage.logout();

        // Проверка - пользователь разлогинен
        assertTrue(loginPage.isNotLoggedIn());

    }

    /**
     * Удаление объекта из системы
     * TODO - обязательно подчищаем за собой данные!!!
     * @param directories
     * @throws Exception
     */
    @AfterTest
    public void removeAnDirectories (Directories directories) throws Exception {
        // Авторизация
        LoginPage loginPage = open(Page.WEB_PAGE_URL, LoginPage.class);
        loginPage.loginAs(ADMIN);
        InternalPage internalPage = loginPage.initializedInsidePage(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertThat("Check that the displayed menu item 8 (Logo; Tasks; Documents; Messages; Calendar; Library; Tools; Details)",
                internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

        // Переход в раздел Администрирование/Справочники
        TaskTypeListObjectPage directoriesPageWeb = internalPage.gotoDirectories();

        // Удаляем объект - Справочник
        directoriesPageWeb.removeAnDirectories(directories);


    }

}
