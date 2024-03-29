package ru.st.selenium.pages.pagespda;

import org.openqa.selenium.By;
import ru.st.selenium.model.Task.Task;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

/*
 * Страница грид - Задачи/Задачи
 */
public class TasksReportsPagePDA extends Page {


    /**
     * Проверяем отображение созданной задачи в гриде раздела - Задачи
     *
     * @param task return values of attributes of the task
     * @return
     */
    public TasksReportsPagePDA checkDisplayTaskGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']"))
                .shouldHave(exactText(task.getTaskName()));
        return this;
    }

    /**
     * Открываем задачу в гриде задач
     *
     * @param task return values of attributes of the task
     * @return
     */
    public EditTaskPagePDA openTaskInGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']/..")).click();
        $(By.xpath("//ul[@class='ui-listview']//a[contains(text(),'" + task.getTaskName() + "')]"))
                .shouldHave(exactText("" + task.getTaskName() + ""));
        return page(EditTaskPagePDA.class);
    }

    /**
     * Проверяем исчезновение задачи в гриде раздела - Задачи
     *
     * @param task return values of attributes of the task
     * @return
     */
    public TasksReportsPagePDA checkDisappearTaskInGrid(Task task) {
        $(By.xpath("//div[@id='mainblock']/table[3]//tr//span[text()='" + task.getTaskName() + "']"))
                .shouldNotBe(visible);
        return this;
    }

}
