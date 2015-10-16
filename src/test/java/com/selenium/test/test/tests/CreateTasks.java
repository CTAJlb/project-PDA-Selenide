package com.selenium.test.test.tests;


import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import com.selenium.test.pages.*;
import com.selenium.test.test.data.GeneralData;
import com.selenium.test.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.*;
import static org.testng.Assert.assertTrue;


@Listeners({ScreenShotOnFailListener.class})
public class CreateTasks extends GeneralData {


    /*
    Инициализируем модель - Задача #1
     */
    Task newTask = getRandomTask()
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
    Task newTask2 = getRandomTask()
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
    public void verifyCreateTask() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTaskPage = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTaskPage.createTask(newTask);

        EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTaskPage.inputValidationFormTask(newTask); // Проверяем отображение значений в форме предпросмотра создания задачи

        editTaskPage.saveNewTask(); // Создать задачу

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.openShapeCreatedTask(newTask); // Открываем созданную задачу
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.goToHome();

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReportsPage.checkDisplayTaskGrid(newTask); // Проверяем отображение созданной задачи в гриде Задач


        internalPage.homeAndSignOut(); // Выход из системы


    }

    /**
     * проверка - Редактирование задачи
     */
    @Test(priority = 2)
    public void verifyEditTask() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTaskPage = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTaskPage.createTask(newTask2);

        EditTaskPage editTaskPage = newTaskPage.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTaskPage.inputValidationFormTask(newTask2); // Проверяем отображение значений в форме предпросмотра создания задачи

        editTaskPage.saveNewTask(); // Создать задачу

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTaskPage.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.openShapeCreatedTask(newTask2); // Открываем созданную задачу
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.goToHome();

        TasksReportsPage tasksReportsPage = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReportsPage.checkDisplayTaskGrid(newTask2); // Проверяем отображение созданной задачи в гриде Задач

        tasksReportsPage.openTaskInGrid(newTask2); // открываем форму в гриде задач

        taskForm.openFormEditTask(newTask2, EMPLOYEE_ADMIN); // открываем форму редактирования атрибутов задачи

        editTaskPage.editAttributesOfTasks(editTask); // редактируем задачу

        editTaskPage.checkTheAttributesAreSaved(editTask); // проверяем сохранение измнений в ленте действий

        taskForm.saveActionsInTheTape(randomString(15)); // добавляем пользовательский текст в задачу и проверяем его сохранение


        internalPage.homeAndSignOut(); // Выход из системы



    }




}
