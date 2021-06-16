package register;

import commons.BaseTest;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Register_Old extends BaseTest {

	private WebDriver driver;

	private String firstName, lastName, company, birthDay, birthMonth, birthYear;
	private String invalidEmail, invalidPassword;
	public static String emailAddress, password;

	@Parameters({"browser", "appUrl", "platform"})
	@BeforeClass
	private void beforeClass(String BrowserName, String appUrl, Platform platform) {
		driver = getBrowserDriver(BrowserName, appUrl);
		
		firstName = "QA";
		lastName = "Test";
		company = "QA COMPANY";
		emailAddress = "emailtesting" + randomNumber() + "@mail.com";
		password = "123456";
		birthDay = "9";
		birthMonth = "September";
		birthYear = "1990";

		invalidEmail = "testingEmail";
		invalidPassword = "123";

	}
	
	@Test
	protected void TC_05_Register_With_Valid_Info() {
		homePage = PageGeneratorManager.getHomePage(driver);

		registerPage = homePage.clickToRegisterLink();

		System.out.println("Register_With_Valid_Info - Step 01: Select Radio male gender");
		registerPage.clickToMaleGenderRadio();

		System.out.println("Register_With_Valid_Info - Step 02: Enter to First Name Textbox with value: " + firstName);
		registerPage.enterToFirstNameTextbox(firstName);

		System.out.println("Register_With_Valid_Info - Step 03: Enter to Last Name Textbox with value: " + lastName);
		registerPage.enterToLastNameTextbox(lastName);

		System.out.println("Register_With_Valid_Info - Step 04: Select Birth Day with value: " + birthDay);
		registerPage.selectBirthDayDropdownList(birthDay);

		System.out.println("Register_With_Valid_Info - Step 05: Select Birth Month with value: " + birthMonth);
		registerPage.selectBirthMonthDropdownList(birthMonth);

		System.out.println("Register_With_Valid_Info - Step 06: Select Birth Year with value: " + birthYear);
		registerPage.selectBirthYearDropdownList(birthYear);

		System.out.println("Register_With_Valid_Info - Step 07: Enter to Company Textbox with email: " + company);
		registerPage.enterToCompanyTextbox(company);

		System.out.println("Register_With_Valid_Info - Step 08: Enter to Email Textbox with email: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);

		System.out.println("Register_With_Valid_Info - Step 09: Enter to Password Textbox with valid password: " + password);
		registerPage.enterToPasswordTextbox(password);

		System.out.println("Register_With_Valid_Info - Step 10: Enter to Confirm Password Textbox with valid password: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);

		System.out.println("Register_With_Valid_Info - Step 11: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_With_Valid_Info - Step 12: Verify that the Susscess message is displayed");
		Assert.assertTrue(registerPage.isSuccessRegisterMessageDisplayed());

		System.out.println("Register_With_Valid_Info - Step 13: Logout to Home Page");
		homePage = registerPage.clickToLogoutLink(driver);

	}

	@AfterClass
	private void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
}
