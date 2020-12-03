package br.com.magazineluiza.test.magalu.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.serenitybdd.core.Serenity.recordReportData;

public class ReportUtils {

    private static String concatBreakLine(String str) {
        return String.join("\n", str);
    }

    public static void appendListToReportWithTitle(List<String> list, String title) {
        String content = String.join("\n", list);
        recordReportData()
                .asEvidence()
                .withTitle(title)
                .andContents(content);
    }
}
