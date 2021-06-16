package register;

import org.openqa.selenium.Platform;
import org.testng.annotations.*;
import utilities.DataHelper;
import org.openqa.selenium.WebDriver;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Register extends BaseTest {

	WebDriver driver;
	DataHelper data;

	String firstName, lastName, company, birthDay, birthMonth, birthYear;
	String invalidEmail, invalidPassword;
	public static String emailAddress, password;

	@Parameters({"browser", "appUrl"})
	@BeforeClass
	private void beforeClass(String BrowserName, String AppUrl) {
		driver = getBrowserDriver(BrowserName, AppUrl);

		data = DataHelper.getData();
		firstName = data.getFirstName();
		lastName = data.getLastName();
		company = data.getCompanyName();
		emailAddress = data.getEmail();
		password = "123456";
		birthDay = "9";
		birthMonth = "September";
		birthYear = "1990";

		invalidEmail = "testingEmail";
		invalidPassword = "123";

	}

	@Test
	protected void TC_01_Register_With_Empty_Data() {
		log.info("**************** Test Case 01: Register_With_Empty_Data ****************");

		log.info("Register_With_Empty_Data - Step 01: Open Home page");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Register_With_Empty_Data - Step 02: Click to Register Link");
		homePage.clickToDynamicHeaderLink(driver,"ico-register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		log.info("Register_With_Empty_Data - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("Register_With_Empty_Data - Step 04: Verify error message for empty First Name is displayed");
		verifyTrue(registerPage.isEmptyFirstNameErrorMessageDisplayed());

		log.info("Register_With_Empty_Data - Step 05: Verify error message for empty Last Name is displayed");
		verifyTrue(registerPage.isEmptyLastNameErrorMessageDisplayed());

		log.info("Register_With_Empty_Data - Step 06: Verify error message for empty mail is displayed");
		verifyTrue(registerPage.isEmptyEmailErrorMessageDisplayed());

		log.info("Register_With_Empty_Data - Step 07: Verify error message for empty Password is displayed");
		verifyTrue(registerPage.isEmptyPasswordErrorMessageDisplayed());

		log.info("Register_With_Empty_Data - Step 08: Verify error message for empty Confirm Password is displayed");
		verifyTrue(registerPage.isEmptyConfirmPasswordErrorMessageDisplayed());
	}

	@Test
	protected void TC_02_Register_With_Invalid_Email() {
		log.info("**************** Test Case 02: Register_With_Invalid_Email ****************");

		log.info("Register_With_Invalid_Email - Step 01: Enter to First Name Textbox with value: " + firstName);
		registerPage.enterToFirstNameTextbox(firstName);

		log.info("Register_With_Invalid_Email - Step 02: Enter to Last Name Textbox with value: " + lastName);
		registerPage.enterToLastNameTextbox(lastName);

		log.info("Register_With_Invalid_Email - Step 03: Enter to Email Textbox with value: " + invalidEmail);
		registerPage.enterToEmailTextbox(invalidEmail);

		log.info("Register_With_Invalid_Email - Step 04: Enter to Password Textbox with value: " + password);
		registerPage.enterToPasswordTextbox(password);

		log.info("Register_With_Invalid_Email - Step 05: Enter to Confirm Password Textbox with value: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register_With_Invalid_Email - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_With_Invalid_Email - Step 07: Verify the Invalid Email Error Message is displayed");
		verifyTrue(registerPage.isInvalidEmailErrorMessageDisplayed());
	}

	@Test
	protected void TC_03_Register_With_Password_Less_Than_6_Characters() {
		log.info("**************** Test Case 03: Register_With_Password_Less_Than_6_Characters ****************");

		log.info("Register_With_Password_Less_Than_6_Characters - Step 01: Enter to Password Textbox with invalid password: " + invalidPassword);
		registerPage.enterToPasswordTextbox(invalidPassword);

		log.info("Register_With_Password_Less_Than_6_Characters - Step 02: Enter to Confirm Password Textbox with invalid password: " + invalidPassword);
		registerPage.enterToConfirmPasswordTextbox(invalidPassword);

		log.info("Register_With_Password_Less_Than_6_Characters - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_With_Password_Less_Than_6_Characters - Step 04: Verify the Short Password Error Message is displayed");
		verifyTrue(registerPage.isShortPasswordErrorMessageDisplayed());
	}

	@Test
	protected void TC_04_Register_With_Unmatched_Confirm_Password() {
		log.info("**************** Test Case 04: Register_With_Unmatched_Confirm_Password ****************");

		log.info("Register_With_Unmatched_Confirm_Password - Step 01: Enter to Password Textbox with valid password: " + password);
		registerPage.enterToPasswordTextbox(password);

		log.info("Register_With_Unmatched_Confirm_Password - Step 01: Enter to Confirm Password Textbox with unmatched password: " + invalidPassword);
		registerPage.enterToConfirmPasswordTextbox(invalidPassword);

		log.info("Register_With_Unmatched_Confirm_Password - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_With_Unmatched_Confirm_Password - Step 04: Verify the Unmatched Password Error Message is displayed");
		verifyTrue(registerPage.isUnmatchedConfirmPasswordErrorMessageDisplayed());
	}

	@Test
	protected void TC_05_Register_With_Valid_Info() {
		log.info("**************** Test Case 05: Register_With_Valid_Info ****************");

		log.info("Register_With_Valid_Info - Step 01: Select Radio male gender");
		registerPage.clickToMaleGenderRadio();

		log.info("Register_With_Valid_Info - Step 02: Enter to First Name Textbox with value: " + firstName);
		registerPage.enterToFirstNameTextbox(firstName);

		log.info("Register_With_Valid_Info - Step 03: Enter to Last Name Textbox with value: " + lastName);
		registerPage.enterToLastNameTextbox(lastName);

		log.info("Register_With_Valid_Info - Step 04: Select Birth Day with value: " + birthDay);
		registerPage.selectBirthDayDropdownList(birthDay);

		log.info("Register_With_Valid_Info - Step 05: Select Birth Month with value: " + birthMonth);
		registerPage.selectBirthMonthDropdownList(birthMonth);

		log.info("Register_With_Valid_Info - Step 06: Select Birth Year with value: " + birthYear);
		registerPage.selectBirthYearDropdownList(birthYear);

		log.info("Register_With_Valid_Info - Step 07: Enter to Company Textbox with email: " + company);
		registerPage.enterToCompanyTextbox(company);

		log.info("Register_With_Valid_Info - Step 08: Enter to Email Textbox with email: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);

		log.info("Register_With_Valid_Info - Step 09: Enter to Password Textbox with valid password: " + password);
		registerPage.enterToPasswordTextbox(password);

		log.info("Register_With_Valid_Info - Step 10: Enter to Confirm Password Textbox with valid password: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register_With_Valid_Info - Step 11: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register_With_Valid_Info - Step 12: Verify that the Susscess message is displayed");
		verifyTrue(registerPage.isSuccessRegisterMessageDisplayed());
		sleepInSecond(3);

		log.info("Register_With_Valid_Info - Step 13: Logout to Home Page");
		homePage = registerPage.clickToLogoutLink(driver);

	}

	@Test
	protected void TC_06_Register_With_Existed_Email() {
		log.info("**************** Test Case 06: Register_With_Existed_Email ****************");

		log.info("Register_With_Existed_Email - Step 01: Click to Register Link");
		registerPage = homePage.clickToRegisterLink(driver);

		log.info("Register_With_Existed_Email - Step 02: Enter to First Name Textbox with value: " + firstName);
		registerPage.enterToFirstNameTextbox(firstName);

		log.info("Register_With_Existed_Email - Step 03: Enter to Last Name Textbox with value: " + lastName);
		registerPage.enterToLastNameTextbox(lastName);

		log.info("Register_With_Existed_Email - Step 04: Enter to Email Textbox with value: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);

		log.info("Register_With_Existed_Email - Step 05: Enter to Password Textbox with valid password: " + password);
		registerPage.enterToPasswordTextbox(password);

		log.info("Register_With_Existed_Email - Step 06: Enter to Confirm Password Textbox with valid password: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);

		log.info("Register_With_Existed_Email - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		sleepInSecond(1);

		log.info("Register_With_Existed_Email - Step 08: Verify that the Existed Email Error Message is displayed");
		verifyTrue(registerPage.isExistedEmailErrorMessageDisplayed());
	}

	@AfterClass
	private void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
}
