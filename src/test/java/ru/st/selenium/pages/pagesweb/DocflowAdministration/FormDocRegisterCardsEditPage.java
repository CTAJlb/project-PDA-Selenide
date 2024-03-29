package ru.st.selenium.pages.pagesweb.DocflowAdministration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.logicinterface.FormDocRegisterCardsEditLogic;
import ru.st.selenium.model.AccessRights;
import ru.st.selenium.model.DocflowAdministration.DocumentRegistrationCards.*;
import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.ShiftDirection;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Калсс, в к-м описываются все элементы указанные на странице редактирования Регистрационной карточки документа (РКД)
 */
public class FormDocRegisterCardsEditPage extends GridDocRegisterCardsPage implements FormDocRegisterCardsEditLogic {


    //-------------------------------------------------------------------------Дополнительные методы-----------------------------------------------------------------------------


    /**
     * Ожидание маски - при открытии формы редактирования
     */
    public FormDocRegisterCardsEditPage waitForTaskMaskDRC() {
        $(By.xpath("//div[contains(@id,'ext-element') and contains(@class,'mask')]")).shouldBe(disappear);
        return this;
    }

    //-----------------------------------------------------------------РКД------------------------------------------------------------------------

    /**
     * Вкладка - Общее
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[1]//span")
    private SelenideElement generalTab;

    /**
     * Вкладка - Права
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[2]//span")
    private SelenideElement rightsTab;

    /**
     * Вкладка - Маршруты согласования
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[3]//span")
    private SelenideElement connectedRoutesTab;

    /**
     * Вкладка - Обработчики
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[5]//span")
    private SelenideElement handlersTab;

    /**
     * Вкладка - Задачи
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[6]//span")
    private SelenideElement tasksTab;

    /**
     * Вкладка - Резолюции
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[7]//span")
    private SelenideElement resolutionsTab;

    /**
     * Вкладка - Настройки почтовых уведомлений
     */
    @FindBy(xpath = "(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[8]//span")
    private SelenideElement mailNotifyTemplatesSettingsTab;


    //----------------------------------------------------------------------------Вкладка - ОБЩЕЕ--------------------------------------------------------------------------------

    /**
     * Название регистрационной карточки документа
     */
    @FindBy(xpath = "//div[contains(@id,'textfield') and @data-ref='bodyEl']//input")
    private SelenideElement setNameDocRegCards;

    /**
     * Статусы документа: На рассмотрении
     */
    @FindBy(xpath = "(//table[@id][ancestor::fieldset[contains(@id,'fieldset')]]//td[3]/div)[1]")
    private SelenideElement clickDocumentStatesOnReview;

    /**
     * Статусы документа: Рассмотрен
     */
    @FindBy(xpath = "(//table[@id][ancestor::fieldset[contains(@id,'fieldset')]]//td[3]/div)[2]")
    private SelenideElement clickDocumentStatesReviewed;

    /**
     * Статусы документа: На подписании
     */
    @FindBy(xpath = "(//table[@id][ancestor::fieldset[contains(@id,'fieldset')]]//td[3]/div)[3]")
    private SelenideElement clickDocumentStatesOnApproval;

    /**
     * Статусы документа: На исполнении
     */
    @FindBy(xpath = "(//table[@id][ancestor::fieldset[contains(@id,'fieldset')]]//td[3]/div)[4]")
    private SelenideElement clickDocumentStatesOnExecution;

    /**
     * Статусы документа: В архив
     */
    @FindBy(xpath = "(//table[@id][ancestor::fieldset[contains(@id,'fieldset')]]//td[3]/div)[5]")
    private SelenideElement clickDocumentStatesInArchive;

    /**
     * Статусы документа
     */
    @FindBy(xpath = "//input[contains(@id,'textfield') and contains(@name,'status_text')][ancestor::fieldset[contains(@id,'fieldset')]]")
    private SelenideElement setValueDocumentStates;

    /**
     * Шаблон отображения
     */
    @FindBy(xpath = "(//input[contains(@id,'textfield')][ancestor::div[contains(@id,'container')]])[1]")
    private SelenideElement setDisplayNameTemplate;

    /**
     * Направление смещения даты при попадании на нерабочее время:
     * Дата не меняется
     *
     * @FindBy
     */
    @FindBy(xpath = "(//div[contains(@id,'radiofield-')]//span[@data-ref])[1]")
    private SelenideElement clickDateDoesNotMove;


    /**
     * Направление смещения даты при попадании на нерабочее время
     * Дата сдвигается вперед
     *
     * @FindBy
     */
    @FindBy(xpath = "(//div[contains(@id,'radiofield-')]//span[@data-ref])[2]")
    private SelenideElement clickDateMovesForward;

    /**
     * Направление смещения даты при попадании на нерабочее время
     * Дата сдвигается назад
     *
     * @FindBy
     */
    @FindBy(xpath = "(//div[contains(@id,'radiofield-')]//span[@data-ref])[3]")
    private SelenideElement clickDateMovesBack;

    /**
     * Настройки по умолчанию при отправке документа на доработку
     * Возврат на доработку с начала текущей схемы
     *
     * @FindBy
     */
    @FindBy(xpath = "(//span[contains(@id,'checkbox')]//../input[@role='checkbox']/../span)[1]")
    private SelenideElement clickAtFirstRevisionScheme;

    /**
     * Настройки по умолчанию при отправке документа на доработку
     * Возврат на доработку в ту же точку рассмотрения
     *
     * @FindBy
     */
    @FindBy(xpath = "(//span[contains(@id,'checkbox')]//../input[@role='checkbox']/../span)[2]")
    private SelenideElement clickForCompletionInTighterPoint;

