package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class SpiralOrderingSegments {
  @EpiTest(testDataFile = "spiral_ordering_segments.tsv")

  public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
    List<Integer> list = new ArrayList<>();
    if(squareMatrix.size()==0)
      return list;
    if(squareMatrix.size()==1) {
      list.add(squareMatrix.get(0).get(0));
      return list;
    }
    int cRow = 0;
    int cCol = 0;
    int rightCol = squareMatrix.get(0).size();
    int rightRow = squareMatrix.get(0).size();
    int leftCol = 0;
    int leftRow = 1;
    while (true){
      //RIGHT
      while(cCol!=rightCol){
        list.add(squareMatrix.get(cRow).get(cCol++));
      }
      cCol--;
      rightCol--;
      if(cRow+1>=rightRow)
        break;
      cRow++;
      //DOWN
      while(cRow!=rightRow){
        list.add(squareMatrix.get(cRow++).get(cCol));
      }
      cRow--;
      rightRow--;
      cCol--;
      //LEFT
      while (cCol!=leftCol){
        list.add(squareMatrix.get(cRow).get(cCol--));
      }
      cCol++;
      leftCol++;
      if(cRow-1<=leftRow)
        break;
      cRow--;
      //UP
      while(cRow!=leftRow){
        list.add(squareMatrix.get(cRow--).get(cCol));
      }
      cCol++;
      cRow++;
      leftRow--;
    }
    list.add(squareMatrix.get(cRow).get(--cCol));
    return list;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpiralOrderingSegments.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
