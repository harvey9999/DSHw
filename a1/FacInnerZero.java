// TODO: you may wish to import BigInteger or something similar

import java.math.BigInteger;
import java.math.*;

public class FacInnerZero {
  public static int zeroInsideFac(int n) {
    BigInteger b1 = BigInteger.valueOf(n);
    BigInteger zero = BigInteger.valueOf(0);
    BigInteger ten = BigInteger.valueOf(10);
    BigInteger b3 = null;
    int fremainder=0;
    int zc=0;
    BigInteger remainder=null;
    for(int i = n-1; i>0; i--){
      BigInteger b2 = BigInteger.valueOf(i);
      b3 = b1.multiply(b2);
      b1=b3;
    }
    while(b3.compareTo(zero)>0){
      remainder=b3.mod(new BigInteger("10"));
      b3=b3.divide(ten);
      if(remainder.compareTo(zero)!=0){
        fremainder++;
      }
      if(fremainder>=1){
        if(remainder.compareTo(zero)==0){
          zc++;
        }
      }
    }
    // TODO: implement me
    return zc; // TODO: delete me, I'm only here so it compiles
  }
}

