public class Last {
    public static Integer binarySearchLast(int[] a, int k) {
        return lookup_helper(a, 0, a.length-1, k,-1);
    }
    static Integer lookup_helper(int[] a, int lo, int hi, int k,int index) {

        if (lo > hi){
            if(index==-1){
                return null;
            }
            return index;
        }
    else {
        int m = (lo+hi)/2;
        if (a[m]==k) {
            index = m;
            return lookup_helper(a, m+1, hi, k,index);
        }
        else if (k < a[m]) {
            return lookup_helper(a, lo, m-1, k,index);
        }
        else {
            return lookup_helper(a, m+1, hi, k,index);
        }
        }
    }
}