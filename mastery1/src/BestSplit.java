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


    public static void main(String[] args) {
        // todo: make more tests -- no need to hand in your tests
        int[] input0 = {8, 4, 5};
        int[] input1 = {3, 1, 4, 5, 9, 2, 6, 5, 3, 5, 8, 7, 3, 11};
        System.out.println("verdict: " + (1==bestSplit(input0)));
        System.out.println("verdict: " + (8==bestSplit(input1)));
    }
}
