package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	
	public static String randomString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
}
