Feature: To test My Adstream Login screen


  Scenario Outline: To test Login functionality with Multiple credentials
    Given I navigate to MyAdstream Login screen
    When I enter <username> and <password>
    And I click on Login button
    Then I should see 'MyAdstream' home page

    Examples:
      | username        | password  |
      | swathi.battula1 | Vinnu143* |
      | swathi          | madhuri   |
      | swathi.battula  | Vinnu143* |


  Scenario: To Login and then navigate to 'Book a Resource' screen and book a resource
    Given I navigate to MyAdstream Login screen
    And I entered following details
      | username       | password  |
      | swathi.battula | Vinnu143* |
    And I click on Login button
    When I am on 'MyAdstream' home page
    And  I click on I Want to and then clicked on Book and then to A Resouce
    And I should navigate to Book a Resource screen
    And I enter location
    And I enter category
    And I enter Resource
    And I cleared Weeks of field
    And I entered date in it
    And I clicked on CheckAvailability button
    And I clicked on first date
    And I entered into MakeBooking screen
    And I entered following Booking details
      | startTime | endTime | description                             |
      | 1:00      | 5:00    | Would like to have access to Desk cycle |
    And I clicked on MakeBooking button
    Then Booking is done


  Scenario: To Apply for Receptionist job
    Given I click on Home link
    When I click on Mycareer icon
    And I click on Technical Support Expert job link
    And I click on Apply for this job link
    And I job Enter all details
      | key       | values                   |
      | Firstname | priya                    |
      | LastName  | Kinthada                 |
      | Email     | priya.kinthada@gmail.com |
      | Phone     | 07779900029              |
      | Address   | 90 Shaftesbury Road      |
      | City      | London                   |
      | County    | Newham                   |
      | PostalZip | E78PD                    |
    Then I could submit CV

