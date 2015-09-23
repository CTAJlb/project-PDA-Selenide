package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Страница - Помощь
 */
public class HelpHtmlPage extends Page {

    /*
     * Все элементы поиска
     */
    @FindBy(xpath = "//div[@id='mainblock' and @class='mainblock withmenu']//li//div")
    private ElementsCollection helpElements;

    /*
     * Элемент - Сохранить
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='save_button']")
    private SelenideElement elementSave;

    /*
     * Элемент - Завершить задачу
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='close_button']")
    private SelenideElement elementCompleteTask;

    /*
     * Элемент - Вернуть задачу на доработку
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='fc-button3']")
    private SelenideElement elementSendTheTaskBackForRevision;

    /*
     * Элемент - Ознакомиться
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='fc-button10']")
    private SelenideElement elementExamine;

    /*
     * Элемент - Приступить
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='play-button play-button-start']")
    private SelenideElement elementStart;

    /*
     * Элемент - Прерваться
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='play-button play-button-pause']")
    private SelenideElement elementPause;

    /*
     * Элемент - Закончить
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='play-button play-button-stop']")
    private SelenideElement elementStop;

    /*
     * Элемент - Согласовать документ
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='doc-button2 doc-button-consider']")
    private SelenideElement elementReviewDocument;

    /*
     * Элемент - Согласовать с замечаниями
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='doc-button2 doc-button-consider-with-notice']")
    private SelenideElement elementReconcileWithNotice;

    /*
     * Элемент - Отказаться согласовать
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='doc-button2 doc-button-refuze-consider']")
    private SelenideElement elementRefuseToConsider;

    /*
     * Элемент - Создать резолюцию
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='doc-button2 doc-button-resolution']")
    private SelenideElement elementCreateResolution;

    /*
     * Элемент - Вернуть документ на доработку
     */
    @FindBy(xpath = "//*[@id='mainblock']//div[@class='doc-button2 doc-button-reject']")
    private SelenideElement elementReturnTheDocumentForRevision;



    /**
     * Проверяем общее количество элементов помощи
     *
     * @return
     */
    public boolean checkPresenceElementsOfAid() {
        helpElements.shouldHaveSize(19); // проверяем отображение 19 элементов помощи (Сохранить; Завершить задачу и пр.)
        return !helpElements.isEmpty();
    }


    /**
     * Проверяем отображения конкретного элемента помощи
     * @return
     */
    public HelpHtmlPage visibleElementsHelp(){
        $(elementSave).shouldBe(Condition.visible);
        $(elementCompleteTask).shouldBe(Condition.visible);
        $(elementSendTheTaskBackForRevision).shouldBe(Condition.visible);
        $(elementExamine).shouldBe(Condition.visible);
        $(elementStart).shouldBe(Condition.visible);
        $(elementPause).shouldBe(Condition.visible);
        $(elementStop).shouldBe(Condition.visible);
        $(elementReviewDocument).shouldBe(Condition.visible);
        $(elementReconcileWithNotice).shouldBe(Condition.visible);
        $(elementRefuseToConsider).shouldBe(Condition.visible);
        $(elementCreateResolution).shouldBe(Condition.visible);
        $(elementCreateResolution).shouldBe(Condition.visible);
        $(elementReturnTheDocumentForRevision).shouldBe(Condition.visible);
        return this;
    }

}
