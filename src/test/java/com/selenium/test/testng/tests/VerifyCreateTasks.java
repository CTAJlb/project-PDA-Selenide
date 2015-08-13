package com.selenium.test.testng.tests;


import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.pages.NewTaskPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.testng.tests.VerifyLoginPassword.PAGE_URL;
import static org.testng.Assert.assertTrue;

public class VerifyCreateTasks {

    /**
     * проверка создания задачи
     */
    @Test
    public void verifyCreateTask() {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);
        loginPage.setInputLogin("admin");
        loginPage.setInputPassword("admin");
        InternalPage resultsPage = loginPage.doMenu(); // Проверяем отображение п.м. системы
        assertTrue(resultsPage.hasResults()); // Проверяем отображение п.м. на внутренней странице
        NewTaskPage newTask = resultsPage.clickCreateTask();
        newTask.setTaskName(); // Название задачи
    }


}
