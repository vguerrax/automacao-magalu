package br.com.magazineluiza.test.magalu.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class CastHook {

    @Before
    public void defineCast() {
        setTheStage(new OnlineCast());
    }
}
