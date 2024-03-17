package com.countrylayer.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import org.json.JSONObject;
import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;

@Epic("REST API Regression Testing with RestAssure and JUnit")
@Feature("Verify Country Austria")
public class APITest {

	String BaseURI = "http://api.countrylayer.com/v2";

	/*
	 * This is one way to test APIs using RestAssured. Another way could be by
	 * writing Gherkin files and running them with the Cucumber tool
	 */

	// only run One Test at Time (Rate limit: 1 per second limit of API{429})

	@Test
	@Story("GET Request US")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Diana Rojas")
	@Description("Test Description : Get information of United States of America")
	public void getInfoUS() {
		given().queryParam("access_key", "abea0078f4fdf15cf71249fed84aaf25").when().get(BaseURI + "/alpha/US").then()
				.statusCode(200).statusLine("HTTP/1.1 200 OK").body("name", equalTo("United States of America"))
				.body("capital", equalTo("Washington, D.C.")).log().all();

	}

	@Test
	@Story("GET Request DE")
	@Severity(SeverityLevel.BLOCKER)
	@Owner("Luis Ruiz")
	@Description("Test Description : Get information of Bundesrepublik Deutschland")
	public void getInfoDE() {
		given().queryParam("access_key", "abea0078f4fdf15cf71249fed84aaf25").when().get(BaseURI + "/alpha/DE").then()
				.statusCode(200).statusLine("HTTP/1.1 200 OK").body("name", equalTo("Germany"))
				.body("capital", equalTo("Berlin")).body("region", equalTo("Europe")).log().all();

	}

	@Test
	@Story("GET Request GB")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Diana Rojas")
	@Description("Test Description : Get information of United Kingdom of Great Britain")
	public void getInfoGB() {
		given().queryParam("access_key", "abea0078f4fdf15cf71249fed84aaf25").when().get(BaseURI + "/alpha/GB").then()
				.statusCode(200).statusLine("HTTP/1.1 200 OK")
				.body("name", equalTo("United Kingdom of Great Britain and Northern Ireland"))
				.body("capital", equalTo("London")).log().all();

	}

	@Test
	@Story("POST Request")
	@Severity(SeverityLevel.TRIVIAL)
	@Owner("Steel Ruiz")
	@Description("Test Description : Add new Country to API")
	public void createNewCountry() {

		JSONObject country = new JSONObject();
		country.put("name", "Steel Doroteo");
		country.put("alpha2Code", "SD");
		country.put("capital", "JackshonS");
		country.put("alpha3Code", "SDX");
		given().queryParams("access_key", "abea0078f4fdf15cf71249fed84aaf25").contentType(ContentType.JSON)
				.body(country.toString()).when().post(BaseURI + "/v2/country").then().statusCode(201)
				.body("name", equalTo("Steel Doroteo")).body("capital", equalTo("JackshonS")).log().all();
	}

}