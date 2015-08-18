package com.selenium.test.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TaskPage extends Page {

    /*
    Кнопки в форме "Обычной задач"
     */
    @FindBy(xpath = "//*[@id='buttonDopMenu2']/div/div")
    private ElementsCollection buttonMenu;

    /*
     Сохранить
     */
    @FindBy(css = "div.save_button")
    private SelenideElement save;


    /**
     * Проверяем отображение формы созданной задачи
     *
     * @param taskName
     * @return
     */
    public TaskPage verifyCreateTask(String taskName) {
        $(By.cssSelector("div.save_button")).shouldBe(Condition.present);
        $(By.xpath("//a[contains(text(),'" + taskName + "')][ancestor::ul[@class='ui-listview']]")).shouldHave(Condition.visible);
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


}
