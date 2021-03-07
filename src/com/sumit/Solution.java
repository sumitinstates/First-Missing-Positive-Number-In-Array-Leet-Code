package com.sumit;

public class Solution {
	
	// requirement of this problem is to have :
	// 1. Space complexity of O(1) so we can't use stack or set as it will 
	//    O(n) space
	// 2. Time complexity of O(n)
	
	   public static int firstMissingPositive(int[] nums) {
		   
		  /* Algorithm works like this:
		   * Step 1: Change all the numbers less than or equal to zero and greater
		   * than the length of array to n+1.
		   * Step 2: Traverse the array and deduct 1 from the current absolute value.
		   * Then the result that we get after deduction, go to that index and flip the
		   * number at the index to negative if the number is
		   * less than length of array. But if lets say number is more than the
		   * length of array then just continue.
		   * Step 3: Traverse array and find the index of first non - negative number 
		   * and then add 1 to that index. So the answer will be index+1
		   * Step 4: Range of finding non-negative value is 1 to n+1. 
		   * example - array = {1,2,3}
		   * so first positive number that is missing will be 4 which is n+1,
		   * where "n" is length of array.
		   */
	        
		   //Step 1
		   for(int i=0 ;i<nums.length;i++) 
		   {
			   if(nums[i]<=0 || nums[i]>nums.length) 
			   {
				   //switching number to n+1, where n is length of array
				   nums[i] = nums.length+1;
			   }
		   }
		   
		   //Step 2
		   for(int i=0; i<nums.length; i++) 
		   {
			   int absoluteValue = Math.abs(nums[i]);
			   
			   //if number is greater than length of array
			   if(absoluteValue > nums.length) {
				   continue;
			   }
			   
			   //find index after deducting 1 from absolute number
			   int index = absoluteValue -1;
			   
			   //if number at index > 0
			   if(nums[index]>0) 
			   {
				   //flip the number to negative number 
				   nums[index] = -nums[index];
			   }
		   }
		   
		   //Step 3
		   for(int i=0; i<nums.length; i++) 
		   {
			   //find first index of non negative number
			   if(nums[i]>0) 
			   {
				   //adding 1 to that index and returning
				   return i+1;
			   }
		   }
		   
		   //Step 4
		   return nums.length+1;
	    }
	   
	   public static void main(String[] args) {
		
		int [] array = {3,4,-1,1};
		System.out.println(Solution.firstMissingPositive(array));
	}

}
