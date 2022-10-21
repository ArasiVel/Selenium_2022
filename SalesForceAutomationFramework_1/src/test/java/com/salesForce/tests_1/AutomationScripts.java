package com.salesForce.tests_1;


	
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

import com.salesForce.Test.base_1.BaseTest;
import com.salesForce.tests.utility_1.CommonUtilities;
	

	public class AutomationScripts extends BaseTest {
			@Test
		
			public static void SFTC01_emptyPassword() {
							
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			validUsername();
			WebElement password = driver.findElement(By.id("password"));
			clickElement(password, "password");
			WebElement loginButton = driver.findElement(By.id("Login"));
			clickElement(loginButton,"login button");
				
		}
		@Test
		
		public static void SFTC02_login()  {
			
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			validUsername();
			validPassword();
			loginButton();		
		}	
		@Test
		
		public static void SFTC03_rememberUsername() {
			
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			validUsername();
			validPassword();
			WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"rememberUn\"]"));
			waitUntilVisible(checkBox, "checkBox");
			clickElement(checkBox, "checkBox");
			WebElement loginButton = driver.findElement(By.id("Login"));
			clickElement(loginButton,"login button");
			WebElement menuDropDown = driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
			waitUntilVisible(menuDropDown,"menuDropDown");
			clickElement(menuDropDown,"menuDropDown");
			WebElement logoutButton = driver.findElement(By.linkText("Logout"));
			clickElement(logoutButton, "logout button");
			closeBrowser();
			
			
				}
		@Test
		public static void  SFTC04A_forgotPassword() throws InterruptedException  {
			setDriver("firefox");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			WebElement forgetPassword =driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]"));
			waitUntilVisible(forgetPassword,"forgetPassword");
			clickElement(forgetPassword, "forget password");
			WebElement forgotPWField=driver.findElement(By.id("un"));
			enterText(forgotPWField,"userName", "forgotPWField");
			WebElement continueButton= driver.findElement(By.xpath("//*[@id=\"continue\"]"));
			waitUntilVisible( continueButton," continue Button");
			clickElement(continueButton, "continue button");
	}
		@Test
		
		public static void SFTC04B_loginErrorMessage()  {
		
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			driver.manage().window().maximize();
			waitUntilPageLoads();
			invalidUserNamePassWord();
			WebElement loginButton = driver.findElement(By.id("Login"));
			clickElement(loginButton, "login button");
			
			}
		@Test
		
		public static void SFTC05_userMenu() {
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			validUsername();
			validPassword();
			loginButton();		
			WebElement menuDropDown=driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
			waitUntilVisible(menuDropDown,"menuDropDown");
			clickElement(menuDropDown, "menu DropDown");
				}
		public static void SFTC06_myProfile(String browsername) throws InterruptedException {
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			loginToSalesForce();
			WebElement menuDropDown = driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
			waitUntilVisible(menuDropDown,"menuDropDown");
			clickElement(menuDropDown, "menu DropDown");
			WebElement myProfile = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[1]"));
			clickElement(myProfile, "My profile");
			WebElement edit = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img"));
			clickElement(edit, "Edit");
			driver.switchTo().frame("contactInfoContentId");
			WebElement about = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/ul/li[1]/a"));
			clickElement(about,"about");
			WebElement lastname = driver.findElement(By.id("lastName"));
			lastname.clear();
			enterText(lastname, "RV", "last name");
			WebElement saveAll = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]"));
			clickElement(saveAll, "saveall button");
			driver.switchTo().defaultContent();
			WebElement postLink = driver.findElement(By.className("publisherattachtext"));
			clickElement(postLink, "Post Link");
			WebElement postFrame = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
			driver.switchTo().frame(postFrame);
			driver.findElement(By.xpath("//html/body")).sendKeys("print this message");
			driver.switchTo().defaultContent();
			WebElement shareButton = driver.findElement(By.id("publishersharebutton"));
			clickElement (shareButton, "share button");
			Thread.sleep(5000);
			WebElement file = driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]")); 
			clickElement(file,"file");
			//Thread.sleep(5000);
			WebElement upLoadFile = driver.findElement(By.id("chatterUploadFileAction"));
			//waitUntilVisibilityOf(UpLoadFile, "upload file");
			clickElement(upLoadFile, "upload file");
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			//WebElement browse = driver.findElement(By.id("chatterFile"));
			//clickElement(browse, "browse");
			WebElement chooseFile = driver.findElement(By.xpath("//*[@id=\"chatterFile\"]"));
			clickElement(chooseFile, "choose file"); 
			driver.switchTo().window("Pictures");
			
	}	
		public static void SFTC07_userMenu(String browsername) throws InterruptedException {
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			loginToSalesForce();
			WebElement menuDropDown = driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
			clickElement(menuDropDown, "menu DropDown");
			WebElement mySettings = driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[2]"));
			clickElement(mySettings, "my settings");
			Thread.sleep(8000);
			WebElement personalLink = driver.findElement(By.id("PersonalInfo_font"));
			clickElement(personalLink, "personal Link");
			driver.switchTo().equals("LoginHistory");
			WebElement loginHistory  = driver.findElement(By.id("LoginHistory_font"));
			clickElement(loginHistory, "login History");
			WebElement downloadLogin =driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/div/a"));
			clickElement(downloadLogin, "download Login");
		    WebElement displayAndLayout = driver.findElement(By.id("DisplayAndLayout_font"));
		    clickElement(displayAndLayout, "Display and layout");
		    //waitUntilVisibilityOf(customizeMyTabs,"customize My Tabs");
		    //Thread.sleep(5000);
		    WebElement cutomizeMyTab = driver.findElement(By.id("CustomizeTabs_font"));
		    clickElement(cutomizeMyTab, "customizeTab");
		    Thread.sleep(5000);
		    WebElement customdropdown =driver.findElement(By.xpath("//select[@id='p4']"));
		    Select select=new Select(customdropdown);
			select.selectByVisibleText("Salesforce Chatter");
			WebElement availabletab = driver.findElement(By.id("duel_select_0"));
			Select select1= new Select(availabletab);
			Thread.sleep(5000);
			select1.selectByVisibleText("Reports");
			WebElement addicon=driver.findElement(By.xpath(" //img[@class='rightArrowIcon']"));
			clickElement(addicon, "add icon");
			driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			WebElement email = driver.findElement(By.id("EmailSetup_font"));
			clickElement(email, "email");
			WebElement myEmailSettings=driver.findElement(By.id("EmailSettings_font"));
			clickElement(myEmailSettings, "myEmail settings");
			WebElement emailName = driver.findElement(By.id("sender_name"));
			emailName.clear();
			enterText(emailName, "dhanushRV", " email Name");
			WebElement emailAddress = driver.findElement(By.id("sender_email"));
			emailAddress.clear();
			enterText(emailAddress,"arasi.darshana@gmail.com" ,"email Address");
			WebElement radioButton = driver.findElement(By.id("auto_bcc1"));
			clickElement (radioButton, "radio button");
			WebElement saveButton= driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
			clickElement(saveButton, "save Button");
			WebElement calenAndRemain = driver.findElement(By.id("CalendarAndReminders_font"));
			clickElement(calenAndRemain, "calender and remainder");
			WebElement activityRemain = driver.findElement(By.id("Reminders_font"));
			clickElement(activityRemain, "activity remainder");
			WebElement openTestRemain = driver.findElement(By.id("testbtn"));
			clickElement(openTestRemain, "openTest Remainder");
	}	
		
		public static void SFTC08_developerConsole(String browsername) throws InterruptedException {
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			loginToSalesForce();
			WebElement menuDropDown = driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
			clickElement(menuDropDown, "menu DropDown");
			WebElement developerConsole = driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
			clickElement(developerConsole, "developer console");
			driver.quit();
			
		}	
			
		
		
	public static void SFTC09_logout(String browsername) throws InterruptedException {	
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			loginToSalesForce();
			WebElement menuDropDown = driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
			clickElement(menuDropDown, "menu DropDown");
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			clickElement(logout, "log out");
		
		}
	public static void SFTC10_createAccount(String browsername) throws InterruptedException, IOException {	
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			loginToSalesForce();
			WebElement accountsLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/nav/ul/li[5]/a"));
			clickElement(accountsLink, "accounts Link");
			Thread.sleep(4000);
			WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
			clickElement(closeFrame, "close Frame");
			//waitUntilVisible(closeFrame, "close frame");
			WebElement newButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[2]/input"));
			clickElement(newButton,"new button");
			WebElement accountName = driver.findElement(By.id("acc2"));
			enterText(accountName,"Tekarch", "accounts Name");
			WebElement type = driver.findElement(By.xpath("//select[@id='acc6']"));
			clickElement(type,"type");
			Select select = new Select(type);
			select.selectByVisibleText("Technology Partner");
			WebElement customerPriority = driver.findElement(By.id("00N4x00000WJLyZ"));
			clickElement(customerPriority,"customer Priority");
			Select select1 = new Select(customerPriority);
			select1.selectByVisibleText("High");
			
		}
	public static void SFTC11_createNewView(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement accountsLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/nav/ul/li[5]/a"));
		clickElement(accountsLink, "accounts Link");
		Thread.sleep(4000);
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		WebElement createNewview = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		clickElement(createNewview, "create New view");
		WebElement viewName = driver.findElement(By.id("fname"));						
		enterText(viewName,"Arasi", "view name");
		WebElement viewUniqueName = driver.findElement(By.id("devname"));						
		enterText(viewUniqueName,"Vel", "view unique name");
		WebElement save= driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickElement(save, "save");

		}
	public static void SFTC12_editView(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement accountsLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/nav/ul/li[5]/a"));
		clickElement(accountsLink, "accounts Link");
		Thread.sleep(4000);
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		Thread.sleep(4000);
		WebElement viewName = driver.findElement(By.id("fcf"));
		clickElement(viewName, "Arasi");
		waitUntilVisible(viewName, "Arasi");
		Select select = new Select(viewName);
		select.selectByVisibleText("Arasi");
		WebElement edit = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[2]/a[1]"));
		clickElement(edit, "edit");
		WebElement editNewName = driver.findElement(By.id("fname"));
		clearElement (editNewName, "edit view Name");
		enterText(editNewName, "Darshana", "new view name");
		WebElement filtersField=driver.findElement(By.id("fcol1"));
		waitUntilVisible(filtersField, "click menu");
		clickElement(filtersField, "click filter menu");
		Select select1 = new Select(filtersField);
		select1.selectByVisibleText("Account Name");
		WebElement operaterField=driver.findElement(By.id("fop1"));
		waitUntilVisible(operaterField, "click menu");
		clickElement(operaterField, "click operater menu");
		Select select2 = new Select(operaterField);
		select2.selectByVisibleText("contains");
		WebElement valueField=driver.findElement(By.id("fval1"));
		waitUntilVisible(valueField, "value field");
		enterText(valueField, "a", "value field");
		WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[3]/table/tbody/tr/td[2]/input[1]"));
		waitUntilVisible(saveButton, "save Button");
		clickElement(saveButton, "save Button");
		driver.close();
		}
	public static void SFTC13_mergeAccounts(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement accountsLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/nav/ul/li[5]/a"));
		clickElement(accountsLink, "accounts Link");
		Thread.sleep(4000);
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		//Thread.sleep(4000);
		WebElement mergeAccounts = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		clickElement(mergeAccounts, "mergeAccounts");
		WebElement textBox = driver.findElement(By.id("srch"));
		waitUntilVisible(textBox, "text box");
		enterText(textBox, "Tekarch ", "text box");
		WebElement findAccounts = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[4]/input[2]"));
		waitUntilVisible(findAccounts, "find accounts");
		clickElement(findAccounts, "find Accounts");
		//WebElement checkBox1 = driver.findElement(By.id("cid2"));
		//waitUntilVisible(checkBox1, "check Box1");
		//driver.switchTo().activeElement();
		//clickElement(checkBox1,"check Box1");
		WebElement nextButton = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[5]/div/input[1]"));
		waitUntilVisible(nextButton, "next");
		clickElement(nextButton,"next Button");
		WebElement mergeButton = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[1]/div/input[2]"));
		clickElement(mergeButton,"merge Button");
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	public static void SFTC14_createAccountReport(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement accountsLink = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/nav/ul/li[5]/a"));
		waitUntilVisible(accountsLink, "accounts Link");
		clickElement(accountsLink, "accounts Link");
		Thread.sleep(4000);
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		WebElement lastActivity=driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		clickElement(lastActivity, "last Activity");
		WebElement dateField=driver.findElement(By.id("ext-gen20"));
		clickElement(dateField, "date Field");
		WebElement createdDate=driver.findElement(By.xpath("/html/body/div[15]/div/div[3]"));
		waitUntilVisible(createdDate, "Created Date");
		clickElement(createdDate, "Created Date");
		WebElement dateField1=driver.findElement(By.id("ext-gen152"));
		clickElement(dateField1, "date Field1");
		WebElement todayButton=driver.findElement(By.id("ext-gen281"));
		//waitUntilElementToBeClickable(div[id='ext-gen265'] div:nth-child(3), "todayButton");
		waitUntilVisible(todayButton, "Today");
		clickElement(todayButton, "today Button");
		WebElement dateField2=driver.findElement(By.id("ext-gen154"));
		waitUntilVisible(dateField2, "date Field2");
		clickElement(dateField2, "date Field2");
		WebElement todayButton1=driver.findElement(By.cssSelector("#ext-gen3"));
		waitUntilVisible(todayButton1, "today");
		clickElement(todayButton1, "today Button");
		WebElement saveButton = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		clickElement(saveButton, "save Button");
		WebElement reportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		enterText(reportName, "salesforce", "reportName");
		WebElement reportUniqueName = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		enterText(reportUniqueName, "1", "report unique Name");
		waitUntilElementToBeClickable(By.id("ext-gen340"), "save And Run");
		WebElement saveAndRun =driver.findElement(By.id("ext-gen340"));
		//waitUntilElementToBeClickable(By.id("ext-gen340"));
		clickElement(saveAndRun, "save And Run");
	}
	public static void SFTC15_oppotunitiesDropDown(String browsername) throws InterruptedException, IOException {	
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		Thread.sleep(4000);
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		clickElement(opportunities,"opportunites login button");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		WebElement opportunitiesDropDown = driver.findElement(By.id("fcf"));
		clickElement(opportunitiesDropDown, "opportunitiesDropDown");
		
		
	}


	public static void SFTC16_createNewOppotunity() throws InterruptedException, IOException {	
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		validUsername();
		validPassword();
		loginButton();		
		Thread.sleep(4000);
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		clickElement(opportunities,"opportunites login button");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		WebElement newButton=driver.findElement(By.cssSelector("input[title='New']"));
		waitUntilVisible(newButton, "new");
		clickElement(newButton, "new Button");
		WebElement opportunityName=driver.findElement(By.id("opp3"));	
		enterText(opportunityName, "whiteHouse", "opportunity Name");
		WebElement accountName=driver.findElement(By.id("opp4"));	
		enterText(accountName, "Tekarch", "account Name");
		WebElement closeDate=driver.findElement(By.id("opp9"));	
		clickElement(closeDate, "close Date");
		Thread.sleep(5000);
		driver.switchTo().frame(closeDate);
		WebElement todayDate =driver.findElement(By.xpath("//a[contains(text(),'9/25/2022')]"));
		waitUntilVisible(todayDate, "Today");
		clickElement(todayDate, "Today");
		WebElement stage=driver.findElement(By.id("opp11"));
		//waitUntilVisible(stage, "Stage");
		clickElement(stage, "Stage");
		waitUntilVisible(stage, "Stage");
		Select select = new Select(stage);
		select.selectByVisibleText("Qualification");
		WebElement probability=driver.findElement(By.id("opp12"));	
		clearElement(probability, "probability");
		enterText(probability,"100%","probability" );
		WebElement leadSource =driver.findElement(By.id("opp6"));
		waitUntilVisible(leadSource, "lead source");
		Select select1= new Select(leadSource);
		select1.selectByVisibleText("Web");
		WebElement primaryCampaign = driver.findElement(By.id("opp17"));
		waitUntilVisible( primaryCampaign, " primary Campaign ");
		enterText(primaryCampaign,"Web","primary Campaign" );
	}

	public static void SFTC17_opportunityPipeline(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		Thread.sleep(4000);
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		clickElement(opportunities,"opportunites login button");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		WebElement opportunityPipeline = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		waitUntilVisible( opportunityPipeline, " Opportunity Pipeline ");
		clickElement(opportunityPipeline, "opportunity Pipeline");
		
		}
	public static void SFTC18_stuckOpportunities(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		Thread.sleep(4000);
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		clickElement(opportunities,"opportunites login button");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		WebElement opporunities =driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		clickElement(opporunities, "opporunities link");
	}
	public static void SFTC19_quaterlySummary(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		Thread.sleep(4000);
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		clickElement(opportunities,"opportunites login button");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		clickElement(closeFrame, "close Frame");
		WebElement quarterlySummary=driver.findElement(By.xpath("//h3[contains(text(),'Quarterly Summary')]"));
		waitUntilVisible(quarterlySummary, "quarterly Summary");
		WebElement interval = driver.findElement(By.id("quarter_q"));
		clickElement(interval, "interval");
		Select select = new Select(interval);
		select.selectByVisibleText("Current and Next FQ");
		WebElement include = driver.findElement(By.id("open"));
		waitUntilVisible(include, "include");
		clickElement(include, "Include");
		Select select1 = new Select(include);
		select1.selectByVisibleText("All Opportunities");
		
	}
	public static void SFTC20_leadsTab(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		Thread.sleep(6000);
		WebElement leadTab=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
		waitUntilVisible(leadTab, "lead Tab");
		clickElement(leadTab, "lead Tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");

	}
	public static void SFTC21_leadsSelectView(String browsername) throws InterruptedException, IOException {

		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement leadTab=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
		waitUntilVisible(leadTab, "lead Tab");
		clickElement(leadTab, "lead Tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement viewDropDown=driver.findElement(By.id("fcf"));
		clickElement(viewDropDown, "drop down");
	}
	public static void SFTC22_functionalityOfTheGo(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement leadTab=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
		waitUntilVisible(leadTab, "lead Tab");
		clickElement(leadTab, "lead Tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement viewDropDown=driver.findElement(By.id("fcf"));
		waitUntilVisible(viewDropDown, "view Drop down");
		clickElement(viewDropDown, "drop down");
		Select select = new Select(viewDropDown);
		select.selectByVisibleText("Today's Leads");
		WebElement userMenu = driver.findElement(By.id("userNav-arrow"));
		waitUntilVisible(userMenu, "user menu");
		clickElement(userMenu, "user menu");
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickElement(logout,"logout");
		Thread.sleep(5000);
		WebElement username1 = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		//waitUntilVisible(username1, "username1");
		enterText(username1,"dhanush@kodak.com","username1");
		WebElement password1 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		enterText(password1, "DarshanA13", "password1");
		WebElement loginButton1 = driver.findElement(By.id("Login"));
		clickElement(loginButton1,"login button");
		Thread.sleep(6000);
		WebElement leadTab1=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
		waitUntilVisible(leadTab1, "lead Tab");
		clickElement(leadTab1, "lead Tab");
		WebElement goButton = driver.findElement(By.cssSelector("input[title='Go!']"));
		waitUntilVisible(goButton, "go");
		clickElement(goButton,"go Button");
		
	}
	public static void SFTC23_todaysLeads(String browsername) throws InterruptedException, IOException {

		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement leadTab=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
		waitUntilVisible(leadTab, "lead Tab");
		clickElement(leadTab, "lead Tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement viewDropDown=driver.findElement(By.id("fcf"));
		waitUntilVisible(viewDropDown, "view Drop Down");
		clickElement(viewDropDown, "drop down");
		Select select = new Select(viewDropDown);
		select.selectByVisibleText("Today's Leads");

	}
	public static void SFTC24_newButtonOnLeads(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement leadTab=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[7]/a"));
		waitUntilVisible(leadTab, "lead Tab");
		clickElement(leadTab, "lead Tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement newButton = driver.findElement(By.xpath("//td[@class='pbButton']//input[@type='button']"));
		waitUntilVisible(newButton, "new button");
		clickElement(newButton, "new button");
		WebElement lastName =  driver.findElement(By.id("name_lastlea2"));
		clearElement(lastName, "last name");
		enterText(lastName,"ABCD", "last name");
		WebElement companyName = driver.findElement(By.xpath("//input[@id='lea3']"));
		enterText(companyName,"ABCD", "company name");
		WebElement saveButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickElement(saveButton, "save button");
		}

	public static void SFTC25_createNewContact(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		clickElement(contactTab, "contact tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement newButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[2]/input"));
		waitUntilVisible(newButton, "new button");
		clickElement(newButton, "new button");
		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		waitUntilVisible(lastName, "last name");
		clearElement(lastName, "last name");
		enterText(lastName, "RV","lastName");
		WebElement accountName = driver.findElement(By.xpath("//input[@id='con4']"));
		enterText(accountName,"Tekarch", "account name");
		WebElement saveButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickElement(saveButton, "save button");
		
		
		}

	public static void SFTC26_createNewViewInContact()  {
		setDriver("firefox");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		clickElement(contactTab, "contact tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitUntilVisible(createNewView, "create new view");
		clickElement(createNewView, "create new view");
		WebElement viewName = driver.findElement(By.id("fname"));
		waitUntilVisible(viewName, "view name");
		enterText(viewName, "bestBrain", "viewName");
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		enterText(viewUniqueName, "best", "viewUniqueName");
		WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickElement(saveButton, "save button");
			
	}
	public static void SFTC27_checkRecentlyCreatedContact(String browsername) throws InterruptedException, IOException {

		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		clickElement(contactTab, "contact tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement recentlyCreated = driver.findElement(By.id("hotlist_mode"));
		waitUntilVisible(recentlyCreated, "recently created ");
		Select select = new Select(recentlyCreated);
		select.selectByVisibleText("Recently Created");
		
		}
	public static void SFTC28_myContacts(String browsername) throws InterruptedException, IOException {
		
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		clickElement(contactTab, "contact tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		//waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		WebElement viewMyContacts = driver.findElement(By.id("fcf"));
		waitUntilVisible(viewMyContacts, "view My Contacts ");
		//clickElement(viewMyContacts , "view My Contacts ");
		Select select = new Select(viewMyContacts);
		select.selectByVisibleText("My Contacts");
		
		}


	public static void SFTC29_viewContactsInContactPage(String browsername) throws InterruptedException, IOException {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		loginToSalesForce();
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		clickElement(contactTab, "contact tab");
		WebElement closeFrame = driver.findElement(By.id("tryLexDialogX"));
		waitUntilVisible(closeFrame, "close frame");
		clickElement(closeFrame, "close Frame");
		Thread.sleep(4000);
		WebElement contactName = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[1]/a"));
		waitUntilVisible(contactName, "contact name ");
		clickElement(contactName, "contact name");
		
	}


	public static void SFTC30_checkviewContacts()  {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		validUsername();
		validPassword();
		loginButton();	
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitUntilVisible(contactTab, "contactTab");
		clickElement(contactTab, "contact tab");
		WebElement closeFrame=driver.findElement(By.id("tryLexDialogX"));
		waitUntilVisible(closeFrame, "closeFrame");
		clickElement(closeFrame, "close Frame");
		WebElement contactNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitUntilVisible(contactNewView, "contactNewView");
		clickElement(contactNewView,"contactNewView");
		WebElement viewUnique = driver.findElement(By.id("devname"));
		waitUntilVisible(viewUnique, "viewUnique");
		enterText(viewUnique,"EFGH","viewUnique");
		WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[1]"));
		clickElement(saveButton,"saveButton");
			
	}

	public static void SFTC31_checkviewContacts()  {
		
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		validUsername();
		validPassword();
		loginButton();	
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitUntilVisible(contactTab, "contactTab");
		clickElement(contactTab, "contact tab");
		WebElement closeFrame=driver.findElement(By.id("tryLexDialogX"));
		waitUntilVisible(closeFrame, "closeFrame");
		clickElement(closeFrame, "close Frame");
		WebElement contactNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		waitUntilVisible(contactNewView, "contactNewView");
		clickElement(contactNewView,"contactNewView");
		WebElement viewName = driver.findElement(By.id("fname"));
		waitUntilVisible(viewName, "viewName");
		enterText(viewName,"ABCD","viewName");
		WebElement viewUnique = driver.findElement(By.id("devname"));
		waitUntilVisible(viewUnique, "viewUnique");
		clearElement(viewUnique, "viewUnique");
		enterText(viewUnique,"EFGH","viewUnique");
		WebElement cancel = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[2]/form/div[1]/table/tbody/tr/td[2]/input[2]"));
		clickElement(cancel, "cancel");
		
	}
		public static void SFTC32_checkSaveAndNewInContacts()  {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		validUsername();
		validPassword();
		loginButton();	
		WebElement contactTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitUntilVisible(contactTab, "contactTab");
		clickElement(contactTab, "contact tab");
		WebElement closeFrame=driver.findElement(By.id("tryLexDialogX"));
		waitUntilVisible(closeFrame, "closeFrame");
		clickElement(closeFrame, "close Frame");
		WebElement newButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[2]/input"));
		clickElement(newButton,"newButton");
		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		waitUntilVisible(lastName, "lastName");
		enterText(lastName,"Indian","last name");
		WebElement accountName = driver.findElement(By.id("con4"));
		waitUntilVisible(accountName, "accountName");
		enterText(accountName,"Global Media","account Name");
		WebElement saveAndNew =driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[2]"));
		clickElement(saveAndNew, "saveAndNew");
	}
		public static void SFTC33_verifyFirstAndLastName()  {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		validUsername();
		validPassword();
		loginButton();		
		WebElement homeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));	
		waitUntilVisible(homeTab, "homeTab");
		clickElement(homeTab, "homeTab");	
		WebElement closeFrame=driver.findElement(By.id("tryLexDialogX"));
		waitUntilVisible(closeFrame, "closeFrame");
		clickElement(closeFrame, "close Frame");	
		WebElement firstAndLastNameLink = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[1]/h1/a"));	
		clickElement(firstAndLastNameLink,"firstAndLastNameLink");	
			
			
		}
		public static void SFTC34_verifyEditedLastName() throws InterruptedException  {
		setDriver("chrome");
		gotoUrl("https://login.salesforce.com/");
		waitUntilPageLoads();
		driver.manage().window().maximize();
		validUsername();
		validPassword();
		loginButton();
		WebElement homeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));	
		waitUntilVisible(homeTab, "homeTab");
		clickElement(homeTab, "homeTab");	
		WebElement closeFrame=driver.findElement(By.id("tryLexDialogX"));
		waitUntilVisible(closeFrame, "closeFrame");
		clickElement(closeFrame, "close Frame");	
		WebElement firstAndLastNameLink= driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[1]/h1/a"));	
		clickElement(firstAndLastNameLink,"firstAndLastNameLink");		
		WebElement editProfile = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img"));	
		clickElement(editProfile, "editProfile");
		Thread.sleep(6000);
		driver.switchTo().frame(editProfile);
		WebElement about = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/ul/li[1]/a"));
		clickElement(about, "about");
		WebElement lastName = driver.findElement(By.id("lastName"));
		clearElement(lastName,"last Name");
		enterText(lastName,"Abcd","last name");
		WebElement saveAll =driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div/input[1]"));
		clickElement(saveAll,"saveAll");
	}
		public static void SFTC35_verifyTabCustomization()  {
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			validUsername();
			validPassword();
			loginButton();
			WebElement plusTab =driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]"));
			clickElement(plusTab, "plusTab");
			WebElement customizeMyTabs = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/table/tbody/tr/td[2]/input"));
			clickElement(customizeMyTabs,"customizeMyTabs"); 
			WebElement libraries = driver.findElement(By.xpath("//option[@value='Workspace']"));
			waitUntilVisible(libraries,"libraries");
			Select select= new Select(libraries);
			select.selectByVisibleText("Libraries");
			clickElement(libraries,"libraries");
			WebElement removeButton = driver.findElement(By.xpath("//img[@class='leftArrowIcon']"));
			clickElement(removeButton,"removeButton");
			WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]/form/div/div[3]/table/tbody/tr/td[2]/input[1]"));
			clickElement(saveButton, "saveButton");
			WebElement userMenuDropDown = driver.findElement(By.id("userNav-arrow"));
			waitUntilVisible(userMenuDropDown,"userMenuDropDown");
			clickElement(userMenuDropDown, "userMenuDropDown");
			Select select1 = new Select(userMenuDropDown);
			select1.selectByVisibleText("logout");
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			validUsername();
			validPassword();
			loginButton();
			
			
	}
		
		
		public static void SFTC36_blockingAnEventInCalender() throws InterruptedException  {
			setDriver("chrome");
			gotoUrl("https://login.salesforce.com/");
			waitUntilPageLoads();
			driver.manage().window().maximize();
			validUsername();
			validPassword();
			loginButton();
			WebElement homeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));	
			waitUntilVisible(homeTab, "homeTab");
			clickElement(homeTab, "homeTab");
			Thread.sleep(6000);
			WebElement closeFrame=driver.findElement(By.id("tryLexDialogX"));
			//waitUntilVisible(closeFrame, "closeFrame");
			clickElement(closeFrame, "close Frame");	
			WebElement currentDate = driver.findElement(By.xpath("//a[contains(text(),'Thursday September 29, 2022')]"));
			clickElement(currentDate,"currentDate");
			WebElement EightPmLink=driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
			clickElement(EightPmLink,"EightPmLink");
			WebElement subjectCombo = driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
			waitUntilVisible(subjectCombo,"subjectCombo");
			clickElement(subjectCombo,"subjectCombo");
			Thread.sleep(6000);
			driver.switchTo().frame("ComboBox");
			WebElement other = driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
			clickElement(other,"other");
			WebElement endTime = driver.findElement(By.xpath("//input[@id='EndDateTime']"));
			clickElement(endTime, "endTime");
			WebElement endtimeDropDown=driver.findElement(By.id("EndDateTime_time"));	
			waitUntilVisible(endtimeDropDown,"endtimeDropDown");
			clickElement(endtimeDropDown,"endtimeDropDown");
			Select select = new Select(endtimeDropDown);
			select.selectByIndex(2);
			WebElement saveButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div[1]/div[1]/table/tbody/tr/td[2]/input[1]"));
			clickElement(saveButton,"saveButton");
			
			
		}	
	}


