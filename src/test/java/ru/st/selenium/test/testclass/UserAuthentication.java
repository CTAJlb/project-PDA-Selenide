package ru.st.selenium.test.testclass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ru.st.selenium.pages.InternalPage;
import ru.st.selenium.pages.LoginPage;
import ru.st.selenium.test.data.BaseObjectCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

/**
 * Автоматически делать скриншот, после каждого упавшего теста
 * Чтобы делать скриншоты после зелёных тестов, нужно вызвать такую команду перед запуском тестов: java ScreenShooter.captureSuccessfulTests = true;
 * Вы также можете сделать скриншот в любом месте теста одной строчкой - screenshot("my_file_name");
 * При этом Selenide создаст два файла: my_file_name.png и my_file_name.html
 */
@Listeners({ScreenShotOnFailListener.class})
/**
 * Раздел - Стр. авторизации
 */
public class UserAuthentication extends BaseObjectCase {

    /**
     * проверка валидации авторизации - авторизация проходит успешно
    */
    @Test(priority = 3, retryAnalyzer = Retry.class)
    public void verifyLoginSuccess() throws Exception {
        LoginPage loginPage = Selenide.open(Page.PDA_PAGE_URL, LoginPage.class);
        loginPage.loginAsAdmin(ADMIN);
        InternalPage internalPage = loginPage.goToInternalMenu(); // Проверяем отображение п.м. системы
        assertTrue(internalPage.hasMenuUserComplete());
        internalPage.signOut(); // Выход из системы
    }

    /**
     * проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(priority = 1, dataProvider = "verifyFailAuthorization", retryAnalyzer = Retry.class)
    public void verifyFailAuthorization(String login, String pass) throws Exception {
        LoginPage loginPage = Selenide.open(Page.PDA_PAGE_URL, LoginPage.class);
        loginPage.loginAs(login, pass);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));

    }

    /**
     * 2-я проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(priority = 2, dataProvider = "secondVerifyFailAuthorization", retryAnalyzer = Retry.class)
    public void secondVerifyFailAuthorization(String login, String pass) throws Exception {
        LoginPage loginPage = Selenide.open(Page.PDA_PAGE_URL, LoginPage.class);
        loginPage.loginAs(login, pass);
        loginPage.loginInSystem();
        assertTrue(loginPage.isNotLoggedIn());
    }


}