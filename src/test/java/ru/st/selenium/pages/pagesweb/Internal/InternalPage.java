package ru.st.selenium.pages.pagesweb.Internal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.logicinterface.BaseOperation;
import ru.st.selenium.pages.Page;
import ru.st.selenium.pages.pagesweb.Administration.DirectoriesEditFormPage;
import ru.st.selenium.pages.pagesweb.Administration.TaskTypeListObjectPage;
import ru.st.selenium.pages.pagesweb.DocflowAdministration.DictionaryEditorPage;
import ru.st.selenium.pages.pagesweb.DocflowAdministration.GridDocRegisterCardsPage;
import ru.st.selenium.pages.pagesweb.Documents.NewDocumentPage;
import ru.st.selenium.pages.pagesweb.Options.PwdPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertFalse;

/**
 * Внутренняя страница системы (ОМ - Основное меню)
 */
public class InternalPage extends Page implements BaseOperation {

    /*
     * Ссылки на все пункты меню
     */
    @FindBy(xpath = "//div[@id='left-panel'][ancestor::div[@id='menu']]/div[not(@id='menu-button-more' and @class='menu-point-hidden')]")
    private ElementsCollection menuElements;

    /*
     * =====================================================================================================Задачи
     */

    @FindBy(id = "task")
    private SelenideElement menuTask;

     /*
     * =====================================================================================================Документы
     */
    @FindBy(css = "#doc")
    private SelenideElement document;

    /*
     * Документы/Создать документ
     */
    @FindBy(css = "#L_DOCUMENT_NEW-menupoint")
    private SelenideElement createDoc;
    
    /*
     * Календарь
     */
    @FindBy(id = "col")
    private SelenideElement CalMenu;

    /*
     * Библиотека
     */
    @FindBy(id = "lib")
    private SelenideElement LibMenu;

    /*
     * Инструменты
     */
    @FindBy(id = "instr")
    private SelenideElement instrMenu;

    /*
     * =======================================================================================================Администирование
     */
    /*
     Администирование
     */
    @FindBy(id = "L_MENU_ADMINISTRATION-menupoint")
    private SelenideElement administration;

    /*
     * Инструменты/Администрирование/Пользователи
     */
    @FindBy(id = "L_MENU_USERADMIN-menupoint")
    private SelenideElement menuUsers;

    /*
     * Инструменты/Администрирование/Типы таблиц
     */
    @FindBy(id = "L_MENU_TABLES-menupoint")
    private SelenideElement Tables;

    /*
     * Инструменты/Администрирование/Справочники
     */
    @FindBy(id = "L_MENU_ADMIN_DICTIONARY-menupoint")
    private SelenideElement directories;

    /*
     * Администрирование ДО
     */
    @FindBy(id = "L_DOCPROCESSING-menupoint")
    private SelenideElement docAdministrationMenu;

    /*
     * Регистрационные карточки документов
     */
    @FindBy(id = "L_AU_DOC_CARDS-menupoint")
    private SelenideElement registerCardsMenu;

    /*
     * Редактор маршрутных схем
     */
    @FindBy(id = "L_MENU_ROUTESCHEME_EDITOR-menupoint")
    private SelenideElement rsEditorMenu;

    /*
     * Счетчики документов
     */
    @FindBy(id = "L_AU_DOCUMENT_COUNTERS-menupoint")
    private SelenideElement docCountersMenu;

    /*
     * Редактор словарей
     */
    @FindBy(id = "L_GLOBAL_DICTIONARY_EDITOR-menupoint")
    private SelenideElement dictionaryEditorMenu;

    /*
     Выход из Системы
     */
    @FindBy(css = "#btn_logout")
    private SelenideElement Logout;

    /*
     * Фрейм
     */
    @FindBy(id = "flow")
    private SelenideElement fremFlow;

    /*
     * Строка поиска
     */
    @FindBy(css = "#searchQueryEdit")
    private SelenideElement search;

    /*
    ================================================================================================НАСТРОЙКИ
     */

    /*
     * Настройки
     */
    @FindBy(id = "L_AU_MENU_SETTINGS-menupoint")
    private SelenideElement menuSettings;

