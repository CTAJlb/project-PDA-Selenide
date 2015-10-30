package com.selenium.test.test.tests;

import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import com.selenium.test.pages.*;
import com.selenium.test.test.data.TestBase;
import com.selenium.test.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.PAGE_URL;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Сегодня
 */
@Listeners({ScreenShotOnFailListener.class})
public class Today extends TestBase  {

    /*
    Инициализируем модель - Задача #1
     */
    Task task1 = getRandomTask()
            .setAuthors(new Employee[]{EMPLOYEE_ADMIN})
            .setTaskSupervisors(new Employee[]{EMPLOYEE_ADMIN})
            .setExecutiveManagers(new Employee[]{EMPLOYEE_ADMIN})
            .setPerformers(new Employee[]{EMPLOYEE_ADMIN})

            .setIsSecret(true) // Секретная задача
            .setIsWithReport(false) // C докладом
            .setIsImportant(true); // Важная задача

    /*
   Инициализируем модель - Задача #2 (атрибуты и лента для редактирования)
    */
    Task editTask = getRandomTask();

    /*
    Инициализируем текст для Ленты действий задачи
     */
    String textActions = randomString(15);



    /**
     * проверка - Отображение информации в разедел - Сегодня
     */
    @Test(priority = 1)
    public void verifyInfoToday() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTaskPage = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTaskPage.createTask(task1);

        EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTaskPage.inputValidationFormTask(task1); // Проверяем отображение значений в форме предпросмотра создания задачи

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.openShapeCreatedTask(task1); // Открываем созданную задачу
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.goToHome();

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReportsPage.checkDisplayTaskGrid(task1); // Проверяем отображение созданной задачи в гриде Задач
        tasksReportsPage.openTaskInGrid(task1); // открываем форму в гриде задач

        //----------------------------------------------------------------ФОРМА - Задачи - Атрибуты

        taskForm.openFormEditTask(task1, EMPLOYEE_ADMIN); // открываем форму редактирования атрибутов задачи

        editTaskPage.editAttributesOfTasks(editTask); // редактируем задачу
        editTaskPage.checkTheAttributesAreSaved(editTask); // проверяем сохранение измнений в ленте действий
        taskForm.saveActionsInTheTape(textActions); // добавляем пользовательский текст в задачу и проверяем его сохранение

        internalPage.goToHome();

        TodayPage todayPage = internalPage.goToToday(); // Переходим на стр.


        todayPage.verifyInformationDisplaySectionToday(textActions);



        internalPage.homeAndSignOut(); // Выход из системы

    }







}
