package ru.st.selenium.test.testWeb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.pages.RandomlySystemObjects;

import static org.junit.Assert.assertTrue;

public class Authorization extends RandomlySystemObjects {

    /**
     * Инициализация входных данных для Логин и Пароль
     */
    @DataProvider(name = "failAuthorization")
    public static Object[][] notSuccessfulAuthorizationDataProvider() {
        return new Object[][]{
                {FAIL_ADMIN},
                {ADMIN_FAIL},
                {FAIL_FAIL},
                {ADMIN_NULL},
                {NULL_ADMIN},
                {NULL_NULL}
        };
    }

    @BeforeMethod
    public void mayBeLogout() {
        if (app.getUsersHelper().isNotLoggedIn()) {
            return;
        }
        app.getUsersHelper().logout();
    }

    // Проверка - Авторизация не прошла - fail password
    @Test(dataProvider = "failAuthorization", priority = 1)
    public void notSuccessfulAuthorization(Employee user) throws Exception {
        app.getUsersHelper().loginAs(user);
        assertTrue(app.getUsersHelper().isNotLoggedIn());
    }


    // Метод - проверка авторизации, валидность логина/пароля и выход из системы
    @Test(priority = 2)
    public void loginSuccess() throws Exception {
        app.getUsersHelper().loginAs(ADMIN);
        assertTrue(app.getUsersHelper().isLoggedInAs(ADMIN)); // Проверяем, что залогинен именно тот пользователь,
        //к-й входил в систему
        app.getUsersHelper().logout();
        assertTrue(app.getUsersHelper().isNotLoggedIn());
    }

}