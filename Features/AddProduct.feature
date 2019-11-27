Feature: Add a product to cart

  Scenario: Add a product to cart
    Given a user logs in with valid credentials
    And the 'My Account' page is displayed
    When the user clicks on the 'Phones & PDAs' category
    Then the 'Phones & PDAs' page is displayed
    When the user clicks on the 'HTC Touch HD' product
    Then the 'HTC Touch HD' page is displayed
    When the user clicks on the 'Add to cart' button
    Then the following message is displayed: 'Success: You have added HTC Touch HD to your shopping cart!'
    When the user clicks on the 'Shopping Cart' button
    Then the 'Shopping Cart' page is displayed
    And the 'HTC Touch HD' is displayed in the shopping cart products table
    And the Chrome Browser closes


  Scenario: Add a product to cart, delete it and verify the cart is empty
    Given a user logs in with valid credentials
    And the 'My Account' page is displayed
    When the user clicks on the 'Phones & PDAs' category
    Then the 'Phones & PDAs' page is displayed
    When the user clicks on the 'HTC Touch HD' product
    Then the 'HTC Touch HD' page is displayed
    When the user clicks on the 'Add to cart' button
    Then the following message is displayed: 'Success: You have added HTC Touch HD to your shopping cart!'
    When the user clicks on the 'Shopping Cart' button
    Then the 'Shopping Cart' page is displayed
    And the 'HTC Touch HD' is displayed in the shopping cart products table
    When the user clicks on the 'Delete' button
    And clicks on the 'Cart Total' button
    Then the 'Your shopping cart is empty!' message is displayed
    And the Chrome Browser closes


  Scenario: Add some products to cart, delete one and verify it is deleted
    Given a user logs in with valid credentials
    And the 'My Account' page is displayed
    When the user clicks on the 'Phones & PDAs' category
    Then the 'Phones & PDAs' page is displayed
    When the user clicks on the 'HTC Touch HD' product
    Then the 'HTC Touch HD' page is displayed
    When the user clicks on the 'Add to cart' button
    Then the following message is displayed: 'Success: You have added HTC Touch HD to your shopping cart!'
    When the user clicks on the 'Tablets' category
    Then the 'Tablets' page is displayed
    When the user clicks on the 'Samsung Galaxy Tab 10.1' product
    Then the 'Samsung Galaxy Tab 10.1' page is displayed
    When the user clicks on the 'Add to cart' button
    Then the following message is displayed: 'Success: You have added Samsung Galaxy Tab 10.1 to your shopping cart!'
    When the user clicks on the 'Shopping Cart' button
    Then the 'Shopping Cart' page is displayed
    And the 'HTC Touch HD' is displayed in the shopping cart products table
    And the 'Samsung Galaxy Tab 10.1' is displayed in the shopping cart products table
    When the user clicks on the 'Delete' button
    Then the 'Samsung Galaxy Tab 10.1' is displayed in the shopping cart products table
    And the Chrome Browser closes