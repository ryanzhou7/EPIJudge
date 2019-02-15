package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    if(L1 == null)
      return L2;
    if(L2 == null)
      return L1;
    ListNode<Integer> head;
    ListNode<Integer> c;
    if(L1.data < L2.data){
      c = L1;
      head = L1;
      L1 = L1.next;
    }
    else{
      c = L2;
      head = L2;
      L2 = L2.next;
    }
    while(L1 != null && L2 != null){
      if(L1.data <= L2.data){
        c.next = L1;
        L1 = L1.next;
      }
      else{
        c.next = L2;
        L2 = L2.next;
      }
      c = c.next;
    }
    if(L1==null){
      c.next = L2;
    }
    else{
      c.next = L1;
    }
    return head;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
