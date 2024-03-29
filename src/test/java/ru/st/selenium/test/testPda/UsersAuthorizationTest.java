package ru.st.selenium.test.testPda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.TextReport;
import ru.st.selenium.pages.pagespda.InternalPagePDA;
import ru.st.selenium.pages.pagespda.LoginPagePDA;
import ru.st.selenium.test.data.BaseObjectTestCase;
import ru.st.selenium.test.data.Retry;
import ru.st.selenium.test.listeners.ScreenShotOnFailListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;


/**
 * Автоматически делать скриншот, после каждого упавшего теста
 * Чтобы делать скриншоты после зелёных тестов, нужно вызвать такую команду перед запуском тестов: java ScreenShooter.captureSuccessfulTests = true;
 * Вы также можете сделать скриншот в любом месте теста одной строчкой - screenshot("my_file_name");
 * При этом Selenide создаст два файла: my_file_name.png и my_file_name.html
 */
@Listeners({ScreenShotOnFailListener.class, TextReport.class})
/**
 * Раздел - Стр. авторизации
 */
public class UsersAuthorizationTest extends BaseObjectTestCase {


    /**
     * проверка валидации авторизации - авторизация проходит успешно
    */
    @Test(priority = 3, retryAnalyzer = Retry.class)
    public void verifyLoginSuccess() throws Exception {
        LoginPagePDA loginPagePDA = open(Page.PDA_PAGE_URL, LoginPagePDA.class);
        loginPagePDA.loginAsAdmin(ADMIN);
        InternalPagePDA internalPagePDA = loginPagePDA.goToInternalMenu(); // Проверяем отображение п.м. системы
        assertThat("Check that the displayed menu item 4 (Tasks; Create Task; Today; Document)",
                internalPagePDA.hasMenuUserComplete());
        internalPagePDA.logout(); // Выход из системы
    }

    /**
     * проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(priority = 1, dataProvider = "verifyFailAuthorization", retryAnalyzer = Retry.class)
    public void verifyFailAuthorization(String login, String pass) throws Exception {
       LoginPagePDA loginPagePDA = open(Page.PDA_PAGE_URL, LoginPagePDA.class);
        loginPagePDA.loginAs(login, pass);
        assertTrue(loginPagePDA.isNotLoggedInPDA());
        $(By.cssSelector("#error")).shouldBe(Condition.exactText("Доступ запрещен"));

    }

    /**
     * 2-я проверка невалидного логина И пароля - авторизация не проходит
     */
    @Test(priority = 2, dataProvider = "secondVerifyFailAuthorization", retryAnalyzer = Retry.class)
    public void secondVerifyFailAuthorization(String login, String pass) throws Exception {
        LoginPagePDA loginPagePDA = open(Page.PDA_PAGE_URL, LoginPagePDA.class);
        loginPagePDA.loginAs(login, pass);
        assertTrue(loginPagePDA.isNotLoggedInPDA());
    }


}