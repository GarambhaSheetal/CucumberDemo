package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.loginPage;

public class LoginSteps {

	String path = System.getProperty("user.dir");
	WebDriver driver;
	loginPage lp;
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", path + "/Drivers/ChromeDriver/chromedriver 2");
		driver = new ChromeDriver();
		System.out.println("Inside step - browser is open ");
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside step - user is on login page ");
		driver.get("https://www.hackerrank.com/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		System.out.println("Inside step - user enters username and password");
		lp = new loginPage(driver);
		lp.enter_Username(username);
		lp.enter_Password(password);
//		driver.findElement(By.id("input-1")).sendKeys(username);
//		driver.findElement(By.id("input-2")).sendKeys(password);

	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Inside step - clicks on login button");
		lp.click_LoginButton();
//		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
	}

	@Then("user is navigted to the home page")
	public void user_is_navigted_to_the_home_page() {
		try {
			System.out.println("Inside step - user is navigted to the home page");
			String expectedTite = "HackerRank";
			System.out.println(expectedTite+"=Expected "+driver.getTitle()+" Actual");
			Assert.assertEquals(expectedTite,driver.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		driver.quit();
		}
	}

}
