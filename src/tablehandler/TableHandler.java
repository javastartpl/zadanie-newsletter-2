package tablehandler;

class TableHandler {

    static int[] getMaxSumCounter(int[] table) {
        int maxSum = table[0] + table[1];
        int currentSum;
        int[] temp = {table[0], table[1]};
        for (int i = 0; i < table.length - 1; i++) {
            int j = i + 1;
            if (i != 0 || j != 1) {
                currentSum = table[i] + table[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    int[] temp2 = new int[2];
                    temp2[0] = table[i];
                    temp2[1] = table[j];
                    temp = temp2;
                } else {
                    temp = checkDuplicates(table, maxSum, currentSum, temp, i, j);
                }
            }
        }
        return temp;
    }


    static int[] getMinSumCounter(int[] table) {
        int minSum = table[0] + table[1];
        int currentSum;
        int[] temp = {table[0], table[1]};
        for (int i = 0; i < table.length - 1; i++) {
            int j = i + 1;
            if (i != 0 || j != 1) {
                currentSum = table[i] + table[j];
                if (currentSum < minSum) {
                    minSum = currentSum;
                    int[] temp2 = new int[2];
                    temp2[0] = table[i];
                    temp2[1] = table[j];
                    temp = temp2;

                } else {
                    temp = checkDuplicates(table, minSum, currentSum, temp, i, j);
                }
            }
        }
        return temp;
    }

    private static int[] checkDuplicates(int[] table, int minSum, int currentSum, int[] temp, int i, int j) {
        if (currentSum == minSum) {
            int n = 0;//duplicate
            for (int l = 0; l < temp.length - 1; l = l + 2) {
                int m = l + 1;
                if (table[i] == temp[l] && table[j] == temp[m]) {
                    n++;
                }
            }
            if (n == 0) {
                int[] temp2 = new int[temp.length + 2];
                for (int z = 0; z < temp2.length; z++) {
                    if (z < temp.length) {
                        temp2[z] = temp[z];
                    }
                }
                temp2[temp.length] = table[i];
                temp2[temp.length + 1] = table[j];
                temp = temp2;
            }

        }
        return temp;
    }

    public static void printPairs(int[] pairsTable) {
        for (int i = 0; i < pairsTable.length - 1; i = i + 2) {
            System.out.print("[" + pairsTable[i] + " , " + pairsTable[i + 1] + "] ");
        }
    }
}

