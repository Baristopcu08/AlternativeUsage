Feature: Multi WebSite test

  @opencart
  Scenario: Opencart
    Given user on Opencart homepage named as "opencart"
    And   opencart, user clicks link "My Account"
    And   opencart, user clicks link "Login"
    And   opencart, user sendkeys "deneme@deneme.com" to control "E-Mail Address"
    And   opencart, user sendkeys "deneme" to control "Password"
    When  opencart, user clicks button "Login"
    Then  opencart, the link "Logout" should be present

  @orangehrm
  Scenario: orangehrm
    Given user on OrangeHRM homepage named as "orangehrm"
    And   orangehrm, user sendkeys "Admin" to control "Username"
    And   orangehrm, user sendkeys "admin123" to control "Password"
    When  orangehrm, user clicks button "Login"
    Then  orangehrm, the link "Admin" should be present


