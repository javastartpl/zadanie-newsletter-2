import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise_2 {
    public static void main(String[] args) {
        checkArgs(args);
        int[] sumOfPair = getSumsOfPair(args);
        int maxValue = Arrays.stream(sumOfPair).max().getAsInt();
        int minValue = Arrays.stream(sumOfPair).min().getAsInt();

        String maxPrefix = "Najwieksza para";
        String minPrefix = "Najmniejsza para";
        if (countOccurance(maxValue, sumOfPair) >= 2) maxPrefix = "Największe pary";
        if (countOccurance(minValue, sumOfPair) >= 2) minPrefix = "Najmniejsze pary";

        StringBuilder maxMessage = new StringBuilder(maxPrefix);
        StringBuilder minMessage = new StringBuilder(minPrefix);
        for (int i = 0; i < args.length - 1; i++) {
            if ((Integer.valueOf(args[i]) + Integer.valueOf(args[i + 1])) == minValue && (!minMessage.toString().contains(args[i] + ", " + args[i + 1]))) {
                buildMessage(args, minMessage, i);
            }
            if ((Integer.valueOf(args[i]) + Integer.valueOf(args[i + 1])) == maxValue && (!maxMessage.toString().contains(args[i] + ", " + args[i + 1]))) {
                buildMessage(args, maxMessage, i);
            }
        }
        showResults(maxMessage, minMessage);

    }

    private static void buildMessage(String[] args, StringBuilder minMessage, int i) {
        minMessage.append("[" + args[i] + ", " + args[i + 1] + "]");
    }

    private static void showResults(StringBuilder maxMessage, StringBuilder minMessage) {
        System.out.println(minMessage.toString());
        System.out.println(maxMessage.toString());
    }

    private static int[] getSumsOfPair(String[] args) {
        int[] sumOfPair = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            sumOfPair[i] = Integer.valueOf(args[i]) + Integer.valueOf(args[i + 1]);
        }
        return sumOfPair;
    }

    private static void checkArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("Nie podano argumentow przy starcie programu");
            System.exit(0);
        }
    }

    private static int countOccurance(int value, int[] sumOfPair) {
        int count = 0;
        for (int i = 0; i < sumOfPair.length - 1; i++) {
            if (value == sumOfPair[i]) count++;
        }
        return count;
    }


}
