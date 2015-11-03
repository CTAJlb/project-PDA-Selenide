package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Страница - Настройки
 */
public class OptionsPage extends Page {


    /*
     * Удалить
     */
    @FindBy(xpath = "(//input[@type='submit'])[1]")
    private SelenideElement remove;

    /*
    * Сохранить
     */
    @FindBy(xpath = "(//input[@type='submit'])[2]")
    private SelenideElement save;

    /*
    * Отображение скрытых задач
     */
    @FindBy(xpath = "//input[@id='secret']")
    private SelenideElement showHiddenTasks;

    /*
    * Возможность присоединения файлов
     */
    @FindBy(xpath = "//input[@id='secret2']//..//span[2]")
    private SelenideElement attachFiles;


    /**
     * Устанавливаем значение - Возможность присоединения файлов
     *
     * @return
     */
    public OptionsPage selAttachFiles(boolean attach) {
        if (attach) {
            attachFiles.click();
        }
        save.click();
        waitMillisecond(0.8);
        getWebDriver().navigate().refresh();
        $(By.xpath("//input[@id='secret2']/..//span[contains(@class,'ui-icon-checkbox-on')]")).shouldBe(Condition.visible);
        return this;
    }



}





