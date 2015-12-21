package ru.st.selenium.test.testWeb;


import org.testng.annotations.Test;
import ru.st.selenium.model.AccessRights;
import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.*;
import ru.st.selenium.model.Document.Document;
import ru.st.selenium.model.Users.Department;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.test.data.BaseObjectTestCase;

import static org.junit.Assert.assertTrue;

public class CreateDocument extends BaseObjectTestCase {



   /* //---------------------------------------------------------------------------------------------------------Инициализация полей и объекта - СПРАВОЧНИКИ

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

    //---------------------------------------------------------------------------------------------------------- Инициализируем объект - Словарь и Элменты словаря

    DictionaryEditorField elementOne = new DictionaryEditorField()
            .setNameDictionItem(randomString(10))
            .setDescriptionDictionItem(randomString(30) + "\n" + randomString(30));

    DictionaryEditorField elementTwo = new DictionaryEditorField()
            .setNameDictionItem(randomString(10))
            .setDescriptionDictionItem(randomString(30) + "\n" + randomString(30));

    *//**
     * Инициализация - Словарь
     *//*
    DictionaryEditor dictionaryEditor = new DictionaryEditor()
            .setDictionaryEditorName("S_Словарь " + randomString(10))
            .setAccessDiction(AccessRights.AVAILABLETOALL)
            .setDictionaryEditorFields(new DictionaryEditorField[]{elementOne, elementTwo});

    //---------------------------------------------------------------------------------------------------------- Инициализируем объект - Подразделеине и Пользователь
    Department department = getRandomDepartment();
    Department department1 = getRandomDepartment();

    Employee employee = getRandomEmployer();
    Employee employee1 = getRandomEmployer();
    Employee employee2 = getRandomEmployer();
    Employee employee3 = getRandomEmployer();

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
                    .setDefaultValue(false) // Значение по умолчанию (true == Текущая дата; false == Нет)
                    .setEditionAvailableWhileCreation(true)) // Изменяемое при создании
            .setEditableField(true);
    *//**
     * 3. СТРОКА (Уникальное == Да)
     *//*
    DocRegisterCardsField fieldString = new DocRegisterCardsField()
            .setFieldNameDoc("Строка (Уникальное) " + randomString(5)) // Имя поля документа
            .setFieldIDDoc("STRING" + randomID(5)) // Идентификатор поля
            .setFieldTypeDoc(new FieldTypeStringDoc()
                    .setSelectOnlyFromDictionary(false) // Выбор только из справочника (true == Да; false == Нет)
                    .setFieldLength(randomInt(999))) // Длина поля
            .setEditableField(true)
            .setUniqueField(true); // Уникальное поле

    *//**
     * 3.1 СТРОКА; Выбор только из спр-ка == Нет
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
            .setFieldIDDoc("DEPARTMENT") // Идентификатор поля
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
                    .setNumeratorTemplateDoc("{STRING}-{counter}-{counter(DEPARTMENT,%04d)}-[8]-{DD}.{YYYY} " + randomString(10))
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
                    .setDirectoryTemplate(randomString(15))
                    .setDirectoryEntriesSelection(false)) // Выбор записей спр-ка; true == Одна запись; false == Несколько записей
            .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)


    //----------------------------------------------------------------------------------------------------------- Инициализация РКД и её настроек
    DocRegisterCards registerCards = getRandomDocRegisterCards()

            .setCheckBoxUseAllPossibleRoutes(true) // Использовать все возможные маршруты

                    // Типы полей документа
            .setDocRegisterCardsFields(new DocRegisterCardsField[]{fieldNumber, fieldDate, fieldString, fieldStringOnlyNoDirectory, fieldText, fieldDictionary,
                    fieldDepartment, fieldEmployee, fieldEmployeeSuperviserAndDefaultValue, fieldEmployeeForInformation, fieldDocument, fieldDocumentSearchRules, fieldNumerator,
                    fieldDirectory, fieldMultiDirectory});


    //----------------------------------------------------------------------------------------------------------- Инициализация Документа
    Document document = new Document()

            .setDocumentType(registerCards) // Тип документа
            .setDateRegistration(randomDateTime()) // Дата регистрации
            .setProject(getRandomProject()) // Инициализируем проект документа

                    // Осуществляем заполнение (наполнение) полей документа через массив
            .setDocumentFields(new DocRegisterCardsField[]{
                            (DocRegisterCardsField) fieldNumber.setValueField(randomInt(9999)),

                            (DocRegisterCardsField) fieldDate.setValueField(randomDateTime()),

                            (DocRegisterCardsField) fieldString.setValueField(randomString(50)),
                            (DocRegisterCardsField) fieldStringOnlyNoDirectory.setValueField(randomString(25)),

                            (DocRegisterCardsField) fieldText.setValueField(randomString(200)),

                            (DocRegisterCardsField) fieldDictionary.setValueDictionaryEditor(elementOne),

                            (DocRegisterCardsField) fieldDepartment.setValueDepartment(new Department[]{department, department1}),

                            (DocRegisterCardsField) fieldEmployee.setValueEmployee(new Employee[]{employee, employee1}),
                            (DocRegisterCardsField) fieldEmployeeForInformation.setValueEmployee(new Employee[]{employee2, employee3})
                    }
            )
            .setRouteScheme("ООА");



    @Test(priority = 1)
    public void CreateDocument() throws Exception {
        //--------------------------------------------------------------Пользователи и Подразделения
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());

        // Создаем подразделения и пользователей
        app.getCreateDepartmentsHelper().beforeAdd();
        app.getCreateDepartmentsHelper().createRootDepartment(department);
        app.getCreateDepartmentsHelper().createRootDepartment(department1);

        app.getUsersHelper().createUser(employee.setDepartment(department));
        app.getUsersHelper().createUser(employee1.setDepartment(department1));
        app.getUsersHelper().createUser(employee2.setDepartment(department1));
        app.getUsersHelper().createUser(employee3.setDepartment(department1));
        app.getUsersHelper().logout();

        //---------------------------------------------------------------------------------Словарь
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());

        // Переход в раздел Администрирование ДО/Редактор словарей
        app.getDictionaryEditorHelper().beforeAdd();
        app.getDictionaryEditorHelper().addDictionaryEditor(dictionaryEditor);
        app.getUsersHelper().logout();

        //---------------------------------------------------------------------------------Справочник
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());
        // Переход в раздел Администрирование/Справочники
        app.getDirectoryHelper().beforeAdd();
        app.getDirectoryHelper().addDirectory(directory);
        // Выход из системы
        app.getUsersHelper().logout();

        //-------------------------------------------------------------------------------------------РКД
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());

        // Переход в раздел Администрирование ДО/Регистрационные карточки документов
        app.getDocRegisterCardsHelper().beforeAdd();

        //----------------------------------------------------------------------------------------Добавление РКД с проинициализированными объектами
        app.getDocRegisterCardsHelper().addDocRegisterCards(registerCards);
        app.getUsersHelper().logout(); // Выход из системы


        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());


        app.getNewDocumentHelper().beforeAdd();
        app.getNewDocumentHelper().createDocument(document);

        // Выход из системы
        app.getUsersHelper().logout();

        // Проверка - пользователь разлогинен
        assertTrue(app.getUsersHelper().isNotLoggedIn());


    }
*/

}
