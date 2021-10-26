Cinnamon Cinemas Movie Theatre Seating Challenge

Assumptions: For a movie, there will always be (number of letters X number of seats per letter) available seats when sales start.

Approach: However, multiple random moments of sale (independent from each other) will produce a much better unit test coverage. 

Solution: In order to do that, we will test different sales through the use of parameterization, providing on each:

- Number of rows (first one will always be A)
- Number of seats in a row
- Maximum number of seats that can be purchased on a single sale
- Available number of seats at that moment (integer)
- Number of tickets that are being purchased (integer)
- Expected seats to be provided by the cinema (string array)

Future thoughts

- In case of refurbishment of the cinema, we will just have to adjust the number of rows and seats on each row in our test.
- In case the maximum number of seats permitted for sale is raised, we can also adjust it on each row in our test.