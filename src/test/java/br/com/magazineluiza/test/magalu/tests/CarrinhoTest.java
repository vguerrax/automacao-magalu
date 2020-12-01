package br.com.magazineluiza.test.magalu.tests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Carrinho/Carrinho.feature", glue = {
		"classpath:br.com.magazineluiza.test.magalu.stepdefinitions" })
public class CarrinhoTest {

}