package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


/**
 * Страницы - Поиск
 */
public class SearchPage extends Page {

    /*
     * Поле - Поиск
     */
    @FindBy(xpath = "//input[@name='search']")
    private SelenideElement search;


    /**
     * Осуществляем поиск по названию задачи
     *
     * @param taskName name task for search
     */
    public SearchPage searchTask(Task taskName) {
        search.setValue("" + taskName.getTaskName() + "").pressEnter();
        $(By.xpath("//div[@id='task']//a[contains(text(),'" + taskName.getTaskName() + "')]")).shouldBe(Condition.visible);

        return this;
    }

    /**
     * Осуществляем поиск Фамилии пользователя
     *
     * @param surname user for search
     */
    public SearchPage searchContact(Employee surname) {
        search.setValue("" + surname.getLastName() + "").pressEnter();
        $(By.xpath("//div[@id='contact']//a[contains(text(),'" + surname.getLastName() + "')]")).shouldBe(Condition.visible);
        return this;
    }


}
