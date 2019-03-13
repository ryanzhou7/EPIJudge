package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeBalanced {

  @EpiTest(testDataFile = "is_tree_balanced.tsv")

  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    if(tree==null)
      return true;
    int r = getH(tree, 0);
    return r != -1;
  }

  public static int getH(BinaryTreeNode<Integer> tree, int height){
    if(tree==null)
      return height-1;
    int leftH = getH(tree.left, height+1);
    if(leftH==-1)
      return -1;
    int rightH = getH(tree.right, height+1);
    if(rightH==-1)
      return -1;
    if(Math.abs(leftH-rightH)>1)
      return -1;
    return Math.max(leftH, rightH);
  }
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
