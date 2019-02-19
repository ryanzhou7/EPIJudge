package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Stack;

public class ReverseSublist {
  @EpiTest(testDataFile = "reverse_sublist.tsv")

  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                 int finish) {
    if(start==finish)
      return L;
    ListNode<Integer> dummy = new ListNode<>(0, L);
    ListNode<Integer> curr = L;
    int c = 1;
    while(c++!= start){
      curr = curr.next;
    }
    ListNode<Integer> bs = curr;
    ListNode<Integer> af = null;
    ListNode<Integer> ns = null;
    c++;
    curr = curr.next;
    ListNode<Integer> nf = curr;
    ListNode<Integer> next = curr.next;
    while(c != finish-2){
      ListNode<Integer> nn = next.next;
      next.next = curr;
      curr = next;
      next = nn;
      c++;
      if(c==finish-2){
        af = nn;
        ns = next;
      }
    }
    bs.next = ns;
    nf.next = af;
    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
