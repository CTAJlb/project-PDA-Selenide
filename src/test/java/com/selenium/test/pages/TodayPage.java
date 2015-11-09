package com.selenium.test.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

/**
 * Страница - Сегодня
 */
public class TodayPage {


    /**
     * Проверяем отображения изменений в разделе Сегодня
     * @param textAction
     * @return
     */
    public TodayPage verifyInformationDisplaySectionToday(String textAction) {
        $(By.xpath("//p[contains(text(),'" + textAction + "')]")).shouldBe(visible);
        return this;
    }


}