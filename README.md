# Demonstration of ScalaTest for Integration Testing in Spring Boot

## Get it ...
```
git clone https://github.com/codesqueak/ScalaTestDemo.git
```
## Run it ...
```
./gradlew clean build test scalatest
```
## You should see the test output ...
```
  Scenario: Check the service is functional
    Given We have defined an endpoint /ping
    When and a call to /ping is sent
    Then we get a response with the 'pong' message
```