package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.selenium.test.model.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Форма задачи (Атрибуты задачи)
 */
public class EditTaskPage extends NewTaskPage {

    /*
     * кнопка Создать задачу
     */
    @FindBy(css = "input[name='next3']")
    private SelenideElement createTask;

    /*
     * Ссылка - Перейти к задаче
     */
    @FindBy(xpath = "//a[contains(@href, '/task/')]")
    private SelenideElement goToTask;

    /*
     * Сохранить
     */
    @FindBy(css = "div.save_button")
    private SelenideElement save;


    /**
     * Проверка введенных данный в предпросмотре формы создания задачи
     *
     * @param task
     * @return
     */
    public EditTaskPage inputValidationFormTask(Task task) {
        $(By.xpath("//form[@id='data_value']//li[2]//span[@style][text()='" + task.getTaskName() + "']"))
                .shouldBe(Condition.visible); // Название задачи
        $(By.xpath("//form[@id='data_value']//li[3]//span[@style][text()='" + task.getDescription() + "']"))
                .shouldBe(Condition.visible); // Описание задачи
        $(By.xpath("//form[@id='data_value']//li[9]//span[@style][contains(text(),'" + task.getEnd() + "')]"))
                .shouldBe(Condition.visible); // Окончание задачи
        return this;
    }

    /**
     * Создать (нажатие кнопки - Создать)
     *
     * @return
     */
    public EditTaskPage saveNewTask() {
        createTask.click();
        $(By.xpath("//a[contains(@href, '/task/')]")).waitUntil(Condition.appear, 4);
        return this;
    }

    /**
     * Перейти к форме созданной задачи
     *
     * @return
     */
    public TaskPage goToTask() {
        goToTask.click();
        return page(TaskPage.class);
    }

    /**
     * Сохранить изменения по задаче
     * @return
     */
    public EditTaskPage saveChangesToTask() {
        save.click();
        return this;
    }

    /**
     * Создание новой задачи
     */
    public void editTask(Task editTask) {
        setTaskName(editTask.getTaskName()) // Название задачи
                .setTasksDescription(editTask.getDescription()) // Описание задачи
                .setDateEnd(editTask.getEnd()) // Дата окончания задачи
                .setImportantTask(editTask.getIsImportant()) // признак - Важная задача
                .setPrivateTask(editTask.getIsSecret()); // признак - Секретная задача
        saveChangesToTask();


    }


}
