/**
 * класс описывающий элементы формы редактирования полей документы (все Типы полей)
 */
package ru.st.selenium.pagesweb.DocflowAdministration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards.DocRegisterCardsField;
import ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards.*;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class DocRegisterCardsEditFieldsPage extends DocRegisterCardsEditPage {



    //--------------------------------------------------------------Вкладка - ПОЛЯ-------------------------------------------------------

    /**
     * Вкладка - Поля
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[4]//span")
    private SelenideElement fieldsTab;

    /**
     * Добавить поле
     */
    @FindBy(xpath = "//div[count(a)=5]/a[1]//span")
    private SelenideElement addFieldDoc;

    /**
     * Редактировать поле
     */
    @FindBy(xpath = "//div[count(a)=5]/a[2]//span")
    private SelenideElement editFieldDoc;

    /**
     * Удалить поле
     */
    @FindBy(xpath = "//div[count(a)=5]/a[3]//span")
    private SelenideElement delFieldDoc;

    /**
     * Переместить поле вврех
     */
    @FindBy(xpath = "//div[count(a)=5]/a[4]//span")
    private SelenideElement moveFieldUp;

    /**
     * Переместить поле вниз
     */
    @FindBy(xpath = "//div[count(a)=5]/a[5]//span")
    private SelenideElement moveFieldDown;

    /**
     * Сохранить как - изменения по документу
     */
    @FindBy(xpath = "(//a[contains(@id,'button')][ancestor::div[contains(@id,'toolbar') and contains(@class,'x-toolbar x-docked x-toolbar-default')]]//span[string-length(text())>=3])[2]")
    private SelenideElement clickSaveAsAllChangesInDocument;

    /**
     * Удалить документ
     */
    @FindBy(xpath = "(//a[contains(@id,'button')][ancestor::div[contains(@id,'toolbar') and contains(@class,'x-toolbar x-docked x-toolbar-default')]]//span[string-length(text())>=3])[3]")
    private SelenideElement clickDelDocument;

    /**
     * Вернуться без сохранения
     */
    @FindBy(xpath = "(//a[contains(@id,'button')][ancestor::div[contains(@id,'toolbar') and contains(@class,'x-toolbar x-docked x-toolbar-default')]]//span[string-length(text())>=3])[4]")
    private SelenideElement clickBackAndDiscardChanges;

    //----------------------------------------------------------------------------Настройки в форме редактирования полей-------------------------------------------------

    /**
     * Название поля
     */
    @FindBy(xpath = "//input[@name='fieldname']")
    private SelenideElement nameFieldDoc;

    /**
     * Идентификатор поля
     */
    @FindBy(xpath = "//input[@name='fieldid']")
    private SelenideElement idFieldDoc;

    /**
     * выбор поля - Тип поля
     */
    @FindBy(xpath = "//input[@name='fieldtype']")
    private SelenideElement clickFieldTypeField;

    /**
     * Формат типа поля - Числа
     */
    @FindBy(xpath = "//input[@name='id_format']")
    private SelenideElement formatFieldNumber;

    /**
     * Изменяемое при редактировании
     */
    @FindBy(xpath = "//input[@name='isedited']")
    private SelenideElement editableField;

    /**
     * Обязательное поле
     */
    @FindBy(xpath = "//input[@name='isnecessary']")
    private SelenideElement selObligatoryField;

    /**
     * Уникальное поле
     */
    @FindBy(xpath = "//input[@name='isunique']")
    private SelenideElement uniqueField;

    /**
     * Скрывать при создании
     */
    @FindBy(xpath = "//input[@name='ishideincreate']")
    private SelenideElement hideForCreation;

    /**
     * Скрывать в таблицах
     */
    @FindBy(xpath = "//input[@name='ishideintable']")
    private SelenideElement hideInTables;

    /**
     * Скрывать при поиске
     */
    @FindBy(xpath = "//input[@name='ishideinsearch']")
    private SelenideElement hideForSearch;

    /**
     * Скрывать в карточке
     */
    @FindBy(xpath = "//input[@name='ishideincard']")
    private SelenideElement hideInCards;

    /**
     * Использовать при создании связанного документа
     */
    @FindBy(xpath = "//input[@name='isuseforlinkeddoc']")
    private SelenideElement usedToCreateTheLinkedDocumentField;

    /**
     * Значение по умолчанию (для полей типа - Дата и Сотрудник)
     */
    @FindBy(xpath = "//input[@name='default_value']")
    private SelenideElement defValueField;

    /**
     * Изменяемое при создании (поля типа - Дата; Сотрудник; Нумератор)
     */
    @FindBy(xpath = "//input[@name='isedited_increate']")
    private SelenideElement editionAvailableWhileCreationField;

    /**
     * Контролер документа
     */
    @FindBy(xpath = "//input[@name='emp_is_controller']")
    private SelenideElement clickDocumentSuperviserField;

    /**
     * Для сведения
     */
    @FindBy(xpath = "//input[@name='emp_for_information']")
    private SelenideElement forInformationField;

    /**
     * Шаблон отображения
     */
    @FindBy(xpath = "//input[@name='document_template']")
    private SelenideElement displayNameTemplateField;

    /**
     * Выбор записей справочника
     */
    @FindBy(xpath = "//input[@name='selectmode']")
    private SelenideElement directoryEntriesSelectionField;

    /**
     * Шаблон справочника
     */
    @FindBy(xpath = "//input[@name='dictionary_template']")
    private SelenideElement directoryTemplate;

    /**
     * Выбор только из справочника
     */
    @FindBy(xpath = "//input[@name='select_only_dictionary']")
    private SelenideElement selOnlyFromDictionary;

    /**
     * Длина поля
     */
    @FindBy(xpath = "//input[@name='fieldlength']")
    private SelenideElement fieldLength;


    //----------------------------------------------------------------------------Типы полей (аннотации)------------------------------------------------------------------

    /**
     * Число
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[1]")
    private SelenideElement selTypeFieldNumber;

    /**
     * Дата
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[2]")
    private SelenideElement selTypeFieldDate;

    /**
     * Строка
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[3]")
    private SelenideElement selTypeFieldString;

    /**
     * Выбор поля - Справочник для поля типа Строка/Текст/Справочник
     */
    @FindBy(xpath = "//input[@name='id_meta_dictionary']")
    private SelenideElement selTypeFieldStringOrTextDirectory;

    /**
     * Текст
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[4]")
    private SelenideElement selTypeFieldText;

    /**
     * Словарь
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[5]")
    private SelenideElement selTypeFieldDictionary;

    /**
     * Выбор поля Словарь для выбора значения
     */
    @FindBy(xpath = "//span[contains(@id,'button')]/span[string-length(text())>=5]/../../../..//div/input[@name='id_cataloguetype']")
    private SelenideElement clickFieldDictionary;

    /**
     * Подразделение
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[6]")
    private SelenideElement selTypeFieldDepartment;

    /**
     * Сотрудник
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[7]")
    private SelenideElement selTypeFieldEmployee;

    /**
     * Документ
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[8]")
    private SelenideElement selTypeFieldDocument;

    /**
     * Вкладка - Поиск - в форме редактирования поля типа "Документ"
     */
    @FindBy(xpath = "//div[contains(@id,'tabbar')]//div[count(a)=2]/a[2]//span")
    private SelenideElement tabSearch;

    /**
     * Вкладка - Поля - в форме редактирования поля типа "Документ"
     */
    @FindBy(xpath = "//div[contains(@id,'tabbar')]//div[count(a)=2]/a[1]//span")
    private SelenideElement tabFields;

    /**
     * Искать похожие документы
     */
    @FindBy(name = "search_documents")
    private SelenideElement searchSimiliarDocuments;

    /**
     * Правила поиска
     */
    @FindBy(xpath = "//textarea[@name='search_template']")
    private SelenideElement searchRulesTemplate;

    /**
     * Нумератор
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[9]")
    private SelenideElement selTypeFieldNumerator;

    /**
     * Шаблон нумератора
     */
    @FindBy(xpath = "//input[@name='numerator_template']")
    private SelenideElement numeratorTemplate;

    /**
     * Справочник
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[10]")
    private SelenideElement selTypeFieldDirectory;

    /**
     * Сохранить поле
     */
    @FindBy(xpath = "(//span[string-length(*[text()])>=3]/ancestor::div[contains(@id,'toolbar')]//a)[5]//span")
    private SelenideElement clickButtonSaveField;

    /**
     * Отменить сохранения поля
     */
    @FindBy(xpath = "(//span[string-length(*[text()])>=3]/ancestor::div[contains(@id,'toolbar')]//a)[6]//span")
    private SelenideElement clickButtonCancelField;


    //----------------------------------------------------------------------------Вкладка - ПОЛЯ (методы)--------------------------------------------------------------------------------

    /**
     * Производим выбор вкладки - ПОЛЯ
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage fieldsTab() {
        fieldsTab.click();
        return this;
    }

    /**
     * Производим клик кнопки - Добавить поле
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage clickAddFieldDoc() {
        addFieldDoc.click();
        return this;
    }

    /**
     * Название поля
     *
     * @param fieldName
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage setFieldNameDoc(String fieldName) {
        nameFieldDoc.clear();
        nameFieldDoc.sendKeys(fieldName);
        return this;
    }

    /**
     * Идентификатор поля
     *
     * @param identifierField
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage setFieldIDDoc(String identifierField) {
        if (identifierField == null) {
            return this;
        } else {
            idFieldDoc.clear();
            idFieldDoc.sendKeys(identifierField);
        }
        return this;
    }

    /**
     * Выбор поля - Тип поля
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage clickFieldTypeFieldDoc() {
        clickFieldTypeField.click();
        return this;
    }

    /**
     * Изменяемое при редактировании
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selEditableFieldDoc(boolean editableField) {
        if (editableField) {
            this.editableField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Шаблон спр-ка
     *
     * @param dirTemplate
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selDirectoryTemplate(String dirTemplate) {
        if (dirTemplate == null) {
            return this;
        } else {
            directoryTemplate.clear();
            directoryTemplate.sendKeys(dirTemplate);
        }
        return this;
    }

    /**
     * Длина поля
     *
     * @param lengthField
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage fieldLength(String lengthField) {
        if (lengthField == null) {
            return this;
        } else {
            fieldLength.clear();
            fieldLength.sendKeys(lengthField);
        }
        return this;
    }

    /**
     * Выбор только из справочника
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selOnlyFromDictionary(boolean onlyFromDictionary) {
        if (!onlyFromDictionary) {
            this.selOnlyFromDictionary.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Обязательное при создании
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selObligatoryFieldDoc(ObligatoryFieldDocument obligatoryFieldDocumentDoc) {
        if (obligatoryFieldDocumentDoc == null) {
            return this;
        } else if (obligatoryFieldDocumentDoc == ObligatoryFieldDocument.REQUIRED_WHEN_CREATION) {
            selObligatoryField.click();
            selectingSecondAdjustmentPosition();
        } else if (obligatoryFieldDocumentDoc == ObligatoryFieldDocument.REQUIRED_WHEN_SENDING_TO_EXECUTION) {
            selObligatoryField.click();
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    /**
     * Уникальное поле
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selUniqueFieldDoc(boolean uniqueField) {
        if (uniqueField) {
            this.uniqueField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать при создании
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selHideForCreation(boolean hideForCreation) {
        if (hideForCreation) {
            this.hideForCreation.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать в таблицах
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selHideInTables(boolean hideInTables) {
        if (hideInTables) {
            this.hideInTables.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать при поиске
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selHideForSearch(boolean hideForSearch) {
        if (hideForSearch) {
            this.hideForSearch.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать в карточке
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selHideInCards(boolean hideInCards) {
        if (hideInCards) {
            this.hideInCards.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Использовать при создании связанного документа
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selUsedToCreateTheLinkedDocumentField(boolean usedToCreateTheLinkedDocumentField) {
        if (usedToCreateTheLinkedDocumentField) {
            this.usedToCreateTheLinkedDocumentField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    //----------------------------------------------------------------------------Выбор типов полей (методы)----------------------------------------------------------------

    /**
     * Выбор поля типа Число
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selectFieldTypeNumber() {
        selTypeFieldNumber.click();
        return this;
    }

    /**
     * Выбор поля типа Дата
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selectFieldTypeDate() {
        selTypeFieldDate.click();
        return this;
    }

    /**
     * Выбор поля типа Строка
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selectFieldTypeString() {
        selTypeFieldString.click();
        return this;
    }

    /**
     * Выбор Справочника для полей типа Строка/Текст
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage chooseTypeFieldStringTextOrDirectory() {
        selTypeFieldStringOrTextDirectory.click();
        return this;
    }

    /**
     * Изменяемое при создании
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selEditionAvailableWhileCreationField(boolean editAvailableWhileCreationField) {
        if (!editAvailableWhileCreationField) {
            this.editionAvailableWhileCreationField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор поля типа Текст
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selectFieldTypeText() {
        selTypeFieldText.click();
        return this;
    }

    /**
     * Выбор поля типа Словарь
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selectFieldTypeDictionary() {
        selTypeFieldDictionary.click();
        return this;
    }

    /**
     * Выбор поля Словарь - для выбора значения типа Словарь
     *
     * @param dictionaryEditorName
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage chooseFieldDictionary(String dictionaryEditorName) {
        if (dictionaryEditorName == null) {
            return this;
        } else {
            clickFieldDictionary.click();
            $(By.xpath("//*[text()='" + dictionaryEditorName + "']")).click();
        }
        return this;
    }

    /**
     * Выбор поля типа Подразделение
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selectFieldTypeDepartment() {
        selTypeFieldDepartment.click();
        return this;
    }

    /**
     * Выбор поля типа Сотрудник
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selectFieldTypeEmployee() {
        selTypeFieldEmployee.click();
        return this;
    }

    /**
     * Выбор значения - Контролер документа == Да
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selValueDocumentSuperviser(boolean valueDocumentSuperviser) {
        if (valueDocumentSuperviser) {
            this.clickDocumentSuperviserField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор значения - Сотрудник - Значение по умолчанию == Текущий пользователь; Дата - Значение по умолчанию == Текущая дата;
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selDefaultValueField(boolean defValueField) {
        if (defValueField) {
            this.defValueField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор значения - Для сведения == Да
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selForInformationField(boolean forInformationField) {
        if (forInformationField) {
            this.forInformationField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Шаблон отображения
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage setDisplayNameTemplateField(String disNameTemplateField) {
        if (disNameTemplateField == null) {
            return this;
        } else {
            displayNameTemplateField.clear();
            displayNameTemplateField.sendKeys(disNameTemplateField);
        }
        return this;
    }

    /**
     * Выбор поля типа Документ
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selFieldTypeDocument() {
        selTypeFieldDocument.click();
        return this;
    }

    /**
     * Выбор вкладки - Поиск (фильтрация документов)
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selTabSearch() {
        tabSearch.click();
        return this;
    }

    /**
     * Выбор вкладки - Поля (фильтрация документов)
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selTabFields() {
        tabFields.click();
        return this;
    }

    /**
     * Выбор настройки - Искать похожие документы
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selSearchSimiliarDocuments(boolean searchSimiliarDoc) {
        if (searchSimiliarDoc)
            this.searchSimiliarDocuments.click();
        selectingSecondAdjustmentPosition();
        return this;
    }

    /**
     * Правила поиска (фильтрация документов)
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage enSearchRulesTemplate(String searchRules) {
        if (searchRules == null) {
            return this;
        } else {
            searchRulesTemplate.clear();
            searchRulesTemplate.sendKeys(searchRules);
        }
        return this;
    }

    /**
     * Выбор поля типа Нумератор
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selFieldTypeNumerator() {
        selTypeFieldNumerator.click();
        return this;
    }

    /**
     * Шаблон нумератора
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage enNumeratorTemplateField(String numeratorTemplateField) {
        if (numeratorTemplateField == null) {
            return this;
        } else {
            numeratorTemplate.clear();
            numeratorTemplate.sendKeys(numeratorTemplateField);
        }
        return this;
    }

    /**
     * Выбор поля типа Справочник
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selFieldTypeDirectory() {
        selTypeFieldDirectory.click();
        return this;
    }

    /**
     * Выбор поля Справочник - для выбора значения типа Справочник
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage clickFieldDirectory() {
        selTypeFieldStringOrTextDirectory.click();
        return this;
    }

    /**
     * Выбор спр-ка из списка Спр-ов (поле - Справочник)
     *
     * @param directoryName
     * @return TaskTypesEditPage
     */
    public DocRegisterCardsEditFieldsPage chooseDirectory(String directoryName) {
        if (directoryName == null) {
            return this;
        } else {
            selTypeFieldStringOrTextDirectory.click();
            $(By.xpath("//*[text()='" + directoryName + "']")).click();
        }
        return this;
    }

    /**
     * Выбор настройки мульти выбора записей справочника
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage selMultipleRecords(boolean multipleRecords) {
        if (!multipleRecords) {
            this.directoryEntriesSelectionField.click();
            selectingSecondAdjustmentPosition();
        }

        return this;
    }

    /**
     * Сохранить поле
     *
     * @return DocRegisterCardsEditFieldsPage
     */
    public DocRegisterCardsEditFieldsPage saveFieldDoc() {
        clickButtonSaveField.click();
        return this;
    }

    /**
     * Перемещение текущего поля в самый вверх по позиции
     *
     * @return
     */
    public DocRegisterCardsEditFieldsPage clickMoveFieldTopUp() {
        for (byte i = 0; i < 10; i++)
            moveFieldUp.click();
        return this;
    }

    /**
     * Проверяем отображение в гриде полей
     *
     * @return TypesOfTablesEditPage
     */
    public DocRegisterCardsEditFieldsPage verifyFieldInGrid(String fieldName) {
        $(By.xpath("//table[contains(@id,'treeview')]//td[1]/div[text()='" + fieldName + "']")).shouldBe(Condition.visible);
        return this;
    }

    /**
     * ----------------------------------------------------------------------------Метод добавления всех типов полей документа--------------------------------
     *
     * @param fieldsDocs
     * @return
     */
    public DocRegisterCardsEditFieldsPage addAllFieldsDoc(DocRegisterCardsField[] fieldsDocs) {
        if (fieldsDocs == null) {
            return null;
        } else
           // TODO Что имелось ввиду!!! appearanceOfItemsInTheEditFormFieldTab(); // Ожидание элементов на вкладке "Поля"
        outer:
        for (DocRegisterCardsField fieldDoc : fieldsDocs) {
            clickAddFieldDoc(); // Добавить поле
            setFieldNameDoc(fieldDoc.getFieldNameDoc()); // Заполняем Название поля документа из массива
            setFieldIDDoc(fieldDoc.getFieldIDDoc()); // Заполняем Идентификатор поля из массива
            clickFieldTypeFieldDoc(); // Выбор поля - Тип поля

            // 1. ЧИСЛО
            if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeNumberDoc) {
                selectFieldTypeNumber();
                FieldTypeNumberDoc fieldNumber = (FieldTypeNumberDoc) fieldDoc.getFieldTypeDoc();
                // 2. ДАТА
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeDateDoc) {
                selectFieldTypeDate();
                FieldTypeDateDoc fieldDate = (FieldTypeDateDoc) fieldDoc.getFieldTypeDoc();
                if (fieldDate.getDefaultValue()) {
                    selDefaultValueField(fieldDate.getDefaultValue()); // Значение по умолчанию == Текущая дата
                }
                if (fieldDate.getEditionAvailableWhileCreation() || !fieldDate.getEditionAvailableWhileCreation()) {
                    selEditionAvailableWhileCreationField(fieldDate.getEditionAvailableWhileCreation()); // Изменяемое при создании
                }
                // 3. СТРОКА
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeStringDoc) {
                selectFieldTypeString(); // Выбор поля типа "Строка"
                FieldTypeStringDoc fieldString = (FieldTypeStringDoc) fieldDoc.getFieldTypeDoc();
                if ((fieldString.getSelectOnlyFromDictionary() || !fieldString.getSelectOnlyFromDictionary()) && !fieldDoc.getUniqueField()) {
                    selOnlyFromDictionary(fieldString.getSelectOnlyFromDictionary()); // Выбор только из спр-ка
                    chooseTypeFieldStringTextOrDirectory(); // Выбор поля Справочник
                    $(By.xpath("//*[text()='" + fieldString.getDirectoryName() + "']")).click();
                    selDirectoryTemplate(fieldString.getDirectoryTemplate()); // Шаблон спр-ка
                    fieldLength(fieldString.getFieldLength()); // Длина поля
                } else if (fieldDoc.getUniqueField()) {
                    fieldLength(fieldString.getFieldLength()); // Длина поля
                }
                // 4. ТЕКСТ
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeTextDoc) {
                selectFieldTypeText();
                FieldTypeTextDoc fieldText = (FieldTypeTextDoc) fieldDoc.getFieldTypeDoc();
                if (fieldText.getSelectOnlyFromDictionary()) {
                    selOnlyFromDictionary(fieldText.getSelectOnlyFromDictionary()); // Выбор только из спр-ка
                    chooseTypeFieldStringTextOrDirectory(); // Выбор поля Справочник
                    $(By.xpath("//*[text()='" + fieldText.getDirectoryName() + "']")).click();
                    selDirectoryTemplate(fieldText.getDirectoryTemplate());
                } else if (!fieldText.getSelectOnlyFromDictionary()) {

                }
                // 5. СЛОВАРЬ
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeDictionaryDoc) {
                selectFieldTypeDictionary();
                FieldTypeDictionaryDoc fieldDictionary = (FieldTypeDictionaryDoc) fieldDoc.getFieldTypeDoc();
                chooseFieldDictionary(fieldDictionary.getDictionaryEditor().getDictionaryEditorName()); // Выбор поля "Словарь"
                // 6. ПОДРАЗДЕЛЕНИЕ
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeDepartmentDoc) {
                selectFieldTypeDepartment();
                FieldTypeDepartmentDoc fieldDepartment = (FieldTypeDepartmentDoc) fieldDoc.getFieldTypeDoc();
                // 7. СОТРУДНИК
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeEmployeeDoc) {
                selectFieldTypeEmployee();
                FieldTypeEmployeeDoc fieldEmployee = (FieldTypeEmployeeDoc) fieldDoc.getFieldTypeDoc();
                if (fieldEmployee.getDefaultValue()) { // Значение по умолчанию == Текущий пользователь
                    selDefaultValueField(fieldEmployee.getDefaultValue());
                }
                if (fieldEmployee.getDocumentSuperviser()) { // Контролер документа
                    selValueDocumentSuperviser(fieldEmployee.getDocumentSuperviser());
                }
                if (fieldEmployee.getForInformation()) { // Для сведения == Да
                    selForInformationField(fieldEmployee.getForInformation());
                }
                if (fieldEmployee.getEditionAvailableWhileCreation()) { // Изменяемое при создании
                    selEditionAvailableWhileCreationField(fieldEmployee.getEditionAvailableWhileCreation());
                }
                // 8. ДОКУМЕНТ
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeDocumentDoc) {
                selFieldTypeDocument();
                FieldTypeDocumentDoc fieldDocument = (FieldTypeDocumentDoc) fieldDoc.getFieldTypeDoc();
                setDisplayNameTemplateField(fieldDocument.getDisplayNameTemplate()); // Шаблон отображения
                if (!fieldDocument.getSearchSimiliarDocuments()) {
                }
                if (fieldDocument.getSearchSimiliarDocuments()) {
                    selTabSearch(); // Выбор вкладки - Поиск
                    selSearchSimiliarDocuments(fieldDocument.getSearchSimiliarDocuments()); // Искать похожие документы
                    enSearchRulesTemplate(fieldDocument.getSearchRules()); // Правила поиска
                    selTabFields(); // выбираем вкладку Поле в форме редактирования поля
                }
                // 9. НУМЕРАТОР
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeNumeratorDoc) {
                selFieldTypeNumerator();
                FieldTypeNumeratorDoc fieldNumerator = (FieldTypeNumeratorDoc) fieldDoc.getFieldTypeDoc();
                enNumeratorTemplateField(fieldNumerator.getNumeratorTemplateDoc()); // Шаблон нумератора
                // 9. СПРАВОЧНИК
            } else if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeDirectoryDoc) {
                selFieldTypeDirectory();
                FieldTypeDirectoryDoc fieldDirectory = (FieldTypeDirectoryDoc) fieldDoc.getFieldTypeDoc();
                if (fieldDirectory.getDirectoryEntriesSelection()) { // Выбор записей спр-ка == Одна запись
                    chooseTypeFieldStringTextOrDirectory(); // Выбор поля Справочник
                    $(By.xpath("//*[text()='" + fieldDirectory.getNameDirectoryDoc() + "']")).click();
                    selMultipleRecords(fieldDirectory.getDirectoryEntriesSelection());
                    selDirectoryTemplate(fieldDirectory.getDirectoryTemplate()); // Шаблон спр-ка
                } else if (!fieldDirectory.getDirectoryEntriesSelection()) { // Выбор записей справочника == Несколько записей
                    chooseDirectory(fieldDirectory.getDirectoryDoc().getDirectoryName()); // Выбор проинициализированного спр-ка
                    selMultipleRecords(fieldDirectory.getDirectoryEntriesSelection()); // Выбор настройки мульти выбора записей справочника
                    selDirectoryTemplate(fieldDirectory.getDirectoryTemplate()); // Шаблон спр-ка

                }
            }

            selEditableFieldDoc(fieldDoc.getEditableField()); // Редактируемость поля
            selObligatoryFieldDoc(fieldDoc.getObligatoryFieldDoc()); // Обязательное поле
            selUniqueFieldDoc(fieldDoc.getUniqueField()); // Уникальное поле
            // Настройки Скрытия полей документа
            selHideForCreation(fieldDoc.getHideForCreationField()); // Скрывать при создании
            selHideInTables(fieldDoc.getHideInTablesField()); // Скрывать в таблицах
            selHideForSearch(fieldDoc.getHideForSearchField()); // Скрывать при поиске
            selHideInCards(fieldDoc.getHideInСardField()); // Скрывать в карточке
            // Использовать при создании связанного документа
            selUsedToCreateTheLinkedDocumentField(fieldDoc.getUsedToCreateTheLinkedDocument());

            saveFieldDoc(); // Сохранить поле документа

            verifyFieldInGrid(fieldDoc.getFieldNameDoc()); // Проверяем отображение добавленного поля в гриде


        }

        return this;
    }



}