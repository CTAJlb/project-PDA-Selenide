package ru.st.selenium.pages.pagesweb.Administration;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.st.selenium.model.Administration.FieldsObject.*;
import ru.st.selenium.model.CorrectionMethod;
import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.ShiftDirection;
import ru.st.selenium.model.Administration.TasksTypes.ComputeModeNumerator;
import ru.st.selenium.model.Administration.TasksTypes.ObligatoryFieldTypeTask;
import ru.st.selenium.model.Administration.TasksTypes.TasksTypesField;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static ru.st.selenium.model.ShiftDirection.*;

/**
 * Форма редактирования - Типы Задач
 */
public class TaskTypesEditPage extends TaskTypeListObjectPage {


    /**
     * Вкладка - Настройки
     *
     * @FindBy
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[1]")
    private WebElement settingsTab;

    /**
     * Вкладка - Поля
     *
     * @FindBy
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[2]")
    private WebElement fieldsTab;

    /**
     * Вкладка - Обработчики
     *
     * @FindBy
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[3]")
    private WebElement handlersTab;

    /**
     * Вкладка - Настройки почтовых уведомлений И Настройки закладок (только для объектов - Справочники И Типы таблиц)
     *
     * @FindBy
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[4]")
    private WebElement handlersAndMailNotifySettingsTab;

    /**
     * Вкладка - Оценки и доклады
     *
     * @FindBy
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[5]")
    private WebElement estimationsAndReportsTab;

    /**
     * Вкладка - Доступ
     *
     * @FindBy
     */
    @FindBy(xpath = "//a/ancestor::div[contains(@id,'tabbar')]/a[6]")
    private WebElement accessTab;


    /**
     *  ЭЛЕМЕНТЫ - Форма грида редактирования полей
     */
    /**
     * Кнопка - Добавить Поле
     */
    @FindBy(xpath = "//a/span[contains(@id, 'button-10')]")
    private WebElement clickOkAndAddFieldTypesObgect;

    /**
     * Нажать кнопку Сохранить объект
     */
    @FindBy(xpath = "//span[@id='button-1010-btnIconEl']")
    private WebElement saveObject;

    /**
     *  ЭЛЕМЕНТЫ - Форма добавления полей
     */
    /**
     * Ввод Названия поля
     */
    @FindBy(css = "#dialog_form_name-inputEl")
    private WebElement nameField;

    /**
     * Ввод Идентификатора поля
     */
    @FindBy(css = "#dialog_form_identifier-inputEl")
    private WebElement nameIdentifier;

    /**
     * Выбор Типа поля
     */
    @FindBy(css = "#dialog_form_type-inputEl")
    private WebElement typeField;

    /**
     * Обязательное поле
     */
    @FindBy(css = "#dialog_form_isnecessary-inputEl")
    private WebElement obligatoryField;

    /**
     * Скрывать при поиске
     */
    @FindBy(css = "#dialog_form_ishideinsearch-inputEl")
    private WebElement isHideInSearch;

    /**
     * Поле - "Шаблон нумератора:"
     */
    @FindBy(css = "#dialog_form_numerator_template-inputEl")
    private WebElement selNumeratorTemp;

    /**
     * Режим вычисления
     */
    @FindBy(css = "#dialog_form_numerator_compute_mode-inputEl")
    private WebElement calculatMode;

    /**
     * "Выбор из списка" для поля типа "Строка"
     */
    @FindBy(css = "#dialog_form_isselect-inputEl")
    private WebElement selectionFromList;

    /**
     * Поле - "Список значений" для поля типа "Строка"
     */
    @FindBy(css = "#dialog_form_listval-inputEl")
    private WebElement fieldListVal;

    /**
     * Клик alert "Ok"
     */
    @FindBy(xpath = "//*[@id='button-1005-btnIconEl']")
    private WebElement clicAlertOk;

    /**
     * Сохранить
     */
    @FindBy(xpath = "//span[contains(@id,'-btnIconEl')] [ancestor::div[contains(@id,'window-')]]")
    private WebElement saveField;

