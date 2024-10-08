package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    private void writeSymptoms(Map<String, Integer> symptoms) {

    }

    boolean containsKey(String readLine);

    Object get(String s);

    void put(String readLine, Object o);
}

