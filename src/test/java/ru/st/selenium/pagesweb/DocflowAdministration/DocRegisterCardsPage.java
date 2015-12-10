package ru.st.selenium.pagesweb.DocflowAdministration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.pagespda.Page;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * грид Регистрационных карточек - Администрирование ДО/Регистрационные карточки документов (.../user/tab/user/DocRegisterCards)
 */
public class DocRegisterCardsPage extends Page {


	/**
	 * Пользователяская API для эмуляции сложных пользовательских действий
	 * (эмуляция клавиатуры и мыши)
	 */
	Actions action = new Actions(getWebDriver());

	/**
	 * Метод имитирующий нажатие клавиши - Enter
	 */
	public void pressEnter() {
		action = action.sendKeys(Keys.chord(Keys.ENTER));
		action.build().perform();
	}

	/**
	 * Метод клавиатурного выбора настроек, смещение на ОДНУ позицию вниз,
	 * например, Скрывать...; Изменяемое при редактировании и etc., полей значение полей, выбирает значение == Да
	 */
	public void selectingSecondAdjustmentPosition() {
		action = action.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
		action.build().perform();
	}

	/**
	 * Метод клавиатурного выбора настроек, смещение на ДВЕ позиции вниз,
	 */
	public void selectingThirdAdjustmentPosition() {
		action = action.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER));
		action.build().perform();
	}

	/**
	 * Метод клавиатурного выбора настроек, смещение на ТРИ позиции вниз,
	 */
	public void selectingFourthlyAdjustmentPosition() {
		action = action.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER));
		action.build().perform();
	}

	/**
	 * Добавить Регистрационную карточку документа
	 */
	@FindBy(xpath = "//div[count(a)=3]/a[1]//span")
	private SelenideElement clickAddOnRegCards;

	/**
	 * Редактировать Регистрационную карточку документа
	 */
	@FindBy(xpath = "//div[count(a)=3]/a[2]//span")
	private SelenideElement clickEditOnRegCards;

	/**
	 * Удалить Регистрационную карточку документа
	 */
	@FindBy(xpath = "//div[count(a)=3]/a[3]//span")
	private SelenideElement clickDelOnRegCards;

	/**
	 * iФрейм
	 */
	@FindBy(id = "flow")
	private SelenideElement Frem;

	/**
	 * Уходим во фрейм - Регистрационные карточки документов
	 */
	public DocRegisterCardsPage gotoFremRegisterCardsPage() {
		getWebDriver().switchTo().frame(Frem);
		return this;
	}

	/**
	 * Уходим из фрейм в ТОР
	 * 
	 * @return TaskTypeListObjectPage
	 */
	public DocRegisterCardsPage gotoTopFrem() {
		getWebDriver().switchTo().defaultContent();
		return this;
	}

	/**
	 * Клик Добавить объект - Регистрационная карточка документа
	 */
	public DocRegisterCardsPage addRegisterCards() {
		clickAddOnRegCards.click();
		return this;
	}

	/**
	 * Ожидание созданного объекта в гриде DocRegisterCards
	 * 
	 * @return DocRegisterCardsPage
	 */
	public DocRegisterCardsPage verifyDocRegisterCards(
			String ObjectDocRegisterCards) {
		$(By.xpath("//div[@class='x-grid-item-container']//span[contains(text(),'"
						+ ObjectDocRegisterCards + "')]")).shouldBe(Condition.visible);
		return this;
	}



}
