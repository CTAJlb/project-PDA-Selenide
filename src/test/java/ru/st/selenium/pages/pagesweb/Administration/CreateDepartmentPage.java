package ru.st.selenium.pages.pagesweb.Administration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.st.selenium.model.Users.Department;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertTrue;

/**
 * Страница - Администрирование/Пользователи ч.1
 */
public class CreateDepartmentPage extends Page {

    /**
     * Строка поиска
     */
    @FindBy(id = "searchQueryEdit")
    private SelenideElement search;

    /**
     * Выбрать корневое подразделение
     */

    @FindBy(xpath = "//tr[@data-recordid='1']/td/div/span")
    private SelenideElement rootDep;

    /**
     * Свернутый элемент дерева подразделений
     */
    @FindBy(xpath = "//tr[not(contains(@class, 'expanded'))]/td/div/img[contains (@class, 'expander')]")
    private SelenideElement closedNode;

    /**
     * Добавить подразделение
     */
    @FindBy(xpath = "//div[contains(@id,'panel-')]//a[1]")
    private SelenideElement buttonAddDep;

    /**
     * Кнопка - Редактировать подразделение
     */
    @FindBy(xpath = "//div[contains(@id,'panel-')]//a[3]")
    private SelenideElement buttonEditDep;

    /**
     * Кнопка - Удаление подразделения
     */
    @FindBy(xpath = "//div[contains(@id,'panel-')]//a[2]")
    private SelenideElement buttonRemoveDep;

    /**
     * Наименование подразделения
     */
    @FindBy(id = "dep_name-inputEl")
    private SelenideElement nameDep;

    /**
     * Условный номер
     */
    @FindBy(id = "add_number-inputEl")
    private SelenideElement conditionalNumber;

    /**
     * Значение счетчика
     */
    @FindBy(id = "counter-inputEl")
    private SelenideElement counter;

    /**
     * Шаблон нумератора
     */
    @FindBy(id = "reset_date-inputEl")
    private SelenideElement resetDate;

    /**
     * Дата обнуления
     */
    @FindBy(id = "numerator_template-inputEl")
    private SelenideElement numeratorTemplate;

    /**
     * Сохранить подразделение
     */
    @FindBy(xpath = "(//span[contains(@id,'button') and @class='x-btn-wrap'] [ancestor::div[@id='editDepWin']])[1]/span/span[last()]")
    private SelenideElement saveDepartment;

    /**
     * Отменить сохранение подразделения
     */
    @FindBy(xpath = "(//span[contains(@id,'button') and @class='x-btn-wrap'] [ancestor::div[@id='editDepWin']])[2]/span/span[last()]")
    private SelenideElement cancellationOfCreatingDivisions;

    /**
     * Маска при клике подразделений
     */
    @FindBy(xpath = "//*[contains (@class, 'x-mask')]")
    private SelenideElement maskDepartment;

    /**
     * Кнопка - Да, в форме предупреждения - Вы уверены, что хотите удалить подразделение?
     */
    @FindBy(xpath = "//*[contains (@class, 'message')][contains (@class, 'closable')]/div[contains (@id, 'toolbar')]//a[2]//span[contains (@class, 'icon')]")
    private SelenideElement savePermissionYes;


    @FindBy(xpath = "//span[contains(@id,'-btnWrap')]//span[text()='Да']/../span[contains(@id,'-btnIconEl')]")
    private SelenideElement okRemoveDel;

    /**
     * Основной фрейм
     */
    @FindBy(id = "flow")
    private SelenideElement Frem;

