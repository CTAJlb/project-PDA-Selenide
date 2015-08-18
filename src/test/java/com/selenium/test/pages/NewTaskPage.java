package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NewTaskPage extends Page {

    /*
     Название задачи
     */
    @FindBy(xpath = "//input[@id='input_prj_t' and @name='task_name']")
    private SelenideElement tasksName;

    /*
     Описание задачи
     */
    @FindBy(xpath = "//textarea[@id='task_description']")
    private SelenideElement tasksDescription;

    /*
     Окончание задачи
     */
    @FindBy(xpath = "//input[@id='mes_date_end']")
    private SelenideElement dateEnd;

    /*
     Авторы
     */
    @FindBy(xpath = "//input[@id='ag']")
    private SelenideElement authors;

    /*
     Контролеры задачи
     */
    @FindBy(xpath = "//input[@id='cg']")
    private SelenideElement taskSupervisors;

    /*
     Ответственные руководители
     */
    @FindBy(xpath = "//input[@id='rg']")
    private SelenideElement executiveManagers;

    /*
     Исполнители
     */
    @FindBy(xpath = "//input[@id='wg']")
    private SelenideElement performers;

    /*
     Секретная задача
     */
    @FindBy(xpath = "//div[@class='ui-checkbox']//input[@id='secret']")
    private SelenideElement privateTask;

    /*
     C докладом
     */
    @FindBy(xpath = "//div[@class='ui-checkbox']//input[@id='withreport2']")
    private SelenideElement reportRequired;

    /*
     Важная задача
     */
    @FindBy(xpath = "//div[@class='ui-checkbox']//input[@id='taskhigh']")
    private SelenideElement importantTask;

    /*
     Просмотр
     */
    @FindBy(css = "input[name='next2']")
    private SelenideElement view;


    /**
     * Название задачи
     *
     * @param nameTasks
     * @return
     */
    public NewTaskPage setTaskName(String nameTasks) {
        tasksName.clear();
        tasksName.setValue(nameTasks);
        return this;
    }

    /**
     * Описание задачи
     *
     * @return
     */
    public NewTaskPage setTasksDescription(String discriptionTasks) {
        tasksDescription.clear();
        tasksDescription.setValue(discriptionTasks);
        return this;
    }

    /**
     * Окончание задачи
     *
     * @return
     */
    public NewTaskPage setDateEnd(String end) {
        dateEnd.clear();
        dateEnd.setValue(end);
        return this;
    }

    /**
     * Производим заполнение поля - Авторы задачи
     *
     * @param author
     * @return
     */
    public NewTaskPage setAuthors(String author) {
        authors.clear();
        authors.setValue(author);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + author + "')]"))
                .shouldBe(Condition.visible);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + author + "')]")).click();
        return this;
    }

    /**
     * Производим заполнение поля - Контролеры задачи
     *
     * @param taskSuperv
     * @return
     */
    public NewTaskPage setTaskSupervisors(String taskSuperv) {
        taskSupervisors.clear();
        taskSupervisors.setValue(taskSuperv);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + taskSuperv + "')]"))
                .shouldBe(Condition.visible);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + taskSuperv + "')]")).click();
        return this;
    }

    /**
     * Производим заполнение поля - Ответственные руководители
     *
     * @param exeManagers
     * @return
     */
    public NewTaskPage setExecutiveManagers(String exeManagers) {
        executiveManagers.clear();
        executiveManagers.setValue(exeManagers);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + exeManagers + "')]"))
                .shouldBe(Condition.visible);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + exeManagers + "')]")).click();
        return this;
    }

    /**
     * Производим заполнение поля - Исполнители
     *
     * @param performer
     * @return
     */
    public NewTaskPage setPerformers(String performer) {
        performers.clear();
        performers.setValue(performer);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + performer + "')]"))
                .shouldBe(Condition.visible);
        $(By.xpath("//ul[contains(@style,' display: block')]//a[contains(text(),'" + performer + "')]")).click();
        return this;
    }

    /**
     * Секретная задача
     *
     * @param privTask
     * @return
     */
    public NewTaskPage setPrivateTask(boolean privTask) {
        if (privTask) {
            privateTask.click();
        }
        return this;
    }

    /**
     * C докладом
     *
     * @param reportReq
     * @return
     */
    public NewTaskPage setReportRequired(boolean reportReq) {
        if (reportReq) {
            reportRequired.click();
        }
        return this;
    }

    /**
     * Важная задача
     *
     * @param impTask
     * @return
     */
    public NewTaskPage setImportantTask(boolean impTask) {
        if (impTask) {
            importantTask.click();
        }
        return this;
    }

    /**
     * Просмотр (предсоздание задачи)
     *
     * @return
     */
    public EditTaskPage goToPreview() {
        view.click();
        $(By.cssSelector("input[name='next3']")).waitUntil(Condition.appear, 4);
        return page(EditTaskPage.class);
    }


}
