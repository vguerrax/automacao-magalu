Feature: Buscar Produtos

    Background: Acessar a loja virtual
        Given o cliente acessou a loja virtual

    Scenario: Buscar produto na tela inicial
        When buscar pelo termo 'samsung galaxy s10'
        Then o sistema deve listar todos os produtos relacionados ao termo

    Scenario: Buscar produto inexistente
        When buscar pelo termo '1234567890'
        Then o sistema deve exibir a mensagem 'Sua busca por #termo# não encontrou resultado algum :('