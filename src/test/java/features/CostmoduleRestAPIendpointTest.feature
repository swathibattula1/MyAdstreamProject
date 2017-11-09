Feature: Testing Adcost Api endpoints.

  Scenario: To get all the costs
    Given  GetAllcosts endpoint is available
    And perform the  get request
    Then validate the response and get the status code
    And print the reponse
    And validate the response schema



    Scenario: To Post the Costdetails
      Given I have post cost details enpoint
      When I set the headers and parameters
      And I set the Request body and submit it
      Then print the response of postcall