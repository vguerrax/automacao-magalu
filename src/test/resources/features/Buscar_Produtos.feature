Feature: Buscar Produtos

    Scenario: Buscar produto na tela inicial
        Given o cliente acessou a loja virtual
        When buscou pelo termo 'samsung galaxy s10'
        Then o sistema deve listar todos os produtos relacionados ao termo