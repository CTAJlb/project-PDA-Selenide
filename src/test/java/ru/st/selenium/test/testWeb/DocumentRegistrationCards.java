package ru.st.selenium.test.testWeb;

import org.testng.annotations.Test;
import ru.st.selenium.model.AccessRights;
import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.*;

import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.ShiftDirection;
import ru.st.selenium.test.data.BaseObjectTestCase;


import static org.junit.Assert.assertTrue;

public class DocumentRegistrationCards extends BaseObjectTestCase {



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

    //---------------------------------------------------------------------------------------------------------Инициализация объекта - СЛОВАРЬ

    DictionaryEditor dictionaryEditor = getRandomDictionaryEditor();

    //--------------------------------------------------------------------------------------------------------- Инициализация ПОЛЕЙ документа

    *//**
     * 1. ЧИСЛО
     *//*
    DocRegisterCardsField fieldNumber = new DocRegisterCardsField()
            .setFieldNameDoc("Число " + randomString(5)) // Имя поля документа
            .setFieldIDDoc("NUMBER" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeNumberDoc())
            .setEditableField(true) // Обязательное при редактировании (true == Да; false == Нет)
            .setObligatoryFieldDoc(ObligatoryFieldDocument.REQUIRED_WHEN_CREATION); // Обязательное поле == Обязательное при создании

    *//**
     * 2. ДАТА
     *//*
    DocRegisterCardsField fieldDate = new DocRegisterCardsField()
            .setFieldNameDoc("Дата " + randomString(5)) // Имя поля документа
            .setFieldIDDoc("DATE" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeDateDoc()
                    .setDefaultValue(true) // Значение по умолчанию (true == Текущая дата; false == Нет)
                    .setEditionAvailableWhileCreation(true)) // Изменяемое при создании
            .setEditableField(true);

    *//**
     * 3. СТРОКА (Уникальное == Да)
     *//*
    DocRegisterCardsField fieldString = new DocRegisterCardsField()
            .setFieldNameDoc("Строка (Уникальное) " + randomString(5)) // Имя поля документа
            .setFieldIDDoc("STRING" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeStringDoc()
                    .setFieldLength(randomInt(999))) // Длина поля
            .setEditableField(true)
            .setUniqueField(true); // Уникальное поле

