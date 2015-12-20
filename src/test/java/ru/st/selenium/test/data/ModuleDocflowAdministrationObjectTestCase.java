package ru.st.selenium.test.data;

import org.testng.annotations.DataProvider;
import ru.st.selenium.model.AccessRights;
import ru.st.selenium.model.Administration.Directories.Directories;
import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditor;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditorField;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.*;
import ru.st.selenium.model.Document.Document;
import ru.st.selenium.model.Administration.FieldsObject.TypeListFieldsInt;
import ru.st.selenium.model.Administration.FieldsObject.TypeListFieldsString;
import ru.st.selenium.model.Administration.FieldsObject.TypeListFieldsText;
import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.ShiftDirection;

/**
 * Данные раздела - Администрирование ДО - инициализация
 */
public abstract class ModuleDocflowAdministrationObjectTestCase extends BaseObjectTestCase {


    //---Администрирование/Администрирование ДО----------------------------------------------------------
    //-----Редактор словарей----------------------------------------------------------
    /**
     * Метод создания полностью случайного объекта - "Редактор словарей"
     */
    public DictionaryEditor getRandomDictionaryEditor() {
        DictionaryEditor dictionEditor = new DictionaryEditor("wD_Словарь " + randomString(15), /* Название словаря*/ randomEnum(AccessRights.class) /* Уровень доступа*/,
                (new DictionaryEditorField[]{

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(80) + "\n" + randomString(15)), // Описание элемента словаря

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(15) + "\n" + randomString(50)), // Описание элемента словаря

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(30) + "\n" + randomString(15)), // Описание элемента словаря

                }));

        return dictionEditor;
    }

    //---Администрирование/Администрирование ДО----------------------------------------------------------
    //-----Регистрационные карточки документа----------------------------------------------------------

    /**
     * Параметризация - Инициализируем модель - Документ (со всеми надстройками)
     */
    @DataProvider
    public Object[][] objectDataDocument() {

        /*
         ----------------------------------------------------------------------------------------------------Инициализация полей объекта - Справочник
         */
        /*
         1. СТРОКА (Выбор из списка == Да; Уникальное; Обязательное)
          */
        DirectoryField fieldStringIsListChoiceDirectory = new DirectoryField()
                .setFieldName("Строка (Выбор из списка == Да; Обяз.) " + randomString(10))
                .setFieldID("STRING" + randomIdentifier(5))
                .setObligatory(true) // Обязательное поле
                .setIsUniqueField(true) // Уникальное
                .setFieldType(new TypeListFieldsString()
                        .setIsListChoice(true) // Выбор из списка
                        .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10)));
        /*
         2. ТЕКСТ
          */
        DirectoryField fieldTextDirectory = new DirectoryField()
                .setFieldName("Текст " + randomString(10))
                .setFieldID("TEXT" + randomIdentifier(5))
                .setFieldType(new TypeListFieldsText());

        // Будешь плохо кодить, придет Java и съест твою память

        /*
         3. ЦЕЛОЕ
          */
        DirectoryField fieldIntDirectory = new DirectoryField()
                .setFieldName("Целое " + randomString(10))
                .setFieldID("INTEGER" + randomIdentifier(5))
                .setFieldType(new TypeListFieldsInt());

        /*
         ----------------------------------------------------------------------------------------------------Инициализация объекта - Справочник
         */
        Directories directories = new Directories("S_Справочник " + randomString(10) /* Название справочника*/, true /* Общедоступность записей */,
                true /* Настройка доступа к записям*/, true /* Способ отображения - Линейный ли? true - да; false - иерархический*/,
                true /*true - поиск записей через SOLR; false - поиск записей через БД*/,
                new DirectoryField[]{fieldStringIsListChoiceDirectory, fieldTextDirectory, fieldIntDirectory});

        /*
         ----------------------------------------------------------------------------------------------------Инициализация объекта - Словарь
         */
        DictionaryEditor dictionaryEditor = getRandomDictionaryEditor();


        /*
         ---------------------------------------------------------------------------------------------------------Инициализация полей объекта - Документ
         */
        /*
         1. ЧИСЛО
         */
        DocRegisterCardsField fieldNumber = new DocRegisterCardsField()
                .setFieldNameDoc("Число " + randomString(5)) // Имя поля документа
                .setFieldIdentifierDoc("NUMBER" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeNumberDoc())
                .setEditableField(true) // Обязательное при редактировании (true == Да; false == Нет)
                .setObligatoryFieldDoc(ObligatoryFieldDocument.REQUIRED_WHEN_CREATION); // Обязательное поле == Обязательное при создании

        /*
          2. ДАТА
         */
        DocRegisterCardsField fieldDate = new DocRegisterCardsField()
                .setFieldNameDoc("Дата " + randomString(5)) // Имя поля документа
                .setFieldIdentifierDoc("DATE" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDateDoc()
                        .setDefaultValue(true) // Значение по умолчанию (true == Текущая дата; false == Нет)
                        .setEditionAvailableWhileCreation(true)) // Изменяемое при создании
                .setEditableField(true);

        /*
          3. СТРОКА (Уникальное == Да)
         */
        DocRegisterCardsField fieldString = new DocRegisterCardsField()
                .setFieldNameDoc("Строка (Уникальное) " + randomString(5)) // Имя поля документа
                .setFieldIdentifierDoc("STRING" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeStringDoc()
                        .setFieldLength(randomInt(999))) // Длина поля
                .setEditableField(true)
                .setUniqueField(true); // Уникальное поле

        /*
          3.1 СТРОКА; Выбор только из спр-ка == Да
         */
        DocRegisterCardsField fieldStringOnlyYesDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Строка (Выбор из спр-ка == Да) " + randomString(5)) // Имя поля документа
                .setFieldIdentifierDoc("STONLYESDIR" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeStringDoc()
                        .setSelectOnlyFromDictionary(true) // Выбор только из справочника (true == Да; false == Нет)
                        .setDirectoryName("Номенклатура дел")
                        .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15))
                        .setFieldLength(randomInt(999))) // Длина поля
                .setEditableField(true);

        /*
          3.2 СТРОКА; Выбор только из спр-ка == Нет
         */
        DocRegisterCardsField fieldStringOnlyNoDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Строка (Выбор из спр-ка == Нет) " + randomString(5)) // Имя поля документа
                .setFieldIdentifierDoc("STONLNODIR" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeStringDoc()
                        .setSelectOnlyFromDictionary(false) // Выбор только из справочника (true == Да; false == Нет)
                        .setDirectoryName("Номенклатура дел")
                        .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15))
                        .setFieldLength(randomInt(999))) // Длина поля
                .setEditableField(true);

        /*
          4. ТЕКСТ
         */
        DocRegisterCardsField fieldText = new DocRegisterCardsField()
                .setFieldNameDoc("Текст " + randomString(5))
                .setFieldIdentifierDoc("TEXT" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeTextDoc())
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          4.1. ТЕКСТ; Выбор только из спр-ка == Да
         */
        DocRegisterCardsField fieldTextOnlyYesDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Текст (Выбор из спр-ка == Да) " + randomString(5))
                .setFieldIdentifierDoc("TEXONLYYESDIR" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeTextDoc()
                        .setSelectOnlyFromDictionary(true)
                        .setDirectoryName("Номенклатура дел")
                        .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15)))
                .setEditableField(true) // Обязательное при редактировании (true == Да; false == Нет)
                .setHideInTablesField(true); // Скрывать в таблицах

        /*
          5. СЛОВАРЬ
         */
        DocRegisterCardsField fieldDictionary = new DocRegisterCardsField()
                .setFieldNameDoc("Словарь " + randomString(5))
                .setFieldIdentifierDoc("DICTIONARY" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDictionaryDoc()
                        .setDictionaryEditor(dictionaryEditor)) // Выбор проинициализированный объект - Словарь
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          6. ПОДРАЗДЕЛЕНИЕ
         */
        DocRegisterCardsField fieldDepartment = new DocRegisterCardsField()
                .setFieldNameDoc("Подразделение " + randomString(5))
                .setFieldIdentifierDoc("DEPARTMENT" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDepartmentDoc())
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          7. СОТРУДНИК
         */
        DocRegisterCardsField fieldEmployee = new DocRegisterCardsField()
                .setFieldNameDoc("Сотрудник " + randomString(5))
                .setFieldIdentifierDoc("EMPLOYEE" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeEmployeeDoc())
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          7.1. СОТРУДНИК (Контролер типа == Да; Текущий пользователь == Да)
         */
        DocRegisterCardsField fieldEmployeeSuperviserAndDefaultValue = new DocRegisterCardsField()
                .setFieldNameDoc("Сотрудник (Контролер типа; Текущий пользователь) " + randomString(5))
                .setFieldIdentifierDoc("EMPDEFAULTVALUY" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeEmployeeDoc()
                        .setDefaultValue(true) // Значение по умолчанию == Текущий пользователь
                        .setDocumentSuperviser(true)) // Контролер документа == Да
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          7.2. СОТРУДНИК (Для сведения == Да)
         */
        DocRegisterCardsField fieldEmployeeForInformation = new DocRegisterCardsField()
                .setFieldNameDoc("Сотрудник (Для сведения) " + randomString(5))
                .setFieldIdentifierDoc("EMFORINFORMATION" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeEmployeeDoc()
                        .setForInformation(true)) // Для сведения == Да
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          8. ДОКУМЕНТ
         */
        DocRegisterCardsField fieldDocument = new DocRegisterCardsField()
                .setFieldNameDoc("Документ " + randomString(5))
                .setFieldIdentifierDoc("DOCUMENT" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDocumentDoc()
                        .setDisplayNameTemplate("{" + randomIdentifier(10) + "}; " + "{" + randomIdentifier(10) + "}; " + randomString(10)))
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          8.1. ДОКУМЕНТ (Правила поиска)
         */
        DocRegisterCardsField fieldDocumentSearchRules = new DocRegisterCardsField()
                .setFieldNameDoc("Документ (Правила поиска) " + randomString(5))
                .setFieldIdentifierDoc("DOCSEARCHRUL" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDocumentDoc()
                        .setDisplayNameTemplate("{" + randomIdentifier(10) + "}; " + "{" + randomIdentifier(10) + "}; " + randomString(10))
                        .setSearchSimiliarDocuments(true) // Искать похожие документы
                        .setSearchRules("DOCUMENT_STATE" + "=" + "0;")) // Правила поиска
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          9. НУМЕРАТОР
         */
        DocRegisterCardsField fieldNumerator = new DocRegisterCardsField()
                .setFieldNameDoc("Нумератор " + randomString(5))
                .setFieldIdentifierDoc("NUMERATOR" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeNumeratorDoc()
                        .setNumeratorTemplateDoc("{" + fieldString.getFieldIdentifierDoc() + "}-{counter}-{counter(" + fieldDepartment.getFieldIdentifierDoc() + ",%04d)}-[8]-{DD}.{YYYY} "
                                + randomString(10))
                        .setEditionAvailableWhileCreation(true)) // Изменяемое при создании
                .setObligatoryFieldDoc(ObligatoryFieldDocument.REQUIRED_WHEN_CREATION) // Обязательное поле == Обязательное при создании
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
         10. СПРАВОЧНИК (Одна запись)
         */
        DocRegisterCardsField fieldDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Справочник " + randomString(5))
                .setFieldIdentifierDoc("DIRECTORY" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDirectoryDoc()
                        .setNameDirectoryDoc("Номенклатура дел")
                        .setDirectoryTemplate("{Код дела}, " + "{Наименование раздела} " + randomString(15))
                        .setDirectoryEntriesSelection(true)) // Одна запись
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

    /*
          11. МН. СПРАВОЧНИК (Несколько записей)
     */
        DocRegisterCardsField fieldMultiDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Множественный справочник " + randomString(5))
                .setFieldIdentifierDoc("DIRMULTI" + randomIdentifier(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDirectoryDoc()
                        .setDirectoryDoc(directories) // Задаем проинициализированный спр-к
                        .setDirectoryTemplate("{" + fieldStringIsListChoiceDirectory.getFieldName() + "}" + ";"
                                + "{" + fieldTextDirectory.getFieldName() + "}" + ";" + "{" + fieldIntDirectory.getFieldName() + "}" + "; " + randomString(15))
                        .setDirectoryEntriesSelection(false)) // Выбор записей спр-ка; true == Одна запись; false == Несколько записей
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)*/

        // Инициализация РКД и её настроек
        DocRegisterCards registerCards = new DocRegisterCards("S_Тестовая карточка " + randomString(20))

                // Статус документа
                .setDocumentStatesOnReview("На рассмотрении " + randomString(20)) // - На рассмотрении
                .setDocumentStatesReviewed("Рассмотрен " + randomString(20)) // - Рассмотрен
                .setDocumentStatesOnApproval("На подписании " + randomString(20)) // - На подписании
                .setDocumentStatesOnExecution("На исполнении " + randomString(20)) // - На исполнении
                .setDocumentStatesInArchive("В архиве " + randomString(20)) // - В архиве

                .setDisplayNameTemplate("{" + fieldNumerator.getFieldIdentifierDoc() + "}, " + "{" + fieldString.getFieldIdentifierDoc() + "} "
                        + randomString(15)) // Шаблон отображения

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
                .setAccessToSectionsDocumentRoute(false) // - Маршрут
                .setAccessToSectionsDocumentFiles(false) // - Файлы
                .setAccessToSectionsDocumentResolution(false) // - Резолюции
                .setAccessToSectionsDocumentLog(false) // - Журнал

                .setCreationOfLinkedDocuments(CreationOfLinkedDocuments.USERS_WITH_RIGHT) // Создание связанных документов

                .setCheckBoxUseAllPossibleRoutes(true) // Использовать все возможные маршруты

                // Типы полей документа
                .setDocRegisterCardsFields(new DocRegisterCardsField[]{fieldNumber, fieldDate, fieldString, fieldStringOnlyYesDirectory,
                        fieldStringOnlyNoDirectory, fieldText, fieldTextOnlyYesDirectory, fieldDictionary, fieldDepartment, fieldEmployee,
                        fieldEmployeeSuperviserAndDefaultValue, fieldEmployeeForInformation, fieldDocument, fieldDocumentSearchRules, fieldNumerator, fieldDirectory})

                // Копирование полей при создании задачи
                // TODO доработать инициализацию
                .setCopyingFieldsWhenCreatingATask("TINTEGER=DNUMBER" + ";" + " " + "TTEXT=DTEXT" + ";" + " " + "TDATA=DDATA" + ";" + " " + "DSTRING=TSTRING")

                // TODO доработать инициализацию полей для трансляции пользователей
                // Поля документа, содержащие...:
                .setAuthorsObjectives("AVTOR") // авторов задач
                .setControllersOfTasks("TASKSUPERVISORS") // контролеров задач
                .setDecisionMakersOfTasks("EXECUTIVEMANAGERS") // ответственных руководителей задач
                .setExecutorsOfTasks("PERFORMERS"); // исполнителей задач

        return new Object[][]{

                {
                        //--------------------------------------------------------------------Инициализация объекта - СПРАВОЧНИКИ
                        directories,
                        //--------------------------------------------------------------------Инициализация объекта - СЛОВАРЬ
                        dictionaryEditor,
                        //--------------------------------------------------------------------Инициализация объекта - РКД
                        registerCards
                }
        };

    }

    //---Администрирование/Администрирование ДО----------------------------------------------------------
    //-----Регистрационные карточки документов----------------------------------------------------------

    /**
     * Метод создания полностью случайного объекта - "Регистрационная карточка документа" со всеми, настройками и типами полей
     */
    public DocRegisterCards getRandomDocRegisterCards() {

        DocRegisterCards registerCards = new DocRegisterCards(randomString(80) /* Название регистрационной карточки */)

                // Статус документа
                .setDocumentStatesOnReview(randomString(50)) // - На рассмотрении
                .setDocumentStatesReviewed(randomString(50)) // - Рассмотрен
                .setDocumentStatesOnApproval(randomString(50)) // - На подписании
                .setDocumentStatesOnExecution(randomString(50)) // - На исполнении
                .setDocumentStatesInArchive(randomString(50)) // - В архиве
                // Шаблон отображения
                .setDisplayNameTemplate("{" + randomIdentifier(5) + "}-" + " " + "{" + randomIdentifier(5) + "}" + " " + randomString(20))
                .setDocRegisterCardsShiftDirection(randomEnum(ShiftDirection.class)) // Направление смещения при попадании на нерабочее время
                // Настройки по умолчанию при отправке документа на доработку:
                .setAtFirstRevisionScheme(randomBoolean()) // Возврат на доработку с начала текущей схемы
                .setForCompletionInTighterPoint(randomBoolean()) // Возврат на доработку в ту же точку рассмотрения
                .setOnCompletionTheNewScheme(randomBoolean()) // Возврат на доработку с новой схемой
                .setOpenFilesForEditDoc(randomEnum(OpenFilesForEdit.class)) // Открывать файлы для редактирования
                .setAutoСalculationNumeratorFields(randomEnum(OpenFilesForEdit.class)) // Автоматическое вычисление полей-нумераторов
                .setAccessDoc(randomEnum(AccessRights.class)) // Доступ

                // Изменение признака "Окончательная версия"
                .setDocAuthorFinalVersionFiles(randomEnum(SettingsFinalVersion.class)) // Автор документа
                .setUserWithEditRightFinalVersionFiles(randomEnum(SettingsFinalVersion.class)) // Пользователь с правами редактирования
                .setDocTypeControllerFinalVersionFiles(randomEnum(SettingsFinalVersion.class)) // Контролер типа документа

                // Редактирование своих документов
                .setEditionOwnDocumentsOnReview(randomEnum(EditionOwnDocuments.class)) // - На рассмотрении
                .setEditionOwnDocumentsOnExecution(randomEnum(EditionOwnDocuments.class)) // - На исполнении
                .setEditionOwnDocumentsInArchive(randomEnum(EditionOwnDocuments.class)) // - В архиве

                // Доступ к разделам документа при просмотре/редактировании
                .setAccessToSectionsDocumentRoute(randomBoolean()) // - Маршрут
                .setAccessToSectionsDocumentFiles(randomBoolean()) // - Файлы
                .setAccessToSectionsDocumentResolution(randomBoolean()) // - Резолюции
                .setAccessToSectionsDocumentLog(randomBoolean()) // - Журнал

                // Создание связанных документов
                .setCreationOfLinkedDocuments(randomEnum(CreationOfLinkedDocuments.class))

                .setCheckBoxUseAllPossibleRoutes(randomBoolean()) // Использовать все возможные маршруты

                .setDocRegisterCardsFields(new DocRegisterCardsField[]{

                        // 1. Тип поля "ЧИСЛО"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10)) // Имя поля документа
                                .setFieldIdentifierDoc(randomIdentifier(10)) // Идентификатор поля
                                .setFieldTypeDoc(new FieldTypeNumberDoc())
                                .setEditableField(randomBoolean())  // Редактирование поля документа
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))  // Обязательность поля
                                .setUniqueField(randomBoolean()) // Уникальность поля
                                .setHideForCreationField(randomBoolean()) // Скрывать при создании
                                .setHideInTablesField(randomBoolean()) // Скрывать в таблицах
                                .setHideForSearchField(randomBoolean()) // Скрывать при поиске
                                .setHideInСardField(randomBoolean()) // Скрывать в карточке
                                .setUsedToCreateTheLinkedDocument(randomBoolean()), // Использовать при создании связанного документа

                        // 2. Тип поля "ДАТА"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeDateDoc()
                                        .setDefaultValue(randomBoolean()) // Значение по умолчанию
                                        .setEditionAvailableWhileCreation(randomBoolean())) // Изменяемое при создании
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 3. Тип поля "СТРОКА"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeStringDoc()
                                        .setDirectoryForFieldString(getRandomDirectory()) // Спр-к для поля типа Строка
                                        .setDirectoryTemplate(randomString(15)) // Шаблон справочника
                                        .setSelectOnlyFromDictionary(randomBoolean()) // Выбор только из справочника; true == Нет; false == Да
                                        .setFieldLength(randomInt(999))) // Длина поля
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 4. Тип поля "ТЕКСТ"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeTextDoc()
                                        .setDirectoryForFieldText(getRandomDirectory()) // Справочник
                                        .setDirectoryTemplate(randomString(15)) // Шаблон справочника
                                        .setSelectOnlyFromDictionary(randomBoolean())) // Выбор только из справочника - true == Да; false == Нет
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 5. Тип поля "СЛОВАРЬ"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeDictionaryDoc() // Тип поля "Словарь"
                                        .setDictionaryEditor(getRandomDictionaryEditor()))
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 6. Тип поля "ПОДРАЗДЕЛЕНИЕ"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeDepartmentDoc()) // Тип поля "Подразделение"
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 7. Тип поля "СОТРУДНИК"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeEmployeeDoc() // Тип поля "Сотрудник"
                                        .setDefaultValue(randomBoolean()) // Значение по умолчанию
                                        .setEditionAvailableWhileCreation(randomBoolean()) // Изменяемое при создании
                                        .setDocumentSuperviser(randomBoolean()) // Контролер документа
                                        .setForInformation(randomBoolean())) // Для сведения
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 8. Тип поля "ДОКУМЕНТ"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeDocumentDoc() // Тип поля "Документ"
                                        .setDisplayNameTemplate("{" + randomIdentifier(10) + "}; " + "{" + randomIdentifier(15) + "}; "
                                                + randomString(10)) // Шаблон отображения
                                        .setSearchSimiliarDocuments(randomBoolean())
                                        .setSearchRules("{" + randomIdentifier(5) + "}" + "=" + "{" + randomIdentifier(5) + "};"))
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 9. Тип поля "НУМЕРАТОР"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeNumeratorDoc() // Тип поля "Нумератор"
                                        .setNumeratorTemplateDoc("{counter}-" + "{DD}." + "{YYYY}" + " " + randomString(20)) // Шаблон нумератора
                                        .setEditionAvailableWhileCreation(randomBoolean())) // Изменяемое при создании
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),

                        // 10. Тип поля "СПРАВОЧНИК"
                        new DocRegisterCardsField()
                                .setFieldNameDoc(randomString(10))
                                .setFieldIdentifierDoc(randomIdentifier(10))
                                .setFieldTypeDoc(new FieldTypeDirectoryDoc() // Тип поля "Справочник"
                                        .setDirectoryDoc(getRandomDirectory())
                                        .setDirectoryEntriesSelection(randomBoolean())) // Определение мн. или ед. выбора записей спр-ка
                                .setEditableField(randomBoolean())
                                .setObligatoryFieldDoc(randomEnum(ObligatoryFieldDocument.class))
                                .setUniqueField(randomBoolean())
                                .setHideForCreationField(randomBoolean())
                                .setHideInTablesField(randomBoolean())
                                .setHideForSearchField(randomBoolean())
                                .setHideInСardField(randomBoolean())
                                .setUsedToCreateTheLinkedDocument(randomBoolean()),


                })

                .setCopyingFieldsWhenCreatingATask("" + randomIdentifier(5) + "=" + "" + randomIdentifier(5) + ";" +
                        "" + randomIdentifier(5) + "=" + "" + randomIdentifier(5) + ";") // Копирование полей при создании задачи

                // Поля документа, содержащие...:
                .setAuthorsObjectives(randomIdentifier(10)) // авторов задач
                .setControllersOfTasks(randomIdentifier(10)) // контролеров задач
                .setDecisionMakersOfTasks(randomIdentifier(10)) // ответственных руководителей задач
                .setExecutorsOfTasks(randomIdentifier(10)); // исполнителей задач


        return registerCards;


    }




    //---Документы/Создать документ----------------------------------------------------------

    /**
     * Метод создания полностью случайного объекта - "Документ"
     */
    public Document getRandomDocument() {
        Document document = new Document()
                .setNameDocumentType("Внутренний документ")
                .setProject(getRandomProject());

        return document;

    }

}
