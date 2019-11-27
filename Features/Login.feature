Feature: Login

  Scenario: Successful Login with valid credentials
    Given a User launches Chrome Browser
    When the User opens the following URL: https://demo.opencart.com/index.php?route=account/login
    And enters Email as 'afasii@gmail.com' and Password as '0123'
    And clicks on the Login button
    Then the Page Title should be My Account
    When the User clicks on the Log Out link
    Then the Page Title is Account Logout
    And close Browser


  Scenario Outline: Login Data Driven
    Given a User launches Chrome Browser
    When the User opens the following URL: https://demo.opencart.com/index.php?route=account/login
    And enters Email as '<email>' and Password as '<password>'
    And clicks on the Login button
    Then the Page Title should be My Account
    When the User clicks on the Log Out link
    Then the Page Title is Account Logout
    And close Browser

    Examples:
    | email           | password |
    |afasii@gmail.com | 0123     |
    |qfasii@gmail.com | 0123     |