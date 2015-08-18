package com.selenium.test.testng.tests;


import com.selenium.test.pages.EditTaskPage;
import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.pages.NewTaskPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.*;
import static org.testng.Assert.assertTrue;

public class VerifyCreateTasks {

    String user = "admin";
    // Инициализируем: - Название задачи
    String nameTask = randomString(25);
    // -Описание задачи
    String taskDescription = randomString(50) + "\n" + randomString(25)
            + "\n" + randomString(100);
    // -Окончание задачи
    String dateEnd = tommorowDate();


    /**
     * проверка - Создания задачи
     */
    @Test
    public void verifyCreateTask() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.setInputLogin(user);
        loginPage.setInputPassword(user);

        InternalPage resultsPage = loginPage.doMenu(); // Проверяем отображение п.м. системы
        assertTrue(resultsPage.hasResults()); // Проверяем отображение п.м. на внутренней странице

        NewTaskPage newTask = resultsPage.clickCreateTask(); // Инициализируем стр. формы создание задачи

        //----------------------------------------------------------------ФОРМА - создание задачи

        newTask.setTaskName(nameTask); // вводим Название задачи

        newTask.setTasksDescription(taskDescription); // вводим Описание задачи

        newTask.setTaskSupervisors(user); // Контролеры задачи
        newTask.setExecutiveManagers(user); // Ответственные руководители задачи
        newTask.setPerformers(user); // Ответственные руководители задачи

        newTask.setDateEnd(dateEnd); // Дата окончани = Завтра;

        newTask.setPrivateTask(true); // Секретная задача
        newTask.setReportRequired(false); // C докладом
        newTask.setImportantTask(true); // Важная задача

        EditTaskPage editTask = newTask.preview(); // Просмотр

        //----------------------------------------------------------------ФОРМА - preview создания задачи

        editTask.inputValidationFormTask(nameTask,taskDescription, dateEnd); // Проверяем отображение значений в форме preview создания задачи

        editTask.createNewTask(); // Создать задачу









    }


}
