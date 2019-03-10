public class Exercise_2 {
    public static void main(String[] args){
        if(args.length==0) {
            System.out.println("Nie podano argumentow przy starcie programu");
            System.exit(0);
        }
        //deklaracja zmiennych tj. tablica prechowujaca sume sasiednich liczb, maxymalna i minimalna wartosc tablicy oraz 2 obiekty String
        int []sumOfPairs=new int[args.length-1];
        int maxValue;
        int minValue;
        String maxPrefix="Najwieksza para";
        String minPrefix="Najmniejsza para";

        // stworzenie tablicy przechowujacej sume sasiednich liczb
        for (int i = 0; i < args.length -1; i++) {
            sumOfPairs[i]=Integer.valueOf(args[i])+Integer.valueOf(args[i+1]);
        }
        // przypisanie pierwszej wartosci z tablicy do zmiennych
        maxValue=sumOfPairs[0];
        minValue=sumOfPairs[0];

        // iteracja po stworzonej tablicy
        for (int i = 1; i <sumOfPairs.length ; i++) {
            //szukanie wartosci maksymalnej
            if(sumOfPairs[i]>maxValue){
                maxValue=sumOfPairs[i];
                maxPrefix="Najwieksza para";
            }
            // sprawdzenie czy jest ich wiecej niz 1
            else if (sumOfPairs[i]==maxValue) {
                maxPrefix="Najwieksze pary";
            }
            // szukanie wartosci minimalnej
            if (sumOfPairs[i]<minValue){
                minValue=sumOfPairs[i];
                minPrefix="Najmniejsza para";
            }
            // sprawdzenie cz jest ich wiecej niz 1
            else if(sumOfPairs[i]==minValue){
                minPrefix="Najmniejsze pary";
            }
        }

        // utworzenie dwoch obiektow StringBuilder
        StringBuilder maxMessage=new StringBuilder(maxPrefix);
        StringBuilder minMessage=new StringBuilder(minPrefix);

        // iteracja po tablicy, ktora zostala przekazana jako argument programu
        for (int i = 0; i <args.length-1 ; i++) {
            // sprawdzenie, czy sasiadujace liczby sa rowne wartosci minimalnej oraz czy nie zostaly juz dodane do obiektu minMessage
            if((Integer.valueOf(args[i])+Integer.valueOf(args[i+1]))==minValue && (!minMessage.toString().contains(args[i] + ", " + args[i+1]))) {
                minMessage.append("[" + args[i] + ", " + args[i+1] + "]");
            }
            //sprawdzenie, czy sasiadujace liczby sa rowne wartosci maksymalnej oraz czy nie zostaly juz dodane do obiektu maxMessage
            if((Integer.valueOf(args[i])+Integer.valueOf(args[i+1]))==maxValue && (!maxMessage.toString().contains(args[i] + ", " + args[i+1]))) {
                maxMessage.append("[" + args[i] + ", " + args[i+1] + "]");
            }


        }
        // wyswietlenie wynikow
        System.out.println(minMessage.toString());
        System.out.println(maxMessage.toString());

    }


}
