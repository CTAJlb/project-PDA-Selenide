package ru.st.selenium.test.testPda;

import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.model.Directories.Directories;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditor;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.*;
import ru.st.selenium.pagespda.DocumentsPage;
import ru.st.selenium.pagespda.InternalPage;
import ru.st.selenium.pagespda.LoginPage;
import ru.st.selenium.pagespda.Page;
import ru.st.selenium.pagesweb.Administration.DirectoriesEditFormPage;
import ru.st.selenium.pagesweb.Administration.TaskTypeListObjectPage;
import ru.st.selenium.pagesweb.DocflowAdministration.DictionaryEditorPage;
import ru.st.selenium.pagesweb.DocflowAdministration.FormDocRegisterCardsEditPageWeb;
import ru.st.selenium.pagesweb.DocflowAdministration.GridDocRegisterCardsPageWeb;
import ru.st.selenium.pagesweb.Internal.InternalPageWeb;
import ru.st.selenium.pagesweb.LoginPageWeb;
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
     * @param directories
     * @param dictionaryEditor
     * @param registerCards
     * @throws Exception
     *
     * TODO 1. retryAnalyzer = Retry.class - добавить параметр в аннотацию тест; 2.Создание Документа и проверка созданного документа в гриде PDA
     */
    @Test(priority = 1, dataProvider = "objectDataDocument", retryAnalyzer = Retry.class)
    public void createRegCardDocumentAllFields(Directories directories, DictionaryEditor dictionaryEditor, DocRegisterCards registerCards) throws Exception {

        LoginPageWeb loginPageWeb = open(Page.WEB_PAGE_URL, LoginPageWeb.class);

        loginPageWeb.loginAsAdmin(ADMIN);

        InternalPageWeb internalPageWeb = loginPageWeb.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertThat("Check that the displayed menu item 8 (Logo; Tasks; Documents; Messages; Calendar; Library; Tools; Details)",
                internalPageWeb.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице


        // Переход в раздел Администрирование/Справочники
        TaskTypeListObjectPage directoriesPageWeb = internalPageWeb.gotoDirectories();

        // добавляем объект - Справочник
        directoriesPageWeb.addDirectories(directories);

        // переходим в форму редактирования Справочника
        DirectoriesEditFormPage directoriesEditPage = internalPageWeb.gotoDirectoriesEditPage();

        // Добавляем настройки И поля спр-ка
        directoriesEditPage.addFieldDirectories(directories);

        // Переход в раздел - Администрирование ДО/Редактор словарей
        DictionaryEditorPage dictionaryEditorPage = internalPageWeb.goToDictionaryEditor();
        dictionaryEditorPage.addDictionaryEditor(dictionaryEditor);


        // Переход в раздел Администрирование ДО/Регистрационные карточки документов
        GridDocRegisterCardsPageWeb gridDocRegisterCardsPageWeb = internalPageWeb.goToGridDocRegisterCards();

        // Добавление РКД с проинициализированными объектами
        FormDocRegisterCardsEditPageWeb formDocRegisterCardsEditPageWeb = gridDocRegisterCardsPageWeb.addDocRegisterCards();

        // Добавление полей РКД
        formDocRegisterCardsEditPageWeb.addFieldsDocRegisterCards(registerCards);

        // Добавление настроек РКД
        formDocRegisterCardsEditPageWeb.addSettingsDocRegisterCards(registerCards);

        // Сохранение настроек РКД
        formDocRegisterCardsEditPageWeb.saveAllChangesInDoc(registerCards);

        internalPageWeb.logout(); // Выход из системы
    }

    /**
     * проверка - Отображение грида документа
     */
    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void checkMapGridOfDocuments() throws Exception {
        LoginPage loginPage = open(Page.PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

        DocumentsPage documentsPage = internalPage.goToDocuments();

        documentsPage.checkMapGridsDocuments();

        internalPage.logout(); // Выход из системы

    }

}
