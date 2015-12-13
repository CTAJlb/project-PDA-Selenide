package ru.st.selenium.test.testPda;

import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.model.Task.Task;
import ru.st.selenium.pagespda.*;
import ru.st.selenium.test.data.BaseObjectCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Создать задачу
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
public class CreateTasksTest extends BaseObjectCase {


    Task editTask = getRandomObjectTask();


    /**
     * проверка - Создание задачи
     */
    @Test(priority = 1, dataProvider = "objectDataTask", retryAnalyzer = Retry.class)
    public void checkTaskCreation(Task task) throws Exception {
        LoginPage loginPage = open(Page.PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTaskPage = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTaskPage.createTask(task);

        EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTaskPage.inputValidationFormTask(task); // Проверяем отображение значений в форме предпросмотра создания задачи

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.openShapeCreatedTask(task); // Открываем созданную задачу
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.goToHome();

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи
        tasksReportsPage.checkDisplayTaskGrid(task); // Проверяем отображение созданной задачи в гриде Задач

        internalPage.logout(); // Выход из системы

    }


    /**
     * проверка - Редактирование задачи
     * TODO - добавить До запуска метода установку зн-ия - Удаление себя из задач == Да
     */
    @Test(priority = 2, dataProvider = "objectDataTask", retryAnalyzer = Retry.class)
    public void checkEditingTasks(Task task) throws Exception {
        LoginPage loginPage = Selenide.open(Page.PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTaskPage = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTaskPage.createTask(task);

        EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTaskPage.inputValidationFormTask(task); // Проверяем отображение значений в форме предпросмотра создания задачи

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.openShapeCreatedTask(task); // Открываем созданную задачу
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.goToHome(); // Домашняя стр-ца

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReportsPage.checkDisplayTaskGrid(task); // Проверяем отображение созданной задачи в гриде Задач
        tasksReportsPage.openTaskInGrid(task); // открываем форму в гриде задач

        //----------------------------------------------------------------ФОРМА - Задачи - Атрибуты

        taskForm.openFormEditTask(task, EMPLOYEE_ADMIN); // открываем форму редактирования атрибутов задачи
        editTaskPage.editAttributesOfTasks(editTask); // редактируем атрибуты задачи
        taskForm.saveActionsInTheTape(randomString(15)); // добавляем пользовательский текст в задачу и проверяем его сохранение
        editTaskPage.editWorkingGroupInTask(EMPLOYEE_ADMIN); // редактируем РГ задачи (удаляем пользователей)

        internalPage.logout(); // Выход из системы

    }


    /**
     * проверка - Закрытие задачи (Отправка в архив)
     */
     @Test(priority = 3, dataProvider = "objectDataTask", retryAnalyzer = Retry.class)
     public void verifyCompletionOfTheTask(Task task) throws Exception {
     LoginPage loginPage = Selenide.open(Page.PDA_PAGE_URL, LoginPage.class);

     // Авторизация
     loginPage.loginAsAdmin(ADMIN);

     InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
     assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице

     // Инициализируем стр. формы создание задачи и переходим на нее
     NewTaskPage newTaskPage = internalPage.goToCreateTask();

     //----------------------------------------------------------------ФОРМА - создания Задачи

     newTaskPage.createTask(task);

     EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

     //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

     editTaskPage.inputValidationFormTask(task); // Проверяем отображение значений в форме предпросмотра создания задачи

     //----------------------------------------------------------------ФОРМА - Задачи

     TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

     taskForm.openShapeCreatedTask(task); // Открываем форму созданной задачу
     assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

     internalPage.goToHome();

     TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

     taskForm.closeTask(task, randomString(15)); // Закрываем задачу (отправляем в архив)

     internalPage.goToHome(); // Возвращаемся домой (внутренняя страница)
     internalPage.goToTaskReports(); // переходим в грид задач

     tasksReportsPage.checkDisappearTaskInGrid(task);

     internalPage.logout(); // Выход из системы


     }


}
