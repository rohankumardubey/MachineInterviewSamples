package rotation;
//Check whether all the rotations of a
// given number is greater than or equal to the given number or not
public class Rotation17 {
  public static void main(String[] args) {
    int n = 123456;
    int numberOfDigit = numberOfDigit(n);
    int counter = 1;
    int division = (int)Math.pow(10, numberOfDigit-1);
    boolean isAllBigger = true;
    int n1 = n;
    while(counter<numberOfDigit) {
      int x = n/division;
      n = n%division;
      n*=10;
      n+=x;
      counter++;
      if(n<n1) {
        isAllBigger = true;
        break;
      }
    }
    System.out.println(isAllBigger);
  }

  private static int numberOfDigit(int x) {
    int counter = 0;
    while(x>0) {
      counter++;
      x=x/10;
    }
    return counter;
  }
}
