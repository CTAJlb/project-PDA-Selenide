package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Внутреняя страница системы
 */
public class InternalPage extends Page {

    /*
     * Ссылки на все пункты меню
     */
    @FindBy(xpath = "//a[@class='ui-link-inherit']")
    private ElementsCollection menuElements;

    /*
     * Выход из системы
     */
    @FindBy(xpath = "//a[contains(@href, '/logout/')]")
    private SelenideElement logout;

    /*
     * Создать задачу
     */
    @FindBy(xpath = "//a[contains(@href, '/edittask/newtask')]")
    private SelenideElement createTask;


    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return
     */
    public boolean hasResults() {
        menuElements.shouldHaveSize(4); // проверяем, что отображается 4 пункта меню (Задачи; Создать задачу; Сегодня; Документы)
        return !menuElements.isEmpty();
    }

    /**
     * Переходим в форму создания Задачи
     *
     * @return
     */
    public NewTaskPage clickCreateTask() {
        createTask.click();
        $(By.xpath("//input[contains(@class,'button') and @name='next2']")).shouldHave(Condition.visible);
        return page(NewTaskPage.class);
    }





    /**
     * Выход из Системы
     */
    public static LoginPage signOut() {
        $(By.xpath("//a[contains(@href, '/logout/')]")).click();
        $("#center>form>div>img").shouldBe(Condition.visible);
        $(By.cssSelector("#login")).shouldHave(Condition.appears);
        $(By.cssSelector("#pass")).shouldHave(Condition.appears);
        $(By.cssSelector("input[name='logon']")).getCssValue("Вход");
        return page(LoginPage.class);
    }

}
