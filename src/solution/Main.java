package solution;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] input = Arrays.stream(args)
                .mapToInt(Integer::parseInt)
                .toArray();

        printMinAndMaxPairInArray(input);
    }

    private static void printMinAndMaxPairInArray(int[] arr) {
        Map<Integer, Set<String>> mapWithAllPairs = new HashMap<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int sumPairElementsInArray = arr[i] + arr[i + 1];
            String pair = arr[i] + "," + arr[i + 1];
            mapWithAllPairs
                    .computeIfAbsent(sumPairElementsInArray, k -> new HashSet<>())
                    .add(pair);
        }

        TreeSet<Integer> integers = new TreeSet<>(mapWithAllPairs.keySet());

        Set<String> minValuesFromMap = mapWithAllPairs.get(integers.first());
        Set<String> maxValuesFromMap = mapWithAllPairs.get(integers.last());

        printPairs(minValuesFromMap, maxValuesFromMap);
    }

    private static void printPairs(Set<String> minValuesFromMap, Set<String> maxValuesFromMap) {
        System.out.println("Najmniejsze pary: " + minValuesFromMap);
        System.out.println("Największe pary: " + maxValuesFromMap + "\n");
    }
}

