

Feature: Validating place APIS

@AddPlace @Regression  
  Scenario Outline: VALIDATING ADD PLACE API
    Given ADD PLACE PAYLOAD with "<name>" "<language>" "<address>"
    When User CALLS "AddPlaceAPI", WITH "POST" HTTP REQUEST
    Then API CALL IS SUCCESS WITH STATUSCODE 200
    And "status" IN RESPONSE BODY IS "OK"
    And "scope" IN RESPONSE BODY IS "APP"
    And VERIFUY place_id created maps to "<name>" using "getPlaceAPI"
    
Examples:
	|name     |language  |address    |
	|AAHOUSE  |ENGLISH   |WCC        |
	|BBHOSUE  |SPANISH   |SCC        |    
    
    
    
 
		