package org.fsmicdev.play.java8features.streams.combinedexample;

import org.fsmicdev.play.java8features.domain.FinTrans;
import org.fsmicdev.play.java8features.domain.FinTransType;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

/**
 * This example demonstrates Java 8 streams processing on collections, in particular:
 *
 *    o filter'ing (i.e. PREDICATE part),
 *    o sort'ing (via specified COMPARATOR key, and reverse [directional] function declaration),
 *    o map'ing FUNCTION to discrete property (or whole object),
 *    o collect'ing the resulted sorted elements in List format COLLECTion output.
 *
 * @author mic
 */
public class MostExpensiveGroceryTrans {

    public MostExpensiveGroceryTrans(List<FinTrans> finTransIn, FinTransType finTransType) {
        List<Double> transValues = filterAndSortValuesByMostExpensive(finTransIn, finTransType);
        System.out.println("SORTED descending financial values transValues: " + transValues);

        List<FinTrans> finTrans = filterAndSortFinTransByMostExpensive(finTransIn, finTransType);
        System.out.println("\nSORTED descending financial values  finTrans: " + finTrans);
    }

    private  List<Double> filterAndSortValuesByMostExpensive(List<FinTrans> finTransIn, FinTransType finTransType) {
        List<Double> transIdsAndValues =
                finTransIn.stream()
                        .filter(t -> t.getFinTransType() == finTransType)
                        .sorted(comparing(FinTrans::getValue, reverseOrder()))
                        .map(FinTrans::getValue)
                        .collect(toList());

        return transIdsAndValues;
    }

    private  List<FinTrans> filterAndSortFinTransByMostExpensive(List<FinTrans> finTransIn, FinTransType finTransType) {
        List<FinTrans> transIdsAndValues =
                finTransIn.stream()
                        .filter(t -> t.getFinTransType() == finTransType)
                        .sorted(comparing(FinTrans::getValue, reverseOrder()))
                        .map(FinTrans::getThis)
                        .collect(toList());

        return transIdsAndValues;
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

        MostExpensiveGroceryTrans app = new MostExpensiveGroceryTrans(finTrans, FinTransType.GROCERY);
    }
}
