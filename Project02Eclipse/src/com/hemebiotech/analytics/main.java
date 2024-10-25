package com.hemebiotech.analytics;

public class main {

    /**
     * The function in the main class call getSymptoms. But this one call the others functions with the return, so calling getSymptoms = calling all functions
     * from AnalyticsCounter
     */
    public static void main(String[] args) {

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        analyticsCounter.getSymptoms();
    }
}
