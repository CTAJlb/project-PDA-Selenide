package com.selenium.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class NewTaskPage extends Page {

    /*
     Логин
     */
    @FindBy(xpath = "//input[@id='input_prj_t' and @name='task_name']")
    private SelenideElement taskName;


    /**
     * Название задачи
     *
     * @return
     */
    public NewTaskPage setTaskName() {
        taskName.clear();
        taskName.setValue(randomString(25));
        return this;
    }

}
