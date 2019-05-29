import java.util.Arrays;

public class Midway {
    //Collaborator Ink,Taem,Vicky.
    public static long stepsRemaining(int[] diskPos){
        return stepsRemainingHelper(diskPos,0,1,2);
    }
    public static long stepsRemainingHelper(int[] diskPos,int start,int target,int auxiliary){
        if(diskPos.length==0){
            return 0;
        }
        else{
            if(diskPos[diskPos.length-1]==target){ //Checks if the biggest disk is at the desired target or not
                return stepsRemainingHelper(Arrays.copyOfRange(diskPos,0,diskPos.length-1),auxiliary,target,start);
            }
            else{
                return (long)(Math.pow(2,diskPos.length-1)+stepsRemainingHelper(Arrays.copyOfRange(diskPos,0,diskPos.length-1),start,auxiliary,target));
            }

        }
    }
}