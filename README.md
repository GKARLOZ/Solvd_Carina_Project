# :microscope: Solvd_Carina_Project :exclamation:
This project provides a demo of API, Web and Mobile test using the Carina Framework. Carina has it own project structure and  " is built on top of the most popular open-source solutions like Selenium, Appium, TestNG allowing to reduce dependence on the specific technology stack. " (https://zebrunner.github.io/carina/)

### API Testing with Facebook's Graph API:
* API testing to perform operations such as POST, GET, and DELETE against Facebook's Graph API.
* This meticulous API testing ensures that our backend services are functioning seamlessly and that data interactions are consistent.

### Web Testing with Selenium and TestNG:
 * Includes the utilization of data providers for diverse test scenarios, soft assert techniques to capture failures without halting test execution, and the creation of reusable page objects.
* This approach guarantees the reliability and functionality of web tests. 

### Mobile Testing with Appium, Android Studio, and Appium Inspector:
 * Detailed testing on mobile applications, ensuring compatibility with various Android devices and versions.
* Appium Inspector for inspecting mobile app elements and guaranteeing smooth user experiences on mobile platforms.

### Parallel testing using Selenium Grid with Docker:
* Executing the mvn test command executes the test suit with parallel testing.
* The bat files sets up the selenium grid using containers and removes the containers as well.

### Jenkins (CI/CD) 
* Thanks to bat files and docker compose file, it is easy to setup this project on Jenkins
* Set up your Jenkins jobs to clone the repository and run the "mvn clean test" command.

# Process when executing mvn clean test: :rocket:
* Maven initiates the execution of the TestNG xml file, named WebTestParallel.xml.
* Within this file, the first class, Setup_DockerGrid, triggers the @BeforeTest method.
* The @BeforeTest method subsequently runs the start_dockergrid.bat script to execute the predefined commands.
* Inside the start_dockergrid.bat script, a docker-compose.yml file is executed.
* This docker-compose operation sets up containers for the Selenium grid and multiple nodes, each with distinct environments.
* Once the @BeforeTest method completes its tasks, the tests DesktopChromeWebTest and DesktopFireFoxWebTest run in parallel, each within its own container.
* Upon test completion, the @AfterTest method comes into play, removing all active containers and terminals. 🚀 
  

# Steps: :exclamation:
## a. 
* Make sure you have Docker running in your machine before executing this code. 
## b.
* Clone this repository:

      git clone https://github.com/GKARLOZ/Solvd_Carina_Project.git
  
## c. 
* go to the /to/path/Solvd_Carina_Project directory and run  

      mvn clean test

## Information:
* Carina Framework: https://zebrunner.github.io/carina/

* Carina is a Java-based test automation framework that unites all testing layers: Mobile applications (web, native, hybrid), WEB applications, Windows applications, REST services, Databases.
