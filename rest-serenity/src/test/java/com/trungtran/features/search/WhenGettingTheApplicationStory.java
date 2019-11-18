package com.trungtran.features.search;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasItems;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;


@RunWith(SerenityRunner.class)
public class WhenGettingTheApplicationStory {
	
/*	EnvironmentVariables environmentVariables;
	
	String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl") 
            .orElse("http://localhost:8080/apidddd");*/
	
	public static final String BASE_URL = "http://localhost:8080/api";
	public static final String CLIENTS_ENDPOINT = "/clients";

	@Test
	public void shouldBeExecutedSuccesfully() {
		
		Actor jacob = Actor.named("Trung")
		         .whoCan(CallAnApi.at(BASE_URL));
		
		jacob.attemptsTo(Get.resource(CLIENTS_ENDPOINT));
		
		jacob.should(
				seeThatResponse("the clients should be returned", 
						response -> response.statusCode(200)
											.body("firstName", hasItems("ddddd", "trung"))
											.body("id", hasItems(2, 3))
				)
		);


	}

}