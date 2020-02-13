Feature: Carrinho

    Background: Buscar produto
        Given o cliente acessou a loja virtual
        And buscou pelo termo 'samsung galaxy s10'

    Scenario: Adicionar produto ao carrinho
        When selecionar um produto
        And adicionar o produto ao carrinho
        Then o sistema deve exibir o carrinho com o produto selecionado

    Scenario: Remover produto do carrinho
        And adicionou um produto ao carrinho
        When solicitar excluir o produto do carrinho
        Then o sistema deve exibir a mensagem 'Sua sacola está vazia' informando que o carrinho esta vazio