package pl.dkunert.newsletter2.service;

import pl.dkunert.newsletter2.model.ArrayPairsDetails;
import pl.dkunert.newsletter2.model.IntTuple;

import java.util.*;

public class ArrayDetailsResolvingService {

    public ArrayPairsDetails findLowestAndHighestPairs(int[] integers) {
        HashMap<Integer, Set<IntTuple>> arrayPairs = new HashMap<>();

        for (int i = 0; i < integers.length - 1; i++) {
            IntTuple tuple = new IntTuple(integers[i], integers[i + 1]);
            arrayPairs.computeIfAbsent(tuple.getSum(), value -> new HashSet<>());
            arrayPairs.computeIfPresent(tuple.getSum(), (key, value) -> {
                value.add(tuple);
                return value;
            });
        }

        TreeSet treeSet = new TreeSet(arrayPairs.keySet());

        return new ArrayPairsDetails(
                arrayPairs.get(treeSet.first()),
                arrayPairs.get(treeSet.last())
        );
    }
}
