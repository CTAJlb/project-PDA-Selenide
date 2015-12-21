package ru.st.selenium.logicinterface;

import ru.st.selenium.model.Users.Department;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.pages.pagesweb.Internal.InternalPage;
import ru.st.selenium.pages.pagesweb.Login.LoginPage;

/**
 * Пользователи
 */
public interface UsersLogic {

    LoginPage loginAs(Employee user);

    boolean isLoggedIn();

    boolean isNotLoggedIn();

    boolean isLoggedInAs(Employee user);

    void passwordChange(Employee user);

    void beforeAdd();

    void deleteUser(Employee user);

    void checkWorkflow();

    void checkDocflow();

    void createAliasForDep(Employee user, Department department);

    void checkIsAlias(Employee user, Department department);

    void createUser(Employee user);

    void editUser(Employee editUser, Employee user);
}
