package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.selenium.test.model.Task;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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
                .shouldHave(Condition.exactText(task.getTaskName()));
        return this;
    }

    /**
     * Открываем задачу в гриде задач
     *
     * @param task
     * @return
     */
    public TasksReportsPage openTaskInGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']/..")).click();
        $(By.xpath("//ul[@class='ui-listview']//a[contains(text(),'" + task.getTaskName() + "')]"))
                .shouldHave(Condition.exactText("" + task.getTaskName() + ""));
        return this;
    }

    /**
     * Проверяем исчезновение задачи в гриде раздела - Задачи
     *
     * @param task
     * @return
     */
    public TasksReportsPage checkDisappearTaskInGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']"))
                .shouldNotBe(Condition.visible);
        return this;
    }

}
