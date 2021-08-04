Feature:  Testing different request on the video games application

  #@Smoke

  Scenario Outline: Create a new video game product and verify if the video game is added
    When I create a new videogame by providing the information name"<name>" releaseDate"<releaseDate>" rating"<rating>"
    Examples:
      | name     | releaseDate             | rating   |
      |pokey mon |2021-07-15T19:08:27.6092 |universal |


  Scenario: Getting the videogame information by Id
    When  I send the Get request to videogame endpoint with ID "id",I should received the videogame information

  Scenario: update a created product and verify if the product is updated
    When  I update a created videogame providing the new name category and rating
    Then I verify the videogame is updated

  Scenario: Delete a created videogames & verify the product is deleted
    When I delete a created videogame ,they must get back a valid status code is 200

  Scenario: check if the video games application can be accessed by user
    When User sends a GET request to videogames endpoint, they must get back a valid status code 200





