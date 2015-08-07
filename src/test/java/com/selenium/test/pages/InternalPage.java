package com.selenium.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Внутреняя страница системы
 */
public class InternalPage {

    /**
     * Все Меню системы
     */
    @FindBy(xpath = "//a[@class='ui-link-inherit']")
    private ElementsCollection menuElements;

    /**
     * Выход из системы
     */
    @FindBy(xpath = "//a[contains(@href, '/logout/')]")
    private SelenideElement logout;


    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return
     */
    public boolean hasResults() {
        menuElements.shouldHaveSize(4); // проверяем, что отображается 4 меню
        return !menuElements.isEmpty();
    }

    /**
     * Выход из Системы
     */
    public static LoginPage signOut() {
        $(By.xpath("//a[contains(@href, '/logout/')]")).click();
        $("#center>form>div>img").shouldBe(Condition.visible);
        $(By.cssSelector("#login")).shouldHave(Condition.appears);
        $(By.cssSelector("#pass")).shouldHave(Condition.appears);
        $(By.cssSelector("input[name='logon']")).getCssValue("Вход");
        return page(LoginPage.class);
    }

}
