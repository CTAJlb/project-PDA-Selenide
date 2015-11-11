package com.selenium.test.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.appears;
/*
 * Импорт для использования методов самого Selenium, в т.ч. объект WebDriver.
 * Дальше можно спокойно использовать метод getWebDriver(), который возвращает объект WebDriver.
 * пример, getWebDriver().findElement(By.id("username"));
 */
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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
     * Помощь
     */
    @FindBy(xpath = "//li[@class='help-but']/a")
    private SelenideElement helpHtml;

    /*
     * Настройки
     */
    @FindBy(xpath = "//li[@class='option-but']/a")
    private SelenideElement options;

    /*
     * Сегодня
     */
    @FindBy(xpath = "//a[contains(@href, '/today/')]")
    private SelenideElement today;

    /*
     * Документы
     */
    @FindBy(xpath = "//a[contains(@href, '/documents/')]")
    private SelenideElement documents;

    /*
     * Домой
     */
    @FindBy(xpath = "//a/img[contains(@src,'home')]")
    private SelenideElement home;

    /**
     * Домой (возврат на основную стр-цу)
     *
     * @return Page
     */
    public Page goToHome() {
        home.click();
        return this;
    }

    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return information about the number of the menu on the main page
     */
    public boolean hasMenu() {
        menuElements.shouldHaveSize(4); // проверяем, что отображается 4 пункта меню (Задачи; Создать задачу; Сегодня; Документы)
        return !menuElements.isEmpty();
    }

    /**
     * Переходим в форму - Создать задачу
     *
     * @return NewTaskPage results page instance
     */
    public NewTaskPage goToCreateTask() {
        createTask.click();
        $(By.xpath("//input[contains(@class,'button') and @name='next2']")).shouldHave(visible);
        return page(NewTaskPage.class);
    }

    /**
     * Переходим в форму - Помощь
     *
     * @return HelpHtmlPage results page instance
     */
    public HelpHtmlPage goToHelpHtml() {
        helpHtml.click();
        $(By.xpath("//div[@id='mainblock']/ul/li[1]/div[@class='save_button']")).shouldHave(visible);
        return page(HelpHtmlPage.class);
    }

    /**
     * Переходим в грид Задачи/Задачи
     *
     * @return TasksReportsPage results page instance
     */
    public TasksReportsPage goToTaskReports() {
        menuTaskReports.click();
        $(By.xpath("//div[@id='mainblock']/table[3]//tr")).shouldBe(present);
        return page(TasksReportsPage.class);
    }

    /**
     * Переходим в грид Настройки
     *
     * @return OptionsPage results page instance
     */
    public OptionsPage goToOptions() {
        options.click();
        $(By.xpath("(//input[@type='submit'])[2]")).shouldBe(present);
        return page(OptionsPage.class);
    }

    /**
     * Переходим в грид Сегодня
     *
     * @return Today Page results page instance
     */
    public TodayPage goToToday() {
        today.click();
        $(By.xpath("//div[@id='headertop']//ul/a[2]/li")).shouldBe(present);
        return page(TodayPage.class);
    }

    /**
     * Переходим в грид Документы
     *
     * @return DocumentsPage
     */
    public DocumentsPage goToDocuments() {
        documents.click();
        $$(By.xpath("//div[@class='ui-navbar ui-navbar-noicons']//li")).shouldBe(size(3));
        return page(DocumentsPage.class);
    }

    /**
     * Универсальный выход из системы (где бы ненаходился пользователь)
     *
     * @return LoginPage
     */
    public LoginPage signOut() {
        try {
            (new WebDriverWait(getWebDriver(), 0, 50))
                    .until(ExpectedConditions.presenceOfElementLocated(By
                            .xpath("//a[contains(@href, '/logout/')]"))).click();
        } catch (WebDriverException e) {
            goToHome();
            logout.waitUntil(appears, 4);
            logout.click();
        }
        $("#center>form>div>img").shouldBe(visible);
        $(By.cssSelector("#login")).shouldHave(appears);
        $(By.cssSelector("#pass")).shouldHave(appears);
        $(By.cssSelector("input[name='logon']")).getCssValue("Вход");
        return page(LoginPage.class);
    }


}
