import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Kamil on 2019-03-06.
 */
public class PairSearch {
    public void findPairs(int[] tab) {
        List<Pair> minResults = new LinkedList<>();
        List<Pair> maxResults = new LinkedList<>();
        Pair pair;
        int min, max, tmp;

        min = max = tab[0] + tab[1];

        for (int i = 0; i < tab.length; i++) {
            if (i + 1 == tab.length) {
                break;
            }
            tmp = tab[i] + tab[i + 1];
            pair = new Pair(tab[i], tab[i + 1]);
            if (tmp < min) {
                if (minResults.size() == 0) {
                    minResults.add(pair);
                } else {
                    minResults.set(0, pair);
                }
                min = tmp;
            } else if (tmp == min) {
                minResults.add(pair);
                min = tmp;
            } else if (tmp > max) {
                if (maxResults.size() == 0) {
                    maxResults.add(pair);
                } else {
                    maxResults.set(0, pair);
                }
                max = tmp;
            } else if (tmp == max) {
                maxResults.add(pair);
                max = tmp;
            }
        }
        System.out.println("Min:");
        showPairs(convertToSet(minResults));
        System.out.println("Max");
        showPairs(convertToSet(maxResults));
    }

    private void showPairs(Set<Pair> result) {
        for (Pair x : result) {
            System.out.println("[" + x.getX() + ", " + x.getY() + "]");
        }
    }

    private Set<Pair> convertToSet(List<Pair> resultList) {
        Set<Pair> resultSet = new HashSet<>();
        for (int i = 0; i < resultList.size(); i++) {
            resultSet.add(resultList.get(i));
        }
        return resultSet;
    }
}
