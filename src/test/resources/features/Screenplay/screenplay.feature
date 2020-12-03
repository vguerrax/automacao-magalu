#language: pt
#encoding: utf-8

@screenplay
Funcionalidade: Buscar Produtos - Screenplay
  Como um consumidor
  João gostaria de realizar uma pesquisa
  Para localizar os produtos que deseja comprar

  Contexto:
    Dado que "João" acessou a página inicial

  Cenário: Buscar produto na tela inicial
    Quando ele pesquisa pelo termo 'samsung galaxy s10'
    Então ele deve ver a lista de todos os produtos relacionados ao termo

  Cenário: Buscar produto inexistente
    Quando ele pesquisa pelo termo '1234567890'
    Então ele deve ver a mensagem
     """
     Sua busca por 1234567890 não encontrou resultado algum :(
     Por favor, tente outra vez com termos menos específicos
     """