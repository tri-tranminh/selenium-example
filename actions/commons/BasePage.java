package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageUIs.BasePageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

	protected void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut){
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public void refreshPage(WebDriver driver){
		driver.navigate().refresh();
	}

	protected String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[]) params);
	}

	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void goPreviousPage(WebDriver driver){
		driver.navigate().back();
	}
	
	protected By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	protected WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	protected List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	protected List<WebElement> getElements(WebDriver driver, String locator, String... params) {
		return driver.findElements(getByXpath(getDynamicLocator(locator, params)));
	}

	protected int countElements(WebDriver driver, String locator){
		return getElements(driver, locator).size();
	}

	protected boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	protected boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
	}

	protected boolean areElementsDisplayed(WebDriver driver, String locator) {
		return !getElements(driver, locator).isEmpty();
	}

	protected boolean isElementUndisplayed(WebDriver driver, String locator) {

		overrideGlobalTimeout(driver, GlobalConstants.UNDISPLAYED_TIMEOUT);
		List<WebElement> elements = getElements(driver, locator);

		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);

		if(elements.size() == 0){
			return true;
		} else if(elements.size() > 0 && !elements.get(0).isDisplayed()){
			return  true;
		}
		else {
			return false;
		}
	}

	protected boolean isElementUndisplayed(WebDriver driver, String locator, String... params) {

		overrideGlobalTimeout(driver, GlobalConstants.UNDISPLAYED_TIMEOUT);
		List<WebElement> elements = getElements(driver, getDynamicLocator(locator, params));

		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);

		if(elements.size() == 0){
			return true;
		} else if(elements.size() > 0 && !elements.get(0).isDisplayed()){
			return  true;
		}
		else {
			return false;
		}
	}

	protected boolean isElementEmpty(WebDriver driver, String locator, String... params){
	    overrideGlobalTimeout(driver, GlobalConstants.UNDISPLAYED_TIMEOUT);
		List<WebElement> elements = getElements(driver, getDynamicLocator(locator, params));
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		return elements.isEmpty();
	}

	protected boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	protected void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	
	protected void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, getDynamicLocator(locator, params)).click();
	}
	
	protected void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	protected void sendKeyToElement(WebDriver driver, String locator, String value, String... params) {
		locator = getDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	protected String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	protected String getTextElement(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getText();
	}
	
	protected String getAttributeElement(WebDriver driver, String locator, String attribute) {
		return getElement(driver, locator).getAttribute(attribute);
	}

	protected String getAttributeElement(WebDriver driver, String locator, String attribute, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attribute);
	}

	protected void checkToRadioOrCheckbox(WebDriver driver, String locator) {
		if(!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	protected void checkToRadioOrCheckbox(WebDriver driver, String locator, String... params) {
		if(!getElement(driver, getDynamicLocator(locator, params)).isSelected()) {
			getElement(driver, getDynamicLocator(locator, params)).click();
		}
	}

	protected void unCheckToCheckbox(WebDriver driver, String locator){
		if(getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	protected void unCheckToCheckbox(WebDriver driver, String locator, String... params){
		if(getElement(driver, getDynamicLocator(locator, params)).isSelected()) {
			getElement(driver, getDynamicLocator(locator, params)).click();
		}
	}
	
	protected void selectItemInDropdownList(WebDriver driver, String locator, String expectedItem) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(expectedItem);
	}

	protected void selectItemInDropdownList(WebDriver driver, String locator, String expectedItem, String... params) {
		select = new Select(getElement(driver, getDynamicLocator(locator, params)));
		select.selectByVisibleText(expectedItem);
	}
	
	protected String getSelectedItemInDropdownList(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	protected String getSelectedItemInDropdownList(WebDriver driver, String locator, String... params) {
		select = new Select(getElement(driver, getDynamicLocator(locator, params)));
		return select.getFirstSelectedOption().getText();
	}

	/*
	 * Explicit Wait
	 */
	protected void waitForElemetVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	protected void waitForElemetVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}

	protected void waitForAllElemetsVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}
	
	protected void waiForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	protected void waiForElementInvisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	/*
		Actions
	 */

	protected void moveMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	protected void moveMouseToElement(WebDriver driver, String locator, String... params) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicLocator(locator, params))).perform();
	}
	
	protected void moveMouseToDynamicElement(WebDriver driver, String locator, String... params) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicLocator(locator, params))).perform();
	}

	protected void pressKey(WebDriver driver, Keys pressedKey){
		action = new Actions(driver);
		action.sendKeys(pressedKey).perform();
	}

	/*
		Alert
	 */

	protected Alert waitForAlertPresence(WebDriver driver){
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver){
		alert = waitForAlertPresence(driver);
		alert.accept();
	}

	protected void cancelAlert(WebDriver driver){
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	protected String getTextAlert(WebDriver driver){
		alert = waitForAlertPresence(driver);
		return  alert.getText();
	}
	protected void sendKeyToAlert(WebDriver driver, String value){
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}


	/*
		Sorting
	 */
	public boolean isDataStringSortedAscending(WebDriver driver, String locator){
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);
		for(WebElement element : elementList){
			arrayList.add(element.getText());
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for(String item : arrayList){
			sortedList.add(item);
		}

		Collections.sort(sortedList);

		return sortedList.equals(arrayList);
	}

	public boolean isDataStringSortedDescending(WebDriver driver, String locator){
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for (String item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return sortedList.equals(arrayList);
	}

	public boolean isDataFloatSortedAscending(WebDriver driver, String locator){
		ArrayList<Float> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}

		ArrayList<Float> sortedList = new ArrayList<>();
		for (Float item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);

		return sortedList.equals(arrayList);
	}

	public boolean isDataFloatSortedDescending(WebDriver driver, String locator){
		ArrayList<Float> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}

		ArrayList<Float> sortedList = new ArrayList<>();
		for (Float item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return sortedList.equals(arrayList);
	}

	public ArrayList<String> getTextBeforeSorting(WebDriver driver, String locator){
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);
		for(WebElement element : elementList){
			arrayList.add(element.getText());
		}

		return arrayList;
	}

	public ArrayList<String> getTextAfterSortingAscending(WebDriver driver, String locator){
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);
		for(WebElement element : elementList){
			arrayList.add(element.getText());
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for(String item : arrayList){
			sortedList.add(item);
		}

		Collections.sort(sortedList);

		return sortedList;
	}

	public ArrayList<String> getTextAfterSortingDescending(WebDriver driver, String locator){
		ArrayList<String> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);
		for(WebElement element : elementList){
			arrayList.add(element.getText());
		}

		ArrayList<String> sortedList = new ArrayList<>();
		for(String item : arrayList){
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return sortedList;
	}

	public ArrayList<Float> getFloatBeforeSorting(WebDriver driver, String locator){
		ArrayList<Float> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}

		return arrayList;
	}

	public ArrayList<Float> getFloatAfterSortingAscending(WebDriver driver, String locator){
		ArrayList<Float> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}

		ArrayList<Float> sortedList = new ArrayList<>();
		for(Float item : arrayList){
			sortedList.add(item);
		}

		Collections.sort(sortedList);

		return sortedList;
	}

	public ArrayList<Float> getFloatAfterSortingDescending(WebDriver driver, String locator){
		ArrayList<Float> arrayList = new ArrayList<>();

		List<WebElement> elementList = getElements(driver, locator);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}

		ArrayList<Float> sortedList = new ArrayList<>();
		for (Float item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return sortedList;
	}
	
	public HomePageObject clickToLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
		clickToElement(driver, BasePageUI.LOGOUT_LINK);
		sleepInSecond(1);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public RegisterPageObject clickToRegisterLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REGISTER_LINK);
		clickToElement(driver, BasePageUI.REGISTER_LINK);
		sleepInSecond(1);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public void clickToDynamicHeaderLink(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_HEADER_LINK, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_HEADER_LINK, pageName);
		sleepInSecond(1);
	}

	public boolean isHeaderLinkDisplayed(WebDriver driver, String linkName) {
		waitForElemetVisible(driver, BasePageUI.DYNAMIC_HEADER_LINK, linkName);
		return isElementDisplayed(driver, BasePageUI.DYNAMIC_HEADER_LINK, linkName);
	}
	
	public void clickToDynamicTopMenu(WebDriver driver, String menuName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
		clickToElement(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
	}
	
	public void moveMouseToDynamicTopMenu(WebDriver driver, String menuName) {
		waitForElemetVisible(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
		moveMouseToElement(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
	}
	
	public void clickToDynamicSubMenu(WebDriver driver, String topMenu,String subMenuName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_SUB_MENU, topMenu, subMenuName);
		clickToElement(driver, BasePageUI.DYNAMIC_SUB_MENU, topMenu, subMenuName);
	}

	public void clickToDynamicProductByName(WebDriver driver, String productName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
		clickToElement(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
	}

	public void clickToDynamicLinkByText(WebDriver driver, String footerLink) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_LINK_BY_TEXT, footerLink);
		clickToElement(driver, BasePageUI.DYNAMIC_LINK_BY_TEXT, footerLink);
	}

	public void enterToDynamicTextbox(WebDriver driver, String textboxId, String value) {
		waitForElemetVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxId);
		sendKeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxId);
	}

	public void selectItemInDropdownListByDynamicID(WebDriver driver, String selectId, String expectedItem) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_ID, selectId);
		selectItemInDropdownList(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_ID, expectedItem, selectId);
	}

	public boolean isProductDisplayedByName(WebDriver driver, String productName) {
	    waitForElemetVisible(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
	    return isElementDisplayed(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
    }

	public boolean isProductUndisplayedByName(WebDriver driver, String productName) {
	    waiForElementInvisible(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
	    return isElementEmpty(driver, BasePageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
    }

	public HomePageObject goToHomePage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.HOME_PAGE);
		clickToElement(driver, BasePageUI.HOME_PAGE);
		return PageGeneratorManager.getHomePage(driver);
	}

	public void moveMouseToDynamicHeaderLink(WebDriver driver, String headerLink) {
		waitForElemetVisible(driver, BasePageUI.DYNAMIC_HEADER_LINK, headerLink);
		moveMouseToElement(driver, BasePageUI.DYNAMIC_HEADER_LINK, headerLink);
	}

	public String getTextNotificationMessage(WebDriver driver){
		waitForElemetVisible(driver, BasePageUI.NOTIFICATION_MESSAGE);
		return getTextElement(driver, BasePageUI.NOTIFICATION_MESSAGE);
	}

	public void closeNotificationMessage(WebDriver driver){
		waitForElementClickable(driver, BasePageUI.NOTIFICATION_MESSAGE_CLOSE_BUTTON);
		clickToElement(driver, BasePageUI.NOTIFICATION_MESSAGE_CLOSE_BUTTON);
	}

	public boolean isNotificationMessageUndisplayed(WebDriver driver){
		waiForElementInvisible(driver, BasePageUI.NOTIFICATION_MESSAGE_CLOSE_BUTTON);
		return isElementEmpty(driver, BasePageUI.NOTIFICATION_MESSAGE_CLOSE_BUTTON);
	}

	public String getBillingShippingInfoWithDynamicField(WebDriver driver, String addressType, String fieldType) {
		waitForElemetVisible(driver, BasePageUI.DYNAMIC_BILLING_SHIPPING_FIELD, addressType, fieldType);
		return getTextElement(driver, BasePageUI.DYNAMIC_BILLING_SHIPPING_FIELD, addressType, fieldType);
	}

	public void pressTabKey(WebDriver driver){
		pressKey(driver, Keys.TAB);
	}

	public void pressEnterKey(WebDriver driver){
		pressKey(driver, Keys.ENTER);
	}

	public void clickToParentItemInSideBarMenuAdminPage(WebDriver driver, String iconPath, String parentItem){
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PARENT_ITEM_IN_SIDE_BAR_MENU_ADMIN_PAGE, iconPath, parentItem);
		clickToElement(driver, BasePageUI.DYNAMIC_PARENT_ITEM_IN_SIDE_BAR_MENU_ADMIN_PAGE, iconPath, parentItem);
	}

	public void cickToChildItemInSideBarMenuInAdminPage(WebDriver driver, String childItem){
		waitForElementClickable(driver, BasePageUI.DYNAMIC_CHILD_ITEM_IN_SIDE_BAR_MENU_ADMIN_PAGE, childItem);
		clickToElement(driver, BasePageUI.DYNAMIC_CHILD_ITEM_IN_SIDE_BAR_MENU_ADMIN_PAGE, childItem);
	}

	public String getValueofTextboxByID(WebDriver driver, String attribute, String textboxId) {
		waitForElemetVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxId);
		return getAttributeElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, attribute, textboxId);
	}

	public String getSelectedValueOfDropdownList(WebDriver driver, String dropdownListID){
		waitForElemetVisible(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownListID);
		return getSelectedItemInDropdownList(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownListID);
	}

	public void clickToDynamicSectionTabByID(WebDriver driver, String collapsedTabId){
		if(isElementEmpty(driver, BasePageUI.DYNAMIC_SECTION_TAB_BY_ID, collapsedTabId)){

		} else {
			waitForElementClickable(driver, BasePageUI.DYNAMIC_SECTION_TAB_BY_ID, collapsedTabId);
			clickToElement(driver, BasePageUI.DYNAMIC_SECTION_TAB_BY_ID, collapsedTabId);
		}
	}

	private Alert alert;
	private Actions action;
	private Select select;
	private WebDriverWait explicitWait;
}
