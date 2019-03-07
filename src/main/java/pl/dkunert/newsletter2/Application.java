package pl.dkunert.newsletter2;

import pl.dkunert.newsletter2.model.ArrayPairsDetails;
import pl.dkunert.newsletter2.service.ArrayDetailsResolvingService;

import java.util.Arrays;

public class Application {

    // Run args example: -5 0 10 -5 0 5 5
    public static void main(String[] args) {
        ArrayDetailsResolvingService arrayDetailsResolvingService = new ArrayDetailsResolvingService();

        ArrayPairsDetails result = arrayDetailsResolvingService.findLowestAndHighestPairs(Arrays.asList(args).stream().mapToInt(Integer::parseInt).toArray());
        System.out.println(result); // ArrayPairsDetails{lowestPairs=[IntTuple{first=-5, second=0}], highestPairs=[IntTuple{first=5, second=5}, IntTuple{first=0, second=10}]}
    }
}
