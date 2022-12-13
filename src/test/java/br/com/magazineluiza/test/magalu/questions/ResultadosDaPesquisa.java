package br.com.magazineluiza.test.magalu.questions;

import br.com.magazineluiza.test.magalu.pages.ResultadoBuscaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

public class ResultadosDaPesquisa implements Question<List<String>> {

    @Override
    @Step("{0} vê os resultados da pesquisa")
    public List<String> answeredBy(Actor actor) {
        return Text.of(ResultadoBuscaPage.ITENS_LISTADOS)
                .asListOf(String.class)
                .answeredBy(actor)
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public static Question<List<String>> exibidos() {
        return new ResultadosDaPesquisa();
    }
}
