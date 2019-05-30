import java.util.ArrayList;
import java.util.Arrays;

public class Zombies {
    public static int countBad(int[] hs) {
        return mergeSort(hs).first;
    }

    public static Pair<Integer, int[]> mergeSort(int[] a) {
        int n = a.length;
        int counter = 0;
        if (n <= 1) return new Pair<>(0, a);
        int[] left = Arrays.copyOfRange(a, 0, n / 2);
        int[] right = Arrays.copyOfRange(a, n / 2, n);
        return merge(mergeSort(left), mergeSort(right), counter);
    }

    static Pair<Integer, int[]> merge(Pair<Integer, int[]> a, Pair<Integer, int[]> b, int counter) {
        int[] out = new int[a.second.length + b.second.length];
        int ai = 0, bi = 0, oi = 0;
        while (ai < a.second.length && bi < b.second.length) {
            if ((a.second[ai] > b.second[bi])) {
                out[oi++] = a.second[ai++];
            } else {
                out[oi++] = b.second[bi++];
                counter += a.second.length - ai;
            }
        }
        while (ai < a.second.length) {
            out[oi++] = a.second[ai++];
        }
        while (bi < b.second.length) {
            out[oi++] = b.second[bi++];
        }
        Pair<Integer, int[]> pair = new Pair<>(counter + a.first + b.first, out);
        return pair;
    }
}



//class Main{
//    public static void main(String[] args) {
//        Zombies obj=new Zombies();
//        Pair<Integer, int[]> emp= obj.mergeSort(new int[]{1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31});
//        for(int i=0;i<emp.length;i++){
//            System.out.println(emp[i]);
//        }
//        Pair<Integer, int[]> pair = new Pair<>(14,new int[]{1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31});
//        System.out.println(emp.first);
//    }
//}

