package com.selenium.test.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Страница - Документы
 */
public class DocumentsPage extends Page {

    /*
     * На рассмотрении
     */
    @FindBy(xpath = "//li[@class='ui-block-a']//a")
    private SelenideElement onReview;

    /*
     * На исполнении
     */
    @FindBy(xpath = "//li[@class='ui-block-b']//a")
    private SelenideElement toExecution;

    /*
     * На контроле
     */
    @FindBy(xpath = "//li[@class='ui-block-c']//a")
    private SelenideElement controlled;


    /**
     * Проверяем отображение гридов документа
     * @return
     * TODO - расширить проверку
     */
    public DocumentsPage checkMapGridsDocuments(){
        onReview.click();
        toExecution.click();
        controlled.click();
        return this;
    }



}
