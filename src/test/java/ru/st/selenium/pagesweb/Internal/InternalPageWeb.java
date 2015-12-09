package ru.st.selenium.pagesweb.Internal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.pagespda.Page;
import ru.st.selenium.pagesweb.DocflowAdministration.DocRegisterCardsPage;
import ru.st.selenium.pagesweb.Documents.NewDocumentPage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;




public class InternalPageWeb extends Page {


    /**
     * Пользователяская API для эмуляции сложных пользовательских действий
     * (клавиатуры и мыши)
     */
    Actions actions = new Actions(getWebDriver());

    /**
     * Метод 2-х уровневой навигации
     *
     * @param firstclick
     * @param secondclick
     */
    private void menuClicker(SelenideElement firstclick, SelenideElement secondclick) {
        firstclick.click();
        secondclick.click();
    }

    /**
     * Метод 3-х уровневой навигации
     *
     * @param firstclick
     * @param secondclick
     * @param thirdclick
     */
    private void subMenuClicker(WebElement firstclick, WebElement secondclick, WebElement thirdclick) {
        firstclick.click();
        actions.moveToElement(secondclick).perform();
        $(thirdclick).shouldBe(Condition.present);
        actions.moveToElement(thirdclick).perform();
        thirdclick.click();
    }

    /*
     * Ссылки на все пункты меню
     */
    @FindBy(xpath = "//a[@class='ui-link-inherit']")
    private ElementsCollection menuElements;
    

    /**
     * Документы/Создать документ
     */
    @FindBy(css = "#L_DOCUMENT_NEW-menupoint")
    private SelenideElement createDoc;
    
    /**
     * Календарь
     */
    @FindBy(id = "col")
    private SelenideElement CalMenu;

    /**
     * Библиотека
     */
    @FindBy(id = "lib")
    private SelenideElement LibMenu;

    /**
     * Инструменты
     */
    @FindBy(id = "instr")
    private SelenideElement InstrMenu;


    /**
     * Администирование
     */
    @FindBy(id = "L_MENU_ADMINISTRATION-menupoint")
    private SelenideElement Administration;

    /**
     * Инструменты/Администрирование/Пользователи
     */
    @FindBy(id = "L_MENU_USERADMIN-menupoint")
    private SelenideElement menuUsers;


    /**
     * Инструменты/Администрирование/Типы таблиц
     */
    @FindBy(id = "L_MENU_TABLES-menupoint")
    private SelenideElement Tables;

    /**
     * Инструменты/Администрирование/Справочники
     */
    @FindBy(id = "L_MENU_ADMIN_DICTIONARY-menupoint")
    private SelenideElement Dictionary;


    /**
     * Администрирование ДО
     */
    @FindBy(id = "L_DOCPROCESSING-menupoint")
    private SelenideElement docAdministrationMenu;

    /**
     * Регистрационные карточки документов
     */
    @FindBy(id = "L_AU_DOC_CARDS-menupoint")
    private SelenideElement registerCardsMenu;

    /**
     * Редактор маршрутных схем
     */
    @FindBy(id = "L_MENU_ROUTESCHEME_EDITOR-menupoint")
    private SelenideElement rsEditorMenu;

    /**
     * Счетчики документов
     */
    @FindBy(id = "L_AU_DOCUMENT_COUNTERS-menupoint")
    private SelenideElement docCountersMenu;

    /**
     * Редактор словарей
     */
    @FindBy(id = "L_GLOBAL_DICTIONARY_EDITOR-menupoint")
    private SelenideElement dictionaryEditorMenu;



    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return information about the number of the menu on the main page
     */
    public boolean hasMenuUserComplete() {
        menuElements.shouldHaveSize(4);
        return !menuElements.isEmpty();
    }



    /**
     * Переход в меню - Администрирование ДО/Регистрационные карточки документов
     */
    public DocRegisterCardsPage gotoDocRegisterCards() {
        subMenuClicker(InstrMenu, docAdministrationMenu, registerCardsMenu);
        return page(DocRegisterCardsPage.class);

    }


    /**
     * Документы/Создать документ
     * @return
     */
    public NewDocumentPage gotoNewDocument(){
     //   menuClicker(Doc, createDoc);
       return page(NewDocumentPage.class);
    }




}
