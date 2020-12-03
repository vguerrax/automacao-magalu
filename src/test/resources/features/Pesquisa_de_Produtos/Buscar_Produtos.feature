#language: pt
#encoding: utf-8

@pesquisa
Funcionalidade: Buscar Produtos

  Contexto: Acessar a loja virtual
    Dado que o cliente acessou a loja virtual

  @1
  Cenário: Buscar produto na tela inicial
    Quando buscar pelo termo 'samsung galaxy s10'
    Então o sistema deve listar todos os produtos relacionados ao termo

  @2
  Cenário: Buscar produto inexistente
    Quando buscar pelo termo '1234567890'
    Então o sistema deve exibir a mensagem
     """
     Sua busca por 1234567890 não encontrou resultado algum :(
     Por favor, tente outra vez com termos menos específicos
     """