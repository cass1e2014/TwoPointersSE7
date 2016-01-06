import java.util.Arrays;

/**
 * 
 * @author Cassie 
 *         Given an array S of n integers, find three integers in S such that the sum is closest to a given
 *         number, target. Return the sum of the three integers. You may assume that each input would have exactly one
 *         solution.
 * 
 *         For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2
 *         + 1 = 2).
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		//

	}

	public int threeSumClosest(int[] num, int target) {
		if (num == null) {
			return -1;
		}

		if (num.length < 3) {
			return -1;
		}

		Arrays.sort(num);

		int closest = num[0] + num[1] + num[num.length - 1];
		for (int i = 0; i < num.length - 2; i++) {
			int p = i + 1;
			int q = num.length - 1;

			while (p < q) {
				int sum = num[i] + num[p] + num[q];
				if (sum == target) {
					return sum;
				}

				if (Math.abs(target - sum) < Math.abs(target - closest)) {
					closest = sum;
				} else if (sum < target) {
					do {
						p++;
					} while (p < q && num[p] == num[p - 1]);
				} else if (sum > target) {
					do {
						q--;
					} while (p < q && num[q] == num[q + 1]);
				}
			}
		}
		return closest;
	}

}
