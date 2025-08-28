Feature: Add admin user

  Scenario: Add admin user Successful
 //Given The user navigates to login page
    Given The user is login into the system
    Then The user succesfully logged in
    And The user add new admin
      | Username   | Password |
      | Molepo | pass123  |



