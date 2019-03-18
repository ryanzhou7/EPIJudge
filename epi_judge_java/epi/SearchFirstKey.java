package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class SearchFirstKey {
  @EpiTest(testDataFile = "search_first_key.tsv")

  public static int searchFirstOfK(List<Integer> A, int k) {
    int L = 0;
    int H = A.size()-1;
    int iLast = -1;
    while(L<=H){
      int M = calc(L, H);
      if(A.get(M)==k){
        //want to be looking for first occurrence
        if(M==0 || A.get(M-1)!=k)
          return M;
        H = M-1;
        iLast = M;
      }
      else if(A.get(M)> k)
        H = M-1;
      else
        L = M+1;
    }
    return iLast;
  }
  public static int calc(int L, int H){
    return (H-L)/2 + L;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchFirstKey.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
