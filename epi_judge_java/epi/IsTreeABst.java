package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeABst {
  @EpiTest(testDataFile = "is_tree_a_bst.tsv")

  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
    return isBinaryTreeBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree, int min, int max) {
    if(tree==null)
      return true;
    if(tree.data>max || tree.data<min)
      return false;
    boolean isTree = isBinaryTreeBST(tree.left, min, tree.data);
    if(!isTree)
      return false;
    return isBinaryTreeBST(tree.right, tree.data, max);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
