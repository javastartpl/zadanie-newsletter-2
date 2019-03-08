package zadania.newsletter;


    /*Napisz program, który spośród tablicy liczb całkowitych wybierze takie pary następujących po sobie liczb,
    dla których suma jest najmniejsza lub największa. W przypadku, gdy istnieje kilka par,
    dla których suma jest najmniejsza lub największa, to użytkownik powinien zobaczyć je wszystkie.
    Jeżeli jakaś para liczb się powtarza, to powinna być uwzględniona tylko raz.
    Tablicę liczb przekaż jako argument wywołania programu.*/

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PairPicker {
    public static void main(String[] args) {
        // Przykład argumentu wywołania programu: "[-5, 0, 10, -5, 0, 5, 5]"
        String arrayString = args[0];

        int[] ints = Arrays.stream(arrayString.substring(1, arrayString.length()-1).split(", "))
                .mapToInt(Integer::parseInt).toArray();



        Map<String,Integer> myMap = generateMap(ints);
        int minSum = getMinSum(myMap);
        int maxSum = getMaxSum(myMap);

        System.out.print("Najmniejsze pary: ");
        for (Map.Entry<String,Integer> e : myMap.entrySet()) {
            if(e.getValue()==minSum){
                System.out.print(e.getKey() + ", ");
            }
        }

        System.out.print("Największe pary : ");
        for (Map.Entry<String,Integer> e : myMap.entrySet()) {
            if(e.getValue()==maxSum){
                System.out.print(e.getKey() + ", ");
            }
        }





    }



    public static Map<String,Integer> generateMap(int[] ints){
        Map<String,Integer> sumMap = new LinkedHashMap<>();
        for (int i = 0; i < ints.length -1; i++) {
            int sum;
            int value1 =  ints[i];
            int value2 =  ints[i+1];
            sum = value1 + value2;
            sumMap.put("["+value1+","+value2+"]",sum);
        }
        return sortMapByValue(sumMap);
    }



    private static Map<String,Integer> sortMapByValue(Map<String,Integer> inputMap){
        Map<String,Integer> sortedBySum = inputMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1 ,LinkedHashMap::new));
        return sortedBySum;
    }


    public static int getMinSum(Map<String,Integer> inputMap){
        int minSum = inputMap.values()
                .stream()
                .findFirst()
                .get();
        return minSum;
    }


    public static int getMaxSum(Map<String,Integer> inputMap){
        int maxValue = inputMap.values()
                .stream()
                .skip((inputMap.size())-1)
                .findFirst()
                .get();
        return maxValue;
    }





}
