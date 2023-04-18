package org.apache.practise.codeproblems;

public class MaxProduct {
  public int maxProduct(int[] nums) {
    int max_product_so_far = Integer.MIN_VALUE;
    int curr_product = 1;
    for(int i=0; i<nums.length; i++) {
      curr_product *= nums[i];
      if(curr_product > max_product_so_far) {
        max_product_so_far = curr_product;
      }
      if(curr_product == 0) {
        curr_product = 1;
      }
    }
    curr_product = 1; // reset
    for(int i=nums.length-1; i>=0; i--) {
      curr_product *= nums[i];

      if(curr_product > max_product_so_far) {
        max_product_so_far = curr_product;
      }

      if(curr_product == 0) {
        curr_product = 1;
      }
    }
    return max_product_so_far;
  }
}
