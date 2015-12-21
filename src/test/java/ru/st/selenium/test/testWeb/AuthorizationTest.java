package ru.st.selenium.test.testWeb;

import com.codeborne.selenide.testng.TextReport;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.model.Users.Employee;
import ru.st.selenium.pages.Page;
import ru.st.selenium.pages.pagesweb.Login.LoginPage;
import ru.st.selenium.test.data.BaseObjectTestCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;

import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenShotOnFailListener.class, TextReport.class})
/**
 * Раздел - Стр. авторизации
 */
public class AuthorizationTest extends BaseObjectTestCase {


    // Проверка - Авторизация не прошла - fail password
    @Test(priority = 1, dataProvider = "verifyFailAuthorizationWeb", retryAnalyzer = Retry.class)
    public void notSuccessfulAuthorization(Employee user) throws Exception {
        LoginPage loginPage = open(Page.WEB_PAGE_URL, LoginPage.class);
        loginPage.loginAs(user);
        assertTrue("Log in to the system fails" ,loginPage.isNotLoggedIn());
    }


    // Метод - проверка авторизации, валидность логина/пароля и выход из системы
    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void loginSuccess() throws Exception {
        LoginPage loginPage = open(Page.WEB_PAGE_URL, LoginPage.class);
        loginPage.loginAs(ADMIN);
        assertTrue(loginPage.isLoggedInAs(ADMIN)); // Проверяем, что залогинен именно тот пользователь, к-й входил в систему
        loginPage.initializedInsidePage().logout();
        assertTrue(loginPage.isNotLoggedIn());
    }

}