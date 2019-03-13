package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SortedArraysMerge {
  @EpiTest(testDataFile = "sorted_arrays_merge.tsv")

  public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
    List<Integer> f = new LinkedList<>();
    PriorityQueue<ELP> minHeap = new PriorityQueue<>(
            (ELP e1, ELP e2)->{
              return Integer.compare(e1.d, e2.d);
            }
    );
    addFirstCol(minHeap, sortedArrays);
    while(!minHeap.isEmpty()){
      ELP e = minHeap.poll();
      f.add(e.d);
      List<Integer> from = sortedArrays.get(e.i);
      int next = e.j+1;
      if(next!=from.size()){
        minHeap.add(new ELP(from.get(next), e.i, next));
      }
    }
    return f;
  }

  public static void addFirstCol(PriorityQueue<ELP> heap, List<List<Integer>> sortedArrays){
    for(int i = 0; i<sortedArrays.size(); i++){
      heap.add(new ELP(sortedArrays.get(i).get(0), i, 0));
    }
  }

  public static class ELP{
    //Element, list, pair
    int d; //data
    int i; //index of list its from
    int j; //index of this elem in the list

    public ELP(Integer d, int i, int j) {
      this.d = d;
      this.i = i;
      this.j = j;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