    /**
     * Настройки по умолчанию при отправке документа на доработку
     * Возврат на доработку с новой схемой
     *
     * @FindBy
     */
    @FindBy(xpath = "(//span[contains(@id,'checkbox')]//../input[@role='checkbox']/../span)[3]")
    private SelenideElement clickOnCompletionTheNewScheme;


    /**
     * Открывать файлы для редактирования
     *
     * @FindBy
     */
    @FindBy(xpath = "(//input[contains(@id,'combo') and (@placeholder)])[1]")
    private SelenideElement clickOpenFilesForedit;

    /**
     * Автоматическое вычисление полей-нумераторов
     *
     * @FindBy
     */
    @FindBy(xpath = "(//input[contains(@id,'combo') and (@placeholder)])[2]")
    private SelenideElement clickAutoСalculationNumeratorFields;


    /**
     * Сохранить - все изменения по документу
     *
     * @FindBy
     */
    @FindBy(xpath = "(//a[contains(@id,'button')][ancestor::div[contains(@id,'toolbar') and contains(@class,'x-toolbar x-docked x-toolbar-default')]]//span[string-length(text())>=3])[1]")
    private SelenideElement clickSaveAllChangesInDocument;

    //----------------------------------------------------------------------------Вкладка - ПРАВА--------------------------------------------------------------------------------

    /**
     * Отображение - Личная
     *
     * @FindBy
     */
    @FindBy(xpath = "(//span[contains(@id,'radiofield-')][ancestor::fieldset])[4]")
    private SelenideElement clickPersonal;

    /**
     * Отображение - Общедоступная
     *
     * @FindBy
     */
    @FindBy(xpath = "(//span[contains(@id,'radiofield-')][ancestor::fieldset])[5]")
    private SelenideElement clickAccessAvailableToAll;

    /**
     * Отображение - Только для чтения
     *
     * @FindBy
     */
    @FindBy(xpath = "(//span[contains(@id,'radiofield-')][ancestor::fieldset])[6]")
    private SelenideElement clickReadOnly;


    /**
     * Изменение признака "Окончательная версия"
     * Автор документа
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset)[6]//div[count(div)=3]/div[1]//input")
    private SelenideElement authorFinalVersionFiles;

    /**
     * Изменение признака "Окончательная версия"
     * Пользователь с правами редактирования
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset)[6]//div[count(div)=3]/div[2]//input")
    private SelenideElement userWithEditRightFinalVersionFiles;

    /**
     * Изменение признака "Окончательная версия"
     * Контролер типа документа
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset)[6]//div[count(div)=3]/div[3]//input")
    private SelenideElement docTypeControllerFinalVersionFiles;

    /**
     * Редактирование своих документов
     * - На рассмотрении
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset)[7]//div[count(div)=3]/div[1]//input")
    private SelenideElement selEditionOwnDocumentsOnReview;

    /**
     * Редактирование своих документов
     * - На исполнении
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset)[7]//div[count(div)=3]/div[2]//input")
    private SelenideElement selEditionOwnDocumentsOnExecution;

    /**
     * Редактирование своих документов
     * - В архиве
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset)[7]//div[count(div)=3]/div[3]//input")
    private SelenideElement selEditionOwnDocumentsInArchive;

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Маршрут
     *
     * @FindBy
     */
    @FindBy(xpath = "((//fieldset)[8]//table//span[contains(@id,'checkbox')])[1]")
    private SelenideElement clickBoxAccessToSectionsDocumentRoute;

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Файлы
     *
     * @FindBy
     */
    @FindBy(xpath = "((//fieldset)[8]//table//span[contains(@id,'checkbox')])[2]")
    private SelenideElement clickBoxAccessToSectionsDocumentFiles;

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Резолюции
     *
     * @FindBy
     */
    @FindBy(xpath = "((//fieldset)[8]//table//span[contains(@id,'checkbox')])[3]")
    private SelenideElement clickBoxAccessToSectionsDocumentResolution;

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Журнал
     *
     * @FindBy
     */
    @FindBy(xpath = "((//fieldset)[8]//table//span[contains(@id,'checkbox')])[4]")
    private SelenideElement clickBoxAccessToSectionsDocumentLog;

    /**
     * Создание связанных документов
     *
     * @FindBy
     */
    @FindBy(xpath = "(//div[count(fieldset)=4]/div)[5]//input")
    private SelenideElement clickCreationOfLinkedDocuments;


    //----------------------------------------------------------------------------Вкладка - МАРШРУТЫ СОГЛАСОВАНИЯ--------------------------------------------------------------------------------

    /**
     * Использовать все возможные маршруты
     *
     * @FindBy
     */
    @FindBy(xpath = "//div[contains(@id,'checkbox')]//input[not(ancestor::fieldset)]")
    private SelenideElement clickCheckBoxUseAllPossibleRoutes;

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
    private SelenideElement typeFieldNumber;

    /**
     * Дата
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[2]")
    private SelenideElement typeFieldDate;

    /**
     * Строка
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[3]")
    private SelenideElement typeFieldString;

    /**
     * Выбор поля - Справочник для поля типа Строка/Текст/Справочник
     */
    @FindBy(xpath = "//input[@name='id_meta_dictionary']")
    private SelenideElement typeFieldStringOrTextDirectory;

