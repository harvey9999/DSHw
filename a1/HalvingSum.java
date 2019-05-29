import java.util.Arrays;
public class HalvingSum {
  public static double hsum(double[] X) {
    while (X.length>1){// Runs as long as the array X has more than 1 variable
      double[] Y= new double[X.length/2]; //Allocating Y as an array of length half of that of X
      for(int i=0;i<X.length/2;i++){
        Y[i]=  (X[2*i]+X[(2*i)+1]);  // Adds two consecutive numbers in X and adds it in Y
      }
      X= Arrays.copyOf(Y,Y.length); //Copy array and length of array of Y in X
    }
    // TODO: implement me
    return X[0]; //Returns the single number remaining.
  }
}