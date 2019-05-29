public class HalvingSumTest {
  public static void main(String[] args) {
    double[] inArray = {3.0, 7.0, 1.0, 4.0};
    assert (Math.abs(15.0 - HalvingSum.hsum(inArray)) < 1e-5);
  }
}
