import java.util.Arrays;
import java.util.Set;

public class ResultCreator {

    private static String setPairsIntoString(Set<Integer[]> smallestPairsSet) {
        StringBuilder temp = new StringBuilder();
        for (Integer[] arr : smallestPairsSet) {
            temp.append("[")
                    .append(arr[0])
                    .append(",")
                    .append(arr[1])
                    .append("]")
                    .append(",");
        }

        if (temp.toString().endsWith(",")) {
            return temp.toString().substring(0, temp.toString().length() - 1);
        }
        return temp.toString();
    }

    public static String finalStringResult(Set<Integer[]> smallestPairsSet, Set<Integer[]> biggestPairsSet) {

        String result = "";

        if (Arrays.equals(biggestPairsSet.iterator().next(), smallestPairsSet.iterator().next())) {
            return "Both smallest and biggest pair is [" + biggestPairsSet.iterator().next()[0] + ", " + biggestPairsSet.iterator().next()[1] + "]";
        }

        if (smallestPairsSet.size() == 1) {
            Integer[] pair = smallestPairsSet.iterator().next();
            result += "Smallest pair is [" + pair[0] + "," + pair[1] + "] and ";

        } else if (smallestPairsSet.size() > 1) {
            result += "Smallest pairs are " + setPairsIntoString(smallestPairsSet).toString() + " and ";
        }

        if (biggestPairsSet.size() == 1) {
            Integer[] pair = biggestPairsSet.iterator().next();
            result += "biggest pair is [" + pair[0] + "," + pair[1] + "]";

        } else if (biggestPairsSet.size() > 1) {

            result += "biggest pairs are " + setPairsIntoString(biggestPairsSet).toString();
        }

        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
