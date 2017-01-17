package org.fsmicdev.play.java8features.streams.sequentialorparallel;

import org.fsmicdev.play.java8features.domain.FinTrans;
import org.fsmicdev.play.java8features.domain.IdenticalFinTransForGCJITPerformanceComparison;
import org.fsmicdev.play.java8features.domain.ListFinTrans;
import org.fsmicdev.play.java8features.domain.ListIdenticalFinTransForGCJITPerformanceComparison;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Parallel Java 8 stream processing on Collections is almost always usually preferred.  This is because of the multi-core,
 * threaded execution benefits presented in modern computers, and the utilisation of multiple threads inherent in the
 * encapsulated Java 8 stream methods.
 *
 * The one possible exception to the above rule, is some tasks are just so small that they're not worth parallelizing,
 * and parallelism does always have some overhead ( for example to manage threads ).
 *
 * In the below sequential versus parallel show-case stream processing examples, the parallel stream example for the
 * same 'sum' function is usually at least about 10 times faster for a relatively small set of collection items for a
 * moderate number of items, however for only 2 items parallel streaming can be slightly more expensive due to the
 * aforementioned slight overhead in thread management.
 *
 * N.B. The identical, but different named classes is to avoid JIT and JVM optimisation dramatically disturbing
 * 2nd test case calculation time outputs.
 * FMI See http://stackoverflow.com/questions/32032095/java-repeated-function-call-reduces-execution-time
 *
 * @autbor mic
 */
public class SequentialVsParallelStream {

    public void benchmarkTestCaseOne() {
        FinTrans finTrans1 = new FinTrans();
        finTrans1.setId(1);
        finTrans1.setValue(58.50);

        FinTrans finTrans2 = new FinTrans();
        finTrans2.setId(2);
        finTrans2.setValue(45.99);

        FinTrans finTrans3 = new FinTrans();
        finTrans3.setId(3);
        finTrans3.setValue(75.0);

        FinTrans finTrans4 = new FinTrans();
        finTrans4.setId(4);
        finTrans4.setValue(65.25);

        FinTrans finTrans5 = new FinTrans();
        finTrans5.setId(5);
        finTrans5.setValue(83.55);

        FinTrans finTrans6 = new FinTrans();
        finTrans6.setId(6);
        finTrans6.setValue(92.75);

        FinTrans finTrans7 = new FinTrans();
        finTrans7.setId(7);
        finTrans7.setValue(59.99);

        FinTrans finTrans8 = new FinTrans();
        finTrans8.setId(8);
        finTrans8.setValue(102.75);

        FinTrans finTrans9 = new FinTrans();
        finTrans9.setId(9);
        finTrans9.setValue(22.45);

        List<FinTrans> finTrans = new ArrayList<>();
        finTrans.add(finTrans1);
        finTrans.add(finTrans2);
        finTrans.add(finTrans3);
        finTrans.add(finTrans4);
        finTrans.add(finTrans5);
        finTrans.add(finTrans6);
        finTrans.add(finTrans7);
        finTrans.add(finTrans8);
        finTrans.add(finTrans9);
        finTrans.add(finTrans8);
        finTrans.add(finTrans7);
        finTrans.add(finTrans6);
        finTrans.add(finTrans5);
        finTrans.add(finTrans4);
        finTrans.add(finTrans3);
        finTrans.add(finTrans2);
        finTrans.add(finTrans1);

        ListFinTrans listFinTrans = new ListFinTrans(finTrans);

        sumViaSequentialStream(listFinTrans);
        sumViaParallelStream(listFinTrans);
    }

