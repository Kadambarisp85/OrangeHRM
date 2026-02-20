package TestCase;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	static WebDriver driver;

	@BeforeTest
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority=1)
	@When("User enters username and password")
	public void user_enters_username_and_password() {
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
	}

	@Test(priority=2)
	@Then("User clicks on login button")
	public void user_clicks_on_login_button() {
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	@And("user navigate to home page")
	public void user_navigate_to_home_page() {
	   //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='oxd-brand-banner'][img]")));
	   Assert.assertTrue(driver.findElements(By.xpath("//div[@class='oxd-brand-banner'][img]")).size()>0);
	}


}
