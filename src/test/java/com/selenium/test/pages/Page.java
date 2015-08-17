package com.selenium.test.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Set;

import static com.codeborne.selenide.Selenide.page;

/**
 * Абстрактное представление класса страницы в пользовательском интерфейсе
 */
public class Page {

    public static final String PAGE_URL = "http://pda.johni/";

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

    //---------------------------------------------------------------------------------------------------General methods--------------------------------------------------------

    // -------------------------------Automation Randomizing Data-----------------------------
    public static Random random = new Random();

    /**
     * Метод выбора случайного значение из множества перечислений
     * пример использования: - (randomEnum(Status.class)
     */
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    /**
     * Случайное Логическое значение
     */
    public static boolean randomBoolean() {
        return Math.random() < 0.5;
    }

    /**
     * Метод генерирующий случайное Строковое значение - например, .SendKeys(randomString(10));
     */
    public static String randomString(int length) {
        final String data = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTVXYабвгдеёжзиклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩъЪЫЬЭЮЯ";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            sb.append(data.charAt(random.nextInt(data.length())));

        return sb.toString();
    }

    /**
     * Метод генерирующий случайные Спецсимволы - например, .SendKeys(randomSpecialCharacters(10));
     */
    public static String randomSpecialCharacters(int length) {
        final String data = "!\"'#$%()*,-./`:;<=>?@[\\]^_{|}~«»";


        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            sb.append(data.charAt(random.nextInt(data.length())));

        return sb.toString();
    }

    /**
     * Метод генерирующий случайное строковое значение (Заглавные латинские буквы)
     */
    public static String randomID(int length) {
        final String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            sb.append(data.charAt(random.nextInt(data.length())));

        return sb.toString();

        // Максимальное значение для полей: Строка, например,
        // .SendKeys(randomString(10));
    }

    /**
     * Метод генерирующий случайный email
     */
    public static String randomEmail() {

        int length = 5;
        String name = "0123456789abcdefghijklmnopqrstuvwxyz";
        String firstDomain = "0123456789abcdefghijklmnopqrstuvwxyz";
        String secondDomain = "0123456789abcdefghijklmnopqrstuvwxyz";


        String email = new String();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(name.charAt(random.nextInt(name.length())));
        email += sb;

        sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)

            sb.append(firstDomain.charAt(random.nextInt(firstDomain.length())));
        email += "@" + sb;

        sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(secondDomain.charAt(random.nextInt(secondDomain.length())));
        email += "." + sb;

        return email;

        // пример - .SendKeys(randomEmail());

    }

    /**
     * Метод генерирующий случайное Целое число
     */
    public static String randomInt(int maxValue) {
        int i = random.nextInt(maxValue);
        return Integer.toString(i);

        // пример, Целое - .SendKeys(String.valueOf(randomNumber(150)));
    }

    /**
     * Метод создания строки содержащей случайую Дату и Время
     */
    public static String randomDateTime() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(2);

        int year = randIntBetween(2016, 2030);
        int monthi = randIntBetween(1, 12);
        int dayi = randIntBetween(1, 28);

        String day = formatter.format(dayi);
        String month = formatter.format(monthi);
        String hour = formatter.format(randIntBetween(0, 23));
        String minute = formatter.format(randIntBetween(0, 59));
        String second = formatter.format(randIntBetween(0, 59));

        String date = (day + "." + month + "." + year + " " + hour + ":"
                + minute + ":" + second);

        return date;

        // пример, Дата - .SendKeys(String.valueOf(randomDateTime));
    }

    /**
     * Метод создания строки содержащей случайный Телефон
     */
    public static String randomPhone() {
        NumberFormat minimum = NumberFormat.getNumberInstance();
        NumberFormat maximum = NumberFormat.getNumberInstance();

        minimum.setMinimumIntegerDigits(3);
        maximum.setMaximumIntegerDigits(2);
        int a = randIntBetween(800, 999);

        String b = minimum.format(randIntBetween(1, 999));
        String c = maximum.format(randIntBetween(1, 999));
        String d = maximum.format(randIntBetween(1, 999));
        String phone = "8(" + a + ")" + b + "-" + c + "-" + d;
        return phone;

    }

    /**
     * Метод создания строки содержащей случайую Дату
     */
    public static String randomDate() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(2);

        int year = randIntBetween(2016, 2030);
        int monthi = randIntBetween(1, 12);
        int dayi = randIntBetween(1, 28);

        String day = formatter.format(dayi);
        String month = formatter.format(monthi);

        String date = (day + "." + month + "." + year);

        return date;

        // пример, Дата - .SendKeys(String.valueOf(randomDate));
    }

    /**
     * Метод создания ColorHEX содержащей случайный цвет. Может применяться для
     * выбора случайного цвета в записи справочника или таблицы
     */
    public static String randomColour() {
        String colour = "#" + randomInt(9) + randomInt(9) + randomInt(9)
                + randomInt(9) + randomInt(9) + randomInt(9);
        return colour;
    }

    /**
     * Метод создания целолго числа в диапазоне От и До
     */
    public static int randIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    // GET DATE & TIME IN ANY FORMAT

    public static final String DATE_FORMAT_NOW = "dd.MM.yyyy HH:mm:ss";
    public static final Calendar cal = Calendar.getInstance();
    public static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);

    /**
     * Метод создания даты равной сейчас (Текущая дата)
     */
    public static String nowDate() {
        return sdf.format(cal.getTime());
    }

    /**
     * Метод создания даты равной завтра
     */
    public static String tommorowDate() {
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(cal.getTime());
    }

    /**
     * Метод создания даты равной вчера
     */
    public static String yesterdayDate() {
        cal.add(Calendar.DAY_OF_MONTH, -2);
        return sdf.format(cal.getTime());
    }

}
