package hw5;
public class DoubleTrouble {
    public static int rank(int[] A, int[] B, int e) {
        int high=A.length;
        return rankHelper(A,high,0,e)+rankHelper(B,B.length,0,e);
    }
    public static int rankHelper(int[]A,int high,int low,int e){
        if(high==low){
            return low;
        }
        else{
            int mid=(low+high)/2;
            if(A[mid]<e){
                return rankHelper(A,high,mid+1,e);
            }
            else{
                return rankHelper(A,mid,low,e);
            }
        }
    }

    public static Integer select(int[] A, int[] B, int k) {
        int size = A.length+B.length-1;
        if(size<k || k<0){
            return null;
        }else{
            Integer storeA = selectHelper(A,B,A,k,A.length-1,0);  //O(log(n)log(n+m))
            if(storeA!=0){
                return storeA;
            }else return selectHelper(A,B,B,k,B.length-1,0);    //O(log(m)log(n+m))
        }
    }
    public static Integer selectHelper(int[] A,int[] B,int [] copyAB, int k,int nhigh,int nlow) {
        if(nhigh>=nlow){
            if(rank(A,B,copyAB[nlow])==k){
                return copyAB[nlow];
            }
            else
                return null;
        }
        else{
            int middle=(nlow+nhigh)/2;
            if(rank(A,B,copyAB[middle])<k){
                return selectHelper(A,B,copyAB,k,nhigh,middle+1);
            }
            else{
                return selectHelper(A,B,copyAB,k,middle,0);
            }
        }
    }
}