    //---------------------------------------------------------------------------------------------------- Выбор типов полей из выпадающего списка:

    /**
     * Строка
     */
    @FindBy(xpath = "//li[text()='Строка']")
    private WebElement typeFieldString;

    /**
     * Текст
     */
    @FindBy(xpath = "//li[text()='Текст']")
    private WebElement typeFieldText;

    /**
     * Целое
     */
    @FindBy(xpath = "//li[text()='Целое']")
    private WebElement typeFieldInteger;

    /**
     * Вещественное
     */
    @FindBy(xpath = "//li[text()='Вещественное']")
    private WebElement typeFieldDouble;

    /**
     * Дата
     */
    @FindBy(xpath = "//li[text()='Дата']")
    private WebElement typeFieldData;

    /**
     * Cсылка на справочник
     */
    @FindBy(xpath = "//li[text()='Cсылка на справочник']")
    private WebElement typeFieldReferenceToTheDictionary;

    /**
     * Клик "Справочник:"
     */
    @FindBy(css = "#dialog_form_dictionary-inputEl")
    private WebElement clickFieldDictionary;

    /**
     * Клик "Поле:"
     */
    @FindBy(css = "#dialog_form_field-inputEl")
    private WebElement selectField;

    /**
     * Шаблон отображения (Справочник/Таблица)
     */
    @FindBy(id = "dialog_form_dictionary_template-inputEl")
    private WebElement dicTemplate;

    /**
     * Вычислить новые значения для сохраненных полей? - при вводе Шаблона отображения
     */
    @FindBy(xpath = "//div[contains(@id,'messagebox')]//div[count(a)=4]/a[2]//span[1]")
    private WebElement calculatNewValues;

    /**
     * Множественная ссылка на справочник
     */
    @FindBy(xpath = "//li[text()='Множественная ссылка на справочник']")
    private WebElement typeFieldMultipleReferenceToTheDictionary;

    /**
     * Логический
     */
    @FindBy(xpath = "//li[text()='Логический']")
    private WebElement typeFieldBoolean;

    /**
     * Ссылка на библиотеку
     */
    @FindBy(xpath = "//li[text()='Ссылка на библиотеку']")
    private WebElement typeFieldLibrarylink;

    /**
     * Cсылка на задачу
     */
    @FindBy(xpath = "//li[text()='Cсылка на задачу']")
    private WebElement typeFieldReferenceTask;

    /**
     * Нумератор
     */
    @FindBy(xpath = "//li[text()='Нумератор']")
    private WebElement typeFieldNumerator;

    /**
     * Ссылка на объект
     */
    @FindBy(xpath = "//li[text()='Ссылка на объект']")
    private WebElement typeFieldLinkObject;

    /**
     * Таблица
     */
    @FindBy(xpath = "//li[text()='Таблица']")
    private WebElement typeFieldTable;

    /**
     * Клик поле "Таблица:"
     */
    @FindBy(css = "#dialog_form_table-inputEl")
    private WebElement fieldTable;


    //--------------------------------------------------------------------Вкладка - НАСТРОЙКИ---------------------------------------------------------------------------------

    /**
     * Направление смещения даты при попадании на нерабочее время:
     * Дата не меняется
     */
    @FindBy(xpath = "//input[@id='direction-no-inputEl']")
    private WebElement clickDateDoesNotMove;


    /**
     * Направление смещения даты при попадании на нерабочее время
     * Дата сдвигается вперед
     */
    @FindBy(xpath = "//input[@id='direction-forward-inputEl']")
    private WebElement clickDateMovesForward;

    /**
     * Направление смещения даты при попадании на нерабочее время
     * Дата сдвигается назад
     */
    @FindBy(xpath = "//input[@id='direction-back-inputEl']")
    private WebElement clickDateMovesBack;

    /**
     * Использовать ЭЦП
     */
    @FindBy(xpath = "(//input[contains(@id,'checkbox')] [ancestor::div[contains(@id,'tabpanel')]])[1]")
    private WebElement useECP;

