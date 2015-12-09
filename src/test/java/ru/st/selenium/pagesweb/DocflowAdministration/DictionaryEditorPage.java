/**
 * Администрирование ДО/Редактор словарей
 */
package ru.st.selenium.pagesweb.DocflowAdministration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.pagespda.Page;


import java.util.List;

import static org.junit.Assert.assertTrue;

public class DictionaryEditorPage extends Page {


    /**
     * Основной фрейм
     */
    @FindBy(id = "flow")
    private WebElement Frem;

    /**
     * Список объектов - Словарь
     * TODO - переписать!!!
     */
    @FindBy(xpath = "//table[contains(@id,'treeview')]")
    private List<WebElement> tableGridTreeView;

    /**
     * Добавить словарь
     */
    @FindBy(xpath = "(//a//preceding-sibling::span)[1]")
    private WebElement addDictionaryEditor;

    /**
     * Редактировать словарь
     */

    @FindBy(xpath = "(//a//preceding-sibling::span)[2]")
    private WebElement editDictionaryEditor;

    /**
     * Удалить словарь
     */
    @FindBy(xpath = "(//a//preceding-sibling::span)[3]")
    private WebElement delDictionaryEditor;

    /**
     * Название словаря
     */
    @FindBy(id = "dict_name-inputEl")
    private WebElement nameDictionaryEditor;


    //----------------------------------------------------------------------------ПРАВА--------------------------------------------------------------------------------

    /**
     * Отображение - Личная
     *
     * @FindBy
     */
    @FindBy(xpath = "(//input[contains(@id,'radiofield')])[3]")
    private WebElement clickPersonal;

    /**
     * Отображение - Общедоступная
     *
     * @FindBy
     */
    @FindBy(xpath = "(//input[contains(@id,'radiofield')])[1]")
    private WebElement clickAccessAvailableToAll;

    /**
     * Отображение - Только для чтения
     *
     * @FindBy
     */
    @FindBy(xpath = "(//input[contains(@id,'radiofield')])[2]")
    private WebElement clickReadOnly;

    /**
     * Доабвить значение словаря
     */

    @FindBy(xpath = "//span[@id='bAddWord-btnEl']")
    private WebElement addDictionaryEditorItem;

    /**
     * Редактировать значения словаря
     */

    @FindBy(xpath = "//span[@id='bEditWord-btnWrap']")
    private WebElement editDictionItem;

    /**
     * Удалить значение словаря
     */

    @FindBy(xpath = "//span[@id='bDeleteWord']")
    private WebElement delDictionItem;

    /**
     * Переместить вверх значение словаря
     */

    @FindBy(xpath = "//span[@id='bUpWord']")
    private WebElement upDictionItem;

    /**
     * Переместить вниз значение словаря
     */

    @FindBy(xpath = "//span[@id='bDownWord']")
    private WebElement downDictionItem;

    /**
     * Название элемента словаря
     */
    @FindBy(xpath = "//input[@id='name_word-inputEl']")
    private WebElement nameDictionaryEditorItem;

    /**
     * Описание элемента словаря
     */
    @FindBy(xpath = "//textarea[@id='value_word-inputEl']")
    private WebElement descriptionDictionaryEditorItem;

    /**
     * Сохранить элемента словаря
     */
    @FindBy(xpath = "(//span[contains(@id,'button')])[8]")
    private WebElement saveDictionaryEditorItem;

    /**
     * Отменить сохранения элемента словаря
     */
    @FindBy(xpath = "(//span[contains(@id,'button')])[7]")
    private WebElement cancelDictionaryEditorItem;

    /**
     * Сохранить все изменения
     */
    @FindBy(xpath = "//span[@id='bSave-btnIconEl']")
    private WebElement saveChanges;

    /**
     * Сохранить как
     */
    @FindBy(xpath = "//span[@id='bSaveAs-btnIconEl']")
    private WebElement saveAsChanges;

    /**
     * Вернуться без сохранения
     */
    @FindBy(xpath = "//div[count(a)=3 and contains(@id,'toolbar')]/a[3]//preceding-sibling::span")
    private WebElement backWithoutSaving;


    /**
     * Уходим во фрейм - Администрирование ДО/Редактор словарей
     *
     * @return CreateDepartmentPage
     */
    public DictionaryEditorPage gotoFremDictionaryEditorPage() {
        driver.switchTo().frame(Frem);
        return this;
    }