    /**
     * Текст
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[4]")
    private SelenideElement typeFieldText;

    /**
     * Словарь
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[5]")
    private SelenideElement typeFieldDictionary;

    /**
     * Выбор поля Словарь для выбора значения
     */
    @FindBy(xpath = "//span[contains(@id,'button')]/span[string-length(text())>=5]/../../../..//div/input[@name='id_cataloguetype']")
    private SelenideElement clickFieldDictionary;

    /**
     * Подразделение
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[6]")
    private SelenideElement typeFieldDepartment;

    /**
     * Сотрудник
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[7]")
    private SelenideElement typeFieldEmployee;

    /**
     * Документ
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[8]")
    private SelenideElement typeFieldDocument;

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
    private SelenideElement typeFieldNumerator;

    /**
     * Шаблон нумератора
     */
    @FindBy(xpath = "//input[@name='numerator_template']")
    private SelenideElement numeratorTemplate;

    /**
     * Справочник
     */
    @FindBy(xpath = "(//ancestor::ul[contains(@id,'boundlist')])[1]/li[10]")
    private SelenideElement typeFieldDirectories;

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


    /*
     * =================================================================================================Вкладка - ЗАДАЧИ
     */

    /**
     * Копирование полей при создании задачи
     *
     * @FindBy
     */
    @FindBy(xpath = "//textarea[contains(@id,'textarea')]")
    private SelenideElement setCopyingFieldsWhenCreatingTask;

    /**
     * Поля документа, содержащие...
     * Авторов задач
     */
    @FindBy(xpath = "(//fieldset)[10]/div/div/descendant::input[1]")
    private SelenideElement setAuthorsObjectives;

    /**
     * Поля документа, содержащие...
     * Контролеров задач
     */
    @FindBy(xpath = "(//fieldset)[10]/div/div/descendant::input[2]")
    private SelenideElement setControllersOfTasks;

    /**
     * Поля документа, содержащие...
     * Ответственных руководителей задач
     */
    @FindBy(xpath = "(//fieldset)[10]/div/div/descendant::input[3]")
    private SelenideElement setDecisionMakersOfTasks;

    /**
     * Поля документа, содержащие...
     * Исполнителей задач
     */
    @FindBy(xpath = "(//fieldset)[10]/div/div/descendant::input[4]")
    private SelenideElement setExecutorsOfTasks;


    /*
     * =======================================================================================Вкладка - ОБЩЕЕ (методы)
     */

    /**
     * Производим выбор вкладки - Общее
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickGeneralTab() {
        waitMillisecond(0.7);
        $(By.xpath("(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[1]//span")).shouldHave(present);
        waitForTaskMaskDRC();
        generalTab.click();
        return this;
    }

    /**
     * Название - Регистрационной карточки документа
     */
    public FormDocRegisterCardsEditPage setNameDocRegisterCards(String text) {
        setNameDocRegCards.clear();
        setNameDocRegCards.setValue(text);
        return this;
    }

    /**
     * Вводим статус документа: На рассмотрении
     */
    public FormDocRegisterCardsEditPage adValueDocumentStatesOnReview(String statesOnReview) {
        if (statesOnReview == null) {
            return this;
        } else {
            clickDocumentStatesOnReview.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.setValue(statesOnReview);
        }
        return this;
    }

    /**
     * Вводим статус документа: Рассмотрен
     */
    public FormDocRegisterCardsEditPage adValueDocumentStatesReviewed(String statesReviewed) {
        if (statesReviewed == null) {
            return this;
        } else {
            clickDocumentStatesReviewed.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.setValue(statesReviewed);
        }
        return this;
    }

    /**
     * Вводим статус документа: На подписании
     */
    public FormDocRegisterCardsEditPage adValueDocumentStatesOnApproval(String statesOnApproval) {
        if (statesOnApproval == null) {
            return this;
        } else {
            clickDocumentStatesOnApproval.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.setValue(statesOnApproval);
        }
        return this;
    }

    /**
     * Вводим статус документа: На исполнении
     */
    public FormDocRegisterCardsEditPage adValueDocumentStatesOnExecution(String statesOnExecution) {
        if (statesOnExecution == null) {
            return this;
        } else {
            clickDocumentStatesOnExecution.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.setValue(statesOnExecution);
        }
        return this;
    }

    /**
     * Вводим статус документа: В архив
     */
    public FormDocRegisterCardsEditPage adValueDocumentStatesInArchive(String statesInArchive) {
        if (statesInArchive == null) {
            return this;
        } else {
            clickDocumentStatesInArchive.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.setValue(statesInArchive);
        }
        return this;
    }

    /**
     * Вводим - Шаблон отображения документа
     */
    public FormDocRegisterCardsEditPage addDisplayNameTemplate(String nameTemplate) {
        if (nameTemplate == null) {
            return this;
        } else {
            setDisplayNameTemplate.clear();
            setDisplayNameTemplate.setValue(nameTemplate);
        }
        return this;
    }

    /**
     * Направление смещения даты при попадании на нерабочее время
     */
    public FormDocRegisterCardsEditPage selDirectionOfDisplacementOfTheDate(ShiftDirection shiftDirection) {
        if (shiftDirection == null) {
            return this;
        } else if (shiftDirection == ShiftDirection.DATE_MOVES_BACK) {
            clickDateDoesNotMove.click();
        } else if (shiftDirection == ShiftDirection.DATE_DOES_NOT_MOVE) {
            clickDateMovesForward.click();
        } else if (shiftDirection == ShiftDirection.DATE_MOVES_FORWARD) {
            clickDateMovesBack.click();
        }
        return this;
    }

