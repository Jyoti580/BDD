package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;
//import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	LoginPage lp;
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
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
	    if(driver.getPageSource().contains("Login was unsuccessful")){
	    	driver.close();
	    	Assert.assertTrue(false);
	    }else {
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

}
