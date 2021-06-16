package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToFirstNameTextbox(String firstName) {
		waitForElemetVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}
	
	
	public void enterToLastNameTextbox(String lastName) {
		waitForElemetVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}
	
	
	public void enterToPasswordTextbox(String password) {
		waitForElemetVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElemetVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isEmptyFirstNameErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.EMPTY_FIRSTNAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMPTY_FIRSTNAME_ERROR_MESSAGE);
	}

	public boolean isEmptyLastNameErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.EMPTY_LASTNAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMPTY_LASTNAME_ERROR_MESSAGE);
	}

	public boolean isEmptyEmailErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
	}

	public boolean isEmptyPasswordErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isEmptyConfirmPasswordErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.EMPTY_CONFIRM_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMPTY_CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElemetVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void enterToCompanyTextbox(String company) {
		waitForElemetVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
	}

	public boolean isInvalidEmailErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}

	public boolean isExistedEmailErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.EXISTED_EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EXISTED_EMAIL_ERROR_MESSAGE);
	}

	public boolean isShortPasswordErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.SHORT_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SHORT_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isUnmatchedConfirmPasswordErrorMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.UNMATCHED_CONFIRM_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.UNMATCHED_CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isSuccessRegisterMessageDisplayed() {
		waitForElemetVisible(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_REGISTER_MESSAGE);
	}

	public void clickToMaleGenderRadio() {
		waitForElementClickable(driver, RegisterPageUI.MALE_GENDER_RADIO);
		checkToRadioOrCheckbox(driver, RegisterPageUI.MALE_GENDER_RADIO);
	}

	public void selectBirthDayDropdownList(String birthDay) {
		waitForElementClickable(driver, RegisterPageUI.BIRTH_DAY_SELECT);
		selectItemInDropdownList(driver, RegisterPageUI.BIRTH_DAY_SELECT, birthDay);
	}

	public void selectBirthMonthDropdownList(String birthMonth) {
		waitForElementClickable(driver, RegisterPageUI.BIRTH_MONTH_SELECT);
		selectItemInDropdownList(driver, RegisterPageUI.BIRTH_MONTH_SELECT, birthMonth);
	}

	public void selectBirthYearDropdownList(String birthYear) {
		waitForElementClickable(driver, RegisterPageUI.BIRTH_YEAR_SELECT);
		selectItemInDropdownList(driver, RegisterPageUI.BIRTH_YEAR_SELECT, birthYear);
	}

}
