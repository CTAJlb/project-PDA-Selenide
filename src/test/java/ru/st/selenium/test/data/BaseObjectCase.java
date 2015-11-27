package ru.st.selenium.test.data;


import org.testng.annotations.DataProvider;
import ru.st.selenium.model.Employee;
import ru.st.selenium.model.Task;

/**
 * данные для работы с объектами Мотив
 */
public abstract class BaseObjectCase extends TestBase {

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

    //--------------------------------------------------------------------Задача

    /**
     * Метод создания полностью случайного объекта - "Задача"
     */
    public Task getRandomObjectTask() {
        Task task = new Task()
                .setTaskName(randomString(15) + " " + randomString(30))
                .setDescription(randomString(100) + "\n " + randomString(100) + "\n " + randomString(100))
                .setDateEnd(tommorowDate())
                .setIsImportant(randomBoolean())
                .setIsSecret(randomBoolean())
                .setIsWithReport(randomBoolean());
        return task;
    }

    /**
     * @DataProvider ответственнен за предоставление тестовых данных для методов, использующих его
     *
     * Инициализируем модель - Задача
     */
    @DataProvider
    public Object[][] objectDataTask() {
        return new Object[][]{

                {getRandomObjectTask().setAuthors(new Employee[]{EMPLOYEE_ADMIN})
                        .setTaskSupervisors(new Employee[]{EMPLOYEE_ADMIN})
                        .setExecutiveManagers(new Employee[]{EMPLOYEE_ADMIN})
                        .setPerformers(new Employee[]{EMPLOYEE_ADMIN})
                        .setIsSecret(true) // Секретная задача
                        .setIsWithReport(false) // C докладом
                        .setIsImportant(true)}, // Важная задача

        };
    }


}