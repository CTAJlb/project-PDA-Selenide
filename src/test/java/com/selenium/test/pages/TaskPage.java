package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Форма задачи (Лента действий)
 */
public class TaskPage extends Page {

    public static final String FILE = "src/test/java/../resources/hello_world.txt";
    public static final String SUBMIT_BUTTON_ADD_FILE = "input[name='myfile1']";

    /*
    Кнопки в форме "Обычной задач"
     */
    @FindBy(xpath = "//*[@id='buttonDopMenu2']/div//div")
    private ElementsCollection buttonMenu;

    /*
     Сохранить
     */
    @FindBy(css = "div.save_button")
    private SelenideElement save;

    /*
     Завершить выполнение
     */
    @FindBy(css = "div.close_button")
    private SelenideElement completeTask;

    /*
     Лента действий
     */
    @FindBy(css = "#text")
    private SelenideElement action;

    /*
     Добавить файл
     */
    @FindBy(xpath = "//a[@onclick='addFile();']//span[2]")
    private SelenideElement addFile;

    /*
     Добавить файл
     */
    @FindBy(css = "input[name='myfile1']")
    private SelenideElement uploadFile;


    /**
     * Проверяем отображение формы созданной задачи
     *
     * @param task
     * @return
     */
    public TaskPage openShapeCreatedTask(Task task) {
        $(By.cssSelector("div.save_button")).shouldBe(Condition.present);
        $(By.xpath("//a[contains(text(),'" + task.getTaskName() + "')][ancestor::ul[@class='ui-listview']]")).shouldHave(Condition.visible);
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

    /**
     * Открываем форму редактирования задачи (Атрибуты задачи)
     *
     * @param task
     * @return
     */
    public EditTaskPage openFormEditTask(Task task, Employee user) {
        $(By.xpath("//a[contains(text(),'" + task.getTaskName() + "')][ancestor::ul[@class='ui-listview']]")).click();
        save.shouldBe(Condition.visible);
        $(By.xpath("//span[@name='autor']/a[text()='" + user.getLastName() + "']")).shouldBe(Condition.visible);
        return page(EditTaskPage.class);
    }


    /**
     * Добавляем текст в ленту действий
     *
     * @param textAction
     * @return
     */
    public TaskPage saveActionsInTheTape(String textAction) {
       $(By.xpath("(//div[@class='menu-line']//a/li)[2]")).click();
        int n = 5;
        while (n > 0) {
            action.setValue(textAction);
            save.click();
            $(By.xpath("//ul[@class='ui-listview']//div/span[text()='" + textAction + "']")).shouldBe(Condition.visible);
            n--;
        }
        return this;
    }

    /**
     * Закрываем задачу
     *
     * @param textAction
     * @return
     */
    public TaskPage closeTask(String textAction) {
        action.setValue(textAction);
        completeTask.click();
        $(By.xpath("//ul[@class='ui-listview']//div/span[text()='" + textAction + "']")).shouldBe(Condition.visible);
        return this;
    }

    /**
     * Проверяем аттачминг файлов в задаче
     *
     * @param textAction
     * @return
     */
    public TaskPage addAttachFiles(String textAction) {
        int i = 2;
        while (i > 0) {
            addFile.click();
            File file = $(By.cssSelector(SUBMIT_BUTTON_ADD_FILE))
                    .uploadFile(new File(FILE));
            action.setValue(textAction);
            save.click();
            $(By.xpath("//div[@class='message-file-container'][text()='Файлы:']")).shouldHave(Condition.visible);
            $(By.xpath("//ul[@class='ui-listview']//div/span[text()='" + textAction + "']")).shouldBe(Condition.visible);
            assertTrue(file.exists());
            assertTrue(file.getPath().replace(File.separatorChar, '/').endsWith("src/test/resources/hello_world.txt"));
            i--;
        }
        return this;
    }


}
