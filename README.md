# covid-simulation-backend
Recruitment task - simulation calculating spreading pandemic
Backend: Spring, Hibernate, Facade, 

| Method  |       URL                    |  Request Body                          | Response body | Comment|
| ------------- | ------------- | ------------- | ------------- | ------------- | 
| PUT | /covid/simulation  | 	"name":"tet2", "population":"1000", "infected":"8", "r":"4", "mortality":"3", "mortalityTime":"5", "recoveryTime":"7", "simulationTime":"50"  | "simulationDetails": { "name": "test2", "population": 1000,"infected": 8,"r": 4,"mortality": 3,"mortalityTime": 5,"recoveryTime": 7,"simulationTime": 50
},
"simulationId": 2,
"run": [
{
"dayNumber": 1,
"infectedPeople": 18,
"vulnerablePeople": 980,
"deadPeople": 2,
"healedPeople": 0
},
{
"dayNumber": 2,
"infectedPeople": 27,
"vulnerablePeople": 971,
"deadPeople": 2,
"healedPeople": 0
}, | using parameters, simulate run of pandemic. then returns state of each day of the pandemic |
