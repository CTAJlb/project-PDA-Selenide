package ru.st.selenium.test.testWeb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Administration.TypesOfTables.Directories.Directory;
import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.TaskTypeListFields.*;
import ru.st.selenium.pages.RandomlySystemObjects;

import static org.junit.Assert.assertTrue;

/**
 * Справочники
 */
public class Directories extends RandomlySystemObjects {

    @BeforeMethod
    public void MayBeLogout() {
        if (app.getUsersHelper().isNotLoggedIn()) {
            return;
        }
        app.getUsersHelper().logout();
    }


    // Инициализация полей объекта - Справочник

    // 1. СТРОКА (Выбор из списка == Да; Уникальное; Обязательное)
    DirectoryField fieldStringIsListChoice = new DirectoryField()
            .setFieldName("Строка (Выбор из списка == Да; Обяз.) " + randomString(10))
            .setFieldID("STRING" + randomID(5))
            .setObligatory(true) // Обязательное поле
            .setIsUniqueField(true) // Уникальное
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(true) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))); // Список значений

    // 1.1. СТРОКА (Выбор из списка == Нет)
    DirectoryField fieldStringIsNotListChoice = new DirectoryField()
            .setFieldName("Строка (Выбор из списка == Нет) " + randomString(10))
            .setFieldID("STRNOTLIST" + randomID(5))
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(false) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))); // Список значений

    // 2. ТЕКСТ
    DirectoryField fieldText = new DirectoryField()
            .setFieldName("Текст " + randomString(10))
            .setFieldID("TEXT" + randomID(5))
            .setFieldType(new TypeListFieldsText());

    // 3. ЦЕЛОЕ
    DirectoryField fieldInt = new DirectoryField()
            .setFieldName("Целое " + randomString(10))
            .setFieldID("INTEGER" + randomID(5))
            .setFieldType(new TypeListFieldsInt());

    // 4. ВЕЩЕСТВЕННОЕ
    DirectoryField fieldFloat = new DirectoryField()
            .setFieldName("Вещественное " + randomString(10))
            .setFieldID("FLOAT" + randomID(5))
            .setFieldType(new TypeListFieldsDouble());

    // 5. ДАТА
    DirectoryField fieldDate = new DirectoryField()
            .setFieldName("Дата " + randomString(10))
            .setFieldID("DATE" + randomID(5))
            .setFieldType(new TypeListFieldsDate());

    // 6. ФАЙЛ (Редактирование == Да)
    DirectoryField fieldFileEdit = new DirectoryField()
            .setFieldName("Файл (Редактирование == Да) " + randomString(10))
            .setFieldID("FILEDIT" + randomID(5))
            .setFieldType(new TypeListFieldsFile()
                    .setOpenFilesForEdit(OpenFilesForEdit.YES)); // Редактирование файлов - Да

    // 6.1. ФАЙЛ (Редактирование == Нет)
    DirectoryField fieldFile = new DirectoryField()
            .setFieldName("Файл (Редактирование == Нет) " + randomString(10))
            .setFieldID("FILE" + randomID(5))
            .setFieldType(new TypeListFieldsFile()
                    .setOpenFilesForEdit(OpenFilesForEdit.NO)); // Редактирование файлов - Нет

    // 7. ССЫЛКА НА СПР-К
    DirectoryField fieldDirectory = new DirectoryField()
            .setFieldName("Ссылка на справочник " + randomString(10))
            .setFieldID("DIRECTORY" + randomID(5))
            .setFieldType(new TypeListFieldsDirectory()
                    .setDirectoryName("Адресная книга")
                    .setNameDirectoryField("Фамилия"));

    // 8. МНОЖЕСТВЕННАЯ ССЫЛКА НА СПР-К
    DirectoryField fieldMultiDirectory = new DirectoryField()
            .setFieldName("Множественная ссылка на справочник " + randomString(5))
            .setFieldID("DIRMULTI" + randomID(5))
            .setFieldType(new TypeListFieldsMultiDirectory()
                    .setDirectoryName("Банк")
                    .setNameDirectoryField("Название"));

    // 9. ЛОГИЧЕСКИЙ
    DirectoryField fieldBoolean = new DirectoryField()
            .setFieldName("Логический " + randomString(5))
            .setFieldID("BOOLEAN" + randomID(5))
            .setFieldType(new TypeListFieldsBoolean());

    // 10. ТЕЛЕФОН
    DirectoryField fieldPhone = new DirectoryField()
            .setFieldName("Телефон " + randomString(5))
            .setFieldID("PHONE" + randomID(5))
            .setFieldType(new TypeListFieldsPhone());

    // 11. EMAIL
    DirectoryField fieldEmail = new DirectoryField()
            .setFieldName("Email " + randomString(5))
            .setFieldID("EMAIL" + randomID(5))
            .setFieldType(new TypeListFieldsEmail());

    // 12. ИЗОБРАЖЕНИЕ
    DirectoryField fieldImage = new DirectoryField()
            .setFieldName("Изображение " + randomString(5))
            .setFieldID("IMAGE" + randomID(5))
            .setFieldType(new TypeListFieldsImage());

    // 13. ЦВЕТ
    DirectoryField fieldColor = new DirectoryField()
            .setFieldName("Цвет " + randomString(5))
            .setFieldID("COLOR" + randomID(5))
            .setFieldType(new TypeListFieldsColor())
            .setIsUniqueField(true); // Уникальное

    // 14. ВЛОЖЕННЫЙ СПРАВОЧНИК
    DirectoryField fieldEnclosedDirectory = new DirectoryField()
            .setFieldName("Вложенный спр-к " + randomString(5))
            .setFieldID("ENCLOSEDDIRECTORY" + randomID(5))
            .setFieldType(new TypeListFieldsEnclosedDirectory()
                    .setDirectoryName("Банк"));

    // Инициализируем объект - Справочник
    Directory directory = new Directory()

            // Вкладка - Настройки
            .setDirectoryName("S_Справочник " + randomString(10)) // Название справочника
            .setShareRecords(true) // Общедоступность записей
            .setSetAccessToRecords(true) // Настройка доступа к записям
            .setMappingDevice(true) // Способ отображения - Линейный ли? true - да; false - иерархический
            .setSearchSettings(true) // true - поиск записей через SOLR; false - поиск записей через БД
            .setDirectoryFields(new DirectoryField[]{fieldStringIsListChoice, fieldStringIsNotListChoice, fieldText, fieldInt, fieldFloat, fieldDate, fieldFileEdit,
                    fieldFile, fieldDirectory, fieldMultiDirectory, fieldBoolean, fieldPhone, fieldEmail, fieldImage, fieldColor, fieldEnclosedDirectory});


    // Add Create Directory
    @Test
    public void createDirectory() throws Exception {

        // Авторизация
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());

        // Переход в раздел Администрирование/Справочники
        app.getDirectoryHelper().beforeAdd();
        app.getDirectoryHelper().addDirectory(directory);
        // Выход из системы
        app.getUsersHelper().logout();

        // Проверка - пользователь разлогинен
        assertTrue(app.getUsersHelper().isNotLoggedIn());

    }

}
