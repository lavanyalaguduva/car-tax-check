# Car Tax Check Test Automation

## Scenario
1. Reads given input file: car_input.txt
2. Extracts vehicle registration numbers based on pattern(s).
3. Each number extracted from input file is fed to https://cartaxcheck.co.uk/
(Perform Free Car Check)
4. Compare the output returned by https://cartaxcheck.co.uk/ with given
car_output.txt
5. Highlight/fail the test for any mismatches.

## Framework Details

The above scenario has been automated using serenity-bdd screenplay pattern, cucumber, hamcrest matchers.

The Screenplay Pattern is an approach to writing high quality automated acceptance tests based on good software engineering principles such as the Single Responsibility Principle, the Open-Closed Principle, and effective use of Layers of Abstraction. 
It encourages good testing habits and well-designed test suites that are easy to read, easy to maintain and easy to extend, enabling teams to write more robust and more reliable automated tests more effectively.

### Code Structure

This project can be imported as a maven, or a gradle project in the IDE.

Consists of mainly two folders:

*main* folder includes actions like reading input and output files which are not tests but tasks.
It also includes the Screenplay Question objects which are used to retrieve the actual details from the application.
This includes a 'resources' folder to store the input and output files used in this scenario.

*test* folder includes feature file, step definitions, userInterface classes. 
It also includes a folder to store the browser drivers for each platform. 
Please update the browser drivers in this folder based on the browser version and platform.
*serenity.conf* file has system specific and environment specific properties

**In order to specify more input files in the test, the file paths can be added in the serenity.conf file and can be referenced in feature files. 
Please refer input.file.path and output.file.path properties under this file**
### Commands
Following maven command can be used to run the test in chrome. By default, chrome browser is being used.

`mvn clean verify`

In order to run the test in other browsers, please pass the browser driver name like below

`mvn clean verify -Dwebdriver.driver=firefox`

Note: Please make sure the required drivers are present under /src/test/resources/webdriver folder

### Reports
Serenity test reports can be viewed at this location once the tests are run

`\target\site\serenity\index.html`

##Improvements
1)Covert the file reading calls into screenplay tasks
2)Better error handling method to handle all possible scenarios
3)Integrate with cross-browser platform like Browserstack/Saucelabs
4)Integrate with grafana/influxDB to view the live results

