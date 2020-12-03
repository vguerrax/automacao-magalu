package br.com.magazineluiza.test.magalu.tests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Screenplay/screenplay.feature",
		glue = {"br.com.magazineluiza.test.magalu.stepdefinitions",
				"br.com.magazineluiza.test.magalu.hooks"})
public class ScreenplayTest {

}