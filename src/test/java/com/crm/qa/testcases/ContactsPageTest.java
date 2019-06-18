package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUP() throws InterruptedException {
		initialazation();//login into the app
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homepage = 	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchtoFrame();
		contactsPage = homepage.clickOnContactsLink();
		
}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() throws InterruptedException {
		Thread.sleep(4000);
	Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact Label is missing on the Page");
	}
	
	
	@Test(priority=2)
	public void selectContactsTest() throws InterruptedException {
		Thread.sleep(3000);
		contactsPage.selectContactsByName("abc test");
		contactsPage.selectContactsByName("ABC XYZ");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() throws InterruptedException {
		Thread.sleep(3000);
		contactsPage.selectContactsByName("abc test");
		contactsPage.selectContactsByName("ABC XYZ");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
	Object data[][] =	TestUtil.getTestData(sheetName);
	return data;
		
	}
	
@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName,String lastName,String company) throws InterruptedException {
		homepage.clickOnNewContactLink();
		Thread.sleep(5000);
		//contactsPage.createNewContact("Mr.", "Tom", "Perter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}