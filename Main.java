/**
 * Created by Kamil on 2019-03-06.
 */
public class Main {
    public static void main(String[] args) {
//        int[] tab_1 = {1,2,3,4,5};
//        int[] tab_2 = {-5,0,5,-10,5,15};
//        int[] tab_3 = {-5,0,10,-5,0,5,5};
        if(args.length == 0){
            System.out.println("Enter data");
            return;
        }
        PairSearch pairSearch_1 = new PairSearch();
        int[] tab = new int[args.length];
        for(int i = 0 ; i < args.length ; i++){
            tab[i] = Integer.parseInt(args[i]);
        }
        pairSearch_1.findPairs(tab);
    }
}
