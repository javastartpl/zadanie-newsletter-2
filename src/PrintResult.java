import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class PrintResult {

    private static int max(Map<Integer, ArrayList<Pair>> map) {
        int max = Collections.max(map.keySet());
        return max;
    }

    private static int min(Map<Integer, ArrayList<Pair>> map) {
        int min =Collections.min(map.keySet());
        return min;
    }

    public static String printResult(Map<Integer, ArrayList<Pair>> map) {
        int max = max(map);
        int min = min(map);
        String textMinOut = null;
        String textMaxOut = null;
        String textOut = null;
        for (Map.Entry<Integer, ArrayList<Pair>> enty : map.entrySet()) {
            if(enty.getKey() == min&&enty.getKey() == max) {
                textMinOut = "Najmniejsza para ";
                textMaxOut = "największa para ";
                for (Pair pair : enty.getValue()) {
                    textMinOut = textMinOut + "[" + pair.getFirst() + "," + pair.getSecond() + "], ";
                    textMaxOut = textMaxOut + "[" + pair.getFirst() + "," + pair.getSecond() + "]";
                }

            }else if (enty.getKey() == min) {
                int listElements = enty.getValue().size();
                if (listElements == 1) {
                    textMinOut = "Najmniejsza para ";
                } else {
                    textMinOut = "Najmniejsze pary ";
                }
                for (Pair pair : enty.getValue()) {
                    textMinOut = textMinOut + "[" + pair.getFirst() + "," + pair.getSecond() + "], ";

                }

            } else if (enty.getKey() == max) {
                int listElements = enty.getValue().size();
                if (listElements == 1) {
                    textMaxOut = "największa para ";
                    for (Pair pair : enty.getValue()) {
                        textMaxOut = textMaxOut + "[" + pair.getFirst() + "," + pair.getSecond() + "]";
                    }
                } else {
                    textMaxOut = "największe pary ";
                    for (int i = 0; i < enty.getValue().size(); i++) {
                        if (i < enty.getValue().size() - 1) {
                            textMaxOut = textMaxOut + "[" + enty.getValue().get(i).getFirst() + "," + enty.getValue().get(i).getSecond() + "], ";
                        } else {
                            textMaxOut = textMaxOut + "[" + enty.getValue().get(i).getFirst() + "," + enty.getValue().get(i).getSecond() + "]";
                        }
                    }
                }
            }

        }
        textOut = textMinOut + textMaxOut;
        return textOut;
    }

}
