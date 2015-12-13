package ru.st.selenium.test.data;

import org.testng.annotations.DataProvider;
import ru.st.selenium.model.AccessRights;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditor;
import ru.st.selenium.model.DocflowAdministration.DictionaryEditor.DictionaryEditorField;
import ru.st.selenium.model.Task.Task;
import ru.st.selenium.model.Users.Employee;


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

    //--------------------------------------------------------------------Создать задачу

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
     * <p>
     * Инициализируем модель - Задача
     */
    @DataProvider
    public Object[][] objectDataTask() {
        return new Object[][]{

                {getRandomObjectTask().setAuthors(new Employee[]{EMPLOYEE_ADMIN})
                        .setControllers(new Employee[]{EMPLOYEE_ADMIN})
                        .setExecutiveManagers(new Employee[]{EMPLOYEE_ADMIN})
                        .setWorkers(new Employee[]{EMPLOYEE_ADMIN})
                        .setIsSecret(true) // Секретная задача
                        .setIsWithReport(false) // C докладом
                        .setIsImportant(true)}, // Важная задача

        };
    }

    //---Администрирование/Администрирование ДО----------------------------------------------------------
    //-----Редактор словарей----------------------------------------------------------

    /**
     * Метод создания полностью случайного объекта - "Редактор словарей"
     */
    public DictionaryEditor getRandomDictionaryEditor() {
        DictionaryEditor dictionEditor = new DictionaryEditor()
                .setDictionaryEditorName(randomString(15)) // Название Словаря
                .setAccessDiction(randomEnum(AccessRights.class))// Уровень доступа
                .setDictionaryEditorFields(new DictionaryEditorField[]{

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(80) + "\n" + randomString(15)), // Описание элемента словаря

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(15) + "\n" + randomString(50)), // Описание элемента словаря

                        new DictionaryEditorField()
                                .setNameDictionItem(randomString(15)) // Название элемента словаря
                                .setDescriptionDictionItem(randomString(30) + "\n" + randomString(15)), // Описание элемента словаря

                });

        return dictionEditor;
    }


}
