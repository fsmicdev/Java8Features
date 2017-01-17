package org.fsmicdev.play.java8features.streams.trivial;

import org.fsmicdev.play.java8features.domain.FinTrans;
import org.fsmicdev.play.java8features.domain.FinTransType;

import java.util.ArrayList;
import java.util.List;

/**
 * This class shows some - relatively simple - additions pertaining to streams-related (Collections) functionality
 * in Java 8:
 *
 *    o  forEach for iterating over collection items more succinctly,
 *    o  filter for selecting items matching some criteria (i.e. in a declarative fashion similar to a SQL 'WHERE' clause)
 *    o  map'ing an item to be used in a greater aggregation function - specifically, in the case below, to a sum
 *       aggregation function.
 *
 * @author mic
 */
public class ForEach {

    public ForEach(List<FinTrans> finTrans) {
        System.out.println("All Financial Transactions:");
        System.out.println("==========================");
        finTrans.stream().forEach(fT -> System.out.println(fT.toString()));

        System.out.println();

        System.out.println("Financial Transactions $50 and over:");
        System.out.println("===================================");
        finTrans.stream().filter(f -> f.getValue() >= 50).forEach(fT -> System.out.println(fT.toString()));

        System.out.println("\nTotal Cost of Financial Transactions $50 and over:");
        System.out.println("=================================================");
        System.out.println("[$]" + finTrans.stream().filter(f -> f.getValue() >= 50).mapToDouble(s -> s.getValue()).sum());
    }

    public static void main(String[] args) {
        FinTrans finTrans1 = new FinTrans();
        finTrans1.setId(1);
        finTrans1.setFinTransType(FinTransType.GROCERY);
        finTrans1.setValue(58.50);

        FinTrans finTrans2 = new FinTrans();
        finTrans2.setId(2);
        finTrans2.setFinTransType(FinTransType.CAR_MAINTENANCE);
        finTrans2.setValue(45.99);

        FinTrans finTrans3 = new FinTrans();
        finTrans3.setId(3);
        finTrans3.setFinTransType(FinTransType.GROCERY);
        finTrans3.setValue(75.0);

        FinTrans finTrans4 = new FinTrans();
        finTrans4.setId(4);
        finTrans4.setFinTransType(FinTransType.GROCERY);
        finTrans4.setValue(65.25);

        FinTrans finTrans5 = new FinTrans();
        finTrans5.setId(5);
        finTrans5.setFinTransType(FinTransType.GROCERY);
        finTrans5.setValue(19.40);

        List<FinTrans> finTrans = new ArrayList<>();
        finTrans.add(finTrans1);
        finTrans.add(finTrans2);
        finTrans.add(finTrans3);
        finTrans.add(finTrans4);
        finTrans.add(finTrans5);

        ForEach app = new ForEach(finTrans);
    }
}
