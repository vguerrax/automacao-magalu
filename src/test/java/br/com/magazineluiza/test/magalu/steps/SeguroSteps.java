package br.com.magazineluiza.test.magalu.steps;

import br.com.magazineluiza.test.magalu.pages.SeguroPage;
import net.thucydides.core.annotations.Step;

public class SeguroSteps {

    private SeguroPage seguroPage;

    public boolean seguroExibido() {
        return seguroPage.seguroExibido();
    }

    @Step("Clicar no botão 'Continuar'")
    public void clicarEmContinuar() {
        seguroPage.clicarEmContinuar();
    }
}