package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class IntersectSortedArrays {
  @EpiTest(testDataFile = "intersect_sorted_arrays.tsv")

  public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                       List<Integer> B) {
    List<Integer> C = new ArrayList<>();
    int i = 0;
    int j = 0;
    while( i<A.size() && j<B.size()){
      int a = A.get(i);
      int b = B.get(j);
      if(a==b){
        if(C.size()==0){
          //put if nothing inside
          C.add(a);
        }
        else if(C.get(C.size()-1)!=a){
          //put in if no duplicate
          C.add(a);
        }
        i++;
        j++;
      }
      else if(a>b){
        j++;
      }
      else{
        i++;
      }
    }
    return C;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
