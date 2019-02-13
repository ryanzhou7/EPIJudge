package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ConvertBase {
  @EpiTest(testDataFile = "convert_base.tsv")

  public static String convertBase(String numAsString, int b1, int b2) {
    StringBuilder sb = new StringBuilder();
    boolean isNeg = numAsString.startsWith("-");
    numAsString = isNeg? numAsString.substring(1): numAsString;
    if(numAsString.compareTo("0")==0)
      return isNeg? "-0": "0";
    int numb10 = convertBase10(numAsString, b1);
    long currentBase = 1;
    while (numb10 > 0){
      long mod = numb10%(currentBase*b2);
      if(mod!=0){
        long dig = mod/currentBase;
        sb.append(convertChar(dig));
        numb10 -= (dig*currentBase);
      }
      else{
        sb.append(0);
      }
      currentBase *= b2;
    }
    sb = isNeg? sb.append('-'): sb;
    return sb.reverse().toString();
  }

  private static int convertBase10(String s, int base){
    int num = 0;
    int cBase = 1;
    for(int i = s.length()-1; i>=0; --i){
      char c = s.charAt(i);
      int val = Character.isDigit(c)? (c-'0'): (c-'A'+10);
      num += val*cBase;
      cBase *= base;
    }
    return num;
  }

  private static char convertChar(long val){
    if(val>=0 && val <10) {
      return (char) (val + '0');
    }
    else{
      long offSet = val - 10;
      return (char)('A' + offSet);
    }
  }

  public static void main(String[] args) {
    //System.out.println(convertBase("3CC5762B", 15, 16));
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
