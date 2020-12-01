package br.com.magazineluiza.test.magalu.matchers;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class StringMatchers {

    public static Matcher<String>[] containsAnyOfStrings(String... termos) {
        Matcher<String>[] arrayMatchers = new Matcher[termos.length];
        for (int i = 0; i < termos.length; i++)
            arrayMatchers[i] = Matchers.containsString(termos[i]);
        return arrayMatchers;
    }
}