package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OEP_1_LoginPage {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Login is navigating to OEP URL is {string}")
	public void to_check_login_is_navigating_to_oep_url_is(String URL) {
	    System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless=old");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@When("To Check Login Enter username and password are {string} and {string}")
	public void to_check_login_enter_username_and_password_are_and(String UserName, String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(UserName);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(Password);
	}
	@When("click the Signin button To Check Login")
	public void click_the_signin_button_to_check_login() {
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to login into Admin Portal']"));
		ele1.click();
	}
	@Then("close the Login Page")
	public void close_the_admin_page() {
		driver.quit();
		System.out.print("\u001B[1mPage is closed\u001B[0m");
	}
	
	@Then("Click User logo button in Top right corner")
	public void click_user_logo_button_in_top_right_corner() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='profile mb-2']")));
		ele1 = driver.findElement(By.xpath("//img[@class='profile mb-2']"));
		Actions action=new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
	}
	@Then("Click SignOut button")
	public void click_sign_out_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Logout']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));
		ele1.click();
	}
	@Then("Check login page is displayed or not using assert")
	public void check_login_page_is_displayed_or_not_using_assert() {
		String CurrentUrl = driver.getCurrentUrl();
		String ExpectedUrl="http://192.168.1.30/OEPADMIN/";
		Assert.assertEquals("Page doesnot landed to Login page", CurrentUrl, ExpectedUrl);
	}
	@Then("Check alert message is displayed or not")
	public void check_alert_message_is_displayed_or_not() {
//		Alert alert = driver.switchTo().alert();
//        String alertText = alert.getText();
//        alert.accept();
//        System.out.println(alertText);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String text = ele1.getText();
		System.out.println("Alert message dispalyed like : "+ text);
	}
	@When("To Check Login Enter Invalid username and valid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_valid_password_are_and(String UserName, String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(UserName);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(Password);
	}
	@When("To Check Login Enter valid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_valid_username_and_invalid_password_are_and(String UserName, String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(UserName);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(Password);
	}
	@When("To Check Login Enter Invalid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_invalid_password_are_and(String UserName, String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(UserName);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(Password);
	}
	@When("To Check Login Enter username only {string}")
	public void to_check_login_enter_username_only(String UserName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(UserName);
	}
	@When("To Check Login Enter password only {string}")
	public void to_check_login_enter_password_only(String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(Password);
	}
	@When("Without enter email id click Forget password button")
	public void without_enter_email_id_click_forget_password_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='active']")));
		ele1 = driver.findElement(By.xpath("//a[@class='active']"));
		ele1.click();	
	}
	@When("To Check Login Enter email id {string}")
	public void to_check_login_enter_email_id(String UserName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(UserName);
	}
	@When("click Forget password button")
	public void click_forget_password_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='active']")));
		ele1 = driver.findElement(By.xpath("//a[@class='active']"));
		ele1.click();	
	}
	@Then("Click Ok button Check landing page")
	public void click_ok_button_check_landing_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to login']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to login']"));
		ele1.click();	
	}
	@When("Click ENTER button")
	public void click_enter_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("password"));
		ele1.sendKeys(Keys.ENTER);
		
	}
	@Then("Check the landing page using assert function")
	public void check_the_landing_page_using_assert_function() {
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl="https://hedgeonline.in/OEPADMIN/TwolevelAuth";
		Assert.assertEquals("Page doesnot landed to Login page", currentUrl, expectedUrl);
	}
	@When("To Check Login Enter inactive username and valid password are {string} and {string}")
	public void to_check_login_enter_inactive_username_and_valid_password_are_and(String UserName, String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(UserName);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(Password);
	}
}