package org.fsmicdev.play.java8features.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 *
 * @mic
 */
public class ComparableFutureAsync {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(5, 15, 30, 50, 75);

        list.stream().map(data -> CompletableFuture.supplyAsync(() -> getNumber(data))).
                map(compFuture->compFuture.thenApply(n->n*n)).map(t -> t.join())
                .forEach(s -> System.out.println(s));
    }

    private static int getNumber(int a){
        return a * a / 2;
    }
}


