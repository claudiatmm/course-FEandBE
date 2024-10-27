Feature: CreateAccountFeature
#  In order to do actions I need to create an account and authorize it with token

  @UI
  Scenario: Create new account from back-end
    When I create a new account from back-end
    And I generate a token for the new account
    When I login into application