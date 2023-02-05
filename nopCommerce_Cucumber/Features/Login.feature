Feature: Login

Scenario: Successful login with Valid Credentials

	Given User launch chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User clicks on Log out link
	Then Page Title should be "Your store. Login"
	And Close browser
	 
	 
Scenario Outline: Login Data driven
	 Given User launch chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login" 
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User clicks on Log out link
	Then Page Title should be "Your store. Login"
	And Close browser
	
	Examples: 
	|email|password|
	|admin@yourstore.com|admin|
	|admin1@yourstore.com|admin123|