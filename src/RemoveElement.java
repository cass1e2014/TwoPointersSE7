/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author cassie9082
 * 
 * two pointer
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int i = 0; 
		int pointer = nums.length - 1;
		
		while(i < pointer){
			if(nums[i] == val){
				nums[i] = nums[pointer];
				pointer --;
			}else{
				i ++;
			}
		}
		return pointer + 1;
	}
}
