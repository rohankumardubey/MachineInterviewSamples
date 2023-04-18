package rotation;

//Generate all rotations of a number
//Given an integer n, the task is to generate all the left shift numbers possible.
// A left shift number is a number that is generated when all the digits of the number
// are shifted
// one position to the left and the digit at the first position is shifted to the last.
public class Rotation16 {
  public static void main(String[] args) {
    int x = 1234;
//    int counter = numberOfDigit(x);
//    int z = ((int)Math.pow(10,counter));
//    int z1 = ((int)Math.pow(10,counter-1));
//    while(counter>1) {
//      int n = x/z1;
//      x=x*10;
//      x+=n;
//      int y = n*z;
//      x=x-y;
//      System.out.println(x);
//      counter--;
//    }
    solution2(x);


//    123*10=1230;
//    1230+1=1231;
//    1231-1000;
//    231;
//    231*10=2310
//    2310+2=2312
//    2312-2000;
//    312
  }

  private static int numberOfDigit(int n) {
    int count = 0;
    while(n>0) {
      count++;
      n=n/10;
    }
    return count;
  }

  private static void solution2(int num) {
    final int numberOfDigit = numberOfDigit(num);
    int counter = 0;
    final int pow = (int)Math.pow(10, numberOfDigit - 1);
    while(counter<numberOfDigit-1) {
      int left = num/pow;
      int right = num%pow;
      right*=10;
      num = right + left;
      System.out.println(num);
      counter++;
    }
  }
}
