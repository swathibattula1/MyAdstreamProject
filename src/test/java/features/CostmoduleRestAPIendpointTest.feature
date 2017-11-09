Feature: Testing Adcost Api endpoints.

  Scenario: To get all the costs
    Given  I have getAllcosts endpoint
    When I perform the  get request
    Then I validate the response and get the status code
    And print the response





  Scenario: To Post the Costdetails using datatable
    Given I have post cost details endpoint
    When I set the headers and parameters
    And I set the Requestbody and submit it
      | key                     | Values                               |
      | DictionaryId            | f02fe634-16fc-49b8-91c6-e54d388007cd |
      | ProjectKey              | RBU                                  |
      | Projectvalue            | RBU                                  |
      | Projectvisibility       | true                                 |
      | ProjectId               | 85950c29-da04-4603-adff-4d0bd4038bfd |
      | BudgetRegionId          | fb0a8d23-a0d1-4aea-9084-e61bfce7fcca |
      | BudgetREgionkey         | GREATER CHINA AREA                   |
      | BudgetRegionName        | Greater China                        |
      | ProductionTypeId        | 00ff614b-822e-4d6a-8541-945cc2e2290f |
      | ProductionTypeKey       | Post Production Only                 |
      | ProductionTypeValue     | Post Production Only                 |
      | ContentTypeDictionaryId | 9ec6a1cb-f38a-4a0b-9196-c1c9a3b63cd0 |
      | ContentTypeId           | b0b2ddb4-1a40-4817-adbe-c0bce48b3a44 |
      | ContentTypeKey          | Photography                          |
      | ContentTypeProjects     | null                                 |
      | ContentTypeValue        | Still Image                          |
      | ContentTypeVisible      | true                                 |
      | dataAgencyCurrency      | USD                                  |
      | dataCampaign            | 14 days challange (Pantene)          |
      | dataCostType            | Production                           |
      | dataDescription         | STUB                                 |
      | dataInitialBudget       | 80000                                |
      | dataIsAIPE              | false                                |
      | dataIsCurrencyChanged   | false                                |
      | dataTitle               | Swathi API test cost                 |
      | dataSmoId               | null                                 |
      | dataProjectId           | 59fc614b9ee5eb0c576b5c0c             |
      | TemplateId              | c17fc46e-6d25-4aa1-afb5-9913d02804df |
    Then print the response of postcall