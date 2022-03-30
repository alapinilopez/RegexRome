package edu.poniperro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Regex {

    protected final Map <String, String> symbolsRulesCollection = new HashMap<String, String>();

    public Regex() {
        fillCollection();
    }
    protected void addRegex(String key, String value) {
        symbolsRulesCollection.putIfAbsent(key, value);
    }

    private void fillCollection() {
        addRegex("summatorySymbols", "(?<!C)[D]|(?<!C)[M]|(?<!X)[L](?![D])|(?<!X)[C](?![M])|(?<!I)[V](?![L])|(?<!I)[X](?![C])|I(?![V])|I(?![X])");
        addRegex("substractiveSymbols", "C(?=[DM])|X(?=[LC])|I(?=[VX])");
    }

    public String getRegex(String key) {
        return symbolsRulesCollection.get(key);
    }

    public List<String> getAllRegex() {
        return new ArrayList<>(symbolsRulesCollection.values());
    }

}
