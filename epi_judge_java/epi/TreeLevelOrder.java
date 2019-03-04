package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
public class TreeLevelOrder {
  @EpiTest(testDataFile = "tree_level_order.tsv")

  public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
    List<List<Integer>> listList = new ArrayList<>();
    if(tree==null)
      return listList;
    Deque<BinaryTreeNode<Integer>> cLevel = new LinkedList<>();
    cLevel.addLast(tree);
    while(!cLevel.isEmpty()){
      Deque<BinaryTreeNode<Integer>> nLevel = new LinkedList<>();
      List<Integer> list = new ArrayList<>();
      while(!cLevel.isEmpty()){
        BinaryTreeNode<Integer> c = cLevel.removeFirst();
        list.add(c.data);
        if(c.left!=null)
          nLevel.addLast(c.left);
        if(c.right!=null)
          nLevel.addLast(c.right);
      }
      listList.add(list);
      cLevel = nLevel;
    }
    return listList;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeLevelOrder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
