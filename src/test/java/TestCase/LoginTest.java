package TestCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.BaseTest;
import util.ExcelUtils;
import util.ExtentReportManager;
import util.Log;

public class LoginTest extends BaseTest {
	
	@DataProvider(name = "Login")
	public Object[][] getLoginData() throws IOException
	{
		String filePath = System.getProperty("user.dir")+ "/TestData/Data.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		for(int i=1;i<rowCount;i++)
		{
			data[i-1][0] = ExcelUtils.getCellData(i,0); //username
			data[i-1][1] = ExcelUtils.getCellData(i, 1); //password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	static WebDriver driver;
	
	@Test(dataProvider="Login")
	@Given("User is on login page")
	public void user_is_on_login_page(String username, String password) {
		//Log.info("Starting webdriver");
		test = ExtentReportManager.createTest("Login Test");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
//	    test.info("Navigating to url");
//	    Log.info("Navigating to url");
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	
	@When("User enters username and password")
	public void user_enters_username_and_password() {
		
		//test.info("Adding credentials");
	    //driver.findElement(By.name("username")).sendKeys("Admin");
	    //driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		//driver.findElement(By.name("username")).sendKeys();
	    //driver.findElement(By.xpath("//input[@type='password']")).sendKeys();
	}

	
	@Then("User clicks on login button")
	public void user_clicks_on_login_button() {
		//test.info("Login button click");
	    //driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	@AfterTest
	@And("user navigate to home page")
	public void user_navigate_to_home_page() {
		//test.info("Verifying page title. Login successfully");
	   //Assert.assertTrue(driver.findElement(By.xpath("//div[@class='oxd-brand-banner'][img]")));
	   Assert.assertTrue(driver.findElements(By.xpath("//div[@class='oxd-brand-banner'][img]")).size()>0);
	  // test.info("Login successfully");
	   driver.close();
	}


}
