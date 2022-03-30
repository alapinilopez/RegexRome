package edu.poniperro;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private final String romanNum;
    private int decimalNum;

    private Regex regexCollection;

    public RomanNumber(String romanNum) {
        this.romanNum = romanNum;
        this.decimalNum = 0;
        regexCollection = new Regex();
    }

    public Regex getRegexCollection() {
        return this.regexCollection;
    }


    private int getNumeroDecimal() {
        return this.decimalNum;
    }

    public void addRegex(String description, String regex) {
        this.getRegexCollection().addRegex(description, regex);
    }

    public int toDecimal() {
        for(String regex : regexCollection()) {
            Matcher matcher = createMatcher(regex);
            groupSumatoryToDecimal(matcher);
        }
        return getNumeroDecimal();
    }

    private List<String> regexCollection() {
        return getRegexCollection().getAllRegex();
    }

    private Matcher createMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.romanNum);
        return matcher;
    }

    private void groupSumatoryToDecimal(Matcher matcher) {
        while (matcher.find()) {
            this.decimalNum += decimalValue(matcher.group());
        }
    }

    public int decimalValue(String romanNum) {
        RomanSymbols symbol = Enum.valueOf(RomanSymbols.class, String.valueOf(romanNum));
        return (int) symbol.getDecimalValue();
    }

    @Override
    public String toString() {
        return this.romanNum;
    }


}
