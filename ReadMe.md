##Prerequisites
* NODE installed and setup
* JAVA installed and setup
* GRADLE installed and setup
* APPIUM installed and setup
* ANDROID/ADB installed and setup

##Framework overview
* ####./src/main/java/utility_module : contains all the utility classes
* ####./src/main/java/PageObjects_Module : contains all the pageobject vise classes
* ####./src/main/java/ObjectInitiator_Module - contains object, configuration and locators initiator module
* ####./sr/test/java : contains test classes
* ####./src/test/resources/Locators : contains locators stored in yaml format
* ####./gradle.properties : contains runtime configuration parameters


##Steps to execute the test
* start the appium server
* mention the appium server port in gradle.properties file
* fill all the device specific details in gradle.proeprties file
* execute the gradle command -  gradle test --tests SampleTest

##OUTPUT
* ./build/reports/tests/test/index.html