    /**
     * Уходим из фрейм в ТОР
     */
    public DictionaryEditorPage gotoTopFrem() {
        driver.switchTo().defaultContent();
        return this;
    }

    /**
     * Клик Добавить объект - Редактор словарей
     */
    public DictionaryEditorPage addDictionaryEditor() {
        addDictionaryEditor.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameDictionaryEditor));
        return this;
    }

    /**
     * Вводим название - Словаря
     */
    public DictionaryEditorPage setNameDictionaryEditor(String nameDictionText) {
        nameDictionaryEditor.clear();
        nameDictionaryEditor.sendKeys(nameDictionText);
        return this;
    }

    /**
     * Метод выбора уровня доступа к РКД (Регистрационная карточка документа)
     */
    public DictionaryEditorPage setRadioButtAccess(AccessRights accessRights) {
        if (accessRights == AccessRights.AVAILABLETOALL) {
            clickAccessAvailableToAll.click();
        } else if (accessRights == AccessRights.PERSONAL) {
            clickPersonal.click();
        } else if (accessRights == AccessRights.READONLY) {
            clickReadOnly.click();
        }
        return this;
    }

    /**
     * Клик Добавить элемент словаря
     */
    public DictionaryEditorPage addDictionaryEditorItem() {
        addDictionaryEditorItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameDictionaryEditorItem));
        return this;
    }

    /**
     * Вводим название Элемента словаря - Словаря
     */
    public DictionaryEditorPage setAddDictionItemFields(DictionaryEditorField[] dictionItem) {
        if (dictionItem == null) {
            return this;
        } else
            outer:
                    for (DictionaryEditorField aDictionItem : dictionItem) {
                        addDictionaryEditorItem(); // Доавть элемент словаря
                        nameDictionaryEditorItem.clear();
                        nameDictionaryEditorItem.sendKeys(aDictionItem.getNameDictionItem()); // Название элемента словаря
                        descriptionDictionaryEditorItem.clear();
                        descriptionDictionaryEditorItem.sendKeys(aDictionItem.getDescriptionDictionItem()); // Описание элемента словаря
                        saveDictionaryEditorItem();
                        verifyDictionaryEditorItem(aDictionItem.getNameDictionItem()); // Проверям отображение элемента словаря в гриде Словаря
                    }
        return this;
    }

    /**
     * Вводим Описание элемента - Словаря
     */
    public DictionaryEditorPage setDescriptionDicItem(String descriptionDicItem) {
        descriptionDictionaryEditorItem.clear();
        descriptionDictionaryEditorItem.sendKeys(descriptionDicItem);
        return this;
    }

    /**
     * Сохранить элемент словаря
     *
     * @return DictionaryEditorPage
     */
    public DictionaryEditorPage saveDictionaryEditorItem() {
        saveDictionaryEditorItem.click();
        return this;
    }

    /**
     * Проверяем, что добавленный элемент словаря сохранился и отображается в гриде добавления элементов словаря
     *
     * @return DictionaryEditorPage
     */
    public DictionaryEditorPage verifyDictionaryEditorItem(String dictionItem) {
        assertTrue(isElementPresent
                (By.xpath("//div[contains(@id,'gridview')]/table//td[1]/div[contains(text(),'" + dictionItem + "')]")));
        return this;
    }


    /**
     * Сохранить все изменения
     *
     * @return DictionaryEditorPage
     */
    public DictionaryEditorPage saveDictionaryEditor() {
        wait.until(ExpectedConditions.elementToBeClickable(saveChanges));
        saveChanges.click();
        return this;
    }

    /**
     * Проверяем, что созданный объект сохранился и отображается в гриде - Редактор словарей
     *
     * @return DictionaryEditorPage
     */
    public DictionaryEditorPage verifyDictionaryEditor(String dictionaryEditor) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//span[contains(@class,'x-tree-node-text') and contains(text(),'" + dictionaryEditor + "')]")));
        assertTrue(isElementPresent
                (By.xpath("//table//span[contains(@class,'x-tree-node-text') and contains(text(),'" + dictionaryEditor + "')]")));
        return this;
    }


    /**
     * Проверяем и ожидаем, что на странице имеется соответствующий элемент: -
     * Кнопк - Добавить и Редактировать в гриде - Редактор словарей
     */
    public DictionaryEditorPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("(//a//preceding-sibling::span)[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("(//a//preceding-sibling::span)[2]")));
        return this;
    }


}

