package ru.st.selenium.test.testclass;

import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.model.Task;
import ru.st.selenium.test.data.BaseObjectCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pages.*;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Настройки
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
public class Options extends BaseObjectCase {



    /**
     * проверка - Аттачминг файлов в форме задачи
     */
    @Test(dataProvider = "objectDataTask", priority = 1, retryAnalyzer = Retry.class)
    public void verifyAttachmentFileInTheTask(Task task) throws Exception {
        LoginPage loginPage = open(Page.PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице


        // Инициализируем стр. формы Настройки и переходим на нее
        OptionsPage optionsPage = internalPage.goToOptions();
        optionsPage.selAttachFiles(true); // устанавливаем признак - возможность прикрепления файлов
        internalPage.goToHome(); // уходим домой


        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTaskPage = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTaskPage.createTask(task);

        EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTaskPage.inputValidationFormTask(task); // Проверяем отображение значений в форме предпросмотра создания задачи

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.openShapeCreatedTask(task); // Открываем форму созданной задачи
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        taskForm.addAttachFiles(randomString(15)); // Аттачим файлы

        internalPage.signOut(); // Выход из системы

    }


}

