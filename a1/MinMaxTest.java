public class MinMaxTest {
  public static void main(String[] args) {
    int[] inArray = {0, 5};
    assert Math.abs(MinMax.minMaxAverage(inArray)-2.5)<1e-5;
  }
}
