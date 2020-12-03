#language: pt
#encoding: utf-8

@carrinho
Funcionalidade: Carrinho

  Contexto: Buscar produto
    Dado que o cliente acessou a loja virtual
    E buscou pelo termo 'samsung galaxy s10'

  @3
  Cenário: Adicionar produto ao carrinho
    Quando selecionar um produto
    E adicionar o produto ao carrinho
    Então o sistema deve exibir o carrinho com o produto selecionado

  @4
  Cenário: Remover produto do carrinho
    E adicionou um produto ao carrinho
    Quando solicitar excluir o produto do carrinho
    Então o sistema deve exibir a mensagem 'Sua sacola está vazia' informando que o carrinho esta vazio