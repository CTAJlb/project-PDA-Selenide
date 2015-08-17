package com.selenium.test.testng.tests;


import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.pages.NewTaskPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.*;
import static org.testng.Assert.assertTrue;

public class VerifyCreateTasks {

    /**
     * проверка - Создания задачи
     */
    @Test
    public void verifyCreateTask() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        String admin = "admin";
        String nameTask = randomString(25);

        // Авторизация
        loginPage.setInputLogin(admin);
        loginPage.setInputPassword(admin);

        InternalPage resultsPage = loginPage.doMenu(); // Проверяем отображение п.м. системы
        assertTrue(resultsPage.hasResults()); // Проверяем отображение п.м. на внутренней странице

        NewTaskPage newTask = resultsPage.clickCreateTask(); // Инициализируем стр. формы создание задачи

        // Заполняем форму создания задачи
        newTask.setTaskName(nameTask); // вводим Название задачи

        newTask.setTasksDescription(randomString(50) + "\n" + randomString(25)
                + "\n" + randomString(100)); // вводим Описание задачи

        newTask.setTaskSupervisors(admin); // Контролеры задачи
        newTask.setExecutiveManagers(admin); // Ответственные руководители задачи
        newTask.setPerformers(admin); // Ответственные руководители задачи

        newTask.setDateEnd(tommorowDate()); // Дата окончани = Завтра;

        newTask.setPrivateTask(true); // Секретная задача
        newTask.setReportRequired(true); // C докладом
    }


}
