package com.hemebiotech.analytics;

public class main {

    public static void main(String[] args) {

        /**
         * The function in the main class call getSymptoms. But this one call the others functions with the return, so calling getSymptoms = calling all functions
         * from AnalyticsCounter
         */
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        System.out.println(analyticsCounter.getSymptoms());
    }
}
