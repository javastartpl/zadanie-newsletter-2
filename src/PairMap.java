import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PairMap {

    public static Map<Integer, ArrayList<Pair>> listToMap(int[] tab) {
        Map<Integer, ArrayList<Pair>> pairMap = new HashMap<>();
        for (int i = 0; i < tab.length; i++) {
            if (i < tab.length - 1) {
                Pair pair = new Pair(tab[i], tab[i + 1]);
                int sum = pair.sum();
                if (pairMap.containsKey(sum)) {
                    ArrayList<Pair> pairList = pairMap.get(sum);
                    pairList.add(pair);
                    pairMap.put(sum, pairList);
                    pairList = null;
                } else {
                    ArrayList<Pair> pairList = new ArrayList<>();
                    pairList.add(pair);
                    pairMap.put(sum, pairList);
                    pairList = null;
                }
            }
        }
        return pairMap;
    }


}
