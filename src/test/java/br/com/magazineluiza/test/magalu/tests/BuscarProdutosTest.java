package br.com.magazineluiza.test.magalu.tests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Pesquisa_de_Produtos/Buscar_Produtos.feature",
        glue = {"br.com.magazineluiza.test.magalu.stepdefinitions"})
public class BuscarProdutosTest {

}