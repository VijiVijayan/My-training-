package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id="user-name")
    private WebElement username;
	@FindBy(id="password")
    private WebElement passWrd;
	@FindBy(id="login-button")
    private WebElement clicklogin;
	@FindBy(tagName="h3")
    private WebElement errorMsg;
	public LoginPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	/*Set user name in textbox*/
    public void setUserName(String strUserName){
 
    	username.sendKeys(strUserName);
    }
    //Set password in password textbox
   @DataProvider(name ="dataProvider1")
    public static Object[][] dataPrividerMethod(){
   return new Object[][] {{"secret_sauce"}};
    	
    }
    public void dataPassword(String strUsername)
    {
    	passWrd.sendKeys(strUsername);
    }
    
    
    public void setPassword(String strPassword){
     passWrd.sendKeys(strPassword);
     }
    //Click on login button
    public void clickLogin1(){
            clicklogin.click();
     }
    public String errorMessage()
    {
    	return errorMsg.getText();
    }
    public void clearUserName() {
    	username.clear();
    }
    public void clearPassword()
    {
    	passWrd.clear();
    }
  
    
    

}
