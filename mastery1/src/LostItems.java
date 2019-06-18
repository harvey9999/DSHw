import java.util.*;

public class LostItems {
    public static int[] lostItems(int[] a, int b[]) {
        int[]countsa=new int[16385];
        int[]countsb=new int[16385];
        int[]expected=new int[16385];
        int count=0;
        int c=0;
        int counter=0;
        for(int i=0;i<a.length;i++) {
            countsa[a[i]]++;
        }
        for(int i=0;i<b.length;i++) {
            countsb[b[i]]++;
        }


        for(int i=0;i<countsb.length;i++) {
            if (countsa[i] != countsb[i]) {
                expected[c]=i;
                count++;
                c++;
            }
            else{
                c++;
            }
        }
        int[] exp=new int[count];
        for(int i=0;i<countsb.length;i++) {
            if(expected[i]!=0) {
                exp[counter]=i;
                counter++;
            }

        }
        return exp; // TODO: fix me
    }

//    public static void main(String[] args) {
//        int[] inA = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
//        int[] inB = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
//        int[] expected = {204, 205, 206};
//
//        int[] yourOutput = lostItems(inA, inB);
//        System.out.println("verdict: "+Arrays.equals(yourOutput, expected));
//    }
}
