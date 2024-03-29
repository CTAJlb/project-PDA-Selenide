package ru.st.selenium.pages.pagesweb.Internal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.pages.Page;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Страница - Календарь
 */
public class CalendarPage extends Page {

	
	/**
	 * Чек-бокс системных календарей
	 */
	@FindBy(xpath = "//span[contains(@id,'extdd')][ancestor::li[@class='x-tree-node']]")
	private WebElement clickCheckBox;
	
	/**
	 * Фрейм
	 */
	@FindBy(id = "flow")
	private WebElement frem;
	
	/**
	 * Фрейм системных календарей
	 */
	@FindBy(id = "hiddenrefresh")
	private WebElement fremSystemCal;

	/**
	 *  Уходим во фрейм
	 * @return
	 */
	public CalendarPage gotoFremCalPage() {
		getWebDriver().switchTo().frame(frem);
		return this;
	}

	/**
	 *  Уходим во фрейм системных календарей
	 * @return
	 */
	public CalendarPage gotoFremSystemCal() {
		getWebDriver().switchTo().frame(fremSystemCal);
		return this;
	}
	
	/**
	 * Клик чек-бокс системных календарей
	 * 
	 * @return RestorePasswordPage
	 */
	public CalendarPage clickCheckBoxCal() {
		clickCheckBox.click();
		return this;
	}
	
	


}