    /**
     * Корректировка даты
     * Способ корректировки:
     * выбор поля - Способ корректировки (активация списка значений)
     */
    @FindBy(css = "#type_correction-inputEl")
    private WebElement typeCorrection;

    /**
     * Способ корректировки:
     * Не корректировать
     */
    @FindBy(xpath = "//ul[@class='x-list-plain']/li[1]")
    private WebElement doNotAdjust;

    /**
     * Способ корректировки:
     * Установить время
     */
    @FindBy(xpath = "//ul[@class='x-list-plain']/li[2]")
    private WebElement setTime;

    /**
     * Способ корректировки:
     * Сместить в рабочем интервале
     */
    @FindBy(xpath = "//ul[@class='x-list-plain']/li[3]")
    private WebElement offsetInTheInterval;

    /**
     * Способ корректировки:
     * Сместить в периоде
     */
    @FindBy(xpath = "//ul[@class='x-list-plain']/li[4]")
    private WebElement offsetInThePeriod;

    /**
     * Запретить изменение типа для созданной задачи
     */
    @FindBy(xpath = "(//input[contains(@id,'checkbox')] [ancestor::div[contains(@id,'tabpanel')]])[2]")
    private WebElement typeChangeDisabled;

    /**
     * Создавать подзадачи ИРГ только родительского типа
     */
    @FindBy(xpath = "(//input[contains(@id,'checkbox')] [ancestor::div[contains(@id,'tabpanel')]])[3]")
    private WebElement sameTypeIWG;

    /**
     * Запретить закрытие задач с неготовыми контрольными точками
     */
    @FindBy(xpath = "(//input[contains(@id,'checkbox')] [ancestor::div[contains(@id,'tabpanel')]])[4]")
    private WebElement closingTasksWithNotReadyCheckpoints;

    /**
     * Открывать файлы для редактирования
     */
    @FindBy(css = "#files_edit-inputEl")
    private WebElement filesEdit;

    /**
     * Прикреплять файлы:
     * Лента действий
     */
    @FindBy(css = "#actiontape_attachments-inputEl")
    private WebElement attachFilesActionLine;

    /**
     * Прикреплять файлы:
     * Описание
     */
    @FindBy(css = "#description_attachments-inputEl")
    private WebElement attachFilesDescription;


    /**
     * МЕТОДЫ--------------------------------------------------------------------------------------------------------------------------------------------
     */

    //-----------------------------------------------------------------------------Вкладка - НАСТРОЙКИ---------------------------------------------------

    /**
     * Выбор вкладки - Настройки (Options)
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage clickSettingsTab() {
        settingsTab.click();
        return this;
    }

    /**
     * Направление смещения даты при попадании на нерабочее время
     */
    public TaskTypesEditPage directionOfDisplacementOfTheDate(ShiftDirection shiftdirection) {
        if (shiftdirection == DATE_MOVES_BACK) {
            clickDateMovesBack.click();
        } else if (shiftdirection == DATE_DOES_NOT_MOVE) {
            clickDateDoesNotMove.click();
        } else if (shiftdirection == DATE_MOVES_FORWARD) {
            clickDateMovesForward.click();
        }

        return this;
    }

    /**
     * Использовать ECP
     *
     * @param useSignature
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selUseECP(boolean useSignature) {
        if (useSignature) {
            useECP.click();
        }

        return this;
    }

    /**
     * Корректировка даты
     *
     * @param dateCorrection
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selDateCorrection(CorrectionMethod dateCorrection) {
        if (dateCorrection == CorrectionMethod.SET_TIME) {
            typeCorrection.click();
            selectingSecondAdjustmentPosition();
        } else if (dateCorrection == CorrectionMethod.OFFSET_IN_THE_INTERVAL) {
            typeCorrection.click();
            selectingThirdAdjustmentPosition();
        } else if (dateCorrection == CorrectionMethod.OFFSET_IN_THE_PERIOD) {
            typeCorrection.click();
            selectingFourthlyAdjustmentPosition();
        }

        return this;
    }

    /**
     * Запретить изменение типа для созданной задачи
     */
    public TaskTypesEditPage selIsTaskTypeChangeDisabled(boolean taskTypeChangeDisabled) {
        if (taskTypeChangeDisabled) {
            typeChangeDisabled.click();
        }
        return this;
    }

