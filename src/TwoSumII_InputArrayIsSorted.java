/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * @author cassie9082
 * 
 */
public class TwoSumII_InputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2)
			return null;
		int lo = 0;
		int hi = numbers.length - 1;

		int[] result = new int[2];
		while (lo < hi) {
			if (numbers[lo] + numbers[hi] == target) {
				result[0] = lo + 1;
				result[1] = hi + 1;
				return result;
			} else if (numbers[lo] + numbers[hi] > target) {
				hi--;
			} else {
				lo++;
			}
		}
		return result;
	}
}
