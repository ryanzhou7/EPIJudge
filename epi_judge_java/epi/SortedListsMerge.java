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
    ListNode<Integer> curr, head;
    if(L1.data<L2.data){
      curr = L1;
      head = curr;
      L1 = L1.next;
    }
    else{
      curr = L2;
      head = curr;
      L2 = L2.next;
    }
    while (L1!=null || L2!=null){
      if(L2==null){
        curr.next = L1;
        L1 = L1.next;
      }
      else if(L1 ==null){
        curr.next = L2;
        L2 = L2.next;
      }
      else if(L1.data < L2.data){
        curr.next = L1;
        L1 = L1.next;
      }
      else{
        curr.next = L2;
        L2 = L2.next;
      }
      curr = curr.next;
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