    /**
     * Создавать подзадачи ИРГ только родительского типа
     */
    public TaskTypesEditPage selOnlyTheSameTypeIWG(boolean onlyTheSameTypeIWG) {
        if (onlyTheSameTypeIWG) {
            sameTypeIWG.click();
        }
        return this;
    }

    /**
     * Запретить закрытие задач с неготовыми контрольными точками
     */
    public TaskTypesEditPage selIsCloseTaskWithNotReadyCheckpointsDisabled(boolean notReadyCheckpointsDisabled) {
        if (notReadyCheckpointsDisabled) {
            closingTasksWithNotReadyCheckpoints.click();
        }
        return this;
    }

    /**
     * Открывать файлы для редактирования
     *
     * @param filesForEdit
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selOpenFilesForEdit(OpenFilesForEdit filesForEdit) {
        if (filesForEdit == OpenFilesForEdit.YES) {
            filesEdit.click();
            selectingThirdAdjustmentPosition();
        } else if (filesForEdit == OpenFilesForEdit.NO) {
            filesEdit.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * @param actionLine
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selIsAttachFilesToActionLine(boolean actionLine) {
        if (actionLine) {
            attachFilesActionLine.click();
        }
        return this;
    }

    /**
     * @param decscription
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selIsAttachFilesToDescription(boolean decscription) {
        if (decscription) {
            attachFilesDescription.click();
        }
        return this;
    }

    //------------------------------------------------------------------------------------------------------------Вкладка - ПОЛЯ --------------------------------------------------

    /**
     * Выбор вкладки - Поля (Fields)
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage clickFieldsTab() {
        fieldsTab.click();
        return this;
    }

    /**
     * Клик кнопка - Добавить поле
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage addField() {
        clickOkAndAddFieldTypesObgect.click();
        return this;
    }

    /**
     * Поле - Название поля
     *
     * @param text
     * @return TypesOfTablesEditPage
     */
    public TaskTypesEditPage adNameField(String text) {
        nameField.clear();
        nameField.sendKeys(text);
        return this;
    }