    *//**
     * 3.1 СТРОКА; Выбор только из спр-ка == Да
     *//*
    DocRegisterCardsField fieldStringOnlyYesDirectory = new DocRegisterCardsField()
            .setFieldNameDoc("Строка (Выбор из спр-ка == Да) " + randomString(5)) // Имя поля документа
            .setFieldIDDoc("STONLYESDIR" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeStringDoc()
                    .setSelectOnlyFromDictionary(true) // Выбор только из справочника (true == Да; false == Нет)
                    .setDirectoryName("Номенклатура дел")
                    .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15))
                    .setFieldLength(randomInt(999))) // Длина поля
            .setEditableField(true);

    *//**
     * 3.2 СТРОКА; Выбор только из спр-ка == Нет
     *//*
    DocRegisterCardsField fieldStringOnlyNoDirectory = new DocRegisterCardsField()
            .setFieldNameDoc("Строка (Выбор из спр-ка == Нет) " + randomString(5)) // Имя поля документа
            .setFieldIDDoc("STONLNODIR" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeStringDoc()
                    .setSelectOnlyFromDictionary(false) // Выбор только из справочника (true == Да; false == Нет)
                    .setDirectoryName("Номенклатура дел")
                    .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15))
                    .setFieldLength(randomInt(999))) // Длина поля
            .setEditableField(true);

    *//**
     * 4. ТЕКСТ
     *//*
    DocRegisterCardsField fieldText = new DocRegisterCardsField()
            .setFieldNameDoc("Текст " + randomString(5))
            .setFieldIDDoc("TEXT" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeTextDoc())
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 4.1. ТЕКСТ; Выбор только из спр-ка == Да
     *//*
    DocRegisterCardsField fieldTextOnlyYesDirectory = new DocRegisterCardsField()
            .setFieldNameDoc("Текст (Выбор из спр-ка == Да) " + randomString(5))
            .setFieldIDDoc("TEXONLYYESDIR" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeTextDoc()
                    .setSelectOnlyFromDictionary(true)
                    .setDirectoryName("Номенклатура дел")
                    .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15)))
            .setEditableField(true) // Обязательное при редактировании (true == Да; false == Нет)
            .setHideInTablesField(true); // Скрывать в таблицах

    *//**
     * 5. СЛОВАРЬ
     *//*
    DocRegisterCardsField fieldDictionary = new DocRegisterCardsField()
            .setFieldNameDoc("Словарь " + randomString(5))
            .setFieldIDDoc("DICTIONARY" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeDictionaryDoc()
                    .setDictionaryEditor(dictionaryEditor)) // Выбор проинициализированный объект - Словарь
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 6. ПОДРАЗДЕЛЕНИЕ
     *//*
    DocRegisterCardsField fieldDepartment = new DocRegisterCardsField()
            .setFieldNameDoc("Подразделение " + randomString(5))
            .setFieldIDDoc("DEPARTMENT" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeDepartmentDoc())
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 7. СОТРУДНИК
     *//*
    DocRegisterCardsField fieldEmployee = new DocRegisterCardsField()
            .setFieldNameDoc("Сотрудник " + randomString(5))
            .setFieldIDDoc("EMPLOYEE" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeEmployeeDoc())
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 7.1. СОТРУДНИК (Контролер типа == Да; Текущий пользователь == Да)
     *//*
    DocRegisterCardsField fieldEmployeeSuperviserAndDefaultValue = new DocRegisterCardsField()
            .setFieldNameDoc("Сотрудник (Контролер типа; Текущий пользователь) " + randomString(5))
            .setFieldIDDoc("EMPDEFAULTVALUY" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeEmployeeDoc()
                    .setDefaultValue(true) // Значение по умолчанию == Текущий пользователь
                    .setDocumentSuperviser(true)) // Контролер документа == Да
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 7.2. СОТРУДНИК (Для сведения == Да)
     *//*
    DocRegisterCardsField fieldEmployeeForInformation = new DocRegisterCardsField()
            .setFieldNameDoc("Сотрудник (Для сведения) " + randomString(5))
            .setFieldIDDoc("EMFORINFORMATION" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeEmployeeDoc()
                    .setForInformation(true)) // Для сведения == Да
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 8. ДОКУМЕНТ
     *//*
    DocRegisterCardsField fieldDocument = new DocRegisterCardsField()
            .setFieldNameDoc("Документ " + randomString(5))
            .setFieldIDDoc("DOCUMENT" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeDocumentDoc()
                    .setDisplayNameTemplate("{" + randomID(10) + "}; " + "{" + randomID(10) + "}; " + randomString(10)))
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 8.1. ДОКУМЕНТ (Правила поиска)
     *//*
    DocRegisterCardsField fieldDocumentSearchRules = new DocRegisterCardsField()
            .setFieldNameDoc("Документ (Правила поиска) " + randomString(5))
            .setFieldIDDoc("DOCSEARCHRUL" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeDocumentDoc()
                    .setDisplayNameTemplate("{" + randomID(10) + "}; " + "{" + randomID(10) + "}; " + randomString(10))
                    .setSearchSimiliarDocuments(true) // Искать похожие документы
                    .setSearchRules("DOCUMENT_STATE" + "=" + "0;")) // Правила поиска
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 9. НУМЕРАТОР
     *//*
    DocRegisterCardsField fieldNumerator = new DocRegisterCardsField()
            .setFieldNameDoc("Нумератор " + randomString(5))
            .setFieldIDDoc("NUMERATOR" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeNumeratorDoc()
                    .setNumeratorTemplateDoc("{STRINGTLVSC}-{counter}-{counter(DEPARTMENT,%04d)}-[8]-{DD}.{YYYY} " + randomString(10))
                    .setEditionAvailableWhileCreation(true)) // Изменяемое при создании
            .setObligatoryFieldDoc(ObligatoryFieldDocument.REQUIRED_WHEN_CREATION) // Обязательное поле == Обязательное при создании
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 10. СПРАВОЧНИК (Одна запись)
     *//*
    DocRegisterCardsField fieldDirectory = new DocRegisterCardsField()
            .setFieldNameDoc("Справочник " + randomString(5))
            .setFieldIDDoc("DIRECTORY" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeDirectoryDoc()
                    .setNameDirectoryDoc("Номенклатура дел")
                    .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15))
                    .setDirectoryEntriesSelection(true)) // Одна запись
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    *//**
     * 11. МН. СПРАВОЧНИК (Несколько записей)
     *//*
    DocRegisterCardsField fieldMultiDirectory = new DocRegisterCardsField()
            .setFieldNameDoc("Множественный справочник " + randomString(5))
            .setFieldIDDoc("DIRMULTI" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeDirectoryDoc()
                    .setDirectoryDoc(directory) // Задаем проинициализированный спр-к
                    .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15))
                    .setDirectoryEntriesSelection(false)) // Выбор записей спр-ка; true == Одна запись; false == Несколько записей
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)


    // Инициализация РКД и её настроек
    ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.DocRegisterCards registerCards = new ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.DocRegisterCards()

            .setDocRegisterCardsName("S_Тестовая карточка " + randomString(20))

                    // Статус документа
            .setDocumentStatesOnReview("На рассмотрении " + randomString(20)) // - На рассмотрении
            .setDocumentStatesReviewed("Рассмотрен " + randomString(20)) // - Рассмотрен
            .setDocumentStatesOnApproval("На подписании " + randomString(20)) // - На подписании
            .setDocumentStatesOnExecution("На исполнении " + randomString(20)) // - На исполнении
            .setDocumentStatesInArchive("В архиве " + randomString(20)) // - В архиве

            .setDisplayNameTemplate("{NUMBER}, " + "{STRINGTLVSC} " + randomString(15))

                    // Направление смещения при попадании на нерабочее время
            .setDocRegisterCardsShiftDirection(ShiftDirection.DATE_MOVES_FORWARD) // Дата сдвигается назад

                    // Настройки по умолчанию при отправке документа на доработку:
            .setAtFirstRevisionScheme(false) // Возврат на доработку с начала текущей схемы
            .setForCompletionInTighterPoint(false) // Возврат на доработку в ту же точку рассмотрения
            .setOnCompletionTheNewScheme(true) // Возврат на доработку с новой схемой

            .setOpenFilesForEditDoc(OpenFilesForEdit.YES) // Открывать файлы для редактирования

            .setAutoСalculationNumeratorFields(OpenFilesForEdit.YES) // Автоматическое вычисление полей-нумераторов

            .setAccessDoc(AccessRights.AVAILABLETOALL) // выбираем права Доступа к РКД

                    // Изменение признака "Окончательная версия"
            .setDocAuthorFinalVersionFiles(SettingsFinalVersion.NO) // Автор документа
            .setUserWithEditRightFinalVersionFiles(SettingsFinalVersion.NULL) // Пользователь с правами редактирования
            .setDocTypeControllerFinalVersionFiles(SettingsFinalVersion.NO) // Контролер типа документа

                    // Редактирование своих документов
            .setEditionOwnDocumentsOnReview(EditionOwnDocuments.USER_RIGHT_EDIT_THEIR_DOCUMENTS) //  - На рассмотрении
            .setEditionOwnDocumentsOnExecution(EditionOwnDocuments.YES) // - На исполнении
            .setEditionOwnDocumentsInArchive(EditionOwnDocuments.NO) // - В архиве

                    // Доступ к разделам документа при просмотре/редактировании
            .setAccessToSectionsDocumentRoute(true) // - Маршрут
            .setAccessToSectionsDocumentFiles(false) // - Файлы
            .setAccessToSectionsDocumentResolution(true) // - Резолюции
            .setAccessToSectionsDocumentLog(false) // - Журнал

            .setCreationOfLinkedDocuments(CreationOfLinkedDocuments.USERS_WITH_RIGHT) // Создание связанных документов

            .setCheckBoxUseAllPossibleRoutes(true) // Использовать все возможные маршруты

                    // Типы полей документа
            .setDocRegisterCardsFields(new DocRegisterCardsField[]{fieldNumber, fieldDate, fieldString, fieldStringOnlyYesDirectory,
                    fieldStringOnlyNoDirectory, fieldText, fieldTextOnlyYesDirectory, fieldDictionary, fieldDepartment, fieldEmployee,
                    fieldEmployeeSuperviserAndDefaultValue, fieldEmployeeForInformation, fieldDocument, fieldDocumentSearchRules, fieldNumerator, fieldDirectory, fieldMultiDirectory})

                    // Копирование полей при создании задачи
            .setCopyingFieldsWhenCreatingATask("TINTEGER=DNUMBER" + ";" + " " + "TTEXT=DTEXT" + ";" + " " + "TDATA=DDATA" + ";" + " " + "DSTRING=TSTRING")

                    // Поля документа, содержащие...:
            .setAuthorsObjectives("AVTOR") // авторов задач
            .setControllersOfTasks("TASKSUPERVISORS") // контролеров задач
            .setDecisionMakersOfTasks("EXECUTIVEMANAGERS") // ответственных руководителей задач
            .setExecutorsOfTasks("PERFORMERS"); // исполнителей задач


    // Создание РКД с проинициализированными объектами
    @Test
    public void createRegCardDocumentAllFields() throws Exception {

        // Авторизация
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());
        // Переход в раздел Администрирование/Справочники
        app.getDirectoryHelper().beforeAdd();
        app.getDirectoryHelper().addDirectory(directory);
        // Выход из системы
        app.getUsersHelper().logout();

        // Авторизация в Систему
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());
        // Переход в раздел Администрирование ДО/Редактор словарей
        app.getDictionaryEditorHelper().beforeAdd();
        app.getDictionaryEditorHelper().addDictionaryEditor(dictionaryEditor);
        app.getUsersHelper().logout();

        // Авторизация в Систему
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());

        // Переход в раздел Администрирование ДО/Регистрационные карточки документов
        app.getDocRegisterCardsHelper().beforeAdd();

        // Добавление РКД с проинициализированными объектами
        app.getDocRegisterCardsHelper().addDocRegisterCards(registerCards);

        // Выход из системы
        app.getUsersHelper().logout();

        // Проверка - пользователь разлогинен
        assertTrue(app.getUsersHelper().isNotLoggedIn());
    }

    */
}