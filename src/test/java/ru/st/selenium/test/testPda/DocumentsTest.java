package ru.st.selenium.test.testPda;

import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.model.Directories.Directories;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditor;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.*;
import ru.st.selenium.pages.Page;
import ru.st.selenium.pages.pagespda.DocumentsPagePDA;
import ru.st.selenium.pages.pagespda.InternalPagePDA;
import ru.st.selenium.pages.pagespda.LoginPagePDA;
import ru.st.selenium.pages.pagesweb.Administration.DirectoriesEditFormPage;
import ru.st.selenium.pages.pagesweb.Administration.TaskTypeListObjectPage;
import ru.st.selenium.pages.pagesweb.DocflowAdministration.DictionaryEditorPage;
import ru.st.selenium.pages.pagesweb.DocflowAdministration.FormDocRegisterCardsEditPage;
import ru.st.selenium.pages.pagesweb.DocflowAdministration.GridDocRegisterCardsPage;
import ru.st.selenium.pages.pagesweb.Internal.InternalPage;
import ru.st.selenium.pages.pagesweb.LoginPage;
import ru.st.selenium.test.data.ModuleDocflowAdministrationObjectTestCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Документы
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
public class DocumentsTest extends ModuleDocflowAdministrationObjectTestCase {

    /**
     * Проверка создания документа и отображение его в гриде
     *
     * @param directories
     * @param dictionaryEditor
     * @param registerCards
     * @throws Exception TODO 1. retryAnalyzer = Retry.class - добавить параметр в аннотацию тест; 2.Создание Документа и проверка созданного документа в гриде PDA
     */
    @Test(priority = 1, dataProvider = "objectDataDocument")
    public void createRegCardDocumentAllFields(Directories directories, DictionaryEditor dictionaryEditor, DocRegisterCards registerCards) throws Exception {

        LoginPage loginPage = open(Page.WEB_PAGE_URL, LoginPage.class);

        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertThat("Check that the displayed menu item 8 (Logo; Tasks; Documents; Messages; Calendar; Library; Tools; Details)",
                internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице


        // Переход в раздел Администрирование/Справочники
        TaskTypeListObjectPage directoriesPageWeb = internalPage.gotoDirectories();

        // добавляем объект - Справочник
        directoriesPageWeb.addDirectories(directories);

        // переходим в форму редактирования Справочника
        DirectoriesEditFormPage directoriesEditPage = internalPage.gotoDirectoriesEditPage();

        // Добавляем настройки И поля спр-ка
        directoriesEditPage.addFieldDirectories(directories);

        // Переход в раздел - Администрирование ДО/Редактор словарей
        DictionaryEditorPage dictionaryEditorPage = internalPage.goToDictionaryEditor();
        dictionaryEditorPage.addDictionaryEditor(dictionaryEditor);


        // Переход в раздел Администрирование ДО/Регистрационные карточки документов
        GridDocRegisterCardsPage gridDocRegisterCardsPage = internalPage.goToGridDocRegisterCards();

        // Добавление РКД с проинициализированными объектами
        FormDocRegisterCardsEditPage formDocRegisterCardsEditPage = gridDocRegisterCardsPage.addDocRegisterCards();

        // Добавление полей РКД
        formDocRegisterCardsEditPage.addFieldsDocRegisterCards(registerCards);

        // Добавление настроек РКД
        formDocRegisterCardsEditPage.addSettingsDocRegisterCards(registerCards);

        // Сохранение настроек РКД
        formDocRegisterCardsEditPage.saveAllChangesInDoc(registerCards);

        internalPage.logout(); // Выход из системы
        assertTrue(loginPage.isNotLoggedIn());
    }

    /**
     * проверка - Отображение грида документа
     */
    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void checkMapGridOfDocuments() throws Exception {
        LoginPagePDA loginPagePDA = open(Page.PDA_PAGE_URL, LoginPagePDA.class);

        // Авторизация
        loginPagePDA.loginAsAdmin(ADMIN);

        InternalPagePDA internalPagePDA = loginPagePDA.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertThat("Check that the displayed menu item 4 (Tasks; Create Task; Today; Document)",
                internalPagePDA.hasMenuUserComplete());

        DocumentsPagePDA documentsPagePDA = internalPagePDA.goToDocuments();

        documentsPagePDA.checkMapGridsDocuments();

        internalPagePDA.logout(); // Выход из системы
        assertTrue(loginPagePDA.isNotLoggedInPDA());


    }

}