    public void benchmarkTestCaseTwo() {
        IdenticalFinTransForGCJITPerformanceComparison aFinTrans1 = new IdenticalFinTransForGCJITPerformanceComparison();
        aFinTrans1.setId(1);
        aFinTrans1.setValue(58.50);

        IdenticalFinTransForGCJITPerformanceComparison aFinTrans2 = new IdenticalFinTransForGCJITPerformanceComparison();
        aFinTrans2.setId(2);
        aFinTrans2.setValue(45.99);

        IdenticalFinTransForGCJITPerformanceComparison aFinTrans3 = new IdenticalFinTransForGCJITPerformanceComparison();
        aFinTrans3.setId(3);
        aFinTrans3.setValue(75.0);

        IdenticalFinTransForGCJITPerformanceComparison aFinTrans4 = new IdenticalFinTransForGCJITPerformanceComparison();
        aFinTrans4.setId(4);
        aFinTrans4.setValue(22.75);

        IdenticalFinTransForGCJITPerformanceComparison aFinTrans5 = new IdenticalFinTransForGCJITPerformanceComparison();
        aFinTrans5.setId(5);
        aFinTrans5.setValue(89.95);

        List<IdenticalFinTransForGCJITPerformanceComparison> smallNumFinTrans = new ArrayList<>();
        smallNumFinTrans.add(aFinTrans1);
        smallNumFinTrans.add(aFinTrans2);

        ListIdenticalFinTransForGCJITPerformanceComparison listIdenticalFinTransForGCJITPerformanceComparison =
                new ListIdenticalFinTransForGCJITPerformanceComparison(smallNumFinTrans);

        sumTwoViaSequentialStream(listIdenticalFinTransForGCJITPerformanceComparison);
        sumTwoViaParallelStream(listIdenticalFinTransForGCJITPerformanceComparison);
    }

    public double sumViaSequentialStream(ListFinTrans finTransList) {
        if (finTransList != null) {
            List<FinTrans> finTrans = finTransList.getFinTransList();

            Instant startTime = Instant.now();
            double sequenSumTime = finTrans.stream().filter(f -> f.getValue() > 0).mapToDouble(s -> s.getValue()).sum();
            Instant endTime = Instant.now();

            System.out.println("sumViaSequentialStream milliseconds time for " + finTrans.size() + " items: " +
                    Duration.between(startTime, endTime).toMillis());

            return sequenSumTime;
        } else {
            return 0;
        }
    }

    public double sumViaParallelStream(ListFinTrans finTransList) {
        if (finTransList != null) {
            List<FinTrans> finTrans = finTransList.getFinTransList();

            Instant startTime = Instant.now();
            double parallelSumTime = finTrans.parallelStream().filter(f -> f.getValue() > 0).mapToDouble(s -> s.getValue()).sum();
            Instant endTime = Instant.now();

            System.out.println("sumViaParallelStream milliseconds time for " + finTrans.size() + " items: " +
                    Duration.between(startTime, endTime).toMillis());


            return parallelSumTime;
        } else {
            return 0;
        }
    }

    public double sumTwoViaSequentialStream(ListIdenticalFinTransForGCJITPerformanceComparison finTransList) {
        if (finTransList != null) {
            List<IdenticalFinTransForGCJITPerformanceComparison> finTrans = finTransList.getFinTransList();

            Instant startTime = Instant.now();
            double sequenSumTime = finTrans.stream().filter(f -> f.getValue() > 0).mapToDouble(s -> s.getValue()).sum();
            Instant endTime = Instant.now();

            System.out.println("sumViaSequentialStream milliseconds time for " + finTrans.size() + " items: " +
                    Duration.between(startTime, endTime).toMillis());

            return sequenSumTime;
        } else {
            return 0;
        }
    }

    public double sumTwoViaParallelStream(ListIdenticalFinTransForGCJITPerformanceComparison finTransList) {
        if (finTransList != null) {
            List<IdenticalFinTransForGCJITPerformanceComparison> finTrans = finTransList.getFinTransList();

            Instant startTime = Instant.now();
            double parallelSumTime = finTrans.parallelStream().filter(f -> f.getValue() > 0).mapToDouble(s -> s.getValue()).sum();
            Instant endTime = Instant.now();

            System.out.println("sumViaParallelStream milliseconds time for " + finTrans.size() + " items: " +
                    Duration.between(startTime, endTime).toMillis());


            return parallelSumTime;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SequentialVsParallelStream app = new SequentialVsParallelStream();
    }
}
