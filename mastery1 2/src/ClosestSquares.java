import java.util.*;

public class ClosestSquares {

    public static int closestSquares(int[] a) {
        long min=Long.MAX_VALUE;
        int[]store =new int[2];
        for(int i=0;i<a.length;i++){
            if(a[i]<0) {
              a[i]=Math.abs(a[i]);
            }
        }
        Arrays.sort(a);
        for(int i=0;i<a.length-1;i++){
            if(a[i+1]-a[i]<min){
                min=a[i+1]-a[i];
                store[0]=a[i+1];
                store[1]=a[i];
            }
        }
        min=(long)store[0]*store[0]-(long)store[1]*store[1];
        return (int)min;
    }
}
