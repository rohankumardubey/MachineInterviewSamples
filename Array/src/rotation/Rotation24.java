package rotation;

public class Rotation24 {
  public static void main(String[] args) {
    String s ="13520";
    int counter=0;
    if(s.length()==1) {
      int a = s.charAt(0) - '0';
      if(a%4==0) {
        counter++;
      }
    } else {
      for (int i = 0; i < s.length()-1; i++) {
        int a = s.charAt(i)*10 - '0' + s.charAt(i+1) - '0';
        if(a%4==0) {
          counter++;
        }
      }
      int a = s.charAt(s.length()-1)*10  - '0'+ s.charAt(0) -'0';
      if(a%4==0) {
        counter++;
      }

    }
//    System.out.println(counter);
    System.out.println('1' - '0');
  }
}
