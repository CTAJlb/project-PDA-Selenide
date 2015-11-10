package com.selenium.test.test.tests;


import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import com.selenium.test.pages.*;
import com.selenium.test.test.data.TestBase;
import com.selenium.test.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.*;
import static org.testng.Assert.assertTrue;


@Listeners({ScreenShotOnFailListener.class})
public class CreateTasks extends TestBase {


    /*
    Инициализируем модель - Задача #1
     */
    Task task = getRandomTask()
            .setAuthors(new Employee[]{EMPLOYEE_ADMIN})
            .setTaskSupervisors(new Employee[]{EMPLOYEE_ADMIN})
            .setExecutiveManagers(new Employee[]{EMPLOYEE_ADMIN})
            .setPerformers(new Employee[]{EMPLOYEE_ADMIN})

            .setIsSecret(true) // Секретная задача
            .setIsWithReport(false) // C докладом
            .setIsImportant(true); // Важная задача

    /*
    Инициализируем модель - Задача #2
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
    Инициализируем модель - Задача #3
     */
    Task task2 = getRandomTask()
            .setAuthors(new Employee[]{EMPLOYEE_ADMIN})
            .setTaskSupervisors(new Employee[]{EMPLOYEE_ADMIN})
            .setExecutiveManagers(new Employee[]{EMPLOYEE_ADMIN})
            .setPerformers(new Employee[]{EMPLOYEE_ADMIN})

            .setIsSecret(true) // Секретная задача
            .setIsWithReport(false) // C докладом
            .setIsImportant(true); // Важная задача

    /*
   Инициализируем модель - Задача #3 (атрибуты и лента для редактирования)
    */
    Task editTask = getRandomTask();


    /**
     * проверка - Создание задачи
     */
    @Test(priority = 1)
    public void checkTaskCreation() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

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

        internalPage.homeAndSignOut(); // Выход из системы

    }

    /**
     * проверка - Редактирование задачи
     */
    @Test(priority = 2)
    public void checkEditingTasks() throws Exception {
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

        internalPage.goToHome(); // Домашняя стр-ца

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReportsPage.checkDisplayTaskGrid(task1); // Проверяем отображение созданной задачи в гриде Задач
        tasksReportsPage.openTaskInGrid(task1); // открываем форму в гриде задач

        //----------------------------------------------------------------ФОРМА - Задачи - Атрибуты

        taskForm.openFormEditTask(task1, EMPLOYEE_ADMIN); // открываем форму редактирования атрибутов задачи

        editTaskPage.editAttributesOfTasks(editTask); // редактируем атрибуты задачи

        taskForm.saveActionsInTheTape(randomString(15)); // добавляем пользовательский текст в задачу и проверяем его сохранение

        editTaskPage.editWorkingGroupInTask(EMPLOYEE_ADMIN); // редактируем РГ задачи (удаляем пользователей)


        internalPage.homeAndSignOut(); // Выход из системы


    }

    /**
     * проверка - Закрытие задачи (Отправка в архив)
     */
    @Test(priority = 3)
    public void checkTheCompletionOfTheTask() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTaskPage = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTaskPage.createTask(task2);

        EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTaskPage.inputValidationFormTask(task2); // Проверяем отображение значений в форме предпросмотра создания задачи

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.openShapeCreatedTask(task2); // Открываем форму созданной задачу
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.goToHome();

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReportsPage.checkDisplayTaskGrid(task2); // Проверяем отображение созданной задачи в гриде Задач
        tasksReportsPage.openTaskInGrid(task2); // открываем форму в гриде задач
        taskForm.closeTask(randomString(20)); // Закрываем задачу (отправляем в архив)


        internalPage.goToHome();
        internalPage.goToTaskReports();

        tasksReportsPage.checkDisappearTaskInGrid(task2);

        internalPage.homeAndSignOut(); // Выход из системы


    }


}
