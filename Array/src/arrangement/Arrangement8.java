package arrangement;

//Minimum swaps required to bring all elements less than or equal to k together
//Given an array of n positive integers and a number k.
// Find the minimum number of swaps required to bring all the numbers
// less than or equal to k together.
public class Arrangement8 {
  public static void main(String[] args) {
//    int a[] = {2, 1, 5, 6, 3};
//    int a[] = {2, 1, 3, 6, 5};
//    String s ="470 10 28 338 384 0 329 405 70 349 40 472 212 14 411 151 215 384 368 46 256 42";

    //263 349 318 277 282 301 250 104 164 278 442 400 130 271 305 52 472 346 24 185
    //212
    String s = "2 7 9 5 8 7 4";
//    int a[] = {2, 1, 3, 6, 5,6};
    final String[] split = s.split(" ");
    int[] a= new int[split.length];
    for (int i = 0; i < a.length; i++) {
      a[i]=Integer.parseInt(split[i]);
    }
//    int k = Integer.parseInt("186");
//    int k = Integer.parseInt("186");
    int k = 6;
    System.out.println(minSwap(a, a.length, k));
  }

  // or equals to k together
  static int minSwap(int arr[], int n, int k) {

    // Find count of elements which are
    // less than equals to k
    int count = 0;
    for (int i = 0; i < n; ++i)
      if (arr[i] <= k)
        ++count;

    // Find unwanted elements in current
    // window of size 'count'
    int bad = 0;
    for (int i = 0; i < count; ++i)
      if (arr[i] > k)
        ++bad;

    // Initialize answer with 'bad' value of
    // current window
    int ans = bad;
    for (int i = 0, j = count; j < n; ++i, ++j) {

      // Decrement count of previous window
      if (arr[i] > k)
        --bad;

      // Increment count of current window
      if (arr[j] > k)
        ++bad;

      // Update ans if count of 'bad'
      // is less in current window
      ans = Math.min(ans, bad);
    }
    return ans;
  }
}
