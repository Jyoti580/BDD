package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;
//import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass {

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User clicks on Log out link")
	public void user_clicks_on_log_out_link() {
		lp.clickLogout();
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
	}

	// Customers.feature step definitions...........................
	@Then("User cn view the dashboard")
	public void user_cn_view_the_dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user clicks on Customers menu")
	public void user_clicks_on_Customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}

	@When("click on Customers menu item")
	public void click_on_Customers_menu_item() {
		addCust.clickOnCutomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() {
		addCust.clickOnAddNew();
	}

	@Then("user can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		String email = randomString() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("Test123");
		addCust.setCustomerRole("Guest");
		Thread.sleep(3000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Raj");
		addCust.setLastName("Kiran");
		addCust.setDob("07/05/1995");
		addCust.setCompanyName("QA Tech");
		addCust.setAdminContent("This is for testing purpose.......");
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}

}
