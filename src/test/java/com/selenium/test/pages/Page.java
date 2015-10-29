package com.selenium.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static com.codeborne.selenide.Selenide.page;

/**
 * Абстрактное представление класса страницы в пользовательском интерфейсе
 */
public class Page {

    private static WebDriver driver;

    public static final String PAGE_URL = "http://pda.motiw/";


    /**
     * Проверяем то, что мы разлогинены
     */
    public boolean isNotLoggedIn() {
        return page(LoginPage.class).isPageLoaded();
    }

    /**
     * Метод обращается к ensurePageLoaded и возвращает булевское значение,
     * (false - не дождались загрузки стр.; true - дождались) ждет загрузки
     * страницы
     *
     * @return
     */
    public boolean isPageLoaded() {
        try {
            ensurePageLoaded();
            return true;
        } catch (TimeoutException to) {
            return false;
        }
    }

    /**
     * Метод - проверяет, где мы находимся здесь и сейчас, возвращает данную
     * страницу И ждет загрузки страницы
     *
     * @return
     */
    public Page ensurePageLoaded() {
        return this;
    }

    /**
     * Глобальная переменная - Сочетание клавиш Shift и Enter -
     * если послать это сочетание веб элементу открывающему новую страницу -
     * страница откроется в новом окне
     */
    public static String NewWindowOpen = Keys.chord(Keys.SHIFT, Keys.ENTER);

    /**
     * The code below will open the link in new Tab
     */
    public static String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
    // пример - driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);

    //------------------------------------------------------------------------------------------------------------WINDOWS---------------------------------------------------

    /**
     * Метод появление новго окна
     *
     * @param locator
     * @return
     */
    public ExpectedCondition<String> newWindowForm(final By locator) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver d) {
                String initialWindowHandle = d.getWindowHandle(); // Запоминаем в начале, в каком окне мы находились
                String found = null;
                Set<String> windowHandles = d.getWindowHandles(); // возвращает множ-во идентификаторов окон И далее проходим в цикле в каждое окно и проверяем
                // имеется ли необходимый элемент в новом окне, нет - тогда переключаемся в следующее, если совпадает, то true
                for (String handle : windowHandles) {
                    try {
                        d.switchTo().window(handle);
                        if (d.findElement((locator)).isDisplayed()) {
                            found = handle;
                            break;
                        }
                    } catch (WebDriverException e) { // игнорируем все исключения
                    }
                }
                d.switchTo().window(initialWindowHandle);
                return found;
            }
        };

        /* пример,
         driver.switchTo().window(new WebDriverWait(driver, 10).until(newWindowForm(By.cssSelector("#searchField"))));
         */

    }

    //-----------------------------------------------Waiting--------------------------------------------

    /**
     * Подождать в течение определенного количества времени
     *
     * @param seconds
     */
    public void waitMillisecond(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * Пример, использования метода - waitTime(0.5 OR 1);
         */
    }

    /**
     * Подождать пока отобразится элемент на странице
     *
     * @param locator
     * @param maxSeconds
     * @return
     */
    public WebElement waitForPageUntilElementIsVisible(By locator,
                                                       int maxSeconds) {
        return (new WebDriverWait(driver, maxSeconds)).until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        /**
         * Пример использования метода
         * - waitForPageUntilElementIsVisible(By.xpath("//*[@id='bAddRec-btnIconEl']"), 5000);
         */
    }


}
