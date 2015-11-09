package com.selenium.test.pages;

import com.selenium.test.model.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

/**
 * Грид - Задачи/Задачи
 */
public class TasksReportsPage extends Page {


    /**
     * Проверяем отображение созданной задачи в гриде раздела - Задачи
     *
     * @param task
     * @return
     */
    public TasksReportsPage checkDisplayTaskGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']"))
                .shouldHave(exactText(task.getTaskName()));
        return this;
    }

    /**
     * Открываем задачу в гриде задач
     *
     * @param task
     * @return
     */
    public EditTaskPage openTaskInGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']/..")).click();
        $(By.xpath("//ul[@class='ui-listview']//a[contains(text(),'" + task.getTaskName() + "')]"))
                .shouldHave(exactText("" + task.getTaskName() + ""));
        return page(EditTaskPage.class);
    }

    /**
     * Проверяем исчезновение задачи в гриде раздела - Задачи
     *
     * @param task
     * @return
     */
    public TasksReportsPage checkDisappearTaskInGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']"))
                .shouldNotBe(visible);
        return this;
    }

}
