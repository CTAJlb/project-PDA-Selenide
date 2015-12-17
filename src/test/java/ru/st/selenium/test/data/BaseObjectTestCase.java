package ru.st.selenium.test.data;

import org.testng.annotations.DataProvider;
import ru.st.selenium.model.Task.Task;
import ru.st.selenium.model.Users.Employee;


/**
 * Общие данные для работы - инициализация
 */
public abstract class BaseObjectTestCase extends TestBase {

    //----------------------------------------------------------------Авторизация

    /**
     * Инициализация входных данных для Логин и Пароль
     */
    @DataProvider(name = "verifyFailAuthorization")
    public Object[][] firstNotSuccessfulAuthorizationDataProvider() {
        return new Object[][]{
                {"fail", "admin"},
                {"admin", "fail"},
                {"fail", "fail"},
                {"admin", ""}
        };
    }

    @DataProvider(name = "secondVerifyFailAuthorization")
    public Object[][] secondNotSuccessfulAuthorizationDataProvider() {
        return new Object[][]{
                {"", "admin"},
                {"", ""}
        };
    }

    /**
     * Метод создания полностью случайного объекта - "Задача"
     */
    public Task getRandomObjectTask() {
        Task task = new Task()
                .setTaskName(randomString(15) + " " + randomString(30))
                .setDescription(randomString(100) + "\n " + randomString(100) + "\n " + randomString(100))
                .setDateEnd(tomorrowDate())
                .setIsImportant(randomBoolean())
                .setIsSecret(randomBoolean())
                .setIsWithReport(randomBoolean());
        return task;
    }

    /**
     * Параметризация - Инициализируем модель - Задача
     */
    @DataProvider
    public Object[][] objectDataTask() {
        return new Object[][]{

                {new Task().setTaskName(randomString(15) + " " + randomString(30))
                        .setDescription(randomString(100) + "\n " + randomString(100) + "\n " + randomString(100))
                        .setDateEnd(tomorrowDate())
                        .setAuthors(new Employee[]{EMPLOYEE_ADMIN})
                        .setControllers(new Employee[]{EMPLOYEE_ADMIN})
                        .setExecutiveManagers(new Employee[]{EMPLOYEE_ADMIN})
                        .setWorkers(new Employee[]{EMPLOYEE_ADMIN})
                        .setIsSecret(true) // Секретная задача
                        .setIsWithReport(false) // C докладом
                        .setIsImportant(true)}, // Важная задача

        };
    }


}
