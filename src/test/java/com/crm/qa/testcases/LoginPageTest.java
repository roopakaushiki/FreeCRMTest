package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	//it calls parent class constructor to initialize
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialazation();
		 loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
	String title  =	loginpage.validateLoginPageTitle();
	String str = "CRMPRO - CRM software for customer relationship management, sales, and support.";
	Assert.assertEquals(title, str);
		
	}

	@Test(priority=2)
	public void crmLogoImageTest() {
	boolean flag  =	loginpage.validateCRMImage();
	Assert.assertTrue(flag);
	}
	

	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homepage =	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
