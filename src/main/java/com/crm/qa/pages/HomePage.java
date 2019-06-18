package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen AutomationLabs')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement TasksLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		TasksLink.click();
		return new TasksPage();
		
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}