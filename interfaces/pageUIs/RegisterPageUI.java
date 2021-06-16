package pageUIs;

public class RegisterPageUI {
	
	public static final String MALE_GENDER_RADIO = "//input[@id='gender-male']";
	public static final String FEMALE_GENDER_RADIO = "//input[@id='gender-female']";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String BIRTH_DAY_SELECT = "//select[@name='DateOfBirthDay']";
	public static final String BIRTH_MONTH_SELECT = "//select[@name='DateOfBirthMonth']";
	public static final String BIRTH_YEAR_SELECT = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	
	/* Error Message */
	public static final String EMPTY_FIRSTNAME_ERROR_MESSAGE = "//span[text()='First name is required.']";
	public static final String EMPTY_LASTNAME_ERROR_MESSAGE = "//span[text()='Last name is required.']";
	public static final String EMPTY_EMAIL_ERROR_MESSAGE = "//span[text()='Email is required.']";
	public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String EMPTY_CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String INVALID_EMAIL_ERROR_MESSAGE = "//span[text()='Wrong email']";
	public static final String EXISTED_EMAIL_ERROR_MESSAGE = "//li[text()='The specified email already exists']";
	public static final String SHORT_PASSWORD_ERROR_MESSAGE = "//li[text()='must have at least 6 characters']";
	public static final String UNMATCHED_CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[text()='The password and confirmation password do not match.']";
	//public static final String SUCCESS_REGISTER_MESSAGE = "//div[text()='Your registration completed']";
	public static final String SUCCESS_REGISTER_MESSAGE = "//div[@class='result']";
}
