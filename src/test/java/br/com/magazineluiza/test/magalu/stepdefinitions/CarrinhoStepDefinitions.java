package br.com.magazineluiza.test.magalu.stepdefinitions;

import br.com.magazineluiza.test.magalu.steps.CarrinhoSteps;
import br.com.magazineluiza.test.magalu.steps.DetalhesProdutoSteps;
import br.com.magazineluiza.test.magalu.steps.ResultadoBuscaSteps;
import br.com.magazineluiza.test.magalu.steps.SeguroSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CarrinhoStepDefinitions {

	@Steps
	private ResultadoBuscaSteps resultadoBuscaSteps;

	@Steps
	private DetalhesProdutoSteps detalhesProdutoSteps;

	@Steps
	private SeguroSteps seguroSteps;

	@Steps
	private CarrinhoSteps carrinhoSteps;

	private String produto = null;

	@When("selecionar um produto")
	public void selecionarUmProduto() {
		resultadoBuscaSteps.clicarNoPrimeiroItem();
	}

	@When("adicionar o produto ao carrinho")
	public void adicionarOProdutoAoCarrinho() {
		produto = detalhesProdutoSteps.clicarEmAdicionarAoCarrinho();
		if (seguroSteps.seguroExibido())
			seguroSteps.clicarEmContinuar();
	}

	@Then("o sistema deve exibir o carrinho com o produto selecionado")
	public void oSistemaDeveExibirOCarrinhoComOProdutoSelecionado() {
		String produtoCarrinho = carrinhoSteps.produtoNoCarrinho();
		assertThat(produtoCarrinho, equalTo(produto));
	}

	@Given("adicionou um produto ao carrinho")
	public void adicionouUmProdutoAoCarrinho() {
		selecionarUmProduto();
		adicionarOProdutoAoCarrinho();
	}

	@When("solicitar excluir o produto do carrinho")
	public void solicitarExcluirOProdutoDoCarrinho() {
		carrinhoSteps.clicarEmExcluirProduto();
	}

	@Then("o sistema deve exibir a mensagem {string} informando que o carrinho esta vazio")
	public void oSistemaDeveExibirAMensagem(String mensagem) {
		assertThat(carrinhoSteps.mensagemSacolaVazia(), equalTo(mensagem));
	}
}