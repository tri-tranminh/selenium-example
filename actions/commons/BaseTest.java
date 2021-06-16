package commons;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private WebDriver driver;
	private String hubUrl = "http://localhost:4444/wd/hub";
	protected final Log log;
	
	protected BaseTest() {
		// Init log
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		} else {
			throw new RuntimeException("Please input your browser name again!!!");
		}
		
		driver.get(url);
		
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url, String ipAddress, String portNumber, Platform platform) {
		
		DesiredCapabilities capability = null;
		
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(platform);
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capability);
			
		} else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("chrome");
			capability.setPlatform(platform);
			
			ChromeOptions options = new ChromeOptions();
			options.merge(capability);
			
		} else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			capability = DesiredCapabilities.edge();
			capability.setBrowserName("edge");
			capability.setPlatform(platform);
			
			EdgeOptions options = new EdgeOptions();
			options.merge(capability);
			
		} else {
			throw new RuntimeException("Please input your browser name again!!!");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(String.format("http://localhost:4444/wd/hub")), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.get(url);
		
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url, Platform platform) {
		
		DesiredCapabilities capability = null;
		
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(platform);
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capability);
			
		} else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("chrome");
			capability.setPlatform(platform);
			
			ChromeOptions options = new ChromeOptions();
			options.merge(capability);
			
		} else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			capability = DesiredCapabilities.edge();
			capability.setBrowserName("edge");
			capability.setPlatform(platform);
			
			EdgeOptions options = new EdgeOptions();
			options.merge(capability);
			
		} else {
			throw new RuntimeException("Please input your browser name again!!!");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(hubUrl), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.get(url);
		
		return driver;
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}
	
	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}
	
	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void sleepInSecond(long second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int randomNumber(){
		Random random = new Random();
		return random.nextInt();
	}

}