    /**
     * Идентификатор поля
     *
     * @param identifier
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage adFieldID(String identifier) {
        nameIdentifier.clear();
        nameIdentifier.sendKeys(identifier);
        return this;
    }

    /**
     * Выбор Типа поля
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selTypeField() {
        typeField.click();
        return this;
    }

    /**
     * Обязательность поля
     *
     * @param oblField
     * @return
     */
    public TaskTypesEditPage selObligatoryField(ObligatoryFieldTypeTask oblField) {
        if (oblField == ObligatoryFieldTypeTask.OBLIGATORY_ON_CREATE) {
            obligatoryField.click();
            selectingSecondAdjustmentPosition();
        } else if (oblField == ObligatoryFieldTypeTask.OBLIGATORY_ON_CLOSE) {
            obligatoryField.click();
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать при поиске
     *
     * @return TypesOfTablesEditPage
     */
    public TaskTypesEditPage selIsHideInSearch(boolean hideInSearch) {
        if (hideInSearch) {
            isHideInSearch.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор из списка
     *
     * @return TypesOfTablesEditPage
     */
    public TaskTypesEditPage selFromList(boolean fromList) {
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
     * @return TypesOfTablesEditPage
     */
    public TaskTypesEditPage selListVal(String listVal) {
        fieldListVal.click();
        fieldListVal.sendKeys(listVal);
        return this;
    }

    /**
     * Сохранить поле объекта
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage clickSaveField() {
        saveField.click();
        clickYesCalculatNewValues(); /* исключение - срабатывает для полей типа Справочник при вводе - Шаблона отображения
        - alert - Вычислить новые значения для сохраненных полей */
        return this;
    }

    /**
     * Сохранить объект
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage clickSaveObject() {
        saveObject.click();
        clicAlertOk();
        return this;
    }

    //------------------------------------------------------------------------------------------Выбор Типов полей из выпадающего списка:-------------------------------------

    /**
     * СТРОКА
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldString() {
        typeFieldString.click();
        return this;
    }

    /**
     * ТЕКСТ
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldText() {
        typeFieldText.click();
        return this;
    }

    /**
     * ЦЕЛОЕ
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldInteger() {
        typeFieldInteger.click();
        return this;
    }

    /**
     * ВЕЩЕСТВЕННОЕ
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldDouble() {
        typeFieldDouble.click();
        return this;
    }

    /**
     * ДАТА
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldDate() {
        typeFieldData.click();
        return this;
    }

    /**
     * ССЫЛКА НА СПРАВОЧНИК
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldDirectory() {
        typeFieldReferenceToTheDictionary.click();
        return this;
    }

    /**
     * Выбор поля - Справочник (в форме редактирования поля - Сслыка и Множественная ссылка)
     *
     * @return
     */
    public TaskTypesEditPage selDirectory() {
        clickFieldDictionary.click();
        return this;
    }

    /**
     * Выбор поля - Поле (в форме редактирования поля - Сслыка и Множественная ссылка)
     *
     * @return TaskTypesEditPag
     */
    public TaskTypesEditPage selField() {
        waitMillisecond(0.3);
        selectField.click();
        return this;
    }

    /**
     * Выбор спр-ка из списка Спр-ов (поле - Справочник)
     *
     * @param directoryName
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage chooseDirectory(String directoryName) {
        clickFieldDictionary.click();
        $(By.xpath("//*[text()='" + directoryName + "']")).click();
        return this;
    }

    /**
     * Выбор поля ср-ка из списка ("Поле:" справочника/типы таблицы)
     *
     * @param directoryFieldName
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage chooseFieldDirectoryAndTable(String directoryFieldName) {
        waitMillisecond(0.5);
        selectField.click();
        $(By.xpath("//*[text()='" + directoryFieldName + "']")).click();
        return this;
    }

    /**
     * Шаблон отображения
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selDirectoryTemplate(String directoryTemplate) {
        dicTemplate.clear();
        dicTemplate.sendKeys(directoryTemplate);
        return this;
    }

    /**
     * Вычислить новые значения для сохраненных полей? - при вводе Шаблона отображения
     */
    public boolean clickYesCalculatNewValues() {
        try {
            (new WebDriverWait(getWebDriver(), 0, 50))
                    .until(ExpectedConditions.elementToBeClickable(By
                            .xpath("//div[contains(@id,'messagebox')]//div[count(a)=4]/a[2]//span[1]")));
            calculatNewValues.click();
            return true;
        } catch (TimeoutException to) {
            return false;
        }
    }

    /**
     * МНОЖЕСТВЕННАЯ ССЫЛКА
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldMultipleDictionary() {
        typeFieldMultipleReferenceToTheDictionary.click();
        return this;
    }

    /**
     * ЛОГИЧЕСКОЕ
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldBoolean() {
        typeFieldBoolean.click();
        return this;
    }

    /**
     * ССЫЛКА НА БИБЛИОТЕКУ
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldLibrarylink() {
        typeFieldLibrarylink.click();
        return this;
    }

    /**
     * ССЫЛКА НА ЗАДАЧУ
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldReferenceTask() {
        typeFieldReferenceTask.click();
        return this;
    }

    /**
     * НУМЕРАТОР
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldNumerator() {
        typeFieldNumerator.click();
        return this;
    }

    /**
     * Ввод Шаблона нумератора
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selNumeratorTemplate(String numeratorTemplate) {
        selNumeratorTemp.clear();
        selNumeratorTemp.sendKeys(numeratorTemplate);
        return this;
    }

    /**
     * Режим вычисления поля типа Нумертаор
     *
     * @param calculationMode
     * @return
     */
    public TaskTypesEditPage selCalculationMode(ComputeModeNumerator calculationMode) {
        if (calculationMode == ComputeModeNumerator.DONTCOMPUTE) {
            calculatMode.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * ССЫЛКА НА ОБЪЕКТ
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldLinkObject() {
        typeFieldLinkObject.click();
        return this;
    }

    /**
     * ТАБЛИЦА
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selectTypeFieldTable() {
        typeFieldTable.click();
        return this;
    }

    /**
     * Клик в поле "Таблица:"
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage selFieldTable() {
        fieldTable.click();
        return this;
    }

    /**
     * Выбор Таблица из списка
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage chooseTable(String tableName) {
        fieldTable.click();
        $(By.xpath("//*[text()='" + tableName + "']")).click();
        return this;
    }

    /**
     * Проверяем отображение в гриде полей
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage verifyFieldInGrid(String fieldName) {
        waitForPageUntilElementIsVisible(
                By.xpath("//table[contains(@id,'gridview')]//td[1]/div[text()='" + fieldName + "']"),
                5000);
        return this;
    }


    /**
     * ----------------------------------------------------------------------------Метод добавления всех типов полей--------------------------------
     *
     * @param fieldsTaskTypes
     * @return
     */
    public TaskTypesEditPage addAllFieldsTaskTypes(TasksTypesField[] fieldsTaskTypes) {
        if (fieldsTaskTypes == null) {
            return null;
        } else
            outer:
                    for (TasksTypesField fieldTaskTypes : fieldsTaskTypes) {
                        addField(); // Добавить поле
                        adNameField(fieldTaskTypes.getFieldName()); // заполняем Название поля документа из массива
                        adFieldID(fieldTaskTypes.getFieldID()); // заполняем Идентификатор поля из массива
                        selTypeField(); // Выбор поля - Тип поля

                        // 1. СТРОКА
                        if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsString) {
                            selectTypeFieldString();
                            TypeListFieldsString fieldString = (TypeListFieldsString) fieldTaskTypes.getFieldType();
                            if (fieldString.getIsListChoice()) {
                                selFromList(fieldString.getIsListChoice()); // Выбор из списка
                                selListVal(fieldString.getValuesList()); // Список значений
                            } else if (!fieldString.getIsListChoice()) {
                                selListVal(fieldString.getValuesList()); // Список значений
                            }
                            // 2. ТЕКСТ
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsText) {
                            selectTypeFieldText();
                            TypeListFieldsText fieldText = (TypeListFieldsText) fieldTaskTypes.getFieldType();
                            // 3. ЦЕЛОЕ
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsInt) {
                            selectTypeFieldInteger();
                            TypeListFieldsInt fieldInt = (TypeListFieldsInt) fieldTaskTypes.getFieldType();
                            // 4. ВЕЩЕСТВЕННОЕ
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsDouble) {
                            selectTypeFieldDouble();
                            TypeListFieldsDouble fieldsDouble = (TypeListFieldsDouble) fieldTaskTypes.getFieldType();
                            // 5. ДАТА
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsDate) {
                            selectTypeFieldDate();
                            TypeListFieldsDate fieldsDate = (TypeListFieldsDate) fieldTaskTypes.getFieldType();
                            // 7. СПРАВОЧНИК
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsDirectory) {
                            selectTypeFieldDirectory();
                            TypeListFieldsDirectory fieldsDir = (TypeListFieldsDirectory) fieldTaskTypes.getFieldType();
                            chooseDirectory(fieldsDir.getDirectories().getDirectoryName()); // Выбор спр-ка
                            chooseFieldDirectoryAndTable(fieldsDir.getFieldDirectory().getFieldName()); // Выбор поля спр-ка
                            selDirectoryTemplate(fieldsDir.getDisplayNameTemplate()); // Шаблон отображения
                            // 8. МНОЖЕСТВЕННАЯ ССЫЛКА НА СПР-К
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsMultiDirectory) {
                            selectTypeFieldMultipleDictionary();
                            TypeListFieldsMultiDirectory fieldsMultiDir = (TypeListFieldsMultiDirectory) fieldTaskTypes.getFieldType();
                            selDirectory(); // Выбор поля Спр-к
                            $(By.xpath("//*[text()='" + fieldsMultiDir.getDirectoryName() + "']")).click(); // Выбор справочника
                            selField(); // Выбор поля Поле
                            $(By.xpath("//li[text()='" + fieldsMultiDir.getNameDirectoryField() + "']")).click(); // Выбор поля справочника
                            selDirectoryTemplate(fieldsMultiDir.getDisplayNameTemplate()); // Шаблон отображения
                            // 8. ЛОГИЧЕСКОЕ
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsBoolean) {
                            selectTypeFieldBoolean();
                            TypeListFieldsBoolean fieldsDate = (TypeListFieldsBoolean) fieldTaskTypes.getFieldType();
                            // 9. ССЫЛКА НА БИБЛИОТЕКУ
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsLibraryLink) {
                            selectTypeFieldLibrarylink();
                            TypeListFieldsLibraryLink fieldsLibraryLink = (TypeListFieldsLibraryLink) fieldTaskTypes.getFieldType();
                            // 10. ССЫЛКА НА ЗАДАЧУ
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsReferenceTask) {
                            selectTypeFieldReferenceTask();
                            TypeListFieldsReferenceTask fieldsReferenceTask = (TypeListFieldsReferenceTask) fieldTaskTypes.getFieldType();
                            // 11. НУМЕРАТОР
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsNumerator) {
                            selectTypeFieldNumerator();
                            TypeListFieldsNumerator fieldsNumerator = (TypeListFieldsNumerator) fieldTaskTypes.getFieldType();
                            selNumeratorTemplate(fieldsNumerator.getNumeratorTemplate()); // Шаблон нумератора
                            selCalculationMode(fieldsNumerator.getComputeMode()); // Режим вычисления
                            // 12. ССЫЛКА НА ОБЪЕКТ
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsObjectLink) {
                            selectTypeFieldLinkObject();
                            TypeListFieldsObjectLink fieldsObjectLink = (TypeListFieldsObjectLink) fieldTaskTypes.getFieldType();
                            // 13. ТАБЛИЦА
                        } else if (fieldTaskTypes.getFieldType() instanceof TypeListFieldsTable) {
                            selectTypeFieldTable();
                            TypeListFieldsTable fieldsTable = (TypeListFieldsTable) fieldTaskTypes.getFieldType();
                            chooseTable(fieldsTable.getTypesOfTables().getTableTypeName()); // Выбор объекта - Таблица, из списка
                            chooseFieldDirectoryAndTable(fieldsTable.getFieldTable().getFieldName()); // Выбор поля объекта - Таблица, из списка
                            selDirectoryTemplate(fieldsTable.getNumeratorTemplate()); // Шаблон отображения
                        }

                        selObligatoryField(fieldTaskTypes.getObligatory()); // Обязательность поля
                        selIsHideInSearch(fieldTaskTypes.getIsHideInSearch()); // Скрывать при поиске
                        clickSaveField(); // Сохранить поле
                        verifyFieldInGrid(fieldTaskTypes.getFieldName()); // Проверяем отображение добавленного поля в гриде

                    }

        return this;
    }


    /**
     * Ожидание появления alert об успешном сохранении - Изменения сохранены;
     * Клик alert
     *
     * @return TaskTypesEditPage
     */
    public TaskTypesEditPage clicAlertOk() {
        waitForPageUntilElementIsVisible(
                By.xpath("//td[contains(@id,'messagebox')]/div[text()='Изменения сохранены']"), 5000);
        clicAlertOk.click();
        return this;
    }

    /**
     * Ожидание появления элементов на соответствующей странице
     */
    public TaskTypesEditPage waitingElementsTabFieldTypesOfTask() {
        $(By.xpath("//a/span[contains(@id, 'button-10')]")).shouldBe(Condition.present);
        $(By.id("bEditField-btnIconEl")).shouldBe(Condition.visible);
        $(By.id("bDeleteField-btnIconEl")).shouldBe(Condition.visible);
        return this;
    }


}