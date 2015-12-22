package ru.st.selenium.pages.pagesweb.Administration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.logicinterface.DirectoriesLogic;
import ru.st.selenium.model.Administration.Directories.Directories;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.Selenide.$;

/**
 * Основной грид разделов - Типы Таблиц/Типы задач/Справочники, раздела Администрирование
 */
public class TaskTypeListObjectPage extends Page implements DirectoriesLogic {

    /*
     * static XPATH base element
     */
    public final SelenideElement CHECKING_MESSAGES_SAVE_OBJECT = $(By.xpath("//div[count(div)=3]/div[2]//div[contains(@id,'messagebox') and (@data-errorqtip)]"));
    public final SelenideElement CLICK_OK_ALERT_MESSAGES = $(By.xpath("//div[count(div)=3]/div[3]//div[count(a)=4]/a[1]//span[position()=2]"));
    public final SelenideElement CHECKING_MESSAGES_DELETE_OBJECT = $(By.xpath("//div[contains(@id,'messagebox')]/ancestor::div[contains(@id,'container')]//div[text()]"));
    public final SelenideElement CLICK_YES_ALERT_MESSAGES = $(By.xpath("//div[count(a)=4]/a[2]//span[position()=2]"));




    /**
     * ОК - Подтверждение добавления объекта
     */
    @FindBy(xpath = "//*[contains (@class, 'message-box')]//a[1]")
    private SelenideElement clickOkAndAddFieldTypesTable;

    /**
     * Поле ввода Названия объекта
     */
    @FindBy(xpath = "//input")
    private SelenideElement nameObject;

    /**
     * Добавить
     */
    @FindBy(xpath = "//div[contains (@class, 'bottom')]//a[1]//span[contains (@class, 'icon')]")
    private SelenideElement clickAddTypesObject;

    /**
     * Редактировать
     */
    @FindBy(xpath = "//div[contains (@class, 'bottom')]//a[2]//span[contains (@class, 'icon')]")
    private SelenideElement clickEditTypesObject;

    /**
     * Удалить
     */
    @FindBy(xpath = "//div[contains (@class, 'bottom')]//a[3]//span[contains (@class, 'icon')]")
    private SelenideElement clickDelTypesObject;


    /**
     * Кнопка: Добавить объект - в гриде - Типы Таблиц/Типы задач/Справочники
     */
    public TaskTypeListObjectPage addTaskTypesObject() {
        clickAddTypesObject.click();
        // Ждем появления формы ввода Названия Типы таблицы
        $(clickOkAndAddFieldTypesTable).shouldBe(Condition.present);
        return this;
    }

    /**
     * Вводим Название объекта и нажимаем кнопку ОК для сохранения
     *
     * @param text
     * @return TaskTypeListObjectPage
     */
    public TaskTypeListObjectPage valueNameObject(String text) {
        $(nameObject).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    /**
     * Проверка созданного объекта в гриде tasktypelist
     *
     * @return TaskTypeListObjectPage
     */
    public TaskTypeListObjectPage verifyCreateObject(String ObjectName) {
        $(By.xpath("//*[contains(text(),'" + ObjectName + "')][ancestor::table]")).shouldBe(Condition.visible);
        return this;
    }


    /**
     * Ожидание появления элемента(\ов) в гридах - Типы таблиц/Типы
     * задач/Справочники - Кнопка - Добавить; - Кнопка - Редактировать
     */
    public TaskTypeListObjectPage ensurePageLoaded() {
        $(clickAddTypesObject).shouldBe(Condition.present);
        $(clickEditTypesObject).shouldBe(Condition.visible);
        return this;
    }


    /**
     * Добавление нового спр-ка (Администрирование / Справочники)
     * @param directories
     */
    @Override
    public void addDirectories(Directories directories) {
        ensurePageLoaded();
        addTaskTypesObject(); // Добавить объект (кнопка - Добавить)
        valueNameObject(directories.getDirectoryName()); // Название Спр-ка
        clickOkAndAddFieldTypesTable.click(); //
    }

    @Override
    public void editDirectories(Directories directories) {

    }

    /**
     * Удаление объекта из системы
     * @param directories
     */
    @Override
    public void removeAnDirectories(Directories directories) {
        ensurePageLoaded();
        $(By.xpath("//*[contains(text(),'" + directories.getDirectoryName() + "')][ancestor::table]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'" + directories.getDirectoryName() + "')][ancestor::table]/../../img[1]")).click();
        clickDelTypesObject.click();
        checkingMessagesConfirmationOfTheObject($(By.xpath("//div[contains(@id,'messagebox')]/ancestor::div[contains(@id,'container')]//div[text()]")),
                "Вы действительно хотите удалить справочник \""+directories.getDirectoryName()+"" + "\"?",
                $(By.xpath("//div[count(a)=4]/a[2]//span[position()=2]")));
        $(By.xpath("//*[contains(text(),'" + directories.getDirectoryName() + "')][ancestor::table]/..")).shouldNotBe(Condition.visible);
    }

}
