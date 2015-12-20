package ru.st.selenium.test.testWeb;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.AccessRights;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.DictionaryEditor.DictionaryEditor;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.DictionaryEditor.DictionaryEditorField;
import ru.st.selenium.pages.RandomlySystemObjects;

import static org.junit.Assert.assertTrue;

/**
 * Редактор словарей
 */
public class EditorDictionariesCheck extends RandomlySystemObjects {

    @BeforeMethod
    public void MayBeLogout() {
        if (app.getUsersHelper().isNotLoggedIn()) {
            return;
        }
        app.getUsersHelper().logout();
    }


    @Test
    public void createDictionaryEditor() throws Exception {

        /**
         * Инициализация элементов - Словарь
         */
        DictionaryEditorField elementOne = new DictionaryEditorField()
                .setNameDictionItem(randomString(10))
                .setDescriptionDictionItem(randomString(15) + "\n" + randomString(30));

        DictionaryEditorField elementTwo = new DictionaryEditorField()
                .setNameDictionItem(randomString(10))
                .setDescriptionDictionItem(randomString(50) + "\n" + randomString(30));

        DictionaryEditorField elementThree = new DictionaryEditorField()
                .setNameDictionItem(randomString(10))
                .setDescriptionDictionItem(randomString(30) + "\n" + randomString(30));

        DictionaryEditorField elementFour = new DictionaryEditorField()
                .setNameDictionItem(randomString(10))
                .setDescriptionDictionItem(randomString(30) + "\n" + randomString(30));

        DictionaryEditorField elementFive = new DictionaryEditorField()
                .setNameDictionItem(randomString(10))
                .setDescriptionDictionItem(randomString(30) + "\n" + randomString(30));

        /**
         * Инициализация - Словарь
         */
        DictionaryEditor dictionaryEditor = new DictionaryEditor()
                .setDictionaryEditorName("S_Словарь " + randomString(10))
                .setAccessDiction(AccessRights.AVAILABLETOALL)
                .setDictionaryEditorFields(new DictionaryEditorField[]{elementOne, elementTwo,
                        elementThree, elementFour, elementFive});


        // Авторизация в Систему
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());

        // Переход в раздел Администрирование ДО/Редактор словарей
        app.getDictionaryEditorHelper().beforeAdd();
        app.getDictionaryEditorHelper().addDictionaryEditor(dictionaryEditor);
        app.getUsersHelper().logout();
        assertTrue(app.getUsersHelper().isNotLoggedIn());

    }

}