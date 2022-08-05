package com.obsqura.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.obsqura.constant.Constants;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utility.ExcelUtility;

public class TestClass extends TestBase{
	LoginPage obj;
	HomePage obj1;
	
	@Test(priority=5)
	public void verifyLogin() throws IOException
		{
			obj=new LoginPage(driver);
			driver.navigate().refresh();
			String username = ExcelUtility.getCellData(0, 0);
		    String password = ExcelUtility.getCellData(0, 1);
			obj.setUserName(username);
			obj.setPassword(password);
			obj.clickLogin1();
			obj1=new HomePage(driver);
			String expectedTitle =Constants.HOMEPAGETITLE;
			//String expectedTitle="Swag Labs";
			//String actualTitle=driver.getTitle();---instead of 35
			String actualTitle=obj1.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			String expectedHeading =Constants.HOMEPAGEHEADING;
			//String expectedHeading="PRODUCTS";
			String actualHeading=obj1.getHeading();
			Assert.assertEquals(actualHeading,expectedHeading);
		}
	@Test(priority=4)
	public void invalidLogin1() throws IOException
	{
		obj=new LoginPage(driver);
		driver.navigate().refresh();
		String username = ExcelUtility.getCellData(1, 0);
	    String password = ExcelUtility.getCellData(1, 1);
		obj.setUserName(username);
		obj.setPassword(password);
		obj.clickLogin1();
		String expectedErrorMsg=Constants.ERRORMSG1;
		String actualErrorMsg=obj.errorMessage();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
		@Test(priority=1)
		public void invalidLogin2() throws IOException
		{
			obj=new LoginPage(driver);
			driver.navigate().refresh();
			String username = ExcelUtility.getCellData(2, 0);
			obj.setUserName(username);
			obj.clickLogin1();
			obj.clearPassword();
			String expectedErrorMsg=Constants.ERRORMSG2;
			String actualErrorMsg=obj.errorMessage();
			Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
		
	}
	@Test(dataProvider="dataProvider1")
	//@Test(priority=2)
	public void invalidLogin4(String strPassword) throws IOException
	{
		obj=new LoginPage(driver);
		driver.navigate().refresh();
	   // String password = ExcelUtility.getCellData(3, 1);
		//obj.setPassword(password);
		obj.dataPassword(strPassword);
		obj.clickLogin1();
		obj.clearUserName();
		String expectedErrorMsg1=Constants.ERRORMSG3;
		String actualErrorMsg1=obj.errorMessage();
		Assert.assertEquals(expectedErrorMsg1, actualErrorMsg1);
		
	}
	@Test(priority=3)
	public void invalidLogin5() throws IOException
	{
		obj=new LoginPage(driver);
		driver.navigate().refresh();
		obj.clickLogin1();
		obj.clearPassword();
		obj.clearUserName();
		String expectedErrorMsg2=Constants.ERRORMSG4;
		String actualErrorMsg2=obj.errorMessage();
		Assert.assertEquals(expectedErrorMsg2, actualErrorMsg2);
		
	}

	
}
