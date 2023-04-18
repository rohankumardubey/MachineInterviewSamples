package rotation;
//Count rotations divisible by 8
//Given a large positive number as string, count all rotations of the given number which are divisible by 8.
public class Rotation23 {
  public static void main(String[] args) {
    String s ="128";
    int counter = 0;
    if(s.length()==1) {
      int oneDigit = s.charAt(0) - '0';
      if(oneDigit%8==0) {
        counter++;
      }
    } else if(s.length()==2) {
      int oneDigit = s.charAt(0) +10*s.charAt(1)- '0';
      if(oneDigit%8==0) {
        counter++;
      }
      oneDigit = s.charAt(1) +10*s.charAt(2)- '0';
      if(oneDigit%8==0) {
        counter++;
      }
    } else {
      for (int i = 0; i < s.length()-2; i++) {
        int oneDigit = s.charAt(0) +100*s.charAt(1) + 10* s.charAt(i+2)- '0';
        if(oneDigit%8==0) {
          counter++;
        }
      }
      int oneDigit = s.charAt(s.length()-1) +100*s.charAt(0) + 10* s.charAt(1)- '0';
      if(oneDigit%8==0) {
        counter++;
      }
      oneDigit = s.charAt(s.length()-2) +100*s.charAt(s.length()-2) + 10* s.charAt(0)- '0';
      if(oneDigit%8==0) {
        counter++;
      }
    }
    System.out.println(counter);
  }
}
