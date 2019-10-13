package com.codingrodent.scalatest

import org.junit.runner.RunWith
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment._
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.TestContextManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest(webEnvironment = DEFINED_PORT)
class PingControllerIntegrationTest extends FeatureSpec with GivenWhenThen with Matchers {

  @Autowired
  var testRestTemplate: TestRestTemplate = _
  new TestContextManager(this.getClass).prepareTestInstance(this)

  @LocalServerPort
  val randomServerPort: Integer = null // doesn't seem to work ... not sure why

  val baseUrl = s"http://localhost:8080"

  feature("Ping controller") {
    scenario("Check the service is functional") {
      Given("We have defined an endpoint /ping")
      val url = s"$baseUrl/ping"
      When("and a call to /ping is sent")
      val response = testRestTemplate.getForEntity(url, classOf[String])
      Then("we get a response with the 'pong' message")
      response.getBody shouldBe "Pong !"
    }
  }
}
