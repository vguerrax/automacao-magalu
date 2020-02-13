Feature: Carrinho

    Background: Buscar produto
        Given o cliente acessou a loja virtual
        And buscou pelo termo 'samsung galaxy s10'

    Scenario: Adicionar produto ao carrinho
        When selecionar um produto
        And adicionar o produto ao carrinho
        Then o sistema deve exibir o carrinho com o produto selecionado