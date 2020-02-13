package br.com.magazineluiza.test.magalu.stepdefinitions;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;

import br.com.magazineluiza.test.magalu.pages.CarrinhoPage;
import br.com.magazineluiza.test.magalu.pages.DetalhesProdutoPage;
import br.com.magazineluiza.test.magalu.pages.ResultadoBuscaPage;
import br.com.magazineluiza.test.magalu.pages.SeguroPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarrinhoStepDefinitions {

	private final BaseStepDefinitions context;
	private final WebDriver driver;
	private ResultadoBuscaPage resultadoBuscaPage;
	private DetalhesProdutoPage detalhesProdutoPage;
	private SeguroPage seguroPage;
	private CarrinhoPage carrinhoPage;

	private String produto = null;

	public CarrinhoStepDefinitions(final BaseStepDefinitions context) {
		this.context = context;
		driver = this.context.driver;
		resultadoBuscaPage = new ResultadoBuscaPage(driver);
	}

	@When("selecionar um produto")
	public void selecionarUmProduto() {
		detalhesProdutoPage = resultadoBuscaPage.clicarNoPrimeiroItem();
	}

	@When("adicionar o produto ao carrinho")
	public void adicionarOProdutoAoCarrinho() {
		produto = detalhesProdutoPage.clicarEmAdicionarAoCarrinho();
		seguroPage = new SeguroPage(driver);
		carrinhoPage = seguroPage.clicarEmContinuar();
	}

	@Then("o sistema deve exibir o carrinho com o produto selecionado")
	public void oSistemaDeveExibirOCarrinhoComOProdutoSelecionado() {
		String produtoCarrinho = carrinhoPage.produtoNoCarrinho();
		assertThat(produtoCarrinho, CoreMatchers.equalTo(produto)); 
	}
 }
