package ru.st.selenium.test.testclass;

import com.codeborne.selenide.Selenide;
import ru.st.selenium.model.Employee;
import ru.st.selenium.model.Task;
import ru.st.selenium.test.data.BaseObjectCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pages.*;


import static org.testng.Assert.assertTrue;

/**
 * Раздел - Сегодня
 */
@Listeners({ScreenShotOnFailListener.class})
public class Today extends BaseObjectCase {


    /*
     Инициализируем модель - Задача #2 (атрибуты и лента для редактирования)
    */
    Task editTask = getRandomObjectTask();

    /*
     Инициализируем текст для Ленты действий задачи
     */
    String textActions = randomString(15);


    /**
     * проверка - Отображение информации в разедел - Сегодня
     */
    @Test(dataProvider = "objectDataTask", priority = 1, retryAnalyzer = Retry.class)
    public void verifyInfoToday(Task task) throws Exception {
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

        internalPage.goToHome();

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReportsPage.checkDisplayTaskGrid(task); // Проверяем отображение созданной задачи в гриде Задач
        tasksReportsPage.openTaskInGrid(task); // открываем форму в гриде задач

        //----------------------------------------------------------------ФОРМА - Задачи - Атрибуты

        taskForm.openFormEditTask(task, EMPLOYEE_ADMIN); // открываем форму редактирования атрибутов задачи

        editTaskPage.editAttributesOfTasks(editTask); // редактируем задачу

        taskForm.saveActionsInTheTape(textActions); // добавляем пользовательский текст в задачу и проверяем его сохранение

        internalPage.goToHome();

        TodayPage todayPage = internalPage.goToToday(); // Переходим на стр.


        todayPage.verifyInformationDisplaySectionToday(textActions);


        internalPage.signOut(); // Выход из системы

    }


}
