/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target = 9 
 * Output: index1=1, index2=2
 */

import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {

	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 5};
		int target = 9;
		TwoSum ts = new TwoSum();
		int[] res = ts.twoSum(numbers, target);
		System.out.println(Arrays.toString(res));

	}

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < numbers.length; i++){
			if(map.containsKey(target - numbers[i])){
				result[0] = map.get(target - numbers[i]) + 1;
				result[1] = i + 1;
			}else{
				map.put(numbers[i], i);
			}
		}
		return result;
	}
}
