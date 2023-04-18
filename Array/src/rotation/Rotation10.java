package rotation;

//Quickly find multiple left rotations of an array | Set 1
//Given an array of size n and multiple values around
// which we need to left rotate the array. How to quickly find multiple left rotations?
public class Rotation10 {
  // Driver Code
  public static void main (String[] args)
  {
    int arr[] = {1, 2, 3, 4, 5};
    int n = arr.length;

    int k = 2;
//    leftRotate(arr, n, k);
//    System.out.println();
//    rotate1(arr, k);
//    System.out.println();
//    rotateMine(arr, k);
//    System.out.println();

    k = 2;
//    leftRotate(arr, n, k);
//    System.out.println();
    rotate1(arr, k);
//    System.out.println();
//    rotateMine(arr, k);
    System.out.println();

//    k = 4;
//    leftRotate(arr, n, k);
//    System.out.println();
//    rotate1(arr, k);
//    System.out.println();
//    rotateMine(arr, k);
//    System.out.println();

  }

  static void leftRotate(int arr[],
      int n, int k)
  {
    // Print array after
    // k rotations
    for (int i = k; i < k + n; i++)
      System.out.print(arr[i % n] + " ");
  }

  static void rotate1(int[] arr, int k) {
    int n = arr.length;
    int mod = k % n;

    // Prints the rotated array from start position
    for (int i = 0; i < n; i++) {
      System.out.print(arr[(mod+i)%n] + " ");
    }
  }

  private static void rotateMine(int a[], int k) {
    for (int i = k; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    for (int i = 0; i < k; i++) {
      System.out.print(a[i] + " ");
    }
  }
}
