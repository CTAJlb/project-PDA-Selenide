package ru.st.selenium.test.data;

import org.testng.annotations.DataProvider;
import ru.st.selenium.model.Administration.FieldsObject.*;
import ru.st.selenium.model.CorrectionMethod;
import ru.st.selenium.model.Administration.Directories.Directories;
import ru.st.selenium.model.Administration.Directories.DirectoryField;
import ru.st.selenium.model.OpenFilesForEdit;
import ru.st.selenium.model.Period;
import ru.st.selenium.model.ShiftDirection;
import ru.st.selenium.model.Task.*;
import ru.st.selenium.model.Administration.TasksTypes.ComputeModeNumerator;
import ru.st.selenium.model.Administration.TasksTypes.ObligatoryFieldTypeTask;
import ru.st.selenium.model.Administration.TasksTypes.TasksTypes;
import ru.st.selenium.model.Administration.TasksTypes.TasksTypesField;
import ru.st.selenium.model.Administration.TypesOfTables.TypesOfTables;
import ru.st.selenium.model.Administration.TypesOfTables.TypesOfTablesField;
import ru.st.selenium.model.Users.Department;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.model.Users.Module;
import ru.st.selenium.model.Users.Status;


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

    //----------------------------------------------------------------------Задачи
    /**
     * Метод создания полностью случайного объекта - "Задача" for PDA
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
     * Параметризация - Инициализируем модель - Задача for PDA
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

    
    //-----Задачи/Создать задачу/Проекты----------------------------------------------------------
    /**
     * Метод создания полностью случайного объекта - "Проект"
     */
    public Project getRandomProject() {
        Project project = new Project()
                .setDescription(randomString(80))
                .setNameProject(randomString(80))
                .setСlient(randomString(80))
                .setEndDate(randomDateTime());
        return project;
    }

    /**
     * Метод создания полностью случайного объекта - "Задача" for Web
     */
    public Task getRandomTask() {
        Task task = new Task()
                .setTaskName(randomString(80))
                .setTasktype(new TasksTypes("Обычный"))
                .setDescription(randomString(500))
                .setDateEnd(tomorrowDate())
                .setIsForReview(randomBoolean())
                .setIsImportant(randomBoolean())
                .setIsSecret(randomBoolean())
                .setIsWithReport(randomBoolean())
                .setProject(getRandomProject());
        return task;
    }

    /**
     * Метод создания полностью случайного объекта - "КТ"
     */
    public Checkpoint getRandomCheckpoint() {
        Checkpoint checkpoint = new Checkpoint()
                .setDate(randomDateTime())
                .setDescription(randomString(100))
                .setIsReady(randomBoolean())
                .setLinkedTo(randomEnum(LinkedTo.class))
                .setName(randomString(80))
                .setOffset(randomInt(10))
                .setPeriod(randomEnum(Period.class));
        return checkpoint;
    }

    /**
     * Метод создания полностью случайного объекта - "ИРГ"
     */
    public IWG getRandomIWG() {
        IWG iwg = new IWG()
                .setIsSystemActionsInParentTask(randomBoolean())
                .setNameIWG(randomString(80))
                .setTasksTypes(new TasksTypes("Обычный"));
        return iwg;
    }


    //---Администрирование----------------------------------------------------------
    //-----Пользователи/Подразделения----------------------------------------------------------

    /**
     * Метод создания полностью случайного объекта - "Подразделение"
     */
    public Department getRandomDepartment() {
        Department department = new Department()
                .setDepName(randomString(20))
                .setConditionalNumber((randomString(20)))
                .setCounter((randomInt(2147483647)))
                .setResetDate(randomDateTime())
                .setNumeratorTemplate("{counter}-{department}-" + " "
                        + randomString(20));
        return department;
    }

    /**
     * Метод создания полностью случайного объекта - "Сотрудник"
     */
    public Employee getRandomEmployer() {
        String pass = randomString(10);
        String newpass = randomString(10);
        Employee user = new Employee()
                .setLastName(randomString(10)).setName(randomString(10)).setPatronymic(randomString(10)) // ФИО
                .setIsMan(randomBoolean())
                .setBirthDate(randomDate())
                .setJobTitle(randomString(20))
                .setLoginName(randomString(10))
                .setPassword(pass).setСonfirmationPassword(pass)
                .setNewPassword(newpass).setNewСonfirmationPassword(newpass)
                .setAdditionalNumber(randomInt(100))
                .setUserForcedSorting(randomInt(100)).setStatus(randomEnum(Status.class))
                .setNeedsPasswordChange(randomBoolean()).setModule(randomEnum(Module.class));
        return user;
    }

    //---Администрирование----------------------------------------------------------
    //-----Типы задач----------------------------------------------------------

    /**
     * Метод создания полностью случайного объекта - "Тип задачи" со всеми типами полей
     */
    public TasksTypes getRandomTasksTypes() {
        TasksTypes tasksTypes = new TasksTypes(randomString(50) /* Название Типа задачи*/)
                .setTaskTypeShiftDirection(randomEnum(ShiftDirection.class)) // Направление смещения при попадании на нерабочее время
                .setTaskTypeCorrectionMethod(randomEnum(CorrectionMethod.class)) // Корректировка даты
                .setIsTaskTypeChangeDisabled(randomBoolean()) // Запретить смену типа задачи
                .setOnlyTheSameTypeIWG(randomBoolean()) // Создавать подзадачи ИРГ только родительского типа
                .setIsCloseTaskWithNotReadyCheckpointsDisabled(randomBoolean()) // Запретить закрытие задач с неготовыми контрольными точками
                .setOpenFilesForEdit(randomEnum(OpenFilesForEdit.class)) // Открывать файлы для редактирования
                .setIsAttachFilesToActionLine(randomBoolean()) // Добавлять файлы в ленту действий
                .setIsAttachFilesToDecription(randomBoolean()) // Добавлять файлы в описание
                .setTasksTypesFields(new TasksTypesField[]{

                        // 1. "СТРОКА"
                        new TasksTypesField()
                                .setFieldName(randomString(20)) // Имя поля
                                .setFieldID(randomIdentifier(15)) // Идентификатор поля
                                .setIsHideInSearch(randomBoolean()) // Скрывать при поиске
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class)) // Обязательность поля
                                .setFieldType(
                                new TypeListFieldsString() // Поле типа "Строка"
                                        .setIsListChoice(randomBoolean()) // Выбор из списка
                                        .setValuesList(randomString(10) + "\n" + randomString(10)) // Список значений
                        ),

                        // 2. "ТЕКСТ"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(
                                new TypeListFieldsText()

                        ),

                        // 3. "ЦЕЛОЕ"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsInt()),

                        // 4. "ВЕЩЕСТВЕННОЕ"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsDouble()),

                        // 5. "ДАТА"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsDate()),

                        // 6. "ССЫЛКА НА СПРАВОЧНИК"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsDirectory() // TODO выбор Cпр-ка И Поля из списка

                        ),

                        // 7. "МНОЖЕСТВЕННАЯ ССЫЛКА НА СПРАВОЧНИК"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsMultiDirectory()), // TODO выбор Cпр-ка И Поля из списка

                        // 8. "ЛОГИЧЕСКИЙ"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsBoolean()

                        ),

                        // 9. "ССЫЛКА НА ЗАДАЧУ"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsReferenceTask()

                        ),

                        // 10. "НУМЕРАТОР"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsNumerator()
                                .setNumeratorTemplate("{counter}-{DD}.{YYYY} " + randomString(15)) // Шаблон нумератора
                                .setComputeMode(randomEnum(ComputeModeNumerator.class)) // Режим вычисления

                        ),

                        // 11. "ССЫЛКА НА ОБЪЕКТ"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsObjectLink()),

                        // 12. "ТАБЛИЦА"
                        new TasksTypesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomIdentifier(15))
                                .setIsHideInSearch(randomBoolean())
                                .setObligatory(randomEnum(ObligatoryFieldTypeTask.class))
                                .setFieldType(new TypeListFieldsTable()),

                });
        return tasksTypes;
    }

    //---Администрирование----------------------------------------------------------
    //-----Справочники----------------------------------------------------------

    /**
     * Метод создания полностью случайного объекта - "Справочники" со всеми типами полей
     */
    public Directories getRandomDirectory() {

        Directories directory = new Directories()

                // Вкладка - Настройки
                .setDirectoryName(randomString(30)) // Название справочника
                .setShareRecords(randomBoolean()) // Общедоступность записей
                .setSetAccessToRecords(randomBoolean()) // Настройка доступа к записям
                .setMappingDevice(randomBoolean()) // Способ отображения - Линейный ли? true - да; false - иерархический
                .setSearchSettings(randomBoolean()) // Поиск через БД? true - Да; false - через SOLR

                // Вкладка - Поля
                .setDirectoryFields(new DirectoryField[]{

                        // 1. Тип поля "СТРОКА"
                        new DirectoryField()
                                .setFieldName(randomString(20)) // Название поля
                                .setFieldID(randomIdentifier(15)) // Идентификатор плдя
                                .setFieldType(new TypeListFieldsString()
                                        .setIsListChoice(randomBoolean()) // Выбор из списка
                                        .setValuesList(randomString(10) + "\n" + randomString(10))) // Список значений
                                .setObligatory(randomBoolean()) // Обязательное поле
                                .setIsUniqueField(randomBoolean()), // Уникальное поле

                        // 2. Тип поля "ТЕКСТ"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsText())
                                .setObligatory(randomBoolean()) // Обязательное поле
                                .setIsUniqueField(randomBoolean()), // Уникальное поле

                        // 3. Тип поля "ЦЕЛОЕ"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsInt())
                                .setObligatory(randomBoolean())
                                .setIsUniqueField(randomBoolean()),

                        // 4. Тип поля "ВЕЩЕСТВЕННОЕ"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsDouble())
                                .setObligatory(randomBoolean())
                                .setIsUniqueField(randomBoolean()),

                        // 5. Тип поля "ДАТА"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsDate())
                                .setObligatory(randomBoolean()),

                        // 6. Тип поля "ФАЙЛ"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsFile()
                                        .setOpenFilesForEdit(randomEnum(OpenFilesForEdit.class))
                                )
                                .setObligatory(randomBoolean()),

                        // 7. Тип поля "ССЫЛКА НА СПРАВОЧНИК"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsDirectory())
                                .setObligatory(randomBoolean()),

                        // 8. Тип поля "МНОЖЕСТВЕННАЯ ССЫЛКА НА СПРАВОЧНИК"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsMultiDirectory())
                                .setObligatory(randomBoolean()),

                        // 9. Тип поля "ЛОГИЧЕСКИЙ"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsBoolean())
                                .setObligatory(randomBoolean()),

                        // 10. Тип поля "ТЕЛЕФОН"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsPhone())
                                .setObligatory(randomBoolean())
                                .setIsUniqueField(randomBoolean()),

                        // 11. Тип поля "EMAIL"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsEmail())
                                .setObligatory(randomBoolean())
                                .setIsUniqueField(randomBoolean()),

                        // 12. Тип поля "ИЗОБРАЖЕНИЕ"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsImage())
                                .setObligatory(randomBoolean()),

                        // 13. Тип поля "ЦВЕТ"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsColor())
                                .setObligatory(randomBoolean())
                                .setIsUniqueField(randomBoolean()),

                        // 14. Тип поля "ВЛОЖЕННЫЙ СПРАВОЧНИК"
                        new DirectoryField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsEnclosedDirectory())
                                .setObligatory(randomBoolean())


                });


        return directory;

    }

    //---Администрирование----------------------------------------------------------
    //-----Типы таблиц----------------------------------------------------------

    /**
     * Метод создания полностью случайного объекта - "Типы таблиц" со всеми типами полей
     */
    public TypesOfTables getRandomTypesOfTables() {

        TypesOfTables typesTables = new TypesOfTables()

                // Вкладка - Настройки
                .setTableTypeName(randomString(30)) // Название справочника
                // Вкладка - Поля
                .setTypesOfTablesFields(new TypesOfTablesField[]{

                        // 1. Тип поля "СТРОКА"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20)) // Название поля
                                .setFieldID(randomIdentifier(15)) // Идентификатор плдя
                                .setFieldType(new TypeListFieldsString()
                                        .setIsListChoice(randomBoolean()) // Выбор из списка
                                        .setValuesList(randomString(10) + "\n" + randomString(10))) // Список значений
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 2. Тип поля "ТЕКСТ"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsText())
                                .setObligatory(randomBoolean()), // Обязательное поле


                        // 3. Тип поля "ЦЕЛОЕ"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsInt()
                                        .setObjectLink(randomBoolean()))
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 4. Тип поля "ВЕЩЕСТВЕННОЕ"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsDouble())
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 5. Тип поля "ДАТА"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsDate())
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 6. Тип поля "ФАЙЛ"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsFile()
                                        .setOpenFilesForEdit(randomEnum(OpenFilesForEdit.class))
                                )
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 7. Тип поля "ССЫЛКА НА СПРАВОЧНИК"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsDirectory() // TODO выбор Cпр-ка И Поля из списка
                                )
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 8. Тип поля "МНОЖЕСТВЕННАЯ ССЫЛКА НА СПРАВОЧНИК"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsMultiDirectory() // TODO выбор Cпр-ка И Поля из списка
                                )
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 9. Тип поля "ЛОГИЧЕСКИЙ"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsBoolean())
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 10. Тип поля "ТЕЛЕФОН"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsPhone())
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 11. Тип поля "EMAIL"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsEmail())
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 12. Тип поля "ИЗОБРАЖЕНИЕ"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsImage())
                                .setObligatory(randomBoolean()), // Обязательное поле

                        // 13. Тип поля "ЦВЕТ"
                        new TypesOfTablesField()
                                .setFieldName(randomString(20))
                                .setFieldID(randomString(15))
                                .setFieldType(new TypeListFieldsColor())
                                .setObligatory(randomBoolean()) // Обязательное поле


                });


        return typesTables;

    }

}
