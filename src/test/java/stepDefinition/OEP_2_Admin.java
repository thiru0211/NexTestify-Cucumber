package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OEP_2_Admin {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Admin is navigating to OEP URL is {string}")
	public void to_check_admin_is_navigating_to_oep_url_is(String URL) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless=old");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@When("To Check Admin Enter username and password are {string} and {string}")
	public void to_check_admin_enter_username_and_password_are_and(String UserName, String Password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(UserName);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(Password);
	}

	@When("click the Signin button To Check Admin")
	public void click_the_signin_button_to_check_admin() {
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to login into Admin Portal']"));
		ele1.click();
	}

	@Then("Click admin button")
	public void click_admin_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='label'])[3]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='label'])[3]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='collapse show']//a[1]")));
		ele2 = driver.findElement(By.xpath("//ul[@class='collapse show']//a[1]"));
		ele2.click();
		driver.navigate().refresh();
	}

	@Given("Enter valid username {string} in the searchbox")
	public void enter_valid_username_in_the_searchbox(String Username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		ele1.sendKeys(Username);
	}

	@When("Enter valid email id {string} in the searchbox")
	public void enter_valid_email_id_in_the_searchbox(String EmailID) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		String clearedText = ele1.getAttribute("value");
		if (clearedText.isEmpty()) {
			ele1.sendKeys(EmailID);
		} else {
			System.out.println("Text is not cleared");
		}
	}

	@Then("Enter valid phone number {string} in the searchbox")
	public void enter_valid_phone_number_in_the_searchbox(String PhoneNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		String clearedText = ele1.getAttribute("value");
		if (clearedText.isEmpty()) {
			ele1.sendKeys(PhoneNumber);
		} else {
			System.out.println("Text is not cleared");
		}
	}

	@Then("Close Admin button")
	public void close_admin_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("\u001B[1mPage is closed\u001B[0m");
	}

	@Given("Select {string} 1st Option in status dropdown")
	public void select_1st_option_in_status_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All']"));
		ele2.click();
	}
	@When("Select {string} 2nd Option in status dropdown")
	public void select_2nd_option_in_status_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Active']"));
		ele2.click();
	}
	@Then("Select {string} 3rd Option in status dropdown")
	public void select_3rd_option_in_status_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Inactive']"));
		ele2.click();
	}

	@Given("Select {string} 1st Option in user type dropdown")
	public void select_1st_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All']"));
		ele2.click();
	}
	@When("Select {string} 2nd Option in user type dropdown")
	public void select_2nd_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Super Admin']"));
		ele2.click();
	}
	@Then("Select {string} 3rd Option in user type dropdown")
	public void select_3rd_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Proctor']"));
		ele2.click();
	}
	@Then("Select {string} 4th Option in user type dropdown")
	public void select_4th_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Question Manager']"));
		ele2.click();
	}
	
	@Given("Click next page button in below of the grid")
	public void click_next_page_button_in_below_of_the_grid() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//main//li[5]//a[1]//span[1]//*[name()='svg']")));
		ele1 = driver.findElement(By.xpath("//main//li[5]//a[1]//span[1]//*[name()='svg']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		ele1.click();
	}

	@When("Click previous page button in below of the grid")
	public void click_previous_page_button_in_below_of_the_grid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='shadow page-item']//a)[2]")));
		ele1 = driver.findElement(By.xpath("(//li[@class='shadow page-item']//a)[2]"));
		ele1.click();
	}

	@Given("Click Add User button in create admin page")
	public void click_add_user_button_in_create_admin_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to add user']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to add user']"));
		ele1.click();
	}

	@Given("Click back button in create admin page")
	public void click_back_button_in_create_admin_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to back']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to back']"));
		ele1.click();
	}

	@Given("Click save button in create admin page")
	public void click_save_button_in_create_admin_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to save']"));
		ele1.click();
	}

	@Given("Enter numerical characters {string} in first name tab")
	public void enter_numerical_characters_in_first_name_tab(String firstname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(firstname);
	}

	@Then("Check tab is empty or not in first name tab")
	public void check_tab_is_empty_or_not_in_first_name_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		String fname = ele1.getAttribute("value");
		if (fname.isEmpty()) {
			System.out.println("Text box is empty & User cannot able to enter the characters");
		} else {
			String fname1 = ele1.getAttribute("value");
			System.out.println("Text box contains : " + fname1);
		}
	}

	@Then("Enter special characters {string} in first name tab")
	public void enter_special_characters_in_first_name_tab(String firstname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(firstname);
	}

	@Given("Enter alphabetical characters {string} in first name tab")
	public void enter_alphabetical_characters_in_first_name_tab(String firstname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(firstname);
	}

	@Given("Enter numerical characters {string} in last name tab")
	public void enter_numerical_characters_in_last_name_tab(String lastname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(lastname);
	}

	@Then("Check tab is empty or not in last name tab")
	public void check_tab_is_empty_or_not_in_last_name_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		String Lname = ele1.getAttribute("value");
		if (Lname.isEmpty()) {
			System.out.println("Text box is empty & User cannot able to enter the characters");
		} else {
			String Lname1 = ele1.getAttribute("value");
			System.out.println("Text box contains : " + Lname1);
		}
	}

	@Then("Enter special characters {string} in last name tab")
	public void enter_special_characters_in_last_name_tab(String lastname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		ele1.sendKeys(lastname);
	}

	@Given("Enter alphabetical characters {string} in last name tab")
	public void enter_alphabetical_characters_in_last_name_tab(String lastname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		ele1.sendKeys(lastname);
	}

	@Given("Enter valid email id {string} in email tab")
	public void enter_valid_email_id_in_email_tab(String EmailID) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		ele1 = driver.findElement(By.id("Email"));
		ele1.sendKeys(EmailID);
	}

	@Then("Check tab is empty or not in email tab")
	public void check_tab_is_empty_or_not_in_email_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		ele1 = driver.findElement(By.id("Email"));
		String Email = ele1.getAttribute("value");
		if (Email.isEmpty()) {
			System.out.println("Text box is empty & User cannot able to enter the characters");
		} else {
			String Email1 = ele1.getAttribute("value");
			System.out.println("Text box contains : " + Email1);
		}
	}

	@Then("Check alert message is displayed or not in email tab")
	public void check_alert_message_is_displayed_or_not_in_email_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='d-block invalid-tooltip']")));
		ele1 = driver.findElement(By.xpath("//div[@class='d-block invalid-tooltip']"));
		String text = ele1.getText();
		System.out.println("Error message is displayed like: " + text);
	}

	@Given("Enter valid user type {string} in the dropdown")
	public void enter_valid_user_type_in_the_dropdown(String UType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();

		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Super Admin']"));
		ele2.click();
	}

	@Given("Select valid user type {string} in the dropdown")
	public void select_valid_user_type_in_the_dropdown(String UType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();

		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Super Admin']"));
		ele2.click();
	}

	@Given("Enter alphabetical characters {string} in phone number tab")
	public void enter_alphabetical_characters_in_phone_number_tab(String Phone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(Phone);
	}

	@Then("Check tab is empty or not in phone number tab")
	public void check_tab_is_empty_or_not_in_phone_number_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		String Phone = ele1.getAttribute("value");
		if (Phone.isEmpty()) {
			System.out.println("Text box is empty & User cannot able to enter the characters");
		} else {
			String Phone1 = ele1.getAttribute("value");
			System.out.println("Text box contains : " + Phone1);
		}
	}

	@Given("Enter special characters {string} in phone number tab")
	public void enter_special_characters_in_phone_number_tab(String Phone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(Phone);
	}

	@Given("Enter numerical {string} characters in phone number tab")
	public void enter_numerical_characters_in_phone_number_tab(String Phone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(Phone);
	}

	@Then("Select valid country code {string}")
	public void select_valid_country_code(String Phone) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='+91']"));
		ele2.click();
	}

	@Then("Enter valid phone number {string}")
	public void enter_valid_phone_number(String Phone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(Phone);
	}

	@Then("Click the toggle button")
	public void click_the_toggle_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ant-switch-inner']")));
		ele1 = driver.findElement(By.xpath("//span[@class='ant-switch-inner']"));
		ele1.click();
	}

	@Given("Enter valid {string} in address1 tab")
	public void enter_valid_in_address1_tab(String address) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address1")));
		ele1 = driver.findElement(By.name("Address1"));
		ele1.sendKeys(address);
	}

	@Given("Enter valid {string} in address2 tab")
	public void enter_valid_in_address2_tab(String address) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address2")));
		ele1 = driver.findElement(By.name("Address2"));
		ele1.sendKeys(address);
	}

	@Given("Enter numerical characters {string} in city tab")
	public void enter_numerical_characters_in_city_tab(String city) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(city);
	}

	@Then("Check tab is empty or not in city tab")
	public void check_tab_is_empty_or_not_in_city_tab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele = driver.findElement(By.name("ZipCode"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
        Thread.sleep(2000);
		ele1 = driver.findElement(By.name("City"));
		String city=ele1.getAttribute("value");
		if (city.isEmpty()) {
			System.out.println("Text box is empty & User cannot able to enter the characters");
		} else {
			String city1 = ele1.getAttribute("value");
			System.out.println("Text box contains : " + city1);
		}
	}

	@Given("Enter special characters {string} in city tab")
	public void enter_special_characters_in_city_tab(String city) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(city);
	}

	@Given("Enter alphabetical characters {string} in city tab")
	public void enter_alphabetical_characters_in_city_tab(String city) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(city);
	}

	@Given("Enter country name {string} in country tab")
	public void enter_country_name_in_country_tab(String CName) throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.sendKeys(CName);
	}

	@Given("Select country name {string} in country tab")
	public void select_country_name_in_country_tab(String CName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		Select sel = new Select(ele1);
		sel.selectByValue(CName);
	}

	@Given("Enter state name {string} in state tab")
	public void enter_state_name_in_state_tab(String State) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#react-select-7-option-1")));
		ele1 = driver.findElement(By.cssSelector("div#react-select-7-option-1"));
		ele1.sendKeys(State);
	}

	@Given("Select state name {string} in state tab")
	public void select_state_name_in_state_tab(String State) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#react-select-7-option-1")));
		ele1 = driver.findElement(By.cssSelector("div#react-select-7-option-1"));
		Select sel = new Select(ele1);
		sel.selectByValue(State);
	}

	@Given("Enter Time Zone name {string} in Time Zone tab")
	public void enter_time_zone_name_in_time_zone_tab(String TZone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[normalize-space(text())='America/New_York']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='America/New_York']"));
		ele1.sendKeys(TZone);
	}

	@Given("Select valid {string} in timezone tab")
	public void select_valid_in_timezone_tab(String TZone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[normalize-space(text())='America/New_York']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='America/New_York']"));
		Select sel = new Select(ele1);
		sel.selectByValue(TZone);
	}

	@Given("Enter alphabetical characters {string} in Zip Code tab")
	public void enter_alphabetical_characters_in_zip_code_tab(String ZipCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ZipCode")));
		ele1 = driver.findElement(By.id("ZipCode"));
		ele1.sendKeys(ZipCode);
	}

	@Then("Check tab is empty or not in Zip Code tab")
	public void check_tab_is_empty_or_not_in_zip_code_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ZipCode")));
		ele1 = driver.findElement(By.id("ZipCode"));
		String ZipCode = ele1.getAttribute("value");
		if (ZipCode.isEmpty()) {
			System.out.println("Text box is empty & User cannot able to enter the characters");
		} else {
			String ZipCode1 = ele1.getAttribute("value");
			System.out.println("Text box contains : " + ZipCode1);
		}
	}

	@Given("Enter special characters {string} in Zip Code tab")
	public void enter_special_characters_in_zip_code_tab(String ZipCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ZipCode")));
		ele1 = driver.findElement(By.id("ZipCode"));
		ele1.sendKeys(ZipCode);
	}

	@Given("Enter valid characters {string} in Zip Code tab")
	public void enter_valid_characters_in_zip_code_tab(String ZipCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ZipCode")));
		ele1 = driver.findElement(By.id("ZipCode"));
		ele1.sendKeys(ZipCode);
	}

	@Given("Upload invalid file in profile upload tab")
	public void upload_invalid_file_in_profile_upload_tab() throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='imageUpload']//button[1]")));
		ele1 = driver.findElement(By.xpath("//div[@id='imageUpload']//button[1]"));
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Blank.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Given("Upload valid file in profile upload tab")
	public void upload_valid_file_in_profile_upload_tab() throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='imageUpload']//button[1]")));
		ele1 = driver.findElement(By.xpath("//div[@id='imageUpload']//button[1]"));
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Click No radio button in 2FA Details tab")
	public void click_no_radio_button_in_2fa_details_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='twoauthstatus'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='twoauthstatus'])[2]"));
		ele1.click();
	}

	@Then("Click Yes radio button in 2FA Details tab")
	public void click_yes_radio_button_in_2fa_details_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='twoauthstatus'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='twoauthstatus'])[1]"));
		ele1.click();
	}

	@Then("Click Email radio button in 2FA Details tab")
	public void click_email_radio_button_in_2fa_details_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='tfaVia'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='tfaVia'])[1]"));
		ele1.click();
	}

	@Then("Click SMS radio button in 2FA Details tab")
	public void click_sms_radio_button_in_2fa_details_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='tfaVia'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='tfaVia'])[2]"));
		ele1.click();
	}

	@When("Enter valid first name in create admin page")
	public void enter_valid_first_name_in_create_admin_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		Faker fakename = new Faker();
		String firstName = fakename.name().firstName();
		ele1.sendKeys(firstName);
	}

	@Then("Enter valid last name in create admin page")
	public void enter_valid_last_name_in_create_admin_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		Faker fakename = new Faker();
		String lastName = fakename.name().lastName();
		ele1.sendKeys(lastName);
	}

	@Then("Enter valid email id in create admin page")
	public void enter_valid_email_id_in_create_admin_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		ele1 = driver.findElement(By.id("Email"));
		Faker fakename = new Faker();
		String firstName = fakename.name().firstName();
		String Email = firstName.toLowerCase() + "@guerrillamail.info";
		ele1.sendKeys(Email);
	}

	@Then("Select valid user type {string} in create admin page")
	public void select_valid_user_type_in_create_admin_page(String UType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__control css-yk16xz-control']//div)[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__control css-yk16xz-control']//div)[1]"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(UType);
	}

	@Then("Select valid country code {string} in create admin page")
	public void select_valid_country_code_in_create_admin_page(String CCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(CCode);
	}

	@Then("Enter valid phone number {string} in create admin page")
	public void Enter_valid_phone_number_in_create_admin_page(String PNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(PNumber);
	}

	@Then("Enter valid address1 details {string}")
	public void enter_valid_address1_details(String address1) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address1")));
		ele1 = driver.findElement(By.name("Address1"));
		ele1.sendKeys(address1);
	}

	@Then("Enter valid address2 details {string}")
	public void enter_valid_address2_details(String address2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address2")));
		ele1 = driver.findElement(By.name("Address2"));
		ele1.sendKeys(address2);
	}

	@Then("Enter valid city details {string}")
	public void enter_valid_city_details(String City) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(City);
	}

	@Then("Select valid country {string} in the dropdown")
	public void select_valid_country_in_the_dropdown(String Country) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(Country);
	}

	@Then("Select valid state {string} in the dropdown")
	public void select_valid_state_in_the_dropdown(String State) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space(text())='California']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='California']"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(State);
	}

	@Then("Select valid timezone {string} in the dropdown")
	public void select_valid_timezone_in_the_dropdown(String timezone) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[normalize-space(text())='America/New_York']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='America/New_York']"));
		Select sel = new Select(ele1);
		sel.selectByVisibleText(timezone);
	}

	@Then("Enter valid zipcode {string}")
	public void enter_valid_zipcode(String Zipcode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele1 = driver.findElement(By.name("ZipCode"));
		ele1.sendKeys(Zipcode);
	}

	@Then("Upload valid file in the profile upload page")
	public void upload_valid_file_in_the_profile_upload_page() throws InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='imageUpload']//button[1]")));
		ele1 = driver.findElement(By.xpath("//div[@id='imageUpload']//button[1]"));
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String FilePath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Select No option in the 2FA tab")
	public void select_no_option_in_the_2fa_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='twoauthstatus'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='twoauthstatus'])[2]"));
		ele1.click();
	}

	@Then("Check error message is displayed or not")
	public void check_error_message_is_displayed_or_not() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String text = ele1.getText();
		System.out.println("Error message displayed like: " + text);
	}

	@Then("Check success message is displayed or not")
	public void check_success_message_is_displayed_or_not() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String text = ele1.getText();
		System.out.println("Success message displayed like: " + text);
	}

	@Given("Enter user name {string} in the Search box")
	public void enter_user_name_in_the_search_box(String userName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(userName);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}

	@When("Click Edit button")
	public void click_edit_button() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]"));
		ele1.click();
	}

	@Then("Modify valid details in edit admin page")
	public void modify_valid_details_in_edit_admin_page() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		String cityName = ele1.getAttribute("value");
		for (int i = 0; i < cityName.length(); i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(4000);
			ele1.sendKeys(cityName);
		}
	}

	@Then("Click update button in edit admin page")
	public void click_update_button_in_edit_admin_page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Update']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
		ele1.click();
	}

	@Then("Change the status to inactive mode")
	public void change_the_status_to_inactive_mode() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]"));
		String text = ele1.getText();
		System.out.println("Text contains: " + text);
		Thread.sleep(2000);
		if (text.contains("Yes")) {
			ele1.click();
		} else {
			System.out.println("Status already in Inactive state");
		}
	}

	@Then("Change the status to active mode")
	public void change_the_status_to_active_mode() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]"));
		String text = ele1.getText();
		System.out.println("Text contains: " + text);
		Thread.sleep(2000);
		if (text.contains("No")) {
			ele1.click();
		} else {
			System.out.println("Status already in Active state");
		}
	}

	@Then("Check the status in the grid of the same username")
	public void check_the_status_in_the_grid_of_the_same_username() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Inactive']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space(text())='Inactive']"));
		String text = ele1.getText();
		System.out.println("Status is displayed as: " + text);
	}

	@Then("Click change email button")
	public void click_change_email_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//b[normalize-space(text())='Change Email']")));
		ele1 = driver.findElement(By.xpath("//b[normalize-space(text())='Change Email']"));
		ele1.click();
	}

	@Then("Click close button of the pop up")
	public void click_close_button_of_the_pop_up() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Enter existing {string} email id")
	public void enter_existing_email_id(String emailId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("newemail")));
		ele1 = driver.findElement(By.id("newemail"));
		ele1.sendKeys(emailId);
	}

	@Then("Click verify email button")
	public void click_verify_email_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-outline-primary')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-outline-primary')]"));
		ele1.click();
	}

	@Then("Enter valid email id")
	public void enter_valid_email_id() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("newemail")));
		ele1 = driver.findElement(By.id("newemail"));
		Faker fakename = new Faker();
		String firstName = fakename.name().firstName();
		String Email = firstName.toLowerCase() + "@guerrillamail.info";
		ele1.sendKeys(Email);
	}

	@Then("Enter valid email id login page {string}")
	public void enter_valid_email_id_login_page(String emailId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(emailId);
	}

	@Then("Enter invalid password {string}")
	public void enter_invalid_password(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		ele1 = driver.findElement(By.name("password"));
		ele1.sendKeys(password);
	}

	@Then("Click login button 5times")
	public void click_login_button_5times() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='text-center mt-1']//button[1]")));
		ele1 = driver.findElement(By.xpath("//div[@class='text-center mt-1']//button[1]"));
		for (int i = 0; i < 5; i++) {
			ele1.click();
			try {
				Thread.sleep(1000); // Wait for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
			ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
			String text = ele1.getText();
			System.out.println("Error message displayed like: " + text);
		}
	}

	@Then("Check lock message is displayed or not")
	public void check_lock_message_is_displayed_or_not() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String text = ele1.getText();
		System.out.println("Error message displayed like: " + text);
	}

	@Then("Click unlock button")
	public void click_unlock_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		ele1.click();
	}

	@Then("Click no button in the pop up")
	public void click_no_button_in_the_pop_up() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='No']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='No']"));
		ele1.click();
	}

	@Then("Click yes button in the pop up")
	public void click_yes_button_in_the_pop_up() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Check unlock button is displayed or not")
	public void check_unlock_button_is_displayed_or_not() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		if (ele1.isDisplayed()) {
			System.out.println("Unlock button is displayed");
		} else {
			System.out.println("Unlock button is not displayed");
		}
	}

}