Feature: OrangeHRM functionality Tesing of login with multiple data 
Scenario Outline: validation Login Fuctionality of OrangeHRM Application

Given Open firefox browser and navigate to OrangeHRM application
When Login application by enter "<username>" and "<password>" and click on signin
Then User should be able to successfull "<username>" login to the application and close the application

Examples:

|	username	|	password	|
|	admin			|	admin123	|
|	mahesh		|	mahesh_01	|
|	live			|	12356e		|
 