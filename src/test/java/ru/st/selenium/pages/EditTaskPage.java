package ru.st.selenium.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.st.selenium.model.Employee;
import ru.st.selenium.model.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Форма задачи (Атрибуты задачи)
 */
public class EditTaskPage extends NewTaskPage {

    /*
     * кнопка Создать задачу
     */
    @FindBy(css = "input[name='next3']")
    private SelenideElement createTask;

    /*
     * Ссылка - Перейти к задаче
     */
    @FindBy(xpath = "//a[contains(@href, '/task/')]")
    private SelenideElement goToTask;

    /*
     * Сохранить
     */
    @FindBy(css = "div.save_button")
    private SelenideElement save;

    /*
     * Ссылка на задачу в форме редактирования задачи
     */
    @FindBy(xpath = "(//div[@class='menu-line']//a/li)[2]")
    private SelenideElement linkTaskReturnMainForm;


    /**
     * Проверка введенных данный в предпросмотре формы создания задачи
     *
     * @param task return values of attributes of the task
     * @return EditTaskPage page
     */
    public EditTaskPage inputValidationFormTask(Task task) {
        $(By.xpath("//form[@id='data_value']//li[2]//span[@style][text()='" + task.getTaskName() + "']"))
                .shouldBe(visible); // Название задачи
        $(By.xpath("//form[@id='data_value']//li[3]//span[@style][text()='" + task.getDescription() + "']"))
                .shouldBe(visible); // Описание задачи
        $(By.xpath("//form[@id='data_value']//li[9]//span[@style][contains(text(),'" + task.getDateEnd() + "')]"))
                .shouldBe(visible); // Окончание задачи
        saveNewTask();
        return this;
    }

    /**
     * Создать (нажатие кнопки - Создать)
     *
     * @return EditTaskPage
     */
    public EditTaskPage saveNewTask() {
        createTask.click();
        $(By.xpath("//a[contains(@href, '/task/')]")).waitUntil(Condition.appear, 4);
        return this;
    }

    /**
     * Перейти к форме задачи (Лента действий)
     *
     * @return TaskPage
     */
    public TaskPage goToTask() {
        goToTask.click();
        return page(TaskPage.class);
    }

    /**
     * Сохранить изменения по задаче
     *
     * @return EditTaskPage
     */
    public EditTaskPage saveChangesToTask() {
        save.click();
        return this;
    }

    /**
     * Редактирование атрибутов задачи
     *
     * @return EditTaskPage
     */
    public EditTaskPage editAttributesOfTasks(Task editTask) {
        setTaskName(editTask.getTaskName()) // Название задачи
                .setTasksDescription(editTask.getDescription()) // Описание задачи
                .setDateEnd(editTask.getDateEnd()) // Дата окончания задачи
                .setImportantTask(editTask.getIsImportant()) // признак - Важная задача
                .setPrivateTask(editTask.getIsSecret()); // признак - Секретная задача
        saveChangesToTask();
        waitMillisecond(1.5);
        checkTheAttributesAreSaved(editTask); // проверяем отображение изменений (системное действие) в ленте действий
        verifyAttributesOfTask(editTask); // проверяем отображение новых значений в полях задачи

        return this;
    }

    /**
     * Проверяем отображение новых значений в полях задачи
     *
     * @return EditTaskPage
     */
    public EditTaskPage verifyAttributesOfTask(Task editTask) {
        goToTask.click();
        $(By.xpath("//input[@id='input_prj_t' and @name='task_name']"))
                .waitUntil(hasValue(" " + editTask.getTaskName() + " "), 5000); // Название задачи
        $(By.xpath("//textarea[@id='task_description']"))
                .shouldHave(value(" " + editTask.getDescription() + " ")); // Описание задачи
        return this;
    }

    /**
     * Редактирование РГ (рабочая группа) задачи
     *
     * @param employee return values user details
     * @return EditTaskPage
     */
    public EditTaskPage editWorkingGroupInTask(Employee employee) {
        goToTask.click();
        // Удаляем - Контролеры задачи
        $(By.xpath("//input[@id='input_prj_t' and contains(@name,'cg_') and @value='" + employee.getLastName() + "']/../..//a[not(contains(@onclick,'window.open'))]//span[2]")).click();
        $(By.xpath("//input[@id='input_prj_t' and contains(@name,'cg_') and @value='" + employee.getLastName() + "']/../..//a[not(contains(@onclick,'window.open'))]//span[2]"))
                .shouldNotBe(visible);
        // Удаляем - Ответственные руководители
        $(By.xpath("//input[@id='input_prj_t' and contains(@name,'rg_') and @value='" + employee.getLastName() + "']/../..//a[not(contains(@onclick,'window.open'))]//span[2]")).click();
        $(By.xpath("//input[@id='input_prj_t' and contains(@name,'rg_') and @value='" + employee.getLastName() + "']/../..//a[not(contains(@onclick,'window.open'))]//span[2]"))
                .shouldNotBe(visible);
        // Удаляем - Исполнители
        $(By.xpath("//input[@id='input_prj_t' and contains(@name,'wg_') and @value='" + employee.getLastName() + "']/../..//a[not(contains(@onclick,'window.open'))]//span[2]")).click();
        $(By.xpath("//input[@id='input_prj_t' and contains(@name,'wg_') and @value='" + employee.getLastName() + "']/../..//a[not(contains(@onclick,'window.open'))]//span[2]"))
                .shouldNotBe(visible);
        checkWorkingGroupInTaskAreSaved(employee); // проверяем формирование системных действий об удалении пользователей в ленте действий задачи
        return this;
    }

    /**
     * Проверяем сохраненные изменения в ленте действий задачи
     *
     * @param editTask
     * @return TaskPage
     */
    public TaskPage checkTheAttributesAreSaved(Task editTask) {
        linkTaskReturnMainForm.click();
        $(By.xpath("//div[@id='mainblock']//ul[@class='ui-listview']//div//font[text()='" + editTask.getTaskName() + "']"))
                .shouldHave(Condition.exactText(" " + editTask.getTaskName() + " "));
        return page(TaskPage.class);
    }

    /**
     * Проверяем сохраненные изменения в ленте действий задачи
     *
     * @param employee
     * @return TaskPage
     */
    public TaskPage checkWorkingGroupInTaskAreSaved(Employee employee) {
        linkTaskReturnMainForm.click();
        $$(By.xpath("//span[contains(text(),'Из задачи удален') and contains(text(),'" + employee.getLastName() + "')]"))
                .shouldHave(CollectionCondition.size(3));
        return page(TaskPage.class);
    }


}
