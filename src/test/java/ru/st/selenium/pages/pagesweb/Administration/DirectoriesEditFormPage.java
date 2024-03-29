package ru.st.selenium.pages.pagesweb.Administration;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.logicinterface.DirectoriesEditFormLogic;
import ru.st.selenium.model.Administration.Directories.Directories;
import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.Administration.FieldsObject.*;
import ru.st.selenium.model.OpenFilesForEdit;

import static com.codeborne.selenide.Selenide.*;

/**
 * Страница - форма редактирования объекта - Справочники
 */
public class DirectoriesEditFormPage extends TaskTypeListObjectPage implements DirectoriesEditFormLogic {

    /**
     * Вкладка - Настройки
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[1]")
    private SelenideElement settingsTab;

    /**
     * Общедоступность записей
     */
    @FindBy(xpath = "//input[@id='quotient-inputEl']")
    private SelenideElement recordsAccessibility;

    /**
     * Настройка доступа к записям
     */
    @FindBy(css = "#visible_quotient-inputEl")
    private SelenideElement recordAccessSetting;

    /**
     * Способ отображения
     * Иерархический
     */
    @FindBy(xpath = "(//tr[contains(@id,'radiofield')]//input)[1]")
    private SelenideElement rbHierarchical;

    /**
     * Способ отображения
     * Линейный
     */
    @FindBy(xpath = "(//tr[contains(@id,'radiofield')]//input)[2]")
    private SelenideElement rbFlat;

    /**
     * Настройки поиска
     * Использовать поисковую систему
     */
    @FindBy(xpath = "(//input[contains(@id,'search_type')])[1]")
    private SelenideElement useSearchSystem;

    /**
     * Настройки поиска
     * Использовать БД
     */
    @FindBy(xpath = "(//input[contains(@id,'search_type')])[2]")
    private SelenideElement useSearchBD;

    /**
     * Вкладка - Поля
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[2]")
    private SelenideElement fieldsTab;

    /**
     * Вкладка - Обработчики
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[3]")
    private SelenideElement handlersTab;

    /**
     * Настройки закладок
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[4]")
    private SelenideElement handlersAndMailNotifySettingsTab;

    /**
     *  ЭЛЕМЕНТЫ - Форма грида редактирования полей
     */
    /**
     * Кнопка - Добавить Поле
     */
    @FindBy(xpath = "//a/span[contains(@id, 'button-10')]")
    private SelenideElement addFieldDirectory;

    /**
     * Нажать кнопку Сохранить объект
     */
    @FindBy(xpath = "//span[@id='button-1010-btnIconEl']")
    private SelenideElement saveObject;


    //-------------------------------------------------------------------------------------- ЭЛЕМЕНТЫ - Форма добавления полей----------------------------------------------------------------

    /**
     * Ввод Названия поля
     */
    @FindBy(css = "#dialog_form_name-inputEl")
    private SelenideElement nameField;

    /**
     * Ввод Идентификатора поля
     */
    @FindBy(css = "#dialog_form_identifier-inputEl")
    private SelenideElement nameIdentifier;

    /**
     * Выбор Тип поля
     */
    @FindBy(css = "#dialog_form_type-inputEl")
    private SelenideElement typeField;

    /**
     * Обязательное поле
     */
    @FindBy(css = "#dialog_form_isnecessary-inputEl")
    private SelenideElement obligatoryField;

    /**
     * Уникальное поле
     */
    @FindBy(css = "#dialog_form_is_unique-inputEl")
    private SelenideElement uniqueField;

    /**
     * Клик "Поле:"
     */
    @FindBy(css = "#dialog_form_field-inputEl")
    private SelenideElement selectField;

    /**
     * "Выбор из списка" для поля типа "Строка"
     */
    @FindBy(css = "#dialog_form_isselect-inputEl")
    private SelenideElement selectionFromList;

    /**
     * Поле - "Список значений" для поля типа "Строка"
     */
    @FindBy(css = "#dialog_form_listval-inputEl")
    private SelenideElement fieldListVal;

    /**
     * Сохранить поле
     */
    @FindBy(xpath = "//span[contains(@id,'-btnIconEl')] [ancestor::div[contains(@id,'window-')]]")
    private SelenideElement saveField;


    //------------------------------------------------------------------------------------ Выбор типов полей из выпадающего списка--------------------------------------------------------------

