import java.util.*;

public class Weave {
    public static int numWeaves(int n) {
        if (n ==0 ){
            return 1;
        }
        else if (n<3) {
            return 0;
        }
        else if(n==3){
            return 1;
        }
        else if(n==4){
            return 1;
        }

        else return numWeaves(n - 3) + numWeaves(n - 4) + numWeaves(n - 11);


    }
}