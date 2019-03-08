import java.util.ArrayList;
import java.util.List;

public class Test {

    private static int sumaMax;
    private static int paraMax1;
    private static int paraMax2;

    private static int sumaMin;
    private static int paraMin1;
    private static int paraMin2;

    private static List<Integer> listmax = new ArrayList<>();
    private static  List<Integer> listmin = new ArrayList<>();

    private static void findExtremeVelues(int[] tab) {
        // Znalezienie największej i najmniejszej pary w tablicy
        for (int i = 0; i < tab.length - 1; i++) {
            if ((tab[i] + tab[i + 1]) > sumaMax) {
                sumaMax = tab[i] + tab[i + 1];
                paraMax1 = tab[i];
                paraMax2 = tab[i + 1];
            }

            if ((tab[i] + tab[i + 1]) < sumaMin) {
                sumaMin = tab[i] + tab[i + 1];
                paraMin1 = tab[i];
                paraMin2 = tab[i + 1];
            }

        }
    }

    private static void createResultList(int[] tab, List<Integer> listmax, List<Integer> listmin) {
        //Tworzenie listy wyników
        for (int i = 0; i < tab.length - 1; i++) {
            if ((tab[i] + tab[i + 1]) == sumaMax) {
                listmax.add(tab[i]);
                listmax.add(tab[i + 1]);
            }

            if (tab[i] + tab[i + 1] == sumaMin) {
                listmin.add(tab[i]);
                listmin.add(tab[i + 1]);
            }

        }
    }

    private static void printPairs(List<Integer> list) {

        int print1 = list.get(0);
        int print2 = list.get(1);

        System.out.print("[" + print1 + ",");
        System.out.print(print2 + "]");

        for (int i = 2; i < list.size() - 1; i++) {

            if (list.get(i) != print1 && list.get(i + 1) != print2) {
                System.out.print("[" + list.get(i) + ",");
                System.out.print(list.get(i + 1) + "]");
                print1 = list.get(i);
                print2 = list.get(i + 1);
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        int tab[] = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            tab[i] = Integer.parseInt(args[i]);
        }

        sumaMax = tab[0] + tab[1];
        paraMax1 = tab[0];
        paraMax2 = tab[1];

        sumaMin = sumaMax;
        paraMin1 = tab[0];
        paraMin2 = tab[1];

        findExtremeVelues(tab);

        createResultList(tab, listmax, listmin);

        System.out.println("Największa para ");
        printPairs(listmax);

        System.out.println("Najmniejsza para ");
        printPairs(listmin);

    }

}
