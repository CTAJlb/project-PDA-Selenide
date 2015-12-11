package ru.st.selenium.pagesweb.Administration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.logicinterface.DirectoriesLogic;
import ru.st.selenium.modelweb.Directories.Directories;
import ru.st.selenium.pagespda.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Основной грид разделов - Типы Таблиц/Типы задач/Справочники, раздела Администрирование
 */
public class TaskTypeListObjectPage extends Page implements DirectoriesLogic {

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
     * Пользователяская API для эмуляции сложных пользовательских действий
     * (эмуляция клавиатуры и мыши)
     */
    Actions action = new Actions(getWebDriver());

    /**
     * Метод имитирующий нажатие клавиши - Enter
     */
    public void pressEnter() {
        action = action.sendKeys(Keys.chord(Keys.ENTER));
        action.build().perform();
    }

    /**
     * Метод клавиатурного выбора настроек, смещение на ОДНУ позицию вниз,
     * например, Скрывать...; Изменяемое при редактировании и etc., полей значение полей, выбирает значение == Да
     */
    public void selectingSecondAdjustmentPosition() {
        action = action.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
        action.build().perform();
    }

    /**
     * Метод клавиатурного выбора настроек, смещение на ДВЕ позиции вниз,
     */
    public void selectingThirdAdjustmentPosition() {
        action = action.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER));
        action.build().perform();
    }

    /**
     * Метод клавиатурного выбора настроек, смещение на ТРИ позиции вниз,
     */
    public void selectingFourthlyAdjustmentPosition() {
        action = action.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER));
        action.build().perform();
    }


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


    @Override
    public void removeAnDirectories(Directories directories) {

    }

}
