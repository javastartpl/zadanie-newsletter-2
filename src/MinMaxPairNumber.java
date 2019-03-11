import java.util.ArrayList;
import java.util.Map;

public class MinMaxPairNumber {
    public static void main(String[] args) {
        ReadNumber readNumber = new ReadNumber();
        //int[] tableNumber={-5, 0, 5, -10, 5, 15};
        int[] tableNumber = readNumber.readNumberList();
        Map<Integer, ArrayList<Pair>> map = PairMap.listToMap(tableNumber);
        readNumber.closeScanner();
        System.out.println(PrintResult.printResult(map));
    }
}
