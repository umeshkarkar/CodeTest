Feature: Login into Application

Scenario Outline: Verify Registration is successfully done on the website
	Given User is on landing page and click on Sign in
	When User create an account with "<emailAddress>" address
	And Navigate to Register page and enter all details to register site
	Then Validate correct name and surname is displayed on landing lage

Examples:
|  emailAddress         |
|sdfffsdf2@gmail.com    |
#|adsfsdfsdf392@gmail.com|