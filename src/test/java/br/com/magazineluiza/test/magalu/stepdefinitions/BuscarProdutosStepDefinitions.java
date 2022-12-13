package br.com.magazineluiza.test.magalu.stepdefinitions;

import br.com.magazineluiza.test.magalu.steps.HomeSteps;
import br.com.magazineluiza.test.magalu.steps.ResultadoBuscaSteps;
import br.com.magazineluiza.test.magalu.utils.ReportUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.magazineluiza.test.magalu.matchers.StringMatchers.containsAnyOfStrings;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BuscarProdutosStepDefinitions {

	@Steps
	private HomeSteps homeSteps;

	@Steps
	private ResultadoBuscaSteps resultadoBuscaresultadoBuscaSteps;

	private String[] termosBuscados = null;

	@Given("(que )o cliente acessou a loja virtual")
	public void oClienteAcessouALojaVirtual() {
		homeSteps.acessarPaginaInicial();
		if (homeSteps.mensagemCookieExibida())
			homeSteps.clicarEmFecharCoockies();
	}

	@When("buscar/buscou pelo termo {string}")
	public void buscouPeloTermo(String termo) {
		homeSteps.informarTermoBusca(termo);
		homeSteps.clicarEmBuscar();
		termosBuscados = termo.split("\\s+");
	}

	@Then("o sistema deve listar todos os produtos relacionados ao termo")
	public void oSistemaDeveListarTodosOsProdutosRelacionadosAoTermo() {
		List<String> resultados = resultadoBuscaresultadoBuscaSteps.itensListados();
		ReportUtils.appendListToReportWithTitle(resultados, "Produtos Listados");
		resultados = resultados
				.stream()
				.map(String::toLowerCase)
				.collect(Collectors.toList());

		assertThat(resultados, everyItem(anyOf(containsAnyOfStrings(termosBuscados))));
	}

	@Then("o sistema deve exibir a mensagem {string}")
	public void oSistemaDeveExibirAMensagem(String mensagem) {
		assertThat(resultadoBuscaresultadoBuscaSteps.mensagemNaoEncontrado(), equalTo(mensagem));
	}
}