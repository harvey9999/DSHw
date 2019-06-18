import java.util.*;

public class Weave {
    public static int numWeaves(int n) {
        if (n ==0 ){
            return 1;
        }
        else if(n==3){
            return 1;
        }
        else if(n==4){
            return 1;
        }
        else if (n == 1||n==2||n<0) {
            return 0;
        }
//        else if(n==11){
//            return 4;
//        }
        else return numWeaves(n - 3) + numWeaves(n - 4) + numWeaves(n - 11);


    }

//    public static void main(String[] args) {
//        int[] input = {3, 6, 14, 75};
//        int[] expected = {1, 1, 8, 5217077};
//
//        System.out.println(numWeaves(14));
//        for (int i = 0; i < input.length; i++) {
//            System.out.printf("Test #%d, verdict: %b [expected=%d]\n",
//                    i + 1, expected[i] == numWeaves(input[i]), expected[i]);
//        }
//    }
}