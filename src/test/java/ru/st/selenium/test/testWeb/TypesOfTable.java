package ru.st.selenium.test.testWeb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Administration.TypesOfTables.Directories.Directory;
import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.TaskTypeListFields.*;
import ru.st.selenium.model.Administration.TypesOfTables.TypesOfTables;
import ru.st.selenium.model.Administration.TypesOfTables.TypesOfTablesField;
import ru.st.selenium.pages.RandomlySystemObjects;

import static org.junit.Assert.assertTrue;

public class TypesOfTable extends RandomlySystemObjects {

    @BeforeMethod
    public void MayBeLogout() {
        if (app.getUsersHelper().isNotLoggedIn()) {
            return;
        }
        app.getUsersHelper().logout();
    }

    //---------------------------------------------------------------------------------------------------------Инициализация полей и объекта - СПРАВОЧНИКИ

    // 1. СТРОКА (Выбор из списка == Да; Уникальное; Обязательное)
    DirectoryField fieldStringIsListChoiceDirectory = new DirectoryField()
            .setFieldName("Строка (Выбор из списка == Да; Обяз.) " + randomString(10))
            .setFieldID("STRING" + randomID(5))
            .setObligatory(true) // Обязательное поле
            .setIsUniqueField(true) // Уникальное
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(true) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))); // Список значений

    // 2. ТЕКСТ
    DirectoryField fieldTextDirectory = new DirectoryField()
            .setFieldName("Текст " + randomString(10))
            .setFieldID("TEXT" + randomID(5))
            .setFieldType(new TypeListFieldsText());

    // 3. ЦЕЛОЕ
    DirectoryField fieldIntDirectory = new DirectoryField()
            .setFieldName("Целое " + randomString(10))
            .setFieldID("INTEGER" + randomID(5))
            .setFieldType(new TypeListFieldsInt());

    // Инициализируем объект - Справочник
    Directory directory = new Directory()

            // Вкладка - Настройки
            .setDirectoryName("S_Справочник" + randomString(10)) // Название справочника
            .setShareRecords(true) // Общедоступность записей
            .setSetAccessToRecords(true) // Настройка доступа к записям
            .setMappingDevice(true) // Способ отображения - Линейный ли? true - да; false - иерархический
            .setSearchSettings(true) // true - поиск записей через SOLR; false - поиск записей через БД
            .setDirectoryFields(new DirectoryField[]{fieldStringIsListChoiceDirectory, fieldTextDirectory, fieldIntDirectory});

    //---------------------------------------------------------------------------------------------------------Инициализация полей объекта - ТИПЫ ТАБЛИЦ

    // 1. СТРОКА (Выбор из списка == Да; Обязательное)
    TypesOfTablesField fieldStringIsListChoice = new TypesOfTablesField()
            .setFieldName("Строка (Выбор из списка == Да; Обязательное) " + randomString(5))
            .setFieldID("STRING" + randomID(5))
            .setObligatory(true) // Обязательное поле
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(true) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))); // Список значений

    // 1.1. СТРОКА (Выбор из списка == Нет)
    TypesOfTablesField fieldStringIsNotListChoice = new TypesOfTablesField()
            .setFieldName("Строка (Выбор из списка == Нет) " + randomString(10))
            .setFieldID("STRING" + randomID(5))
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(false) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))); // Список значений

    // 2. ТЕКСТ
    TypesOfTablesField fieldText = new TypesOfTablesField()
            .setFieldName("Текст " + randomString(10))
            .setFieldID("TEXT" + randomID(5))
            .setFieldType(new TypeListFieldsText());

    // 3. ЦЕЛОЕ (Ссылка на объект == Задача)
    TypesOfTablesField fieldIntLinkObject = new TypesOfTablesField()
            .setFieldName("Целое (Ссылка на объект == Задача) " + randomString(10))
            .setFieldID("INTEGER" + randomID(5))
            .setFieldType(new TypeListFieldsInt()
                    .setObjectLink(true)); // Ссылка на объект

    // 3.1. ЦЕЛОЕ (Ссылка на объект == Нет)
    TypesOfTablesField fieldInt = new TypesOfTablesField()
            .setFieldName("Целое (Ссылка на объект == Нет) " + randomString(10))
            .setFieldID("INTEGER" + randomID(5))
            .setFieldType(new TypeListFieldsInt()
                    .setObjectLink(false));

    // 4. ВЕЩЕСТВЕННОЕ
    TypesOfTablesField fieldFloat = new TypesOfTablesField()
            .setFieldName("Вещественное " + randomString(10))
            .setFieldID("FLOAT" + randomID(5))
            .setFieldType(new TypeListFieldsDouble());

    // 5. ДАТА
    TypesOfTablesField fieldDate = new TypesOfTablesField()
            .setFieldName("Дата " + randomString(10))
            .setFieldID("DATE" + randomID(5))
            .setFieldType(new TypeListFieldsDate());

    // 6. ФАЙЛ (Редактирование == Да)
    TypesOfTablesField fieldFileEdit = new TypesOfTablesField()
            .setFieldName("Файл (Редактирование == Да) " + randomString(10))
            .setObligatory(true)
            .setFieldID("FILEDIT" + randomID(5))
            .setFieldType(new TypeListFieldsFile()
                    .setOpenFilesForEdit(OpenFilesForEdit.YES)); // Редактирование файлов - Да

    // 6.1. ФАЙЛ (Редактирование == Нет)
    TypesOfTablesField fieldFile = new TypesOfTablesField()
            .setFieldName("Файл (Редактирование == Нет) " + randomString(10))
            .setFieldID("FILE" + randomID(5))
            .setFieldType(new TypeListFieldsFile()
                    .setOpenFilesForEdit(OpenFilesForEdit.NO)); // Редактирование файлов - Нет

    // 7. ССЫЛКА НА СПР-К
    TypesOfTablesField fieldDirectory = new TypesOfTablesField()
            .setFieldName("Ссылка на справочник " + randomString(10))
            .setFieldID("DIRECTORY" + randomID(5))
            .setFieldType(new TypeListFieldsDirectory()
                    .setDirectoryName("Адресная книга")
                    .setNameDirectoryField("Фамилия"));

    // 8. МНОЖЕСТВЕННАЯ ССЫЛКА НА СПР-К
    TypesOfTablesField fieldMultiDirectory = new TypesOfTablesField()
            .setFieldName("Множественная ссылка на справочник " + randomString(5))
            .setFieldID("DIRMULTI" + randomID(5))
            .setFieldType(new TypeListFieldsMultiDirectory()
                    .setDirectory(directory)
                    .setFieldDirectory(fieldStringIsListChoiceDirectory));

    // 9. ЛОГИЧЕСКИЙ
    TypesOfTablesField fieldBoolean = new TypesOfTablesField()
            .setFieldName("Логический " + randomString(5))
            .setFieldID("BOOLEAN" + randomID(5))
            .setFieldType(new TypeListFieldsBoolean());

    // 10. ТЕЛЕФОН
    TypesOfTablesField fieldPhone = new TypesOfTablesField()
            .setFieldName("Телефон " + randomString(5))
            .setFieldID("PHONE" + randomID(5))
            .setFieldType(new TypeListFieldsPhone());

    // 11. EMAIL
    TypesOfTablesField fieldEmail = new TypesOfTablesField()
            .setFieldName("Email " + randomString(5))
            .setFieldID("EMAIL" + randomID(5))
            .setFieldType(new TypeListFieldsEmail());

    // 12. ИЗОБРАЖЕНИЕ
    TypesOfTablesField fieldImage = new TypesOfTablesField()
            .setFieldName("Изображение " + randomString(5))
            .setFieldID("IMAGE" + randomID(5))
            .setFieldType(new TypeListFieldsImage());

    // 13. ЦВЕТ
    TypesOfTablesField fieldColor = new TypesOfTablesField()
            .setFieldName("Цвет " + randomString(5))
            .setFieldID("COLOR" + randomID(5))
            .setFieldType(new TypeListFieldsColor());


    // Инициализируем объект - Типы таблиц
    TypesOfTables typesOfTables = new TypesOfTables()

            // Вкладка - Настройки
            .setTableTypeName("S_Типы таблиц " + randomString(10)) // Название Типа таблицы
            .setMappingDevice(true) // Способ отображения - Линейный ли? true - да; false - иерархический
            .setTypesOfTablesFields(new TypesOfTablesField[]{fieldStringIsListChoice, fieldStringIsNotListChoice, fieldText, fieldIntLinkObject, fieldInt, fieldFloat, fieldDate, fieldFileEdit,
                    fieldFile, fieldDirectory, fieldMultiDirectory, fieldBoolean, fieldPhone, fieldEmail, fieldImage, fieldColor});

    // Add Create Types Of Table
    @Test
    public void createTypesOfTable() throws Exception {

        // Авторизация
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());
        // Переход в раздел Администрирование/Справочники
        app.getDirectoryHelper().beforeAdd();
        app.getDirectoryHelper().addDirectory(directory);
        // Выход из системы
        app.getUsersHelper().logout();

        // Авторизация
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());
        // Переход в раздел Администрирование/Типы таблиц
        app.getTypesOfTablesHelper().beforeAdd();
        app.getTypesOfTablesHelper().addTypesOfTables(typesOfTables);

        // Выход из системы
        app.getUsersHelper().logout();

        // Проверка - пользователь разлогинен
        assertTrue(app.getUsersHelper().isNotLoggedIn());


    }


}
