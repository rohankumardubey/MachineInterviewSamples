package rotation;

public class Rotation19 {
  public static void main(String[] args) {
    int n = 2;
    sol(2);
  }

  private static void sol(int n) {
    int start = (int)Math.pow(10,n-1);
    int end = (int)Math.pow(10, n);
    for (int i = start; i < end; i++) {
      if(checkIfDivisorOfRight(i)) {
        System.out.println(i);
      }
    }
  }

  private static boolean checkIfDivisorOfRight(int i) {
    int acutal = i;
    int numberOfD = numberOfDigit(i);
    int pow= (int)Math.pow(10,numberOfD-1);
    int x  = i%10;
    i = i/10;
    x*=pow;
    x+=i;
    return x%acutal==0;
  }

  private static int numberOfDigit(int n) {
    int counter = 0;
    while(n>0) {
      counter++;
      n= n/10;
    }
    return counter;
  }
}