    /**
     * Строка
     */
    @FindBy(xpath = "//li[text()='Строка']")
    private SelenideElement typeFieldString;

    /**
     * Текст
     */
    @FindBy(xpath = "//li[text()='Текст']")
    private SelenideElement typeFieldText;

    /**
     * Целое
     */
    @FindBy(xpath = "//li[text()='Целое']")
    private SelenideElement typeFieldInteger;

    /**
     * Вещественное
     */
    @FindBy(xpath = "//li[text()='Вещественное']")
    private SelenideElement typeFieldDouble;

    /**
     * Дата
     */
    @FindBy(xpath = "//li[text()='Дата']")
    private SelenideElement typeFieldData;

    /**
     * Файл
     */
    @FindBy(xpath = "//li[text()='Файл']")
    private SelenideElement typeFieldFile;

    /**
     * Открывать файлы для редактирования
     */
    @FindBy(id = "dialog_form_files_edit-inputEl")
    private SelenideElement openFileForEdit;

    /**
     * Cсылка на справочник
     */
    @FindBy(xpath = "//li[text()='Cсылка на справочник']")
    private SelenideElement typeFieldReferenceToTheDictionary;

    /**
     * поле "Справочник:"
     */
    @FindBy(id = "dialog_form_dictionary-inputEl")
    private SelenideElement typeDictionary;

    /**
     * Множественная ссылка на справочник
     */
    @FindBy(xpath = "//li[text()='Множественная ссылка на справочник']")
    private SelenideElement typeFieldMultipleReferenceToTheDictionary;

    /**
     * Логический
     */
    @FindBy(xpath = "//li[text()='Логический']")
    private SelenideElement typeFieldBoolean;

    /**
     * Телефон
     */
    @FindBy(xpath = "//li[text()='Телефон']")
    private SelenideElement typeFieldPhone;

    /**
     * Email
     */
    @FindBy(xpath = "//li[text()='Email']")
    private SelenideElement typeFieldEmail;

    /**
     * Изображение
     */
    @FindBy(xpath = "//li[text()='Изображение']")
    private SelenideElement typeFieldImage;

    /**
     * Цвет
     */
    @FindBy(xpath = "//li[text()='Цвет']")
    private SelenideElement typeFieldColor;

    /**
     * Вложенный справочник
     */
    @FindBy(xpath = "//li[text()='Вложенный справочник']")
    private SelenideElement typeFieldEnclosedDirectory;

    /**
     * Подразделение
     */
    @FindBy(xpath = "//li[text()='Подразделение']")
    private SelenideElement typeFieldDepartment;


    //-------------------------------------------------------------------------------------вкладка - НАСТРОЙКИ-------------------------------------------------------

    /**
     * Выбор вкладки - Настройки
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage clickSettingsTab() {
        $(settingsTab).shouldBe(Condition.present).click();
        return this;
    }

    /**
     * Выбор вкладки - Поля
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage clickFieldsTab() {
        $(fieldsTab).shouldBe(Condition.present).click();
        return this;
    }

    /**
     * Общедоступность записей
     *
     * @param shareRecords
     * @return
     */
    public DirectoriesEditFormPage selShareRecords(boolean shareRecords) {
        if (shareRecords) {
            this.recordsAccessibility.click();
        }
        return this;
    }

    /**
     * Настройка доступа к записям
     *
     * @param recAccessSetting
     * @return
     */
    public DirectoriesEditFormPage selRecordAccessSetting(boolean recAccessSetting) {
        if (recAccessSetting) {
            this.recordAccessSetting.click();
        }
        return this;
    }

    /**
     * Способ отображения
     */
    public DirectoriesEditFormPage selMappingDevice(boolean flat) {
        if (flat) {
            rbFlat.click();
        } else if (!flat) {
            rbHierarchical.click();
        }
        return this;
    }

    /**
     * Настройка поиска
     */
    public DirectoriesEditFormPage selSearchSettings(boolean searchSystem) {
        if (searchSystem) {
            useSearchSystem.click();
        } else if (!searchSystem) {
            useSearchBD.click();
        }

        return this;
    }

    //------------------------------------------------------------------Форма редактирования полей-----------------------------------------------------

