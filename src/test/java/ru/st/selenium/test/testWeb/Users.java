package ru.st.selenium.test.testWeb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Users.Department;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.model.Users.Module;
import ru.st.selenium.test.data.BaseObjectTestCase;


import static org.junit.Assert.assertTrue;

public class Users extends BaseObjectTestCase {

  /*

    *//**
     * Инициализация переменных - Подразделение
     *//*
    Department department1 = getRandomDepartment();
    Department department2 = getRandomDepartment();
    Department department2_1 = getRandomDepartment();
    Department department2_1_1 = getRandomDepartment();
    Department editDepartment = getRandomDepartment();
    Department department3 = getRandomDepartment();
    Department department2_2 = getRandomDepartment();

    *//**
     * Инициализация переменных - Пользователь
     *//*
    Employee user1 = getRandomEmployer();
    Employee user2 = getRandomEmployer();
    Employee changepass = getRandomEmployer();
    Employee workflow = getRandomEmployer();
    Employee docflow = getRandomEmployer();
    Employee editUser = getRandomEmployer();

    *//**
     * Создание Подразделений различной степени вложенности, с помощью
     * специальных методов, обращаясь к объектам инициализированным в начале
     * класса
     *//*
    @Test(priority = 1)
    public void createDepartments() throws Exception {
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());

        app.getCreateDepartmentsHelper().beforeAdd();
        app.getCreateDepartmentsHelper().createRootDepartment(department1);
        app.getCreateDepartmentsHelper().createRootDepartment(department2);
        app.getCreateDepartmentsHelper().createSubDepartment(department2_1.setParentDepartment(department2));
        app.getCreateDepartmentsHelper().createSubDepartment(department2_1_1.setParentDepartment(department2_1));
        app.getCreateDepartmentsHelper().dndSavePermissions(department2_1_1, department1);
        app.getCreateDepartmentsHelper().createSubDepartment(editDepartment.setParentDepartment(department1));
        app.getCreateDepartmentsHelper().editDepartments(editDepartment, department3);
        app.getCreateDepartmentsHelper().createSubDepartment(department2_2.setParentDepartment(department2_1));

        app.getUsersHelper().logout();
        assertTrue(app.getUsersHelper().isNotLoggedIn());
    }

    *//**
     * Создание Пользователей, с помощью специальных методов, обращаясь к
     * объектам инициализированным в начале класса
     *//*
    @Test(priority = 2)
    public void createUsers() throws Exception {
        app.getUsersHelper().loginAs(ADMIN); // Авторизация пользователя
        assertTrue(app.getUsersHelper().isLoggedIn());
        app.getUsersHelper().beforeAdd(); // Переход в раздел Администрирование/Пользователи
        app.getUsersHelper().createUser(user1 // Создание пользователя
                .setNeedsPasswordChange(true) // сбросить признак - "Сменить пароль при следующем входе" (true - изменяем значение; false - оставляем без изменений)
                .setDepartment(department1));
        app.getUsersHelper().createUser(user2
                .setModule(Module.COMPLETE)
                .setNeedsPasswordChange(true)
                .setDepartment(department2));
        app.getUsersHelper().editUser(
                editUser.setNeedsPasswordChange(false).setModule(Module.COMPLETE),
                user2.setDepartment(department2).setNeedsPasswordChange(true)); // Проверяем редактирование пользователя
        app.getUsersHelper().createUser(changepass
                .setNeedsPasswordChange(false)
                .setDepartment(department2));
        app.getUsersHelper().createUser(workflow // Создание пользователя с правом на модуль "WORKFLOW"
                .setNeedsPasswordChange(true)
                .setModule(Module.WORKFLOW)
                .setDepartment(department1));
        app.getUsersHelper().createUser(docflow // Создание пользователя с правом на модуль "DOCFLOW"
                .setNeedsPasswordChange(true)
                .setModule(Module.DOCFLOW)
                .setDepartment(department1));
        app.getUsersHelper().createAliasForDep(user1, department2); // Создание псевдонима пользователя
        app.getUsersHelper().checkIsAlias(user1, department2); // Проверка наличия псевдонима в подразделении
        app.getUsersHelper().logout(); // Выход из системы
        assertTrue(app.getUsersHelper().isNotLoggedIn()); // Проверка того, что пользователь разлогинен
    }

    *//**
     * Авторизация под созданными пользователями
     * @throws Exception
     *//*
    @Test(priority = 3)
    public void verifyUsers() throws Exception {
        app.getUsersHelper().loginAs(user1);
        assertTrue(app.getUsersHelper().isLoggedInAs(user1));
        app.getUsersHelper().logout();
        app.getUsersHelper().loginAs(editUser);
        assertTrue(app.getUsersHelper().isLoggedInAs(editUser));
        app.getUsersHelper().logout();
        assertTrue(app.getUsersHelper().isNotLoggedIn());
        app.getUsersHelper().loginAs(changepass);
        app.getUsersHelper().passwordChange(changepass);
        app.getUsersHelper().logout();
        app.getUsersHelper().loginAs(docflow);
        assertTrue(app.getUsersHelper().isLoggedInAs(docflow));
        app.getUsersHelper().checkDocflow();
        app.getUsersHelper().logout();
        app.getUsersHelper().loginAs(workflow);
        assertTrue(app.getUsersHelper().isLoggedInAs(workflow));
        app.getUsersHelper().checkWorkflow();
        app.getUsersHelper().logout();
        assertTrue(app.getUsersHelper().isNotLoggedIn());
    }

    *//**
     * Удаление Пользователей и Подразделений
     *
     * @throws Exception
     *//*
    @Test(dependsOnMethods = "verifyUsers", alwaysRun = true)
    // dependsOnMethods = "verifyUsers" - не "жесткая" зависимость
    // от тестового метода - verifyUsers, соответственно выполняется после verifyUsers()
    public void cleanUsersAndDepartments() throws Exception {
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedIn());
        app.getCreateDepartmentsHelper().beforeAdd();
        app.getUsersHelper().deleteUser(user1);
        app.getUsersHelper().deleteUser(editUser);
        app.getUsersHelper().deleteUser(changepass);
        app.getUsersHelper().deleteUser(docflow);
        app.getUsersHelper().deleteUser(workflow);
        app.getCreateDepartmentsHelper().deleteDepartment(department1);
        app.getCreateDepartmentsHelper().deleteDepartment(department2);
        app.getCreateDepartmentsHelper().deleteDepartment(department2_1);
        app.getCreateDepartmentsHelper().deleteDepartment(department2_1_1);
        app.getCreateDepartmentsHelper().deleteDepartment(department3);
        app.getCreateDepartmentsHelper().deleteDepartment(department2_2);

        app.getUsersHelper().logout();
        assertTrue(app.getUsersHelper().isNotLoggedIn());
    }*/

}
