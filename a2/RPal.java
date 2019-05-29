public class RPal {
  public static int countRPal(int N){
    int c=1;
    if (N == 1) {
      return 1;
    }
    else {
      for(int i=1;i<=N/2;i++){
        c+= countRPal(i);
      }
    }
    return c;
  }
}