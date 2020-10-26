# APIAutomationRestAssured

1. Pre-requisite:
  -Java should be installed e.i 1.8
  -Maven should be configured(To check run mvn -version command)
  -Allure should be installed
   run command "scoop install allure" at powershell

2. Navigate to pom.xml location
  -Run below command:
   mvn clean test

3. To generate allure report run below command:
  -allure generate allure-results --clean -o allure-report
  -index.html report generated in allure-reports folder
