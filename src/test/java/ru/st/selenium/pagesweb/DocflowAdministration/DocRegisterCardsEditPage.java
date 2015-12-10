package ru.st.selenium.pagesweb.DocflowAdministration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.modelweb.AccessRights;
import ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards.CreationOfLinkedDocuments;
import ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards.EditionOwnDocuments;
import ru.st.selenium.modelweb.DocflowAdministration.DocumentRegistrationCards.SettingsFinalVersion;
import ru.st.selenium.modelweb.OpenFilesForEdit;
import ru.st.selenium.modelweb.ShiftDirection;


import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Калсс, в к-м описываются все элементы указанные на странице редактирования Регистрационной карточки документа (РКД)
 */
public class DocRegisterCardsEditPage extends DocRegisterCardsPage {


    //-------------------------------------------------------------------------Дополнительные методы-----------------------------------------------------------------------------


    /**
     * Ожидание маски - при открытии формы редактирования
     */
    public DocRegisterCardsEditPage waitForTaskMaskDRC() {
        waitMillisecond(0.3);
       $(By.xpath("//div[contains(@id,'ext-element') and contains(@class,'mask')]")).shouldBe(Condition.disappear);
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
    @FindBy(xpath = "//div[contains(@id,'radiogroup')]//td[count(div)=3]/div[1]//input")
    private SelenideElement clickDateDoesNotMove;


    /**
     * Направление смещения даты при попадании на нерабочее время
     * Дата сдвигается вперед
     *
     * @FindBy
     */
    @FindBy(xpath = "//div[contains(@id,'radiogroup')]//td[count(div)=3]/div[2]//input")
    private SelenideElement clickDateMovesForward;

    /**
     * Направление смещения даты при попадании на нерабочее время
     * Дата сдвигается назад
     *
     * @FindBy
     */
    @FindBy(xpath = "//div[contains(@id,'radiogroup')]//td[count(div)=3]/div[3]//input")
    private SelenideElement clickDateMovesBack;

    /**
     * Возврат на доработку с начала текущей схемы
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset//input[contains(@id,'checkbox') and contains(@role,'checkbox')])[1]")
    private SelenideElement clickAtFirstRevisionScheme;

    /**
     * Возврат на доработку в ту же точку рассмотрения
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset//input[contains(@id,'checkbox') and contains(@role,'checkbox')])[2]")
    private SelenideElement clickForCompletionInTighterPoint;

    /**
     * Возврат на доработку с новой схемой
     *
     * @FindBy
     */
    @FindBy(xpath = "(//fieldset//input[contains(@id,'checkbox') and contains(@role,'checkbox')])[3]")
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
    @FindBy(xpath = "((//fieldset//table[contains(@id,'radiogroup')])[2]//div[contains(@id,'radio')]/..//input)[1]")
    private SelenideElement clickPersonal;

    /**
     * Отображение - Общедоступная
     *
     * @FindBy
     */
    @FindBy(xpath = "((//fieldset//table[contains(@id,'radiogroup')])[2]//div[contains(@id,'radio')]/..//input)[2]")
    private SelenideElement clickAccessAvailableToAll;

    /**
     * Отображение - Только для чтения
     *
     * @FindBy
     */
    @FindBy(xpath = "((//fieldset//table[contains(@id,'radiogroup')])[2]//div[contains(@id,'radio')]/..//input)[3]")
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
    @FindBy(xpath = "(//table[contains(@id,'checkboxgroup')])[2]//div[1]//input")
    private SelenideElement clickBoxAccessToSectionsDocumentRoute;

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Файлы
     *
     * @FindBy
     */
    @FindBy(xpath = "(//table[contains(@id,'checkboxgroup')])[2]//div[2]//input")
    private SelenideElement clickBoxAccessToSectionsDocumentFiles;

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Резолюции
     *
     * @FindBy
     */
    @FindBy(xpath = "(//table[contains(@id,'checkboxgroup')])[2]//div[3]//input")
    private SelenideElement clickBoxAccessToSectionsDocumentResolution;

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Журнал
     *
     * @FindBy
     */
    @FindBy(xpath = "(//table[contains(@id,'checkboxgroup')])[2]//div[4]//input")
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


    //----------------------------------------------------------------------------Вкладка - ЗАДАЧИ-----------------------------------------------------------------------

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


    //----------------------------------------------------------------------------Вкладка - ОБЩЕЕ (методы)-----------------------------------------------------------

    /**
     * Производим выбор вкладки - Общее
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickGeneralTab() {
        waitMillisecond(0.7);
        $(By.xpath("(//div[contains(@id,'tabbar')]/following-sibling::*)[1]//a[1]//span")).shouldHave(Condition.present);
        waitForTaskMaskDRC();
        generalTab.click();
        return this;
    }

    /**
     * Название - Регистрационной карточки документа
     */
    public DocRegisterCardsEditPage setNameDocRegisterCards(String text) {
        setNameDocRegCards.clear();
        setNameDocRegCards.sendKeys(text);
        return this;
    }

    /**
     * Вводим статус документа: На рассмотрении
     */
    public DocRegisterCardsEditPage adValueDocumentStatesOnReview(String statesOnReview) {
        if (statesOnReview == null) {
            return this;
        } else {
            clickDocumentStatesOnReview.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.sendKeys(statesOnReview);
        }
        return this;
    }

    /**
     * Вводим статус документа: Рассмотрен
     */
    public DocRegisterCardsEditPage adValueDocumentStatesReviewed(String statesReviewed) {
        if (statesReviewed == null) {
            return this;
        } else {
            clickDocumentStatesReviewed.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.sendKeys(statesReviewed);
        }
        return this;
    }

    /**
     * Вводим статус документа: На подписании
     */
    public DocRegisterCardsEditPage adValueDocumentStatesOnApproval(String statesOnApproval) {
        if (statesOnApproval == null) {
            return this;
        } else {
            clickDocumentStatesOnApproval.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.sendKeys(statesOnApproval);
        }
        return this;
    }

    /**
     * Вводим статус документа: На исполнении
     */
    public DocRegisterCardsEditPage adValueDocumentStatesOnExecution(String statesOnExecution) {
        if (statesOnExecution == null) {
            return this;
        } else {
            clickDocumentStatesOnExecution.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.sendKeys(statesOnExecution);
        }
        return this;
    }

    /**
     * Вводим статус документа: В архив
     */
    public DocRegisterCardsEditPage adValueDocumentStatesInArchive(String statesInArchive) {
        if (statesInArchive == null) {
            return this;
        } else {
            clickDocumentStatesInArchive.click();
            setValueDocumentStates.clear();
            setValueDocumentStates.sendKeys(statesInArchive);
        }
        return this;
    }

    /**
     * Вводим - Шаблон отображения документа
     */
    public DocRegisterCardsEditPage selDisplayNameTemplate(String nameTemplate) {
        if (nameTemplate == null) {
            return this;
        } else {
            setDisplayNameTemplate.clear();
            setDisplayNameTemplate.sendKeys(nameTemplate);
        }
        return this;
    }

    /**
     * Направление смещения даты при попадании на нерабочее время
     */
    public DocRegisterCardsEditPage selDirectionOfDisplacementOfTheDate(ShiftDirection shiftDirection) {
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
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage selAtFirstRevisionScheme(boolean atFirstRevisionScheme) {
        if (atFirstRevisionScheme) {
            clickAtFirstRevisionScheme.click();
        }
        return this;
    }

    /**
     * Возврат на доработку в ту же точку рассмотрения
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage selForCompletionInTighterPoint(boolean forCompletionInTighterPoint) {
        if (forCompletionInTighterPoint) {
            clickForCompletionInTighterPoint.click();
        }
        return this;
    }

    /**
     * Возврат на доработку с новой схемой
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage selOnCompletionTheNewScheme(boolean onCompletionTheNewScheme) {
        if (onCompletionTheNewScheme) {
            clickOnCompletionTheNewScheme.click();
        }
        return this;
    }

    /**
     * Метод выбора открытия файлов для редактирования
     */
    public DocRegisterCardsEditPage selOpenFilesForEditDoc(OpenFilesForEdit openFilesForEdit) {
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
    public DocRegisterCardsEditPage selAutoСalculationNumeratorFields(OpenFilesForEdit autoСalculationNumeratorFields) {
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

    //----------------------------------------------------------------------------Вкладка - ПРАВА (методы)--------------------------------------------------------------------------------


    /**
     * Производим выбор вкладки - Права
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickRightsTab() {
        rightsTab.click();
        $(By.xpath("((//fieldset//table[contains(@id,'radiogroup')])[2]//div[contains(@id,'radio')]/..//input)[2]")).shouldBe(Condition.visible);
        return this;
    }

    /**
     * Метод выбора уровня доступа к РКД (Регистрационная карточка документа)
     */
    public DocRegisterCardsEditPage setRadioButtAccess(AccessRights accessRights) {
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
    public DocRegisterCardsEditPage setDocAuthorFinalVersionFiles(SettingsFinalVersion finalVersionChanging) {
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
    public DocRegisterCardsEditPage setUserWithEditRightFinalVersionFiles(SettingsFinalVersion finalVersionChanging) {
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
    public DocRegisterCardsEditPage setDocTypeControllerFinalVersionFiles(SettingsFinalVersion finalVersionChanging) {
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
    public DocRegisterCardsEditPage setEditionOwnDocumentsOnReview(EditionOwnDocuments editionOwnDocumentsOnReview) {
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
    public DocRegisterCardsEditPage setEditionOwnDocumentsOnExecution(EditionOwnDocuments editionOwnDocumentsOnExecution) {
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
    public DocRegisterCardsEditPage setEditionOwnDocumentsInArchive(EditionOwnDocuments editionOwnDocumentsInArchive) {
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
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentRoute(boolean checkBoxAccessToSectionsDocumentRoute) {
        if (checkBoxAccessToSectionsDocumentRoute) {
            clickBoxAccessToSectionsDocumentRoute.click();
        }
        return this;
    }

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Файлы
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentFiles(boolean checkBoxAccessToSectionsDocumentFiles) {
        if (checkBoxAccessToSectionsDocumentFiles) {
            clickBoxAccessToSectionsDocumentFiles.click();
        }
        return this;
    }

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Резолюции
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentResolution(boolean checkBoxAccessToSectionsDocumentResolution) {
        if (checkBoxAccessToSectionsDocumentResolution) {
            clickBoxAccessToSectionsDocumentResolution.click();
        }
        return this;
    }

    /**
     * Доступ к разделам документа при просмотре/редактировании
     * -Журнал
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickCheckBoxAccessToSectionsDocumentLog(boolean checkBoxAccessToSectionsDocumentLog) {
        if (checkBoxAccessToSectionsDocumentLog) {
            clickBoxAccessToSectionsDocumentLog.click();
        }
        return this;
    }

    /**
     * Создание связанных документов
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage setCreationOfLinkedDocuments(CreationOfLinkedDocuments creationOfLinkedDocuments) {
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


    //----------------------------------------------------------------------------Вкладка - МАРШРУТЫ СОГЛАСОВАНИЯ (методы)--------------------------------------------------------------------------------

    /**
     * Производим выбор вкладки - МС
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickConnectedRoutesTab() {
        connectedRoutesTab.click();
        $(By.xpath("//div[contains(@id,'selectionform')]//div[contains(@id,'gridview')]//table")).shouldBe(Condition.visible);
        return this;
    }

    /**
     * Производим выбор настройки - Использовать все МС
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickCheckBoxUseAllPossibleRoutes(boolean checkBoxUseAllPossibleRoutes) {
        if (checkBoxUseAllPossibleRoutes) {
            clickCheckBoxUseAllPossibleRoutes.click();
        }
        return this;
    }


    //----------------------------------------------------------------------------Вкладка - ЗАДАЧИ (методы)---------------------------------------------------

    /**
     * Выбор вкладки - Задачи
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickTasksTab() {
        tasksTab.click();
       $(By.xpath("//span[string-length(text())>=10]/../../div//textarea")).shouldBe(Condition.visible);
        return this;
    }

    /**
     * Копирование полей при создании задачи
     */
    public DocRegisterCardsEditPage setCopyingFieldsWhenCreatingTask(String сopyingFieldsWhenCreatingTask) {
        if (сopyingFieldsWhenCreatingTask == null) {
            return this;
        } else {
            setCopyingFieldsWhenCreatingTask.clear();
            setCopyingFieldsWhenCreatingTask.sendKeys(сopyingFieldsWhenCreatingTask);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Авторов задач
     */
    public DocRegisterCardsEditPage setAuthorsObjectives(String authorsObjectives) {
        if (authorsObjectives == null) {
            return this;
        } else {
            setAuthorsObjectives.clear();
            setAuthorsObjectives.sendKeys(authorsObjectives);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Контролеров задач
     */
    public DocRegisterCardsEditPage setControllersOfTasks(String controllersOfTasks) {
        if (controllersOfTasks == null) {
            return this;
        } else {
            setControllersOfTasks.clear();
            setControllersOfTasks.sendKeys(controllersOfTasks);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Ответственных руководителей задач
     */
    public DocRegisterCardsEditPage setDecisionMakersOfTasks(String decisionMakersOfTasks) {
        if (decisionMakersOfTasks == null) {
            return this;
        } else {
            setDecisionMakersOfTasks.clear();
            setDecisionMakersOfTasks.sendKeys(decisionMakersOfTasks);
        }
        return this;
    }

    /**
     * Вводим значение в поле - Поля документа, содержащие...
     * Исполнителей задач
     */
    public DocRegisterCardsEditPage setExecutorsOfTasks(String executorsOfTasks) {
        if (executorsOfTasks == null) {
            return this;
        } else {
            setExecutorsOfTasks.clear();
            setExecutorsOfTasks.sendKeys(executorsOfTasks);
        }
        return this;
    }


    /**
     * Сохранить изменения по документу
     *
     * @return DocRegisterCardsEditPage
     */
    public DocRegisterCardsEditPage clickSaveAllChangesInDoc() {
        clickSaveAllChangesInDocument.click();
        return this;
    }


}