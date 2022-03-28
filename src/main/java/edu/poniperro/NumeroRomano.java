package edu.poniperro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumeroRomano {
    private String numeroRomano;

    public NumeroRomano() {}

    public NumeroRomano(String numeroRomano) {
        this.numeroRomano= numeroRomano;
    }

    public String getNumeroRomano() {
        return this.numeroRomano;
    }

    String regex = "[M]";

    public int toDecimal() {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(getNumeroRomano());
        int sum = 0;
        if (m.find()) {
            return 1000;
        }
        return sum;
    }
}
