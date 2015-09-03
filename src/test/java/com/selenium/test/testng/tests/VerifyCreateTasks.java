package com.selenium.test.testng.tests;


import com.selenium.test.pages.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.*;
import static org.testng.Assert.assertTrue;

public class VerifyCreateTasks {

    String admin = "admin";
    // Инициализируем: - Название задачи
    String nameTask = randomString(25);
    // -Описание задачи
    String taskDescription = randomString(50) + "\n" + randomString(25)
            + "\n" + randomString(100);
    // -Окончание задачи
    String dateEnd = tommorowDate();


    /**
     * проверка - Создание задачи
     */
    @Test
    public void verifyCreateTask() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAs(admin, admin);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице

        NewTaskPage newTask = internalPage.goToCreateTask(); // Инициализируем стр. формы создание задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - создание задачи

        newTask.setTaskName(nameTask); // вводим Название задачи

        newTask.setTasksDescription(taskDescription); // вводим Описание задачи

        newTask.setTaskSupervisors(admin); // Контролеры задачи
        newTask.setExecutiveManagers(admin); // Ответственные руководители задачи
        newTask.setPerformers(admin); // Ответственные руководители задачи

        newTask.setDateEnd(dateEnd); // Дата окончани = Завтра;

        newTask.setPrivateTask(true); // Секретная задача
        newTask.setReportRequired(false); // C докладом
        newTask.setImportantTask(true); // Важная задача

        EditTaskPage editTask = newTask.goToPreview(); // Инициализируем стр. формы предпросмотра задачи и переходим на нее

        //----------------------------------------------------------------ФОРМА - Предпросмотр создания задачи

        editTask.inputValidationFormTask(nameTask, taskDescription, dateEnd); // Проверяем отображение значений в форме предпросмотра создания задачи

        editTask.createNewTask(); // Создать задачу

        //----------------------------------------------------------------ФОРМА - Задачи

        TaskPage task = editTask.goToTask(); // Инициализируем стр. формы - Созданной задачи и переходим на нее

        task.verifyCreateTask(nameTask); // Проверяем отображение название созданной Задачи
        assertTrue(task.resultsDisplayButtons()); // Проверяем отображения кнопок в форме задачи

        internalPage.homeAndSignOut(); // Универсальный выход из системы



    }


}
