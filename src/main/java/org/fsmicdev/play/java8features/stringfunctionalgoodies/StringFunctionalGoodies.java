package org.fsmicdev.play.java8features.stringfunctionalgoodies;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * @mic
 */
public class StringFunctionalGoodies {

    public static String joinStringsWithDelimeter(String delimeter) {
        return String.join(delimeter, "Are", "you", "being", "serious");
    }

    public static String sortStringsMatchingPatternMatch(String patternMatch, String strIn, String delimeter) {
        return Pattern.compile(":")
                .splitAsStream(strIn)
                .filter(s -> s.contains(patternMatch))
                .sorted()
                .collect(Collectors.joining(delimeter));
    }

    public static long regexFunctionallyAppliedInPredicate() {
        Pattern pattern = Pattern.compile(".*@gmail\\.com");

        return Stream.of("bob@gmail.com", "alice@hotmail.com", "simon@gmail.com", "simon@somewhere.net")
                .filter(pattern.asPredicate())
                .count();
    }

    public static void main(String[] args) {
        System.out.println("\n" + StringFunctionalGoodies.joinStringsWithDelimeter(":"));
        System.out.println("\n" + StringFunctionalGoodies.joinStringsWithDelimeter("---"));

        System.out.println("\n" + StringFunctionalGoodies.sortStringsMatchingPatternMatch("Mic", "Mic:Micky:Michelangelo:Mik:Michael", ":"));
        System.out.println("\n" + StringFunctionalGoodies.sortStringsMatchingPatternMatch("sta", "stand:stare:stop:statistical", "*"));

        System.out.println("\n" + StringFunctionalGoodies.regexFunctionallyAppliedInPredicate());
    }
}
