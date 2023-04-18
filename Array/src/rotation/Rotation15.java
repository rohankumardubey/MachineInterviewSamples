package rotation;
//Count rotations of N which are Odd and Even
//Given a number n, the task is to count all rotations of
// the given number which are odd and even.
public class Rotation15 {
  public static void main(String[] args) {
    int number = 246;
    int oddcount = 0;
    int evencount = 0;
    while(number>0) {
      int x = number%10;
      if(x%2 ==0) {
        evencount++;
      } else {
        oddcount++;
      }
      number = number/10;
    }
    System.out.println(oddcount);
    System.out.println(evencount);
  }
}
