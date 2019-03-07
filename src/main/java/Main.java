public class Main {

    public static void main(String[] args) throws Exception {


        int[] testTable = new int[]{0};

        TableProcessor processor = new TableProcessor();
        processor.printTable(testTable);

        System.out.println(processor.processTable(testTable));


    }
}
