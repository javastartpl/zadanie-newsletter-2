import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ReadNumber {
    private Scanner sc = new Scanner(System.in);

    public ReadNumber() {
        sc.useLocale(Locale.US);
    }

    public void closeScanner() {
        sc.close();
    }


    public int[] readNumberList() {
        int[] table = null;
        try {
            System.out.println("Podaj minimut dwie liczby po przecinku");
            String line = sc.nextLine();
            String[] tableString = line.split(",");
            table = new int[tableString.length];
            for (int i = 0; i < tableString.length; i++) {
                table[i] = Integer.parseInt(tableString[i]);
            }

        } catch (InputMismatchException e) {
            sc.nextLine();
            System.err.println(e.getMessage());
        }catch(NullPointerException e){
           System.err.println(e.getMessage());
        }

        return table;
    }

}
