package StutteringSubstring;

//Collaborators: Ink,Taem,Parm.
public class Stutter {
    public static boolean isSubstr(String a, String b){
        int c=0;
        boolean ans=false;
        if(a.length()==0){
            return true;
        }
        for(int i=0;i<b.length();i++){
            if(a.charAt(c)==b.charAt(i)){
                c++;
            }

        if(a.length()==c) {
            ans = true;
            break;
            }
        }
        return ans;
    }

    public static String stutter(String A, int k){
        StringBuilder str= new StringBuilder("");
        for(int i=0;i<A.length();i++){
            for(int j=0;j<k;j++){      //O(nk)
                str.append(A.charAt(i));
            }
        }
        return str.toString();
    }
    public static int maxStutter(String a, String b){
        int low=0;
        int high=(b.length()/a.length())+1;
        if((a.length()==0)){
            return 0;
        }
        int i=(b.length()/a.length())/2;
        while(high-low>1){
            if(isSubstr(stutter(a,i),b)){
                low=i;
                i=(high+low)/2;


            }
            else if(!isSubstr(stutter(a,i),b)){
                high=i;
                i=(high+low)/2;


            }
        }
        if(isSubstr(stutter(a,i),b)){
            return i;
        }
        else{
            return i-1;
        }
    }
}

//class Main{
//    public static void main(String[] args) {
//        Stutter s=new Stutter();
//        System.out.println(s.isSubstr("cat", "excavate"));
//        System.out.println(s.stutter("HI", 5));
//        System.out.println(s.maxStutter("ho","hi and hello jello"));
//        System.out.println(s.maxStutter("aca", "aaksjaklccaa"));
//    }
//}
