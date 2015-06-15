/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		int[] A = {1, 1, 1, 2, 2, 3};
		RemoveDuplicatesFromSortedArrayII rd = new RemoveDuplicatesFromSortedArrayII();
		int result = rd.removeDuplicates(A);
		System.out.print(result);
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }
        
       int prev = 1;
       int curr = 2;
       while(curr < nums.length){
           if(nums[curr] == nums[prev] && nums[curr] == nums[prev - 1]){
               curr ++;
           }else{
               prev ++;
               nums[prev] = nums[curr];
               curr ++;
           }
       }
       return prev + 1;
    }

}