    /**
     * Выбор Типа поля
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selTypeField() {
        typeField.click();
        return this;
    }

    /**
     * Клик кнопка - Добавить поле
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage clickAddFieldDirectory() {
        addFieldDirectory.click();
        return this;
    }

    /**
     * Поле - Название поля
     *
     * @param text
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage adNameField(String text) {
        nameField.clear();
        nameField.setValue(text);
        return this;
    }

    /**
     * Идентификатор поля
     *
     * @param identifier
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage adFieldID(String identifier) {
        nameIdentifier.clear();
        nameIdentifier.setValue(identifier);
        return this;
    }

    /**
     * Обязательное поле
     *
     * @param oblField
     * @return
     */
    public DirectoriesEditFormPage selObligatoryField(boolean oblField) {
        if (oblField) {
            obligatoryField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Уникальное поле
     *
     * @param uniqField
     * @return
     */
    public DirectoriesEditFormPage selUniqueField(boolean uniqField) {
        if (uniqField) {
            uniqueField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор из списка
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selFromList(boolean fromList) {
        if (fromList) {
            selectionFromList.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Список значений
     *
     * @param listVal
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selListVal(String listVal) {
        fieldListVal.click();
        fieldListVal.setValue(listVal);
        return this;
    }

    /**
     * Сохранить поле объекта
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage clickSaveField() {
        saveField.click();
        return this;
    }

    /**
     * Сохранить объект
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage clickSaveObject() {
        saveObject.click();
        checkingMessagesConfirmationOfTheObject($(By.xpath("//div[count(div)=3]/div[2]//div[contains(@id,'messagebox') and (@data-errorqtip)]")),
                "Изменения сохранены",
                $(By.xpath("//div[count(div)=3]/div[3]//div[count(a)=4]/a[1]//span[position()=2]")));
        return this;
    }

    /**
     * Проверяем отображение в гриде полей
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage verifyFieldInGrid(String fieldName) {
        $(By.xpath("//table[contains(@id,'gridview')]//td[1]/div[text()='" + fieldName + "']")).shouldBe(Condition.visible);
        return this;
    }

    //-----------------------------------------------------------------------------------------Выбор Типов полей из выпадающего списка-------------------------------------

    /**
     * СТРОКА
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldString() {
        typeFieldString.click();
        return this;
    }

    /**
     * ТЕКСТ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldText() {
        typeFieldText.click();
        return this;
    }

    /**
     * ЦЕЛОЕ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldInteger() {
        typeFieldInteger.click();
        return this;
    }

    /**
     * ВЕЩЕСТВЕННОЕ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldDouble() {
        typeFieldDouble.click();
        return this;
    }

    /**
     * ДАТА
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldDate() {
        typeFieldData.click();
        return this;
    }

    /**
     * ФАЙЛ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldFile() {
        typeFieldFile.click();
        return this;
    }

    /**
     * выбор поля - Открывать файлы для редактирования
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selFieldOpenFileForEdit() {
        openFileForEdit.click();
        return this;
    }

    /**
     * выбор значения поля - Открывать файлы для редактирования
     */
    public DirectoriesEditFormPage selOpenFilesForEdit(OpenFilesForEdit filesForEdit) {
        selFieldOpenFileForEdit(); // выюбираем поле - Открывать файлы для редактирования
        if (filesForEdit == OpenFilesForEdit.NULL) {
        } else if (filesForEdit == OpenFilesForEdit.NO) {
            selectingSecondAdjustmentPosition();
        } else if (filesForEdit == OpenFilesForEdit.YES) {
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    /**
     * ССЫЛКА НА СПРАВОЧНИК
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldDirectory() {
        typeFieldReferenceToTheDictionary.click();
        return this;
    }

    /**
     * Клик в поле "Справочник:"
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selFieldDirectory() {
        typeDictionary.click();
        return this;
    }

    /**
     * Клик в поле "Поле:" справочника
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectField() {
        waitMillisecond(0.3);
        $(selectField).click();
        return this;
    }

    /**
     * МНОЖЕСТВЕННАЯ ССЫЛКА
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldMultipleDictionary() {
        typeFieldMultipleReferenceToTheDictionary.click();
        return this;
    }

    /**
     * ЛОГИЧЕСКОЕ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldBoolean() {
        typeFieldBoolean.click();
        return this;
    }

    /**
     * ТЕЛЕФОН
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldPhone() {
        typeFieldPhone.click();
        return this;
    }

    /**
     * EMAIL
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldEmail() {
        typeFieldEmail.click();
        return this;
    }

    /**
     * ИЗОБРАЖЕНИЕ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldImage() {
        typeFieldImage.click();
        return this;
    }

    /**
     * ЦВЕТ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldColor() {
        typeFieldColor.click();
        return this;
    }

    /**
     * ВЛОЖЕННЫЙ СПРАВОЧНИК
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldEnclosedDirectory() {
        typeFieldEnclosedDirectory.click();
        return this;
    }

    /**
     * ПОДРАЗДЕЛЕНИЕ
     *
     * @return DirectoriesEditFormPage
     */
    public DirectoriesEditFormPage selectTypeFieldDepartment() {
        typeFieldDepartment.click();
        return this;
    }


    /**
     * ----------------------------------------------------------------------------Метод добавления всех типов полей------------------------------------
     *
     * @param fieldsDirectory
     * @return
     */
    public DirectoriesEditFormPage addAllFieldsDirectory(DirectoryField[] fieldsDirectory) {
        if (fieldsDirectory == null) {
            return null;
        } else
            outer:
                    for (DirectoryField fieldDirectory : fieldsDirectory) {
                        clickAddFieldDirectory(); // Добавить поле
                        adNameField(fieldDirectory.getFieldName()); // заполняем Название поля документа из массива
                        adFieldID(fieldDirectory.getFieldID()); // заполняем Идентификатор поля из массива
                        selTypeField(); // Выбор поля - Тип поля

                        // 1. СТРОКА
                        if (fieldDirectory.getFieldType() instanceof TypeListFieldsString) {
                            selectTypeFieldString();
                            TypeListFieldsString fieldString = (TypeListFieldsString) fieldDirectory.getFieldType();
                            if (fieldString.getIsListChoice()) {
                                selFromList(fieldString.getIsListChoice()); // Выбор из списка
                                selListVal(fieldString.getValuesList()); // Список значений
                            } else if (!fieldString.getIsListChoice()) {
                                selListVal(fieldString.getValuesList()); // Список значений
                            }
                            // 2. ТЕКСТ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsText) {
                            selectTypeFieldText();
                            TypeListFieldsText fieldText = (TypeListFieldsText) fieldDirectory.getFieldType();
                            // 3. ЦЕЛОЕ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsInt) {
                            selectTypeFieldInteger();
                            TypeListFieldsInt fieldInt = (TypeListFieldsInt) fieldDirectory.getFieldType();
                            // 4. ВЕЩЕСТВЕННОЕ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsDouble) {
                            selectTypeFieldDouble();
                            TypeListFieldsDouble fieldsDouble = (TypeListFieldsDouble) fieldDirectory.getFieldType();
                            // 5. ДАТА
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsDate) {
                            selectTypeFieldDate();
                            TypeListFieldsDate fieldsDate = (TypeListFieldsDate) fieldDirectory.getFieldType();
                            // 6. ФАЙЛ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsFile) {
                            selectTypeFieldFile();
                            TypeListFieldsFile fieldsFile = (TypeListFieldsFile) fieldDirectory.getFieldType();
                            if (fieldsFile.getOpenFilesForEdit() == OpenFilesForEdit.YES || fieldsFile.getOpenFilesForEdit() == OpenFilesForEdit.NO) {
                                selOpenFilesForEdit(fieldsFile.getOpenFilesForEdit());
                            }
                            // 7. СПРАВОЧНИК
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsDirectory) {
                            selectTypeFieldDirectory();
                            TypeListFieldsDirectory fieldsDir = (TypeListFieldsDirectory) fieldDirectory.getFieldType();
                            selFieldDirectory(); // Выбор поля Спр-к
                            $(By.xpath("//*[text()='" + fieldsDir.getDirectoryName() + "']")).click(); // Выбор справочника
                            selectField();
                            $(By.xpath("//li[text()='" + fieldsDir.getNameDirectoryField() + "']")).click(); // Выбор поля справочника
                            // 8. МНОЖЕСТВЕННАЯ ССЫЛКА НА СПР-К
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsMultiDirectory) {
                            selectTypeFieldMultipleDictionary();
                            TypeListFieldsMultiDirectory fieldsMultiDir = (TypeListFieldsMultiDirectory) fieldDirectory.getFieldType();
                            selFieldDirectory(); // Выбор поля Спр-к
                            $(By.xpath("//*[text()='" + fieldsMultiDir.getDirectoryName() + "']")).click();
                            selectField();
                            pressEnter();
                            // 8. ЛОГИЧЕСКОЕ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsBoolean) {
                            selectTypeFieldBoolean();
                            TypeListFieldsBoolean fieldsDate = (TypeListFieldsBoolean) fieldDirectory.getFieldType();
                            // 9. ТЕЛЕФОН
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsPhone) {
                            selectTypeFieldPhone();
                            TypeListFieldsPhone fieldsPhone = (TypeListFieldsPhone) fieldDirectory.getFieldType();
                            // 10. EMAIL
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsEmail) {
                            selectTypeFieldEmail();
                            TypeListFieldsEmail fieldsEmail = (TypeListFieldsEmail) fieldDirectory.getFieldType();
                            // 11. ИЗОБРАЖЕНИЕ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsImage) {
                            selectTypeFieldImage();
                            TypeListFieldsImage fieldsImage = (TypeListFieldsImage) fieldDirectory.getFieldType();
                            // 12. ЦВЕТ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsColor) {
                            selectTypeFieldColor();
                            TypeListFieldsColor fieldsColor = (TypeListFieldsColor) fieldDirectory.getFieldType();
                            // 14. ВЛОЖЕННЫЙ СПРАВОЧНИК
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsEnclosedDirectory) {
                            selectTypeFieldEnclosedDirectory();
                            TypeListFieldsEnclosedDirectory fieldsEnclosedDirectory = (TypeListFieldsEnclosedDirectory) fieldDirectory.getFieldType();
                            selFieldDirectory(); // Выбор поля Спр-к
                            $(By.xpath("//*[text()='" + fieldsEnclosedDirectory.getDirectoryName() + "']")).click();
                            waitMillisecond(0.2);
                            // 15. ПОДРАЗДЕЛЕНИЕ
                        } else if (fieldDirectory.getFieldType() instanceof TypeListFieldsDepartment) {
                            selectTypeFieldDepartment();
                            TypeListFieldsDepartment fieldsDepartment = (TypeListFieldsDepartment) fieldDirectory.getFieldType();
                        }

                        selObligatoryField(fieldDirectory.getObligatory()); // Обязательное поле
                        selUniqueField(fieldDirectory.getIsUniqueField()); // Уникальное поле

                        clickSaveField(); // Сохранить поле

                        verifyFieldInGrid(fieldDirectory.getFieldName()); // Проверяем отображение добавленного поля в гриде

                    }

        return this;
    }


    /**
     * Ожидание появления элементов на вкладке - Поля
     */
    public DirectoriesEditFormPage waitingElementsTabField() {
        $(By.xpath("//a/span[contains(@id, 'button-10')]")).shouldBe(Condition.present);
        $(By.id("bEditField-btnIconEl")).shouldBe(Condition.present);
        $(By.id("bDeleteField-btnIconEl")).shouldBe(Condition.present);
        return this;
    }

    /**
     * Добавление полей Справочника
     * @param directories
     */
    @Override
    public void addFieldDirectories(Directories directories) {
        $$(By.xpath("//div[count(a)=4]/a//text()//..")).shouldBe(CollectionCondition.size(4)); // проверка отображения вкладок в форме редактирования Спр-ка
        clickFieldsTab(); // Выбираем вкладку Поля
        waitingElementsTabField() // Ожидаем появления элементов на вкладке "Поля"
                .addAllFieldsDirectory(directories.getDirectoryFields()) // Добавление типов полей
                .clickSettingsTab() // выбор вкладки Настройки
                .selShareRecords(directories.getShareRecords()) // Общедоступность записей
                .selRecordAccessSetting(directories.getAccessToRecords()) // Настройка доступа к записям
                .selMappingDevice(directories.getMappingDevice()) // Способ отображения
                .selSearchSettings(directories.getSearchSettings()) // Настройка поиска
                .clickSaveObject() // Сохранить объект
                .verifyCreateObject(directories.getDirectoryName()); // Проверяем отображение сохраненного объекта в гриде

                gotoTopFrem(); // Уходим в ТОП фрейм для дальнейшего взаимодействия с Внутренней страницей (InternalPage)
    }

    @Override
    public void editFieldDirectories(Directories directories) {

    }

    @Override
    public void removeAnFieldDirectories(Directories directories) {

    }


}
