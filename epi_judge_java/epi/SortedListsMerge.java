package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    /*
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
    */

    ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
    //ListNode<Integer> currNode = null;
    //currNode =
    if (L2 == null){return L1;}

    if (L1 == null){return L2;}

    dummyHead.next = (L1.data < L2.data)? L1:L2;
    ListNode<Integer> currNode = dummyHead.next;

    if(currNode == L1)
      L1 = L1.next;

    else {//currNode will be at L2
      L2 = L2.next;
    }

    while (L1!=null && L2!=null)
    {
      currNode.next = (L1.data < L2.data)? L1:L2;
      currNode = currNode.next;

      if (currNode == L1)
      {
        L1 = L1.next;
      }

      else
      {
        L2 = L2.next;
      }

    }

    if (L1==null && L2!=null)
    {
      currNode.next = L2;
    }

    else if (L2==null && L1!=null)
    {
      currNode.next = L1;
    }

    // L1 = 5
    // L2 = 1->3
    // 1->3
    return dummyHead.next;
    //return L1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
