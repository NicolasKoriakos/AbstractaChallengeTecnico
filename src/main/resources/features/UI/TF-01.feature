Feature: Get prices on MercadoLibre
    Scenario: find product on searchbar
    Given I navigate to the MercadoLibre search page
    When I search "camisetas" in the search bar
    Then I get the results from the first <3> pages

