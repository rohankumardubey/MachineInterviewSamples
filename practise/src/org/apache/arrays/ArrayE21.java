package org.apache.arrays;

import java.util.Arrays;

//Spirally traversing a matrix
public class ArrayE21 {
  public static void main(String[] args) {
    int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {

      }
    }
    ReversespiralPrint(4,4,a);
  }

  public static void ReversespiralPrint(int m, int n,
      int a[][])
  {
    // Large array to initialize it
    // with elements of matrix
    long b[] = new long[m*n];

        /* k - starting row index
        l - starting column index*/
    int i, k = 0, l = 0;

    // Counter for single dimension array
    //in which elements will be stored
    int z = 0;

    // Total elements in matrix
    int size = m * n;

    while (k < m && l < n)
    {
      // Variable to store value of matrix.
      int val;

            /* Print the first row from the remaining
            rows */
      for (i = l; i < n; ++i)
      {

        val = a[k][i];
        b[z] = val;
        ++z;
      }
      k++;

            /* Print the last column from the remaining
            columns */
      for (i = k; i < m; ++i)
      {

        val = a[i][n-1];
        b[z] = val;
        ++z;
      }
      n--;

            /* Print the last row from the remaining
            rows */
      if ( k < m)
      {
        for (i = n-1; i >= l; --i)
        {

          val = a[m-1][i];
          b[z] = val;
          ++z;
        }
        m--;
      }

            /* Print the first column from the remaining
            columns */
      if (l < n)
      {
        for (i = m-1; i >= k; --i)
        {

          val = a[i][l];
          b[z] = val;
          ++z;
        }
        l++;
      }
      System.out.println(Arrays.toString(b));
    }

    for (int x = 0 ; x<size; x++)
    {
      System.out.print(b[x]+" ");
    }
  }
}
