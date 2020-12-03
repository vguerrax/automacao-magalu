package br.com.magazineluiza.test.magalu.matchers;

import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.containsString;

public class StringMatchers {

    public static Matcher<String>[] containsAnyOfStrings(String... termos) {
        Matcher<String>[] arrayMatchers = new Matcher[termos.length];
        for (int i = 0; i < termos.length; i++)
            arrayMatchers[i] = containsString(termos[i]);
        return arrayMatchers;
    }
}