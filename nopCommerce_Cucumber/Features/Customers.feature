Feature: Customers

Scenario: Add a customer
	 Given User launch chrome browser
	 When User opens URL "https://admin-demo.nopcommerce.com/login"
	 And User enters Email as "admin@yourstore.com" and Password as "admin"
	 And Click on Login
	 Then User cn view the dashboard
	 When user clicks on Customers menu
	 And click on Customers menu item
	 And click on Add new button
	 Then user can view Add new customer page
	 When user enters customer info
	 And click on save button
	 Then user can view confirmation message "The new customer has been added successfully."
	 And Close browser