    /**
     * Уходим во фрейм - Администрирование/Подразделения
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage gotoFremDepartmentPage() {
        getWebDriver().switchTo().frame(Frem);
        return this;
    }

    /**
     * Уходим из фрейм опять в ТОР
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage gotoFromDepartmentInTopFrem() {
        getWebDriver().switchTo().defaultContent();
        return this;
    }

    /**
     * Развернем все ветви дерева подразделений
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage unwrapAllNodes() {
        try {
            while (isElementPresent(By
                    .xpath("//tr[not(contains(@class, 'expanded'))]/td/div/img[contains (@class, 'expander')]")))
                closedNode.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Выбрать корневое Подразделение для взаимодействия с элементом
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage clickRootDep() {
        rootDep.click();
        waitForMask();
        return this;
    }

    /**
     * Добавить Подразделение
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage ButtonAddDep() {
        buttonAddDep.click();
        return this;
    }

    /**
     * Удаление Подразделения
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage clickButtonRemoveDep() {
        buttonRemoveDep.click();
        return this;
    }

    /**
     * Редактировать Подразделение
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage clickbuttonEditDep() {
        buttonEditDep.click();
        return this;
    }

    /**
     * Название Подразделения
     *
     * @param text
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage setNameDep(String text) {
        nameDep.clear();
        nameDep.setValue(text);
        return this;
    }

    /**
     * Условный номер подразделения
     *
     * @param text
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage setConditionalNumber(String text) {
        conditionalNumber.clear();
        conditionalNumber.setValue(text);
        return this;
    }

    /**
     * Значение счетчика подразделения
     *
     * @param text
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage setCounter(String text) {
        counter.clear();
        counter.setValue(text);
        return this;
    }

    /**
     * Дата обнуления счетчика подразделения
     *
     * @param text
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage setResetDate(String text) {
        resetDate.clear();
        resetDate.setValue(text);
        return this;
    }

    /**
     * Дата обнуления счетчика подразделения
     *
     * @param text
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage setNumeratorTemplate(String text) {
        numeratorTemplate.clear();
        numeratorTemplate.setValue(text);
        return this;
    }

    /**
     * Сохранение подразделения
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage clickSaveDep() {
        saveDepartment.click();
        return this;
    }


    /**
     * Проверка отображения созданного подразделения
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage verifyCreateDep(String DepName) {
        $(By.xpath("//*[contains(text(),'" + DepName
                + "')] [ancestor::*[contains(@id,'treeview')]]")).shouldBe(Condition.visible);
        assertTrue(isElementPresent(By.xpath("//span[contains(text(),'" + DepName
                + "')] [ancestor::*[contains(@id,'treeview')]]")));

        return this;

    }

    /**
     * После каждого клика на подразделение повисает маска, данный метод должен
     * использовваться после каждого клика по подразделению для ожидания
     * невидимости маски
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage waitForMask() {
        waitMillisecond(0.3);
        $(By.xpath("//*[contains (@class, 'x-mask')]")).shouldHave(Condition.disappear);
        return this;
    }

    /**
     * Метод ДнД
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage DnD(Department source, Department target) {
        WebElement sourceElement = getWebDriver().findElement(By
                .xpath("//span[contains(text(),'" + source.getDepName()
                        + "')] [ancestor::tbody[contains(@id,'treeview')]]"));
        WebElement targetElement = getWebDriver().findElement(By
                .xpath("//span[contains(text(),'" + target.getDepName()
                        + "')] [ancestor::tbody[contains(@id,'treeview')]]"));
        sourceElement.click();
        Actions builder = new Actions(getWebDriver());
        Action drag = builder.clickAndHold(sourceElement).build();
        Action drop = builder.moveToElement(targetElement)
                .release(targetElement).build();
        drag.perform();
        waitForMask();
        drop.perform();
        return this;
    }

    /**
     * Метод ДнД для удаления подразделений
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage dndFirstChildToRoot(Department department) {
        $(By.xpath("//*[contains (@id, 'messagebox')][contains (@class, 'closable')]/div[contains (@id, 'toolbar')]//a[1]"))
                .click();
        WebElement child = getWebDriver()
                .findElement(By.xpath("//span[contains(text(),'"
                        + department.getDepName()
                        + "')] [ancestor::tbody[contains(@id,'treeview')]]/parent::div/parent::td/parent::tr/following-sibling::tr/td/div/span"));
        child.click();
        Actions builder = new Actions(getWebDriver());
        Action drag = builder.clickAndHold(child).build();
        Action drop = builder.moveToElement(rootDep).release(rootDep).build();
        drag.perform();
        waitForMask();
        drop.perform();
        $(savePermissionYes).shouldBe(Condition.visible);
        savePermissionYes.click();
        return this;
    }

    /**
     * Клик - Да - в форме подтверждения сохранения дополнительных полномочий
     * при ДнД подразделений
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage clickYes() {
       $(savePermissionYes).shouldBe(Condition.visible);
        savePermissionYes.click();
        waitForMask();
        return this;
    }

    /**
     * Выбираем подразделение по имени
     *
     * @return
     */

    public CreateDepartmentPage clickDepByName(Department department) {
        waitForMask();
        $(By.xpath("//span[contains(text(),'" + department.getDepName()
                        + "')] [ancestor::tbody[contains(@id,'treeview')]]"))
                .click();
        return this;
    }

    /**
     * Подтверждение удаления
     *
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage clickOkRemoveDel() {
        $(By.xpath("//span[string-length(text())>=2]/ancestor::div[contains(@id,'messagebox')]//a[2]//span[contains(@id,'-btnIconEl')]"))
                .shouldBe(Condition.present);
        okRemoveDel.click();
        waitForMask();
        return this;
    }

    /**
     * Поиск пользователя в гриде
     *
     * @param user
     * @return CreateDepartmentPage
     */
    public CreateDepartmentPage searchUser(Employee user) {
        // TODO Что здесь??? - pages.internalPage.search(user.getLastName());
        return this;
    }

    /**
     * Логическая проверка, есть ли у подразделения дочерние подразделение,
     * производится только, после клика кнопки - Удалить подразделение
     */
    public boolean hasChild() {
        try {
            (new WebDriverWait(getWebDriver(), 0, 50))
                    .until(ExpectedConditions.elementToBeClickable(By
                            .xpath("//*[contains (@id, 'messagebox')][contains (@class, 'closable')]/div[contains (@id, 'toolbar')]//a[1]")));
            return true;
        } catch (TimeoutException to) {
            return false;
        }
    }

    /**
     * Проверяем и ожидаем, что на странице имеется соответствующий элемент: -
     * Главное подразделение - в фрейме иерархии подразделений; - Кнопка -
     * Добавить подразделение
     */
    public CreateDepartmentPage ensurePageLoaded() {
        $(By.xpath("//tr[@data-recordid='1']/td/div/span")).shouldBe(Condition.visible);
        return this;
    }


}