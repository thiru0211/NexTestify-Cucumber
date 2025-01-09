Feature: Login Page

  @TC_01
  Scenario: Login:Valid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then close the Login Page

  @TC_02
  Scenario: Login:Sign Out Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@sankarasoftware.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Click User logo button in Top right corner
    And Click SignOut button
    Then Check login page is displayed or not using assert
    Then close the Login Page

  @TC_03
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and valid password are "thirumaran1@sankarasoftware.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_04
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter valid username and Invalid password are "0211thiru@gmail.com" and "Thirumaran12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_05
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and Invalid password are "0211thiru@gmail.com" and "Thirumaran12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_06
  Scenario: Login:Without Password Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username only "thirumaran@sankarasoftware.com"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_07
  Scenario: Login:Without Mail Id Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter password only "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_08
  Scenario: Login:Forget Password Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When Without enter email id click Forget password button
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_09
  Scenario: Login:Forget Password Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter email id "0211thiru@gmail.com"
    And click Forget password button
    Then Click Ok button Check landing page
    Then close the Login Page

  @TC_18
  Scenario: Login:Invalid Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "test@yopmail.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_19
  Scenario: Login:Lock Account
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@yopmail.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    Then close the Login Page

  @TC_20
  Scenario: Login:Lock Account
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter username and password are "thirumaran@yopmail.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then close the Login Page

  @TC_21
  Scenario: Login:Enter button check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and valid password are "thirumaran@sankarasoftware.com" and "Thirumaran@12345"
    And Click ENTER button
    Then Check the landing page using assert function
    And click the Signin button To Check Login
		Then close the Login Page
		
  @TC_22
  Scenario: Login:2FA Enabled User Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter Invalid username and valid password are "thirumaran@sankarasoftware.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Check the landing page using assert function
    And click the Signin button To Check Login
    Then close the Login Page

  @TC_26
  Scenario: Login:With Inactive User Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter inactive username and valid password are "inactiveuser@yopmail.com" and "Thirumaran@12345"
    And click Forget password button
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then close the Login Page

  @TC_27
  Scenario: Login:With Inactive User Check
    Given To Check Login is navigating to OEP URL is "http://192.168.1.30/OEPADMIN/"
    When To Check Login Enter inactive username and valid password are "inactiveuser@yopmail.com" and "Thirumaran@12345"
    And click the Signin button To Check Login
    Then Check alert message is displayed or not
    And click the Signin button To Check Login
    Then close the Login Page
