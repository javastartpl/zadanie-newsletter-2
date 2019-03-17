package tablehandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many values your table contains, enter min. 3?");
        int tableLength = 0;
        while (tableLength < 3) {
            System.out.println("Enter table length, minimum 3 integer values:");
            tableLength = scanner.nextInt();
        }
        int[] table = new int[tableLength];
        System.out.println("Enter integers:");
        System.out.println("Confirm values by pressing enter");
        int i = 0;
        while (i < table.length) {
            table[i] = scanner.nextInt();
            i++;
        }
        System.out.print("wejście: ");
        for (int k = 0; k < table.length; k++) {
            if (k == tableLength - 1) {
                System.out.println(table[k]);
            } else System.out.print(table[k] + " , ");
        }
        System.out.print("wyjście: ");
        System.out.print("Najmniejsze pary ");
        TableHandler.printPairs(TableHandler.getMinSumCounter(table));
        System.out.print(", największe pary ");
        TableHandler.printPairs(TableHandler.getMaxSumCounter(table));
    }
}

