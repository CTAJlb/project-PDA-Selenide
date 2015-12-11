package ru.st.selenium.test.testPda;

import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.test.data.BaseObjectCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pagespda.InternalPage;
import ru.st.selenium.pagespda.LoginPage;
import ru.st.selenium.pagespda.Page;
import ru.st.selenium.pagespda.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

/**
 * раздел - Поиск
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
public class SearchTest extends BaseObjectCase {



    /**
     * проверка - Посик в системе - SOLR
     */
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void verifySearch() throws Exception {
        LoginPage loginPage = open(Page.PDA_PAGE_URL, LoginPage.class);

        // Авторизация
        loginPage.loginAsAdmin(ADMIN);
        InternalPage internalPage = loginPage.goToInternalMenu(); // Инициализируем внутренюю стр. системы и переходим на нее
        assertTrue(internalPage.hasMenuUserComplete()); // Проверяем отображение п.м. на внутренней странице


       /*  TODO поиск задачи через SOLR
       NewTaskPage newTaskPage = internalPage.goToCreateTask();  // Инициализируем стр. формы создание задачи и переходим на нее

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

        internalPage.goToHome();

        //----------------------------------------------------------------ГРИД - ПОИСК

        SearchPage searchPage = internalPage.goToSearch(); // Переходим в раздел Поиска
        searchPage.searchTask(task); // Производим поиск задачи по - Названию */

        SearchPage searchPage = internalPage.goToSearch(); // Переходим в раздел Поиска
        //TODO Добавить выбор фильтрации - КОНТАКТЫ
        searchPage.searchContact(EMPLOYEE_ADMIN); // проверяем поиск Контакта пользователя по Фамилии


        internalPage.logout(); // Выход из системы

    }


}


