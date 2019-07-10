public class BestSplit {
    public static int bestSplit(int[] a) {
        // todo: implement me
        long storerem = Long.MAX_VALUE;
        int left = 0;
        int right = 0;
        long ans = 0;
        int c = a.length;
        for(int i=0;i<a.length;i++) {
            left+=a[i];
        }


        for(int i=a.length-1; i>0;i--){
            right += a[i];
            left-=a[i];
            if((left-right)*(left-right)<storerem){
                storerem = (left - right) * (left - right);
                ans=i;
            }
        }


            return (int)ans;
        }
}
