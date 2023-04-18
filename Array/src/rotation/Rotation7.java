package rotation;

//Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
public class Rotation7 {
  public static void main(String[] args) {
    int[] a = {1, 20, 2, 10};
    int max = 0;
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      max += i*a[i];
    }
    int currentMax = max;
    for (int i = 1; i < a.length; i++) {
      max = max + sum-a.length*a[a.length-i];
      if(max>currentMax) {
        currentMax = max;
      }
    }
    System.out.println(currentMax);
  }
}