    /**
     * Возврат на доработку с начала текущей схемы
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selAtFirstRevisionScheme(boolean atFirstRevisionScheme) {
        if (atFirstRevisionScheme) {
            clickAtFirstRevisionScheme.click();
        }
        return this;
    }

    /**
     * Возврат на доработку в ту же точку рассмотрения
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selForCompletionInTighterPoint(boolean forCompletionInTighterPoint) {
        if (forCompletionInTighterPoint) {
            clickForCompletionInTighterPoint.click();
        }
        return this;
    }

    /**
     * Возврат на доработку с новой схемой
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selOnCompletionTheNewScheme(boolean onCompletionTheNewScheme) {
        if (onCompletionTheNewScheme) {
            clickOnCompletionTheNewScheme.click();
        }
        return this;
    }

    /**
     * Метод выбора открытия файлов для редактирования
     */
    public FormDocRegisterCardsEditPage selOpenFilesForEditDoc(OpenFilesForEdit openFilesForEdit) {
        if (openFilesForEdit == null) {
            return this;
        } else if (openFilesForEdit == OpenFilesForEdit.NO) {
            clickOpenFilesForedit.click();
            selectingSecondAdjustmentPosition();
        } else if (openFilesForEdit == OpenFilesForEdit.YES) {
            clickOpenFilesForedit.click();
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    /**
     * Автоматическое вычисление полей-нумераторов
     */
    public FormDocRegisterCardsEditPage selAutoСalculationNumeratorFields(OpenFilesForEdit autoСalculationNumeratorFields) {
        if (autoСalculationNumeratorFields == null) {
            return this;
        } else if (autoСalculationNumeratorFields == OpenFilesForEdit.NO) {
            clickAutoСalculationNumeratorFields.click();
            selectingSecondAdjustmentPosition();
        } else if (autoСalculationNumeratorFields == OpenFilesForEdit.YES) {
            clickAutoСalculationNumeratorFields.click();
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    //=======================================================================Вкладка - ПРАВА (методы)


    /**
     * Производим выбор вкладки - Права
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickRightsTab() {
        rightsTab.click();
        $(By.xpath("((//fieldset//table[contains(@id,'radiogroup')])[2]//div[contains(@id,'radio')]/..//input)[2]")).shouldBe(visible);
        return this;
    }

    /**
     * Метод выбора уровня доступа к РКД (Регистрационная карточка документа)
     */
    public FormDocRegisterCardsEditPage setRadioButtAccess(AccessRights accessRights) {
        switch (accessRights) {
            case AVAILABLETOALL:
                clickAccessAvailableToAll.click();
                break;
            case PERSONAL:
                clickPersonal.click();
                break;
            case READONLY:
                clickReadOnly.click();
                break;
        }
        return this;
    }

    /**
     * Изменение признака "Окончательная версия"
     * Автор документа:
     */
    public FormDocRegisterCardsEditPage setDocAuthorFinalVersionFiles(SettingsFinalVersion finalVersionChanging) {
        if (finalVersionChanging == null) {
            return this;
        } else if (finalVersionChanging == SettingsFinalVersion.NO) {
            authorFinalVersionFiles.click();
            selectingSecondAdjustmentPosition();
        } else if (finalVersionChanging == SettingsFinalVersion.YES) {
            authorFinalVersionFiles.click();
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    /**
     * Изменение признака "Окончательная версия"
     * Пользователь с правами редактирования:
     */
    public FormDocRegisterCardsEditPage setUserWithEditRightFinalVersionFiles(SettingsFinalVersion finalVersionChanging) {
        if (finalVersionChanging == null) {
            return this;
        } else if (finalVersionChanging == SettingsFinalVersion.NO) {
            userWithEditRightFinalVersionFiles.click();
            selectingSecondAdjustmentPosition();
        } else if (finalVersionChanging == SettingsFinalVersion.YES) {
            userWithEditRightFinalVersionFiles.click();
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    /**
     * Изменение признака "Окончательная версия"
     * Конролер типа документа:
     */
    public FormDocRegisterCardsEditPage setDocTypeControllerFinalVersionFiles(SettingsFinalVersion finalVersionChanging) {
        if (finalVersionChanging == null) {
            return this;
        } else if (finalVersionChanging == SettingsFinalVersion.NO) {
            docTypeControllerFinalVersionFiles.click();
            selectingSecondAdjustmentPosition();
        } else if (finalVersionChanging == SettingsFinalVersion.YES) {
            docTypeControllerFinalVersionFiles.click();
            selectingThirdAdjustmentPosition();
        }
        return this;
    }

    /**
     * Редактирование своих документов
     * - На рассмотрении
     */
    public FormDocRegisterCardsEditPage setEditionOwnDocumentsOnReview(EditionOwnDocuments editionOwnDocumentsOnReview) {
        if (editionOwnDocumentsOnReview == null) {
            return this;
        } else if (editionOwnDocumentsOnReview == EditionOwnDocuments.NO) {
            selEditionOwnDocumentsOnReview.click();
            selectingSecondAdjustmentPosition();
        } else if (editionOwnDocumentsOnReview == EditionOwnDocuments.YES) {
            selEditionOwnDocumentsOnReview.click();
            selectingThirdAdjustmentPosition();
        } else if (editionOwnDocumentsOnReview == EditionOwnDocuments.USER_RIGHT_EDIT_THEIR_DOCUMENTS) {
            selEditionOwnDocumentsOnReview.click();
            selectingFourthlyAdjustmentPosition();
        }
        return this;
    }

    /**
     * Редактирование своих документов
     * - На исполнении
     */
    public FormDocRegisterCardsEditPage setEditionOwnDocumentsOnExecution(EditionOwnDocuments editionOwnDocumentsOnExecution) {
        if (editionOwnDocumentsOnExecution == null) {
            return this;
        } else if (editionOwnDocumentsOnExecution == EditionOwnDocuments.NO) {
            selEditionOwnDocumentsOnExecution.click();
            selectingSecondAdjustmentPosition();
        } else if (editionOwnDocumentsOnExecution == EditionOwnDocuments.YES) {
            selEditionOwnDocumentsOnExecution.click();
            selectingThirdAdjustmentPosition();
        } else if (editionOwnDocumentsOnExecution == EditionOwnDocuments.USER_RIGHT_EDIT_THEIR_DOCUMENTS) {
            selEditionOwnDocumentsOnExecution.click();
            selectingFourthlyAdjustmentPosition();
        }
        return this;
    }

    /**
     * Редактирование своих документов
     * - В архиве
     */
    public FormDocRegisterCardsEditPage setEditionOwnDocumentsInArchive(EditionOwnDocuments editionOwnDocumentsInArchive) {
        if (editionOwnDocumentsInArchive == null) {
            return this;
        } else if (editionOwnDocumentsInArchive == EditionOwnDocuments.NO) {
            selEditionOwnDocumentsInArchive.click();
            selectingSecondAdjustmentPosition();
        } else if (editionOwnDocumentsInArchive == EditionOwnDocuments.YES) {
            selEditionOwnDocumentsInArchive.click();
            selectingThirdAdjustmentPosition();
        } else if (editionOwnDocumentsInArchive == EditionOwnDocuments.USER_RIGHT_EDIT_THEIR_DOCUMENTS) {
            selEditionOwnDocumentsInArchive.click();
            selectingFourthlyAdjustmentPosition();
        }
        return this;
    }


    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Маршрут
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentRoute(boolean checkBoxAccessToSectionsDocumentRoute) {
        if (checkBoxAccessToSectionsDocumentRoute) {
            clickBoxAccessToSectionsDocumentRoute.click();
        }
        return this;
    }

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Файлы
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentFiles(boolean checkBoxAccessToSectionsDocumentFiles) {
        if (checkBoxAccessToSectionsDocumentFiles) {
            clickBoxAccessToSectionsDocumentFiles.click();
        }
        return this;
    }

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Резолюции
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentResolution(boolean checkBoxAccessToSectionsDocumentResolution) {
        if (checkBoxAccessToSectionsDocumentResolution) {
            clickBoxAccessToSectionsDocumentResolution.click();
        }
        return this;
    }

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Журнал
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentLog(boolean checkBoxAccessToSectionsDocumentLog) {
        if (checkBoxAccessToSectionsDocumentLog) {
            clickBoxAccessToSectionsDocumentLog.click();
        }
        return this;
    }

    /**
     * Создание связанных документов
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage setCreationOfLinkedDocuments(CreationOfLinkedDocuments creationOfLinkedDocuments) {
        if (creationOfLinkedDocuments == null) {
            return this;
        } else if (creationOfLinkedDocuments == CreationOfLinkedDocuments.NO) {
            clickCreationOfLinkedDocuments.click();
            selectingSecondAdjustmentPosition();
        } else if (creationOfLinkedDocuments == CreationOfLinkedDocuments.USERS_WITH_RIGHT) {
            clickCreationOfLinkedDocuments.click();
            selectingThirdAdjustmentPosition();
        } else if (creationOfLinkedDocuments == CreationOfLinkedDocuments.USERS_WITH_RIGHT_LINKED_DOCUMENTS_CREATION) {
            clickCreationOfLinkedDocuments.click();
            selectingFourthlyAdjustmentPosition();
        }
        return this;
    }


    /*
     * ==========================================================================Вкладка - МАРШРУТЫ СОГЛАСОВАНИЯ (методы)
     */

    /**
     * Производим выбор вкладки - МС
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickConnectedRoutesTab() {
        connectedRoutesTab.click();
        $(By.xpath("//div[contains(@id,'selectionform')]//div[contains(@id,'gridview')]//table")).shouldBe(visible);
        return this;
    }

    /**
     * Производим выбор настройки - Использовать все МС
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickCheckBoxUseAllPossibleRoutes(boolean checkBoxUseAllPossibleRoutes) {
        if (checkBoxUseAllPossibleRoutes) {
            clickCheckBoxUseAllPossibleRoutes.click();
        }
        return this;
    }

    //===========================================================================================Вкладка - ПОЛЯ (методы)

    /**
     * Производим выбор вкладки - ПОЛЯ
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage fieldsTab() {
        fieldsTab.click();
        return this;
    }

    /**
     * Производим клик кнопки - Добавить поле
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickAddFieldDoc() {
        addFieldDoc.click();
        return this;
    }

    /**
     * Название поля
     *
     * @param fieldName
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage setFieldNameDoc(String fieldName) {
        nameFieldDoc.clear();
        nameFieldDoc.setValue(fieldName);
        return this;
    }

    /**
     * Идентификатор поля
     *
     * @param identifierField
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage setFieldIDDoc(String identifierField) {
        if (identifierField == null) {
            return this;
        } else {
            idFieldDoc.clear();
            idFieldDoc.setValue(identifierField);
        }
        return this;
    }

    /**
     * Выбор поля - Тип поля
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage fetchTypeField() {
        clickFieldTypeField.click();
        return this;
    }

    /**
     * Изменяемое при редактировании
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selEditableFieldDoc(boolean editableField) {
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
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selDirectoryTemplate(String dirTemplate) {
        if (dirTemplate == null) {
            return this;
        } else {
            directoryTemplate.clear();
            directoryTemplate.setValue(dirTemplate);
        }
        return this;
    }

    /**
     * Длина поля
     *
     * @param lengthField
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage fieldLength(String lengthField) {
        if (lengthField == null) {
            return this;
        } else {
            fieldLength.clear();
            fieldLength.setValue(lengthField);
        }
        return this;
    }

    /**
     * Выбор только из справочника
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selOnlyFromDictionary(boolean onlyFromDictionary) {
        if (!onlyFromDictionary) {
            this.selOnlyFromDictionary.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Обязательное при создании
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selObligatoryFieldDoc(ObligatoryFieldDocument obligatoryFieldDocumentDoc) {
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
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selUniqueFieldDoc(boolean uniqueField) {
        if (uniqueField) {
            this.uniqueField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать при создании
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selHideForCreation(boolean hideForCreation) {
        if (hideForCreation) {
            this.hideForCreation.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать в таблицах
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selHideInTables(boolean hideInTables) {
        if (hideInTables) {
            this.hideInTables.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать при поиске
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selHideForSearch(boolean hideForSearch) {
        if (hideForSearch) {
            this.hideForSearch.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Скрывать в карточке
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selHideInCards(boolean hideInCards) {
        if (hideInCards) {
            this.hideInCards.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Использовать при создании связанного документа
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selUsedToCreateTheLinkedDocumentField(boolean usedToCreateTheLinkedDocumentField) {
        if (usedToCreateTheLinkedDocumentField) {
            this.usedToCreateTheLinkedDocumentField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /*
     * =========================================================================================Вкладка - ПОЛЯ - Выбор типов полей (методы)
     */

    /**
     * Выбор поля типа Число
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selectFieldTypeNumber() {
        typeFieldNumber.click();
        return this;
    }

    /**
     * Выбор поля типа Дата
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selectFieldTypeDate() {
        typeFieldDate.click();
        return this;
    }

    /**
     * Выбор поля типа Строка
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selectFieldTypeString() {
        typeFieldString.click();
        return this;
    }

    /**
     * Выбор Справочника для полей типа Строка/Текст
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage chooseTypeFieldStringTextOrDirectory() {
        typeFieldStringOrTextDirectory.click();
        return this;
    }

    /**
     * Изменяемое при создании
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selEditionAvailableWhileCreationField(boolean editAvailableWhileCreationField) {
        if (!editAvailableWhileCreationField) {
            this.editionAvailableWhileCreationField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор поля типа Текст
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selectFieldTypeText() {
        typeFieldText.click();
        return this;
    }

    /**
     * Выбор поля типа Словарь
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selectFieldTypeDictionary() {
        typeFieldDictionary.click();
        return this;
    }

    /**
     * Выбор поля Словарь - для выбора значения типа Словарь
     *
     * @param dictionaryEditorName
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage chooseFieldDictionary(String dictionaryEditorName) {
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
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selectFieldTypeDepartment() {
        typeFieldDepartment.click();
        return this;
    }

    /**
     * Выбор поля типа Сотрудник
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selectFieldTypeEmployee() {
        typeFieldEmployee.click();
        return this;
    }

    /**
     * Выбор значения - Контролер документа == Да
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selValueDocumentSuperviser(boolean valueDocumentSuperviser) {
        if (valueDocumentSuperviser) {
            this.clickDocumentSuperviserField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор значения - Сотрудник - Значение по умолчанию == Текущий пользователь; Дата - Значение по умолчанию == Текущая дата;
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selDefaultValueField(boolean defValueField) {
        if (defValueField) {
            this.defValueField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Выбор значения - Для сведения == Да
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selForInformationField(boolean forInformationField) {
        if (forInformationField) {
            this.forInformationField.click();
            selectingSecondAdjustmentPosition();
        }
        return this;
    }

    /**
     * Шаблон отображения
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage setDisplayNameTemplateField(String disNameTemplateField) {
        if (disNameTemplateField == null) {
            return this;
        } else {
            displayNameTemplateField.clear();
            displayNameTemplateField.setValue(disNameTemplateField);
        }
        return this;
    }

    /**
     * Выбор поля типа Документ
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selFieldTypeDocument() {
        typeFieldDocument.click();
        return this;
    }

    /**
     * Выбор вкладки - Поиск (фильтрация документов)
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selTabSearch() {
        tabSearch.click();
        return this;
    }

    /**
     * Выбор вкладки - Поля (фильтрация документов)
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selTabFields() {
        tabFields.click();
        return this;
    }

    /**
     * Выбор настройки - Искать похожие документы
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selSearchSimiliarDocuments(boolean searchSimiliarDoc) {
        if (searchSimiliarDoc)
            this.searchSimiliarDocuments.click();
        selectingSecondAdjustmentPosition();
        return this;
    }

    /**
     * Правила поиска (фильтрация документов)
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage enSearchRulesTemplate(String searchRules) {
        if (searchRules == null) {
            return this;
        } else {
            searchRulesTemplate.clear();
            searchRulesTemplate.setValue(searchRules);
        }
        return this;
    }

    /**
     * Выбор поля типа Нумератор
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selFieldTypeNumerator() {
        typeFieldNumerator.click();
        return this;
    }

    /**
     * Шаблон нумератора
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage enNumeratorTemplateField(String numeratorTemplateField) {
        if (numeratorTemplateField == null) {
            return this;
        } else {
            numeratorTemplate.clear();
            numeratorTemplate.setValue(numeratorTemplateField);
        }
        return this;
    }

    /**
     * Выбор поля типа Справочник
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selFieldTypeDirectory() {
        typeFieldDirectories.click();
        return this;
    }

    /**
     * Выбор поля Справочник - для выбора значения типа Справочник
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickFieldDirectory() {
        typeFieldStringOrTextDirectory.click();
        return this;
    }

    /**
     * Выбор спр-ка из списка Спр-ов (поле - Справочник)
     *
     * @param directoryName
     * @return TaskTypesEditPage
     */
    public FormDocRegisterCardsEditPage chooseDirectory(String directoryName) {
        if (directoryName == null) {
            return this;
        } else {
            typeFieldStringOrTextDirectory.click();
            $(By.xpath("//*[text()='" + directoryName + "']")).click();
        }
        return this;
    }

    /**
     * Выбор настройки мульти выбора записей справочника
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage selMultipleRecords(boolean multipleRecords) {
        if (!multipleRecords) {
            this.directoryEntriesSelectionField.click();
            selectingSecondAdjustmentPosition();
        }

        return this;
    }

    /**
     * Сохранить поле
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage saveFieldDoc() {
        clickButtonSaveField.click();
        return this;
    }

    /**
     * Метод добавления всех типов полей документа
     *
     * @param fieldsDocs
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage addAllFieldsDoc(DocRegisterCardsField[] fieldsDocs) {
        if (fieldsDocs == null) {
            return null;
        } else
            outer:
                    for (DocRegisterCardsField fieldDoc : fieldsDocs) {
                        clickAddFieldDoc(); // Добавить поле
                        setFieldNameDoc(fieldDoc.getFieldNameDoc()); // Заполняем Название поля документа из массива
                        setFieldIDDoc(fieldDoc.getFieldIdentifierDoc()); // Заполняем Идентификатор поля из массива
                        fetchTypeField(); // Выбор поля - Тип поля

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

                        // Перемещение поля типа СТРОКА - вверх
                        if (fieldDoc.getFieldTypeDoc() instanceof FieldTypeStringDoc) {
                            for (int i = 0; i < 10; i++) moveFieldUp.click();
                        }

                        // Проверяем отображение добавленного поля в гриде
                        $(By.xpath("//table[contains(@id,'treeview')]//td[1]/div[text()='" + fieldDoc.getFieldNameDoc() + "']")).shouldBe(Condition.exactText("" + fieldDoc.getFieldNameDoc() + ""));

                    }

        return this;
    }


    /*
     * ===================================================================================Вкладка - ЗАДАЧИ (методы)
     */

    /**
     * Выбор вкладки - Задачи
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickTasksTab() {
        tasksTab.click();
        $(By.xpath("//span[string-length(text())>=10]/../../div//textarea")).shouldBe(visible);
        return this;
    }

    /**
     * Копирование полей при создании задачи
     */
    public FormDocRegisterCardsEditPage setCopyingFieldsWhenCreatingTask(String сopyingFieldsWhenCreatingTask) {
        if (сopyingFieldsWhenCreatingTask == null) {
            return this;
        } else {
            setCopyingFieldsWhenCreatingTask.clear();
            setCopyingFieldsWhenCreatingTask.setValue(сopyingFieldsWhenCreatingTask);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Авторов задач
     */
    public FormDocRegisterCardsEditPage setAuthorsObjectives(String authorsObjectives) {
        if (authorsObjectives == null) {
            return this;
        } else {
            setAuthorsObjectives.clear();
            setAuthorsObjectives.setValue(authorsObjectives);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Контролеров задач
     */
    public FormDocRegisterCardsEditPage setControllersOfTasks(String controllersOfTasks) {
        if (controllersOfTasks == null) {
            return this;
        } else {
            setControllersOfTasks.clear();
            setControllersOfTasks.setValue(controllersOfTasks);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Ответственных руководителей задач
     */
    public FormDocRegisterCardsEditPage setDecisionMakersOfTasks(String decisionMakersOfTasks) {
        if (decisionMakersOfTasks == null) {
            return this;
        } else {
            setDecisionMakersOfTasks.clear();
            setDecisionMakersOfTasks.setValue(decisionMakersOfTasks);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Исполнителей задач
     */
    public FormDocRegisterCardsEditPage setExecutorsOfTasks(String executorsOfTasks) {
        if (executorsOfTasks == null) {
            return this;
        } else {
            setExecutorsOfTasks.clear();
            setExecutorsOfTasks.setValue(executorsOfTasks);
        }
        return this;
    }


    /**
     * Сохранить изменения по документу
     *
     * @return FormDocRegisterCardsEditPage
     */
    public FormDocRegisterCardsEditPage clickSaveAllChangesInDoc() {
        clickSaveAllChangesInDocument.click();
        return this;
    }


    /**
     * Добавление настроек РКД
     *
     * @param registerCards
     * @return
     */
    @Override
    public void addSettingsDocRegisterCards(DocRegisterCards registerCards) {
        waitForTaskMaskDRC();
        appearanceOfElementsInFormOfEditingCards(); // Ожидание появление элементов на стр-це
        /*
         * ==========================================================================================================вкладка - Общее
          */
        clickGeneralTab()
                .setNameDocRegisterCards(registerCards.getDocRegisterCardsName()); // Название РКД
        // Статусы документа
        adValueDocumentStatesOnReview(registerCards.getDocumentStatesOnReview()) // - На рассмотрении
                .adValueDocumentStatesReviewed(registerCards.getDocumentStatesReviewed()) // - Рассмотрен
                .adValueDocumentStatesOnApproval(registerCards.getDocumentStatesOnApproval()) // - На подписании
                .adValueDocumentStatesOnExecution(registerCards.getDocumentStatesOnExecution())  // - На исполнении
                .adValueDocumentStatesInArchive(registerCards.getDocumentStatesInArchive()); // - В архиве
        // Шаблон отображения (Название документа)
        addDisplayNameTemplate(registerCards.getDisplayNameTemplate());

        // Направление смещения даты при попадании на нерабочее время
        selDirectionOfDisplacementOfTheDate(registerCards.getDocRegisterCardsShiftDirection());

        // TODO корректировка даты

        // Настройки по умолчанию при отправке документа на доработку:
        selAtFirstRevisionScheme(registerCards.getAtFirstRevisionScheme()) // Возврат на доработку с начала текущей схемы
                .selForCompletionInTighterPoint(registerCards.getForCompletionInTighterPoint()) // Возврат на доработку в ту же точку рассмотрения
                .selOnCompletionTheNewScheme(registerCards.getOnCompletionTheNewScheme()); // Возврат на доработку с новой схемой

        // Открывать файлы для редактирования
        selOpenFilesForEditDoc(registerCards.getOpenFilesForEditDoc());

        // Автоматическое вычисление полей-нумераторов
        selAutoСalculationNumeratorFields(registerCards.getAutoСalculationNumeratorFields());

        /*
         * =====================================================================================================производим выбор вкладки - Права
          */
        clickRightsTab()

                // выбираем Доступ к Объекту
                .setRadioButtAccess(registerCards.getAccessDoc());

        // Изменение признака "Окончательная версия"
        setDocAuthorFinalVersionFiles(registerCards.getDocAuthorFinalVersionFiles()) // Автор документа
                .setUserWithEditRightFinalVersionFiles(registerCards.getUserWithEditRightFinalVersionFiles()) // Пользователь с правами редактирования
                .setDocTypeControllerFinalVersionFiles(registerCards.getDocTypeControllerFinalVersionFiles()); // Контролер типа документа

        // Редактирование своих документов
        setEditionOwnDocumentsOnReview(registerCards.getEditionOwnDocumentsOnReview()) //  - На рассмотрении
                .setEditionOwnDocumentsOnExecution(registerCards.getEditionOwnDocumentOnExecution()) // - На исполнении
                .setEditionOwnDocumentsInArchive(registerCards.getEditionOwnDocumentInArchive()); // - В архиве

        // Доступ к разделам документа при просмотре/редактировании
        clickCheckBoxAccessToSectionsDocumentRoute(registerCards.getAccessToSectionsDocumentRoute()) // - Маршрут
                .clickCheckBoxAccessToSectionsDocumentFiles(registerCards.getAccessToSectionsDocumentFiles()) // - Файлы
                .clickCheckBoxAccessToSectionsDocumentResolution(registerCards.getAccessToSectionsDocumentResolution()) // - Резолюции
                .clickCheckBoxAccessToSectionsDocumentLog(registerCards.getAccessToSectionsDocumentLog()); // - Журнал

        // Создание связанных документов
        setCreationOfLinkedDocuments(registerCards.getCreationOfLinkedDocuments());

        /*
          * ====================================================================================================Выбор вкладки - Маршруты согласования
          */
        clickConnectedRoutesTab()
                .clickCheckBoxUseAllPossibleRoutes(registerCards.getCheckBoxUseAllPossibleRoutes()); // Производим выбор настройки - Использовать все МС

        /*
         * =====================================================================================================Вкладка Задачи
         */
        clickTasksTab()
                .setCopyingFieldsWhenCreatingTask(registerCards.getCopyingFieldsWhenCreatingATask()) // Копирование полей при создании задачи

                // Поля документа, содержащие...:
                .setAuthorsObjectives(registerCards.getAuthorsObjectives()) // авторов задач
                .setControllersOfTasks(registerCards.getControllersOfTasks()) // контролеров задач
                .setDecisionMakersOfTasks(registerCards.getDecisionMakersOfTasks()) // ответственных руководителей задач
                .setExecutorsOfTasks(registerCards.getExecutorsOfTasks()); // исполнителей задач

    }


    /**
     * Метод добавлений полей документа
     *
     * @param registerCards
     */
    @Override
    public void addFieldsDocRegisterCards(DocRegisterCards registerCards) {
        fieldsTab() // выбор вкладки "Поля"
                .addAllFieldsDoc(registerCards.getDocRegisterCardsFields());
    }

    /**
     * Сохранить изменения в РКД
     *
     * @return
     */
    public GridDocRegisterCardsPage saveAllChangesInDoc(DocRegisterCards registerCards) {
        clickSaveAllChangesInDoc(); // Сохранить все изменения РКД
        ensurePageLoaded();
        verifyDocRegisterCards(registerCards.getDocRegisterCardsName()); // Проверка - Создание и отображение РКД в гриде
        gotoTopFrem();
        return page(GridDocRegisterCardsPage.class);
    }


    /**
     * Ожидание появления элемента(\ов) в форме редактирования - Регистрационные
     * карточки документов -Вкладка Общее -Текст на вкладке - Общее
     */
    public FormDocRegisterCardsEditPage appearanceOfElementsInFormOfEditingCards() {
        $(By.xpath("(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[1]//span")).shouldBe(visible);
        $(By.xpath("//span[string-length(span[text()])>=2]")).shouldBe(visible);
        return this;
    }


}