package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class StringIntegerInterconversion {

  public static String intToString(int x) {
    StringBuilder sb = new StringBuilder();
    boolean isNeg = false;
    if(x<0){
      isNeg = true;
    }
    do{
      sb.append((char)(Math.abs(x%10) +'0'));
      x /= 10;
    }while(x!=0);
    if(isNeg){
      sb.append("-");
    }
    sb.reverse();
    return sb.toString();
  }
  public static int stringToInt(String s) {
    boolean isNegative = false;
    if(s.charAt(0)=='-'){
      isNegative = true;
      s = s.substring(1);
    }
    int num = 0;
    int base = 1;
    for(int i = s.length()-1; i>=0; i--){
      char c = s.charAt(i);
      int temp = (c-'0');
      num += (temp*base);
      base *= 10;
    }
    if(isNegative)
      num *= -1;
    return num;
  }
  @EpiTest(testDataFile = "string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (!intToString(x).equals(s)) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
