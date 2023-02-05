package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//ul[@class='nav nav-treeview']//p[contains(text(),'Customers')]");
	By btnAddnew = By.xpath("//a[@class='btn btn-primary']");

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");

	By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdFemaleGender = By.xpath("//input[@id='Gender_Female']");
	
	By opnRegisteredDelete = By.xpath("//span[@title='delete']");
	By txtCustomerRoles = By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
	By lstItemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstItemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstItemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstItemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");

	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");

	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name = 'save']");

	// Action methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCutomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddNew() {
		ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRole(String role) throws InterruptedException {
		ldriver.findElement(opnRegisteredDelete).click();
		ldriver.findElement(txtCustomerRoles).click();
		WebElement listItem;
		Thread.sleep(3000);

		if (role.equals("Administrators")) {
			listItem = ldriver.findElement(lstItemAdministrators);
		} else if (role.equals("Guests")) {
			listItem = ldriver.findElement(lstItemGuests);
		} else if (role.equals("Registered")) {
			listItem = ldriver.findElement(lstItemRegistered);
		} else if (role.equals("Vendors")) {
			listItem = ldriver.findElement(lstItemVendors);
		} else {
			listItem = ldriver.findElement(lstItemGuests);
		}

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listItem);
	}

	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(rdFemaleGender).click();
		}
	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}

	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}
}
