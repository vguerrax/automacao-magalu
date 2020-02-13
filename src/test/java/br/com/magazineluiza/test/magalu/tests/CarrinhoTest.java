package br.com.magazineluiza.test.magalu.tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Carrinho.feature", glue = {
		"classpath:br.com.magazineluiza.test.magalu.stepdefinitions" })
public class CarrinhoTest {

}
