## Synopsis

This is a role based game called `Game of stones`. Player needs to acquire all the infinity stones placed in different planets by fighting with each villain on the planet. Player explore or move to near by planets to complete game. To simplify the solution the fighting is simulated b/w the avengers and villains. 

Patterns used:
- MVC: To structure the solution
- Command: To run all user actions during game play.

I think that this code is quite extensible, for example:
- To add new Commands or User Action you just need to create a new Command. 
- To improve the setup process or add a new Feature, you just need to add a new Controller. 

## Run/Build

- To compile type: mvn package (in the same folder where the pom.xml is)
- To run type: java -jar target/gameofstones.jar (You must have write permission into the folder you are running gameofstones)

## Test

Execute 'mvn clean test' to run tests.