    /*
     * Мои реквизиты
     */
    @FindBy(id = "L_MENU_MYOPTIONS-menupoint")
    private SelenideElement menuMyOptions;


    /*
     * Уходим во фрейм объекта
     */
    public void goToFremFlow() {
        getWebDriver().switchTo().frame(fremFlow);
    }



    /**
     * Поиск
     *
     * @param serachstring
     * @return CreateDepartmentPage
     */
    public InternalPage search(String serachstring) {
        search.clear();
        search.setValue(serachstring);
        search.pressEnter();
        return this;
    }

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
    private void subMenuClicker(SelenideElement firstclick, SelenideElement secondclick, SelenideElement thirdclick) {
        firstclick.click();
        actions.moveToElement(secondclick).perform();
        $(thirdclick).shouldBe(Condition.visible);
        actions.moveToElement(thirdclick).perform();
        thirdclick.click();
    }

    /**
     * Проверяем отображение меню на внутренней странице
     *
     * @return information about the number of the menu on the main page
     */
    @Override
    public boolean hasMenuUserComplete() {
        menuElements.shouldHaveSize(8);
        return !menuElements.isEmpty();
    }


    /**
     * Переход в меню - Администрирование ДО/Регистрационные карточки документов
     */
    public GridDocRegisterCardsPage goToGridDocRegisterCards() {
        subMenuClicker(instrMenu, docAdministrationMenu, registerCardsMenu);
        goToFremFlow();
        return page(GridDocRegisterCardsPage.class);

    }

    /**
     * Переход в меню - Администрирование ДО/Редактор словарей
     */
    public DictionaryEditorPage goToDictionaryEditor(){
        subMenuClicker(instrMenu, docAdministrationMenu, dictionaryEditorMenu);
        goToFremFlow();
        return page(DictionaryEditorPage.class);
    }

    /**
     * Переход в меню - Администрирование/Справочники
     */
    public TaskTypeListObjectPage gotoDirectories() {
        subMenuClicker(instrMenu, administration, directories);
        goToFremFlow();
        return page(TaskTypeListObjectPage.class);

    }

    /**
     * Форма редактирования объекта - Справочники
     */
    public DirectoriesEditFormPage gotoDirectoriesEditPage(){
        return page(DirectoriesEditFormPage.class);
    }


    /**
     * Документы/Создать документ
     */
    public NewDocumentPage gotoNewDocument(){
        menuClicker(document, createDoc);
        goToFremFlow();
       return page(NewDocumentPage.class);
    }


    /**
     * Выход из системы
     */
    @Override
    public void logout() {
        gotoTopFrem();
        $(Logout).shouldBe(Condition.visible).click();
        $(By.cssSelector("#login")).shouldBe(Condition.visible);
        $(By.cssSelector("#pass")).shouldBe(Condition.visible);

    }

    /**
     * Проверяем, что текущий пользователь Workflow. Отсутствует п.м. Документы
     *
     * @return InternalPage
     */
    public InternalPage checkDocSearchNotVisible() {
        gotoTopFrem();
        assertFalse(isElementVisible(By.id("doc-search")));
        return this;

    }

    /**
     * Проверяем, что текущий пользователь Docflow. Отсутствует п.м. Создать задачу
     *
     * @return InternalPage
     */
    public InternalPage checkCreateTaskNotVisible() {
        gotoTopFrem();
        menuTask.click();
        assertFalse(isElementPresent(By.xpath("//*[@id='L_INFORMER_CREATETASK-menupoint']")));
        return this;

    }

    /**
     * Переход в меню - Настройки/Мои реквизиты
     */
    public PwdPage gotoPwd() {
        subMenuClicker(instrMenu, menuSettings, menuMyOptions);
        return page(PwdPage.class);
    }

    /**
     * Ожидания появления объектов ОМ - Сообщение; -Календарь; -Библиотека
     */
    public InternalPage ensurePageLoaded() {
        $(By.id("mes")).shouldBe(Condition.present);
        $(By.id("col")).shouldBe(Condition.present);
        $(By.id("lib")).shouldBe(Condition.visible);
        return this;
    }

}
