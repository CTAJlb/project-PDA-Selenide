package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

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
     * Задачи/Задачи
     */
	@FindBy(xpath = "//a[@href='/tasksreports/']")
	private SelenideElement menuTaskReports;


    /*
     * Создать задачу
     */
    @FindBy(xpath = "//a[contains(@href, '/edittask/newtask')]")
    private SelenideElement createTask;

    /*
     * Домой
     */
    @FindBy(xpath = "//a/img[contains(@src,'home')]")
    private SelenideElement home;

    /**
     * Домой (возврат на основную стр-цу)
     *
     * @return
     */
    public Page goToHome() {
        home.click();
        return this;
    }

    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return
     */
    public boolean hasMenu() {
        menuElements.shouldHaveSize(4); // проверяем, что отображается 4 пункта меню (Задачи; Создать задачу; Сегодня; Документы)
        return !menuElements.isEmpty();
    }

    /**
     * Переходим в форму создания Задачи
     *
     * @return
     */
    public NewTaskPage goToCreateTask() {
        createTask.click();
        $(By.xpath("//input[contains(@class,'button') and @name='next2']")).shouldHave(Condition.visible);
        return page(NewTaskPage.class);
    }

    /**
     * Переходим в грид Задачи/Задачи
     *
     * @return
     */
    public TasksReportsPage goToTaskReports() {
        menuTaskReports.click();
        $(By.xpath("//div[@id='mainblock']/table[3]//tr")).shouldBe(Condition.present);
        return page(TasksReportsPage.class);
    }

    /**
     * Вернуться домой и выйти из системы
     */
    public LoginPage homeAndSignOut() {
        goToHome();
        logout.waitUntil(Condition.appear, 4);
        logout.click();
        $("#center>form>div>img").shouldBe(Condition.visible);
        $(By.cssSelector("#login")).shouldHave(Condition.appears);
        $(By.cssSelector("#pass")).shouldHave(Condition.appears);
        $(By.cssSelector("input[name='logon']")).getCssValue("Вход");
        return page(LoginPage.class);
    }

    /**
     * Выход из Системы
     */
    public LoginPage signOut() {
        logout.click();
        $("#center>form>div>img").shouldBe(Condition.visible);
        $(By.cssSelector("#login")).shouldHave(Condition.appears);
        $(By.cssSelector("#pass")).shouldHave(Condition.appears);
        $(By.cssSelector("input[name='logon']")).getCssValue("Вход");
        return page(LoginPage.class);
    }

}
