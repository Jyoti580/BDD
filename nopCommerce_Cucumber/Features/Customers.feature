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
	 
Scenario: Search Customer by EmailID
	 Given User launch chrome browser
	 When User opens URL "https://admin-demo.nopcommerce.com/login"
	 And User enters Email as "admin@yourstore.com" and Password as "admin"
	 And Click on Login
	 Then User cn view the dashboard
	 When user clicks on Customers menu
	 And click on Customers menu item 
	 And Enter customer email
	 When click on search button
	 Then user should find email in search table
	 And Close browser
	 
Scenario: Search Customer by Name
	 Given User launch chrome browser
	 When User opens URL "https://admin-demo.nopcommerce.com/login"
	 And User enters Email as "admin@yourstore.com" and Password as "admin"
	 And Click on Login
	 Then User cn view the dashboard
	 When user clicks on Customers menu
	 And click on Customers menu item 
	 And Enter customer FirstName
	 And Enter customer LastName
	 When click on search button
	 Then user should find Name in search table
	 And Close browser