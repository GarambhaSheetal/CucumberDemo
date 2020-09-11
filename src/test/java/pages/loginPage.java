package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;

	@FindBy(id="input-1")
	WebElement txt_username;
	
	@FindBy(id="input-2")
	WebElement txt_password;
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement btn_login;
	
	
	public loginPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enter_Username(String username)
	{
		txt_username.sendKeys(username);
	}
	public void enter_Password(String password)
	{
		txt_password.sendKeys(password);
	}

	public void click_LoginButton()
	{
		btn_login.click();
	}


}
