package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	WaitHelper waitHelper;

	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper = new WaitHelper(ldriver);
	}

	@FindBy(id = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(id = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(id = "SearchMonthOfBirth")
	@CacheLookup
	WebElement drpDobMonth;

	@FindBy(id = "SearchDayOfBirth")
	@CacheLookup
	WebElement drpDobDay;

	@FindBy(id = "SearchCompany")
	@CacheLookup
	WebElement txtCompany;

	@FindBy(xpath = "//span[@title='delete']")
	@CacheLookup
	WebElement opnDeleteRegistered;

	@FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstItemAdministrators;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstItemGuests;

	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstItemRegistered;

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstItemVendors;

	@FindBy(id = "search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']//table")
	@CacheLookup
	WebElement tblSearchResults;

	@FindBy(id = "customers-grid")
	@CacheLookup
	WebElement table;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody//td")
	@CacheLookup
	List<WebElement> tableColumns;

	// Action methods
	public void setEmail(String email) {
		waitHelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String fname) {
		waitHelper.WaitForElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		waitHelper.WaitForElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void clickSearch() {
		btnSearch.click();
		waitHelper.WaitForElement(btnSearch, 30);
	}

	public int getNoOfRows() {
		return (tableRows.size());
	}

	public int getNoOfColumns() {
		return (tableColumns.size());
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				flag = true;
			}
		}
		return flag;
	}
}
