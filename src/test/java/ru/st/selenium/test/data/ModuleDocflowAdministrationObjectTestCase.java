package ru.st.selenium.test.data;

import org.testng.annotations.DataProvider;
import ru.st.selenium.model.AccessRights;
import ru.st.selenium.model.Directories.Directories;
import ru.st.selenium.model.Directories.DirectoryField;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditor;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditorField;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.*;
import ru.st.selenium.model.FieldsObject.TypeListFieldsInt;
import ru.st.selenium.model.FieldsObject.TypeListFieldsString;
import ru.st.selenium.model.FieldsObject.TypeListFieldsText;
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
        DictionaryEditor dictionEditor = new DictionaryEditor()
                .setDictionaryEditorName(randomString(15)) // Название Словаря
                .setAccessDiction(randomEnum(AccessRights.class))// Уровень доступа
                .setDictionaryEditorFields(new DictionaryEditorField[]{

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(80) + "\n" + randomString(15)), // Описание элемента словаря

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(15) + "\n" + randomString(50)), // Описание элемента словаря

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(30) + "\n" + randomString(15)), // Описание элемента словаря

                });

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
                .setFieldID("STRING" + randomID(5))
                .setObligatory(true) // Обязательное поле
                .setIsUniqueField(true) // Уникальное
                .setTaskTypeField(new TypeListFieldsString()
                        .setIsListChoice(true) // Выбор из списка
                        .setValuesList(randomString(10) + "\n" + randomString(10) + "\n" + randomString(10)));
        /*
         2. ТЕКСТ
          */
        DirectoryField fieldTextDirectory = new DirectoryField()
                .setFieldName("Текст " + randomString(10))
                .setFieldID("TEXT" + randomID(5))
                .setTaskTypeField(new TypeListFieldsText());

        /*
         3. ЦЕЛОЕ
          */
        DirectoryField fieldIntDirectory = new DirectoryField()
                .setFieldName("Целое " + randomString(10))
                .setFieldID("INTEGER" + randomID(5))
                .setTaskTypeField(new TypeListFieldsInt());

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
                .setFieldIDDoc("NUMBER" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeNumberDoc())
                .setEditableField(true) // Обязательное при редактировании (true == Да; false == Нет)
                .setObligatoryFieldDoc(ObligatoryFieldDocument.REQUIRED_WHEN_CREATION); // Обязательное поле == Обязательное при создании

        /*
          2. ДАТА
         */
        DocRegisterCardsField fieldDate = new DocRegisterCardsField()
                .setFieldNameDoc("Дата " + randomString(5)) // Имя поля документа
                .setFieldIDDoc("DATE" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDateDoc()
                        .setDefaultValue(true) // Значение по умолчанию (true == Текущая дата; false == Нет)
                        .setEditionAvailableWhileCreation(true)) // Изменяемое при создании
                .setEditableField(true);

        /*
          3. СТРОКА (Уникальное == Да)
         */
        DocRegisterCardsField fieldString = new DocRegisterCardsField()
                .setFieldNameDoc("Строка (Уникальное) " + randomString(5)) // Имя поля документа
                .setFieldIDDoc("STRING" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeStringDoc()
                        .setFieldLength(randomInt(999))) // Длина поля
                .setEditableField(true)
                .setUniqueField(true); // Уникальное поле

        /*
          3.1 СТРОКА; Выбор только из спр-ка == Да
         */
        DocRegisterCardsField fieldStringOnlyYesDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Строка (Выбор из спр-ка == Да) " + randomString(5)) // Имя поля документа
                .setFieldIDDoc("STONLYESDIR" + randomID(5)) // Идентификатор поля
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
                .setFieldIDDoc("STONLNODIR" + randomID(5)) // Идентификатор поля
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
                .setFieldIDDoc("TEXT" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeTextDoc())
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          4.1. ТЕКСТ; Выбор только из спр-ка == Да
         */
        DocRegisterCardsField fieldTextOnlyYesDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Текст (Выбор из спр-ка == Да) " + randomString(5))
                .setFieldIDDoc("TEXONLYYESDIR" + randomID(5)) // Идентификатор поля
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
                .setFieldIDDoc("DICTIONARY" + randomID(5)) // Идентификатор поля
                    .setFieldTypeDoc(new FieldTypeDictionaryDoc()
                           .setDictionaryEditor(dictionaryEditor)) // Выбор проинициализированный объект - Словарь
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /**
         * 6. ПОДРАЗДЕЛЕНИЕ
         */
        DocRegisterCardsField fieldDepartment = new DocRegisterCardsField()
                .setFieldNameDoc("Подразделение " + randomString(5))
                .setFieldIDDoc("DEPARTMENT" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDepartmentDoc())
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          7. СОТРУДНИК
         */
        DocRegisterCardsField fieldEmployee = new DocRegisterCardsField()
                .setFieldNameDoc("Сотрудник " + randomString(5))
                .setFieldIDDoc("EMPLOYEE" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeEmployeeDoc())
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          7.1. СОТРУДНИК (Контролер типа == Да; Текущий пользователь == Да)
         */
        DocRegisterCardsField fieldEmployeeSuperviserAndDefaultValue = new DocRegisterCardsField()
                .setFieldNameDoc("Сотрудник (Контролер типа; Текущий пользователь) " + randomString(5))
                .setFieldIDDoc("EMPDEFAULTVALUY" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeEmployeeDoc()
                        .setDefaultValue(true) // Значение по умолчанию == Текущий пользователь
                        .setDocumentSuperviser(true)) // Контролер документа == Да
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          7.2. СОТРУДНИК (Для сведения == Да)
         */
        DocRegisterCardsField fieldEmployeeForInformation = new DocRegisterCardsField()
                .setFieldNameDoc("Сотрудник (Для сведения) " + randomString(5))
                .setFieldIDDoc("EMFORINFORMATION" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeEmployeeDoc()
                        .setForInformation(true)) // Для сведения == Да
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          8. ДОКУМЕНТ
         */
        DocRegisterCardsField fieldDocument = new DocRegisterCardsField()
                .setFieldNameDoc("Документ " + randomString(5))
                .setFieldIDDoc("DOCUMENT" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDocumentDoc()
                        .setDisplayNameTemplate("{" + randomID(10) + "}; " + "{" + randomID(10) + "}; " + randomString(10)))
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          8.1. ДОКУМЕНТ (Правила поиска)
         */
        DocRegisterCardsField fieldDocumentSearchRules = new DocRegisterCardsField()
                .setFieldNameDoc("Документ (Правила поиска) " + randomString(5))
                .setFieldIDDoc("DOCSEARCHRUL" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeDocumentDoc()
                        .setDisplayNameTemplate("{" + randomID(10) + "}; " + "{" + randomID(10) + "}; " + randomString(10))
                        .setSearchSimiliarDocuments(true) // Искать похожие документы
                        .setSearchRules("DOCUMENT_STATE" + "=" + "0;")) // Правила поиска
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
          9. НУМЕРАТОР
         */
        DocRegisterCardsField fieldNumerator = new DocRegisterCardsField()
                .setFieldNameDoc("Нумератор " + randomString(5))
                .setFieldIDDoc("NUMERATOR" + randomID(5)) // Идентификатор поля
                .setFieldTypeDoc(new FieldTypeNumeratorDoc()
                        .setNumeratorTemplateDoc("{STRINGTLVSC}-{counter}-{counter(DEPARTMENT,%04d)}-[8]-{DD}.{YYYY} " + randomString(10))
                        .setEditionAvailableWhileCreation(true)) // Изменяемое при создании
                .setObligatoryFieldDoc(ObligatoryFieldDocument.REQUIRED_WHEN_CREATION) // Обязательное поле == Обязательное при создании
                .setEditableField(true); // Обязательное при редактировании (true == Да; false == Нет)

        /*
         10. СПРАВОЧНИК (Одна запись)
         */
        DocRegisterCardsField fieldDirectory = new DocRegisterCardsField()
                .setFieldNameDoc("Справочник " + randomString(5))
                .setFieldIDDoc("DIRECTORY" + randomID(5)) // Идентификатор поля
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
                .setFieldIDDoc("DIRMULTI" + randomID(5)) // Идентификатор поля
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

                .setDisplayNameTemplate("{NUMBER}, " + "{STRINGTLVSC} " + randomString(15)) // Шаблон отображения

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
                        fieldEmployeeSuperviserAndDefaultValue, fieldEmployeeForInformation, fieldDocument, fieldDocumentSearchRules, fieldNumerator, fieldDirectory})

                // Копирование полей при создании задачи
                .setCopyingFieldsWhenCreatingATask("TINTEGER=DNUMBER" + ";" + " " + "TTEXT=DTEXT" + ";" + " " + "TDATA=DDATA" + ";" + " " + "DSTRING=TSTRING")

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


}
