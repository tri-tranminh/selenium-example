package pageUIs;

public class BasePageUI {

	public static final String HOME_PAGE = "//img[@alt='nopCommerce demo store']";

	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";

    public static final String NOTIFICATION_MESSAGE = "//div[@class='bar-notification success']//p[@class='content']";
	public static final String NOTIFICATION_MESSAGE_CLOSE_BUTTON = "//span[@class='close']";
	public static final String DYNAMIC_DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String DYNAMIC_BILLING_SHIPPING_FIELD = "//div[@class='%s-info']//li[@class='%s']";
	public static final String DYNAMIC_PARENT_ITEM_IN_SIDE_BAR_MENU_ADMIN_PAGE = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']//i[@class='%s']/following-sibling::p[contains(text(), '%s')]";
	public static final String DYNAMIC_CHILD_ITEM_IN_SIDE_BAR_MENU_ADMIN_PAGE = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']//following-sibling::p[text()=' %s']";
	public static final String DYNAMIC_SECTION_TAB_BY_ID = "//div[@id='customer-address']//i[contains(@class, 'fa-plus')]";

	public static String DYNAMIC_HEADER_LINK = "//a[@class='%s']";
	public static final String DYNAMIC_TOP_MENU = "//ul[@class='top-menu notmobile']/li[contains(string(), '%s')]";
	public static final String DYNAMIC_SUB_MENU = "//ul[@class='top-menu notmobile']/li[contains(string(), '%s')]//a[contains(string(), '%s')]";

	public static final String DYNAMIC_PRODUCT_BY_NAME = "//h2[@class='product-title']//a[text()='%s']";
	public static final String DYNAMIC_LINK_BY_TEXT = "//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
}
