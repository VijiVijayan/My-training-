package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(className="title")
	private WebElement productTitle;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		public String getHeading()
		{
			 return productTitle.getText();
		}
		public String getTitle()
		{
			return driver.getTitle();
		}
	
		

}
