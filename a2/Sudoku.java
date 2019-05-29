import java.util.*;

public class Sudoku {
  public static boolean sudokuSolved(int[][] grid) {
    int c = 0;
    boolean ans = true;
    HashSet<Integer> oneline = new HashSet<>();
    HashSet<Integer> oneline1 = new HashSet<>();
    HashSet<Integer> oneline2 = new HashSet<>();
    for (int i = 0; i < grid.length ; i++) {
      for (int j = 0; j < grid.length ; j++) {
        oneline.add(grid[i][j]);
        oneline1.add(grid[j][i]);
      }
      if(oneline.size()!=9||oneline.size()!=9){
        ans=false;
        break;
      }
      else{
        oneline.clear();
        oneline1.clear();
      }

    }
    for (int i = 0; i < grid.length-2; i+=3) {
      for (int j = 0; j < grid.length-2; j+=3) {
        oneline2.add(grid[i][j]);
        oneline2.add(grid[i][j+1]);
        oneline2.add(grid[i][j+2]);
        oneline2.add(grid[i+1][j]);
        oneline2.add(grid[i+2][j]);
        oneline2.add(grid[i+1][j+1]);
        oneline2.add(grid[i+2][j+1]);
        oneline2.add(grid[i+1][j+2]);
        oneline2.add(grid[i+2][j+2]);
        if(oneline2.size()!=9){
          ans=false;
          break;
        }
        else
        {
          oneline2.clear();
        }
      }
    }
    return ans;
  }
}

