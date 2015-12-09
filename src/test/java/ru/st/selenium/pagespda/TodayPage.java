package ru.st.selenium.pagespda;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

/*
 * Страница - Сегодня
 */
public class TodayPage {


    /**
     * Проверяем отображения изменений в разделе Сегодня
     *
     * @param textAction input text for feed action tasks
     * @return
     */
    public TodayPage verifyInformationDisplaySectionToday(String textAction) {
        $(By.xpath("//p[contains(text(),'" + textAction + "')]")).shouldBe(visible);
        return this;
    }


}
