package com.selenium.test.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class EditTaskPage extends Page {

    /*
     * кнопка Создать
     */
    @FindBy(css = "input[name='next3']")
    private SelenideElement createTask;

    /*
    Ссылка - Перейти к задаче
     */
    @FindBy(xpath = "//a[contains(@href, '/task/')]")
    private SelenideElement goToTask;


    /**
     * Проверка введенных данный в предпросмотре формы создания задачи
     *
     * @param taskName        -  Название задачи
     * @param taskDescription -  Описание задачи
     * @param dateEnd         - Окончание задачи
     * @return
     */
    public EditTaskPage inputValidationFormTask(String taskName, String taskDescription, String dateEnd) {
        $(By.xpath("//form[@id='data_value']//li[2]//span[@style][text()='" + taskName + "']"))
                .shouldBe(Condition.visible); // Название задачи
        $(By.xpath("//form[@id='data_value']//li[3]//span[@style][text()='" + taskDescription + "']"))
                .shouldBe(Condition.visible); // Описание задачи
        $(By.xpath("//form[@id='data_value']//li[9]//span[@style][contains(text(),'" + dateEnd + "')]"))
                .shouldBe(Condition.visible); // Окончание задачи
        return this;
    }

    /**
     * Создать (нажатие кнопки - Создать)
     *
     * @return
     */
    public EditTaskPage createNewTask() {
        createTask.click();
        $(By.xpath("//a[contains(@href, '/task/')]")).waitUntil(Condition.appear, 4);
        return this;
    }

    /**
     * Перейти к форме созданной задачи
     * @return
     */
    public TaskPage goToTask(){
        goToTask.click();
        return page(TaskPage.class);
    }


}
