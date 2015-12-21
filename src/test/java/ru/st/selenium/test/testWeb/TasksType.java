package ru.st.selenium.test.testWeb;


import org.testng.annotations.Test;
import ru.st.selenium.model.CorrectionMethod;

import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.ShiftDirection;

import ru.st.selenium.model.Administration.TasksTypes.ComputeModeNumerator;
import ru.st.selenium.model.Administration.TasksTypes.ObligatoryFieldTypeTask;
import ru.st.selenium.model.Administration.TasksTypes.TasksTypes;
import ru.st.selenium.model.Administration.TasksTypes.TasksTypesField;
import ru.st.selenium.model.Administration.TypesOfTables.TypesOfTables;
import ru.st.selenium.model.Administration.TypesOfTables.TypesOfTablesField;


import static org.junit.Assert.assertTrue;

public class TasksType  {


/*
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


    //---------------------------------------------------------------------------------------------------------Инициализация полей и объекта - ТИПЫ ТАБЛИЦ

    // 1. СТРОКА (Выбор из списка == Да; Обязательное)
    TypesOfTablesField fieldStringTypesTable = new TypesOfTablesField()
            .setFieldName("Строка (Выбор из списка == Да) " + randomString(10))
            .setFieldID("STRING" + randomID(5))
            .setObligatory(true) // Обязательное поле
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(true) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))); // Список значений

    // 2. ТЕКСТ
    TypesOfTablesField fieldTextTypesTable = new TypesOfTablesField()
            .setFieldName("Текст " + randomString(10))
            .setFieldID("TEXT" + randomID(5))
            .setFieldType(new TypeListFieldsText());

    // 3. ЦЕЛОЕ (Ссылка на объект == Задача)
    TypesOfTablesField fieldIntLinkObjectTypesTable = new TypesOfTablesField()
            .setFieldName("Целое (Ссылка на объект == Задача) " + randomString(10))
            .setFieldID("INTEGER" + randomID(5))
            .setFieldType(new TypeListFieldsInt()
                    .setObjectLink(true)); // Ссылка на объект


    // Инициализация объекта - Типы таблиц
    TypesOfTables typesOfTables = new TypesOfTables()
            .setTableTypeName(randomString(20)) // Название Типа таблицы
            .setMappingDevice(true)
            .setTypesOfTablesFields(new TypesOfTablesField[]{fieldStringTypesTable, fieldTextTypesTable, fieldIntLinkObjectTypesTable});


    //---------------------------------------------------------------------------------------------------------Инициализация полей и объекта - ТИПЫ ЗАДАЧ

    // 1. СТРОКА (Выбор из списка == Да; Обязательное)
    TasksTypesField fieldStringIsListChoice = new TasksTypesField()
            .setFieldName("Строка (Выбор из списка == Да; Обязательное) " + randomString(5))
            .setFieldID("STRING" + randomID(5))
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(true) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))) // Список значений
            .setObligatory(ObligatoryFieldTypeTask.OBLIGATORY_ON_CREATE) // Обязательное при создании
            .setIsHideInSearch(true);

    // 1.1. СТРОКА (Выбор из списка == Нет; Обязательное при завершении)
    TasksTypesField fieldStringIsNotListChoice = new TasksTypesField()
            .setFieldName("Строка (Выбор из списка == Нет; Обяз. при завершении) " + randomString(5))
            .setFieldID("STRNOTLIST" + randomID(5))
            .setFieldType(new TypeListFieldsString()
                    .setIsListChoice(false) // Выбор из списка
                    .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10))) // Список значений
            .setObligatory(ObligatoryFieldTypeTask.OBLIGATORY_ON_CLOSE); // Обязательное при завершении

    // 2. ТЕКСТ (Скрывать при поиске)
    TasksTypesField fieldText = new TasksTypesField()
            .setFieldName("Текст " + randomString(10))
            .setFieldID("TEXT" + randomID(5))
            .setFieldType(new TypeListFieldsText())
            .setIsHideInSearch(true); // Скрывать при поиске

    // 3. ЦЕЛОЕ
    TasksTypesField fieldInt = new TasksTypesField()
            .setFieldName("Целое " + randomString(10))
            .setFieldID("INTEGER" + randomID(5))
            .setFieldType(new TypeListFieldsInt());

    // 4. ВЕЩЕСТВЕННОЕ
    TasksTypesField fieldFloat = new TasksTypesField()
            .setFieldName("Вещественное " + randomString(10))
            .setFieldID("FLOAT" + randomID(5))
            .setFieldType(new TypeListFieldsDouble());

    // 5. ДАТА
    TasksTypesField fieldDate = new TasksTypesField()
            .setFieldName("Дата " + randomString(10))
            .setFieldID("DATE" + randomID(5))
            .setFieldType(new TypeListFieldsDate());

    // 6. ССЫЛКА НА СПР-К
    TasksTypesField fieldDirectory = new TasksTypesField()
            .setFieldName("Ссылка на справочник " + randomString(10))
            .setFieldID("DIRECTORY" + randomID(5))
            .setFieldType(new TypeListFieldsDirectory()
                    .setDirectory(directory) // Выбираем проинициализированный объект - Справочник
                    .setFieldDirectory(fieldStringIsListChoiceDirectory)  // Выбираем проинициализированный объект - поле Справочника
                    .setDisplayNameTemplate("{STRING}-обычный текст-" + "{" + randomID(5) + "}"));

    // 7. МНОЖЕСТВЕННАЯ ССЫЛКА НА СПР-К
    TasksTypesField fieldMultiDirectory = new TasksTypesField()
            .setFieldName("Множественная ссылка на справочник " + randomString(5))
            .setFieldID("DIRMULTI" + randomID(5))
            .setFieldType(new TypeListFieldsMultiDirectory()
                    .setDirectoryName("Банк")
                    .setNameDirectoryField("Адрес")
                    .setDisplayNameTemplate("{STRING}-обычный текст-" + "{" + randomID(5) + "}"));

    // 8. ЛОГИЧЕСКИЙ
    TasksTypesField fieldBoolean = new TasksTypesField()
            .setFieldName("Логический " + randomString(5))
            .setFieldID("BOOLEAN" + randomID(5))
            .setFieldType(new TypeListFieldsBoolean());

    // 9. ССЫЛКА НА БИБЛИОТЕКУ
    TasksTypesField libraryLink = new TasksTypesField()
            .setFieldName("Ссылка на библиотеку " + randomString(5))
            .setFieldID("LIBLINK" + randomID(5))
            .setFieldType(new TypeListFieldsLibraryLink());

    // 10. ССЫЛКА НА ЗАДАЧУ
    TasksTypesField fieldReferenceToTheTask = new TasksTypesField()
            .setFieldName("Ссылка на задачу " + randomString(5))
            .setFieldID("REFTHETASK" + randomID(5))
            .setFieldType(new TypeListFieldsReferenceTask());

    // 11. НУМЕРАТОР
    TasksTypesField fieldNumerator = new TasksTypesField()
            .setFieldName("Нумератор " + randomString(5))
            .setFieldID("NUMERATOR" + randomID(5))
            .setFieldType(new TypeListFieldsNumerator()
                    .setNumeratorTemplate("{counter}-{STRING}-{DD}.{YYYY} " + randomString(15)) // Шаблон нумератора
                    .setComputeMode(ComputeModeNumerator.WHEN_CREATING_TASK)); // Режим вычисления - При создании задачи

    // 12. ССЫЛКА НА ОБЪЕКТ
    TasksTypesField fieldObjectLink = new TasksTypesField()
            .setFieldName("Ссылка на объект " + randomString(5))
            .setFieldID("OBJECTLINK" + randomID(5))
            .setFieldType(new TypeListFieldsObjectLink());

    // 13. ТАБЛИЦА
    TasksTypesField fieldTable = new TasksTypesField()
            .setFieldName("Таблица " + randomString(5))
            .setFieldID("TABLE" + randomID(5))
            .setFieldType(new TypeListFieldsTable()
                    .setTypesOfTables(typesOfTables)
                    .setFieldTable(fieldStringTypesTable)
                    .setNumeratorTemplate("{STRING}-обычный текст-" + "{" + randomID(5) + "}")); // Шаблон отображения


    // I. Инициализация объекта - Типы задач с настройками
    TasksTypes tasksTypes = new TasksTypes()
            .setTaskTypeName("SТип задачи " + randomString(20))
                    // Направление смещения даты при попадании на нерабочее время
            .setTaskTypeShiftDirection(ShiftDirection.DATE_MOVES_BACK) // Дата сдвигается назад

                    // Корректировка даты
            .setTaskTypeCorrectionMethod(CorrectionMethod.SET_TIME)

            .setIsTaskTypeChangeDisabled(true) // Запретить изменение типа для созданной задачи
            .setOnlyTheSameTypeIWG(true) // Создавать подзадачи ИРГ только родительского типа
            .setIsCloseTaskWithNotReadyCheckpointsDisabled(true) // Запретить закрытие задач с неготовыми контрольными точками
            .setOpenFilesForEdit(OpenFilesForEdit.YES) // Открывать файлы для редактирования
                    // Прикреплять файлы:
            .setIsAttachFilesToActionLine(false) // Лента действий (true - есть сигнал, значит производим клик - снимаем настройку; false - оставляем без изменения)
            .setIsAttachFilesToDecription(false) // Описание

                    // Поля типа
            .setTasksTypesFields(new TasksTypesField[]
                    {fieldStringIsListChoice, fieldStringIsNotListChoice, fieldText, fieldInt,
                            fieldFloat, fieldDate, fieldDirectory, fieldMultiDirectory, fieldBoolean, libraryLink, fieldReferenceToTheTask, fieldNumerator, fieldObjectLink, fieldTable});


    // II. Инициализация объекта - Типы задач с настройками ЭЦП
    TasksTypes tasksTypesUsualSignature = new TasksTypes()
            .setTaskTypeName("S_Тип задачи (\"Использовать ЭЦП\"; Формат == Обычная) " + randomString(20))
            .setUseECP(true); // Использовать ЭЦП


    // Add Create Types Task
    @Test
    public void createTasksTypes() throws Exception {

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
        app.getUsersHelper().logout();

        // Авторизация
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());
        // Добавление объекта - Типы задач
        app.getTaskTypeHelper().beforeAdd();
        app.getTaskTypeHelper().createTypesTask(tasksTypes);
        app.getUsersHelper().logout();
        assertTrue(app.getUsersHelper().isNotLoggedIn());
    }*/
}
