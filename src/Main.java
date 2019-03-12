import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {-5, 0, 10, -5, 0, 5, 5};
        int[] arr3 = {-5, 0, 5, -10, 5, 15};

        searchMinAndMaxPairInArray(arr);
        searchMinAndMaxPairInArray(arr2);
        searchMinAndMaxPairInArray(arr3);
    }

    private static void searchMinAndMaxPairInArray(int[] arr) {
        Map<Integer, List<String>> mapWithAllPairs = new HashMap<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int sumPairElementsInArray = arr[i] + arr[i + 1];
            String pair = arr[i] + "," + arr[i + 1];
            mapWithAllPairs
                    .computeIfAbsent(sumPairElementsInArray, k -> new ArrayList<>())
                    .add(pair);
        }

        int max = mapWithAllPairs
                .keySet()
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("The largest key in the map can not be found"));

        int min = mapWithAllPairs
                .keySet()
                .stream()
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("The smallest key in the map can not be found"));

        List<String> minValuesFromMap = mapWithAllPairs.get(min);
        List<String> deduplicateMinValuesFromMap = minValuesFromMap
                .stream()
                .distinct()
                .collect(Collectors.toList());

        List<String> maxValuesFromMap = mapWithAllPairs.get(max);
        List<String> deduplicateMaxValuesFromMap = maxValuesFromMap
                .stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Najmniejsze pary: " + deduplicateMinValuesFromMap);
        System.out.println("Największe pary: " + deduplicateMaxValuesFromMap);
    }
}

