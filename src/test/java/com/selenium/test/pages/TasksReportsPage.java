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
     * Проверяем отображение созданной задачи в гриде раздела
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
     * Открываем задачу из грида
     * @param task
     * @return
     */
    public TasksReportsPage openTaskInGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']/..")).click();
        return this;
    }

}
