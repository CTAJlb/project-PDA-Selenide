package com.selenium.test.test.tests;

import com.selenium.test.model.Employee;
import com.selenium.test.model.Task;
import com.selenium.test.pages.*;
import com.selenium.test.test.data.GeneralData;
import com.selenium.test.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.selenium.test.pages.Page.PAGE_URL;
import static org.testng.Assert.assertTrue;

/**
 * Раздел - Настройки
 */
@Listeners({ScreenShotOnFailListener.class})
public class Options extends GeneralData {


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



    /**
     * проверка - Аттачминг файлов в форме задачи
     */
    @Test(priority = 1)
    public void verifyAttachFiles() throws Exception {
        LoginPage loginPage = open(PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);

        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenu()); // Проверяем отображение п.м. на внутренней странице


        // Инициализируем стр. формы Настройки и переходим на нее
        OptionsPage optionsPage = internalPage.goToOptions();

        optionsPage.selAttachFiles(true); // устанавливаем признак - возможность прикрепления файлов
        internalPage.goToHome(); // уходим домой


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



    }

}

