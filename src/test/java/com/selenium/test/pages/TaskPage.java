package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Форма задачи (Лента действий)
 */
public class TaskPage extends Page {

    /*
    Кнопки в форме "Обычной задач"
     */
    @FindBy(xpath = "//*[@id='buttonDopMenu2']/div//div")
    private ElementsCollection buttonMenu;

    /*
     Сохранить
     */
    @FindBy(css = "div.save_button")
    private SelenideElement save;

    /*
     Лента действий
     */
    @FindBy(css = "#text")
    private SelenideElement action;


    /**
     * Проверяем отображение формы созданной задачи
     *
     * @param task
     * @return
     */
    public TaskPage openShapeCreatedTask(Task task) {
        $(By.cssSelector("div.save_button")).shouldBe(Condition.present);
        $(By.xpath("//a[contains(text(),'" + task.getTaskName() + "')][ancestor::ul[@class='ui-listview']]")).shouldHave(Condition.visible);
        return this;
    }

    /**
     * Проверяем отображениия кнопок в форме задачи
     *
     * @return
     */
    public boolean resultsDisplayButtons() {
        buttonMenu.shouldHaveSize(5); // проверяем, что отображается 5 кнопок в форме задачи (Сохранить; Завершить выполнение; Play; Pause; Stop)
        return !buttonMenu.isEmpty();
    }

    /**
     * Открываем форму редактирования задачи (Атрибуты задачи)
     *
     * @param task
     * @return
     */
    public EditTaskPage openFormEditTask(Task task, Employee user) {
        $(By.xpath("//a[contains(text(),'" + task.getTaskName() + "')][ancestor::ul[@class='ui-listview']]")).click();
        save.shouldBe(Condition.visible);
        $(By.xpath("//span[@name='autor']/a[text()='" + user.getLastName() + "']")).shouldBe(Condition.visible);
        return page(EditTaskPage.class);
    }


    /**
     * Добавляем текст в ленту действий
     *
     * @param textAction
     * @return
     */
    public TaskPage saveActionsInTheTape(String textAction) {
        for (int i = 0; i < 5; i++) {
            action.setValue(textAction);
            save.click();
            $(By.xpath("//ul[@class='ui-listview']//div/span[text()='" + textAction + "']")).shouldBe(Condition.visible);
        }
        return this;
    }


}
