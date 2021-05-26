# covid-simulation-backend
Recruitment task - simulation calculating spreading pandemic<br>
Backend: Spring, Hibernate, Facade, 

| Method  |       URL                    |  Request Body                          | Response body | Comment|
| ------------- | ------------- | ------------- | ------------- | ------------- | 
| PUT | /covid/simulation  | 	"name":"tet2", "population":"1000", "infected":"8", "r":"4", "mortality":"3", "mortalityTime":"5", "recoveryTime":"7", "simulationTime":"50"  | "simulationDetails":<br> { "name": "test2",<br> "population": 1000,<br>"infected": 8,<br>"r": 4,<br>"mortality": 3,<br>"mortalityTime": 5,<br>"recoveryTime": 7,<br>"simulationTime": 50 }<br> "simulationId": 2,<br> "run":<br> [<br> { "dayNumber": 1,<br> "infectedPeople": 18,<br> "vulnerablePeople": 980,<br> "deadPeople": 2,<br> "healedPeople": 0 },<br> { "dayNumber": 2,<br> "infectedPeople": 27,<br> "vulnerablePeople": 971,<br> "deadPeople": 2,<br> "healedPeople": 0 }, ... ]} | using parameters, simulate run of pandemic. then returns state of each day of the pandemic |
