package com.selenium.test.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.appears;

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
     * Переходим в форму - Создать задачу
     *
     * @return
     */
    public NewTaskPage goToCreateTask() {
        createTask.click();
        $(By.xpath("//input[contains(@class,'button') and @name='next2']")).shouldHave(visible);
        return page(NewTaskPage.class);
    }

    /**
     * Переходим в форму - Помощь
     *
     * @return
     */
    public HelpHtmlPage goToHelpHtml() {
        helpHtml.click();
        $(By.xpath("//div[@id='mainblock']/ul/li[1]/div[@class='save_button']")).shouldHave(visible);
        return page(HelpHtmlPage.class);
    }

    /**
     * Переходим в грид Задачи/Задачи
     *
     * @return
     */
    public TasksReportsPage goToTaskReports() {
        menuTaskReports.click();
        $(By.xpath("//div[@id='mainblock']/table[3]//tr")).shouldBe(present);
        return page(TasksReportsPage.class);
    }

    /**
     * Переходим в грид Настройки
     *
     * @return
     */
    public OptionsPage goToOptions() {
        options.click();
        $(By.xpath("(//input[@type='submit'])[2]")).shouldBe(present);
        return page(OptionsPage.class);
    }

    /**
     * Переходим в грид Сегодня
     *
     * @return
     */
    public TodayPage goToToday() {
        today.click();
        $(By.xpath("//div[@id='headertop']//ul/a[2]/li")).shouldBe(present);
        return page(TodayPage.class);
    }

    /**
     * Переходим в грид Задачи/Задачи
     *
     * @return
     */
    public TasksReportsPage goToTaskOptions() {
        menuTaskReports.click();
        $(By.xpath("//div[@id='mainblock']/table[3]//tr")).shouldBe(present);
        return page(TasksReportsPage.class);
    }

    /**
     * Вернуться домой и выйти из системы
     */
    public LoginPage homeAndSignOut() {
        goToHome();
        logout.waitUntil(appears, 4);
        logout.click();
        $("#center>form>div>img").shouldBe(visible);
        $(By.cssSelector("#login")).shouldHave(appears);
        $(By.cssSelector("#pass")).shouldHave(appears);
        $(By.cssSelector("input[name='logon']")).getCssValue("Вход");
        return page(LoginPage.class);
    }

    /**
     * Выход из Системы
     */
    public LoginPage signOut() {
        logout.click();
        $("#center>form>div>img").shouldBe(visible);
        $(By.cssSelector("#login")).shouldHave(appears);
        $(By.cssSelector("#pass")).shouldHave(appears);
        $(By.cssSelector("input[name='logon']")).getCssValue("Вход");
        return page(LoginPage.class);
    }


}
