package org.fsmicdev.play.java8features.foreach;

import java.util.HashMap;
import java.util.Map;

public class MapIterationViaForEach {

    public static void main(String args[]) {
        Map<String, String> stateTerritoryToCapitalMap = new HashMap<>();
        stateTerritoryToCapitalMap.put("Queensland", "Brisbane");
        stateTerritoryToCapitalMap.put("New South Wales", "Sydney");
        stateTerritoryToCapitalMap.put("Victoria", "Melbourne");
        stateTerritoryToCapitalMap.put("South Australia", "Adelaide");
        stateTerritoryToCapitalMap.put("Tasmania", "Hobart");
        stateTerritoryToCapitalMap.put("Western Australia", "Perth");
        stateTerritoryToCapitalMap.put("Northern Territory", "Darwin");
        stateTerritoryToCapitalMap.put("Australian Capital Territory", "Canberra");

        System.out.println("Iterating a Map using Java 8's forEach");
        System.out.println("--------------------------------------");

        stateTerritoryToCapitalMap.forEach((k, v)->System.out.println("\nState/Territory: " + k + "\n\tCapital: " + v));

        System.out.println("-----------------------------------------------------------");
    }

}