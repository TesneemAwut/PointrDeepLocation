# Pointr Front-End UI Testing Project
The automation test script of this project was developed with Java in Intellij IDE using Selenium WebDriver. What makes the project outstanding is:

1. Both Cucumber and TestNG frameworks were used.
2. Page Object Model design dattern was used.
3. Test implementations support two different browsers with three different operating systems.
4. WebDriverManager is used to automate the handling of browser driver binaries. 
5. Generate extending reports and logs while excuting every action.
6. Project test data does not include any hardcode.
7. Doesen't include any sleep method. 
8. Doesen't have any index number in webelements.
9. This project includes XML file for generating emailable TestNG report, and it also make the test ready to run in Jenkins server.
10. This project was successfully built on Jenkins Server. 

## Automation Test Cases
- ### Front-End
  ##### Go to https://www.pointr.tech/blog
   * Verify that all articles have loaded.
   * Find the most repeated 5 words in the latest 3 articles and save them (with their repeat count) into a .txt file.

### When I create my project, first of all, I managed all dependencies in POM.xml file.
![pom.xml file](https://user-images.githubusercontent.com/105384992/168116772-fae2e3bd-8637-4711-95de-ec9afef621d5.jpg)

### Then I created a Utility package for my utilities where I would store all utilities that I need when I execute my tests.

#### BasePage class includes functions below:
* setUpBrowser( );
* closeBrowser( );
#### Utility class includes functions below:
* waitElementPresent( );
* sleep( );
#### Log class includes functions below:
* startTestCase( );
* endTestCase( );
* info( );
#### ReadFromFiles class includes function below:
* readConfigProperties( );
* getHashMapWithProperties( );

![Utility Package](https://user-images.githubusercontent.com/105384992/168116781-39515071-cd10-4325-8037-5373aeaf5a84.jpg)

### I created config file and put all variables I need like Website url, timeout, browser name etc and I call them from config file instead of hard coding when I need.
![config_file](https://user-images.githubusercontent.com/105384992/168116743-562c81f8-3980-4e02-91e8-f0af91b8f886.jpg)

### I also created another config file and put the expected test date that is needed for the test validation, and call the data from config file to populate a Hashmap.
![Result config_file](https://user-images.githubusercontent.com/105384992/168116765-bae74c6c-eb77-4bab-89ae-f96656a4f803.jpg)

### I also added Log4j for generating extending report and logs when the project is running.
![log4j](https://user-images.githubusercontent.com/105384992/168116788-d6b3b0aa-e624-4522-ac52-bbc4e3bde8a2.png)

### Then I created separated Java Class for the webPage where I store all elements of that page as well as related methods. I used POM design pattern in order to keep my codes more organized and clean.
![POM_pages](https://user-images.githubusercontent.com/105384992/168124077-dc79fcbb-20cf-4c57-97b5-3d24de2cbe6a.jpg)

## Frameworks
I used both Cucumber and TestNG Frameworks for running this project.

- ### Cucumber Framework
#### I created Cucumber Feature File where I used Gherkin language in order to describe my test scenarios. 
![feature_file](https://user-images.githubusercontent.com/105384992/168116799-a91ef8f4-6a0c-47df-b9f0-cdaceea7647e.jpg)

#### I created Hooks class for running Setup and TearDown methoeds before and after each scenarios.
![Hooks](https://user-images.githubusercontent.com/105384992/168116817-cdf480fa-8e5b-44da-b95e-8a95d71535e1.jpg)

#### I put All step definitions in StepDefinitions class. It can be separated to different classes as well.
![stepDefinitions](https://user-images.githubusercontent.com/105384992/168116829-df79402a-74e0-4052-8de1-bf3394df8207.jpg)

#### I created CucumberTestRunner class.
![cucumberRunner](https://user-images.githubusercontent.com/105384992/168116811-5065befd-20ec-43a6-b433-df0248173bd8.jpg)

- ### TestNG Framework
#### I created TestNGTestRunner class
![testNGRunner](https://user-images.githubusercontent.com/105384992/168116838-0fe6a00c-c5cd-47d1-a37b-63b8ce0931c3.jpg)

#### I also created TestNG.xml file for generating emailable testNG report, and It also can be used for running the project using mvn command.
![testNG_xml](https://user-images.githubusercontent.com/105384992/168116848-9b5029c7-9ce2-48c9-a905-59a457f8a0da.jpg)

#### Generated TestNG emailable Report
![testNGReport](https://user-images.githubusercontent.com/105384992/168124911-84ba1bb9-5be5-4013-a34b-157e6f1735e3.jpg)

## CI/CD pipeline Design
#### I used Jenkins to implement Continuous Integration (CI) and Continuous Delivery (CD) for the project development.
![Jenkins](https://user-images.githubusercontent.com/105384992/168153586-761d5062-7fb9-4890-b504-69413a9bf981.png)

#### Firts, I set up the jenkins configuration to get the server ready for buil the job.
 Note:I exported the Config.xml file for the job which contains information about Jenkins like version, Pipeline information, owner, etc. It also contains the workspace Directory path and builds Directory path. 
 
![Jenkins-config](https://user-images.githubusercontent.com/105384992/168153571-446cd76f-58c9-4b89-aa19-3f793146b875.png)

#### After the configurations are set, I built the job. It runs successfully, now the job is ready for schuduling. 
![Jenkins-built](https://user-images.githubusercontent.com/105384992/168153577-66e8bbd6-39be-476d-86bc-baca6b033eda.png)








 
