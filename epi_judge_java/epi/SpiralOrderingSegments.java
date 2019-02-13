package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class SpiralOrderingSegments {
  @EpiTest(testDataFile = "spiral_ordering_segments.tsv")

  public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
    List<Integer> list = new ArrayList<>();
    int c = 0;
    int r = 0;
    List<List<Integer>> A = squareMatrix;
    if(A.size()==1) {
      list.add(A.get(0).get(0));
      return list;
    }
    else if(A.size()==0)
      return list;
    int LR = A.get(0).size()-1;
    //LR = exclusive index to add when going from left to right

    int UD = A.size()-1;
    //UD = Up to down

    int RL = 0;
    int DU = 1;
    int total = A.size()*A.get(0).size();
    while(true){
      while (c!=LR){
        list.add(A.get(r).get(c++));
      }
      --LR;
      if(list.size()+1==total){
        list.add(A.get(r).get(c));
        break;
      }
      while (r!=UD){
        list.add(A.get(r++).get(c));
      }
      --UD;
      while (c!=RL){
        list.add(A.get(r).get(c--));
      }
      ++RL;
      if(list.size()+1==total){
        list.add(A.get(r).get(c));
        break;
      }
      while (r!=DU){
        list.add(A.get(r--).get(c));
      }
      ++DU;
    }
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
