package com.selenium.test.test.tests;


import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import com.selenium.test.pages.*;
import com.selenium.test.test.data.GeneralData;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.*;
import static org.testng.Assert.assertTrue;

public class VerifyCreateTasks extends GeneralData {


    /*
    Инициализируем модель - Задача
     */
    Task task = setRandomTask()
            .setAuthors(new Employee[]{EMPLOYEE_ADMIN})
            .setTaskSupervisors(new Employee[]{EMPLOYEE_ADMIN})
            .setExecutiveManagers(new Employee[]{EMPLOYEE_ADMIN})
            .setPerformers(new Employee[]{EMPLOYEE_ADMIN})

            .setIsSecret(true) // Секретная задача
            .setIsWithReport(false) // C докладом
            .setIsImportant(true); // Важная задача


    /**
     * проверка - Создание задачи
     */
    @Test
    public void verifyCreateTask() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        // Инициализируем стр. формы создание задачи и переходим на нее
        NewTaskPage newTask = internalPage.goToCreateTask();

        //----------------------------------------------------------------ФОРМА - создания Задачи

        newTask.createTask(task);

        EditTaskPage editTask = newTask.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTask.inputValidationFormTask(task); // Проверяем отображение значений в форме предпросмотра создания задачи

        editTask.createNewTask(); // Создать задачу

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage taskForm = editTask.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        taskForm.verifyCreateTask(task); // Проверяем отображение название созданной Задачи
        assertTrue(taskForm.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.goToHome();

        TasksReportsPage tasksReports = internalPage.goToTaskReports(); // переходим в грид - Задачи/Задачи

        tasksReports.checkDisplayTasksGrid(task); // Проверяем отображение созданной задаи в гриде Задач


        internalPage.homeAndSignOut(); // Универсальный выход из системы


    }


}
