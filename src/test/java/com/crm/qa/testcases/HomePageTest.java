package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() throws InterruptedException {
		initialazation();//login into the app
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homepage = 	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String homePageTitle = 	homepage.verifyHomePageTitle();
		Thread.sleep(4000);
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePage Title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchtoFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchtoFrame();
        contactsPage=homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
