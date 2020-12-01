package br.com.magazineluiza.test.magalu.steps;

import br.com.magazineluiza.test.magalu.pages.DetalhesProdutoPage;

public class DetalhesProdutoSteps{

    private DetalhesProdutoPage detalhesProdutoPage;

    public String clicarEmAdicionarAoCarrinho() {
        return detalhesProdutoPage.clicarEmAdicionarAoCarrinho();
    }
}