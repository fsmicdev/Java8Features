package org.fsmicdev.play.java8features.functionstoprexistingobjects;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author micg
 */
public class ConcurrentHashMapUtilityFunctionalMethods {

    private void computeWordsCountViaComputeIfPresentMethod() {
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        String someStr =
                "Lorem ipsum dolor sit amet consetetur iam nonumy sadipscing " +
                        "elitr, sed diam nonumy eirmod tempor invidunt ut erat sed " +
                        "labore et dolore magna dolor sit amet aliquyam erat sed diam";

        wordCounts.put("sed", 0);
        wordCounts.put("erat", 0);
        wordCounts.put("magna", 0);

        for (String t : someStr.split(" ")) {
            wordCounts.computeIfPresent(t, (k,v) -> v+1);
        }

        System.out.println(wordCounts);
    }

    public static void main(String[] args) {
        ConcurrentHashMapUtilityFunctionalMethods app = new ConcurrentHashMapUtilityFunctionalMethods();
        app.computeWordsCountViaComputeIfPresentMethod();
    }
}
