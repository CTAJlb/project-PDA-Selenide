package com.selenium.test.test.tests;

import com.codeborne.selenide.Condition;
import com.selenium.test.pages.InternalPage;
import com.selenium.test.pages.LoginPage;
import com.selenium.test.test.data.TestBase;
import com.selenium.test.test.listeners.ScreenShotOnFailListener;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;
import static com.selenium.test.pages.Page.*;

/**
 * Автоматически делать скриншот, после каждого упавшего теста
 * Чтобы делать скриншоты после зелёных тестов, нужно вызвать такую команду перед запуском тестов: java ScreenShooter.captureSuccessfulTests = true;
 * Вы также можете сделать скриншот в любом месте теста одной строчкой - screenshot("my_file_name");
 * При этом Selenide создаст два файла: my_file_name.png и my_file_name.html
 */
@Listeners({ScreenShotOnFailListener.class})
public class UserAuthentication extends TestBase {

    /**
     * Инициализация входных данных для Логин и Пароль
     */
    @DataProvider(name = "failAuthorization")
    public Object[][] firstNotSuccessfulAuthorizationDataProvider() {
        return new Object[][]{
                {"fail", "admin"},
                {"admin", "fail"},
                {"fail", "fail"},
                {"admin", ""},
        };
    }

    @DataProvider(name = "secondFailAuthorization")
    public Object[][] secondNotSuccessfulAuthorizationDataProvider() {
        return new Object[][]{
                {"", "admin"},
                {"", ""}
        };
    }


    /**
     * проверка валидации авторизации - авторизация проходит успешно
     */
    @Test(priority = 3)
    public void loginSuccess() throws Exception {
        LoginPage loginPage = open(PDA_PAGE_URL, LoginPage.class);
        loginPage.loginAsAdmin(ADMIN);
        InternalPage internalPage = loginPage.goToInternalMenu(); // Проверяем отображение п.м. системы
        assertTrue(internalPage.hasMenu());
        internalPage.signOut(); // Выход из системы
    }

    /**
     * проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(dataProvider = "failAuthorization", priority = 1)
    public void failAuthorization(String login, String pass) throws Exception {
        LoginPage loginPage = open(PDA_PAGE_URL, LoginPage.class);
        loginPage.loginAs(login, pass);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));

    }

    /**
     * 2-я проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(dataProvider = "secondFailAuthorization", priority = 2)
    public void secondFailAuthorization(String login, String pass) throws Exception {
        LoginPage loginPage = open(PDA_PAGE_URL, LoginPage.class);
        loginPage.loginAs(login, pass);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
    }


}