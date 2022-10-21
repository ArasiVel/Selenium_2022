package com.salesForce.Test.base_1;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.salesForce.tests.utility_1.CommonUtilities;
import com.salesForce.tests.utility_1.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Logger logger =LogManager.getLogger(BaseTest.class);
	public static GenerateReports report=null;
	@BeforeTest
	public static void setupBeforeTest() {
		report=GenerateReports.getInstance();
		report.startExtentReport();
	}
	@Parameters({ "browsername" })
	@BeforeMethod
	public static void setUp( String browsername,Method m) {
		report.startSingleTestReport(m.getName());
		System.out.println("beofore method execution started");
		setDriver(browsername);
		CommonUtilities CU = new CommonUtilities();
		Properties salesForceDataPropertiesFile = CU.loadFile("salesforceDataProperties");
		String url = CU.getApplicationProperty("url", salesForceDataPropertiesFile);
		gotoUrl(url);
		waitUntilPageLoads();
				
	}
	
	
	@AfterMethod
	public static void tearDown() {
		logger.info("after method execution is started");
		closeBrowser();
	}
	
	@AfterTest
	public static void teardownAfterTest() {
		report.endReport();
	}

	public static void setDriver(String browser) {

		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
		}
		public static void loginToSalesForce() {
			WebElement username = driver.findElement(By.id("username"));
			waitUntilVisible(username,"username field");
			enterText(username,"userName","usernamefield");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, "PassWord", "password");
			WebElement loginButton = driver.findElement(By.id("Login"));
			clickElement(loginButton, "login button");		
			
	}
	
	
	
	public static void  validUsername() {
		
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"dhanush@kodak.com","user name");
	}
	
	public static void  validPassword() {
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "DarshanA13", "password");	
		
	}
	public static  void loginButton() {
		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "login button");		
	}
	
	
	
	public static void invalidUserNamePassWord() {
		WebElement username = driver.findElement(By.id("username"));
		enterText(username,"123","invalid_username");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		enterText(password, "22131", "invalid_password");
	}
	
		

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
		report.logTestInfo("page got refreshed");
	}
	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static void enterText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			report.logTestInfo("text entered in " + objName + "field");
			
		} else {
			report.logTestFailed("fail: " + objName + " element not displayed");
			
		}
	}

	public static void clickElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.click();
			report.logTestpassed("pass:" + objName + " element clicked");
			
		} else {
			report.logTestFailed("fail:" + objName + "  element not displayed");

		}
	}

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {
			element.clear();
			report.logTestpassed("pass:" + objName + "  element cleared");

		} else {
			report.logTestFailed("fail:" + objName + " element not displayed");
		}
	}

	public static WebDriver getDriverInstance() {
		return driver;
	}

	public static void gotoUrl(String url) {
		driver.get(url);
	}

	public static void moveToElement(WebElement element, String objectName) {
		waitUntilVisible(element, objectName);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		report.logTestInfo("moved to " + objectName);
		
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void closeAllbrowser() {
		driver.quit();
	}

	public static void waitUntilVisibilityOf(By locator, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static String readText(WebElement element, String objectName) {
		waitUntilVisible(element, objectName);
		String text = element.getText();
		return text;
	}

	public static void waitUntilVisible(WebElement element, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntilAlertIsPresent() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitUntilElementToBeClickable(By locator, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static Alert switchToAlert() {
		
		waitUntilAlertIsPresent();
		return driver.switchTo().alert();
	}

	public static void AcceptAlert(Alert alert) {

		report.logTestInfo("Alert accepted");
		alert.accept();

	}

	public static String getAlertText(Alert alert) {

		return alert.getText();

	}

	public static void dismisAlert() {
		waitUntilAlertIsPresent();
		Alert alert = switchToAlert();
		alert.dismiss();
		report.logTestInfo("Alert dismissed");

	}

	public static void selectByTextData(WebElement element, String text, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		report.logTestInfo(objName + " selected " + text);

	}

	public static void selectByIndexData(WebElement element, int index, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
	}

	public static void selectByValueData(WebElement element, String text) {
		Select selectCity = new Select(element);
		selectCity.selectByValue(text);
	}

	public static void switchToWindowOpned(String mainWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
		}
		report.logTestInfo("switched to new window");
	}
	public static WebElement selectFromList(List<WebElement> list,String text) {
		WebElement country=null;
		for (WebElement i : list) {
			if (i.getText().equalsIgnoreCase(text)) {
				report.logTestInfo("selected=" +i.getText());
				country=i;
				break;
			}
			
		}
		return country;
		
	}

}
	
	
	
	

