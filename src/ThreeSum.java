import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is: (-1, 0, 1), (-1, -1, 2)
 */

public class ThreeSum {

	public static void main(String[] args) {
		int[] num = {-1, 0, 1, 2, -1, -4};
		ThreeSum ts3 = new ThreeSum();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = ts3.threeSum(num);
		System.out.println(res.size());

	}

	public List<List<Integer>> threeSum(int[] num) {
		if (num == null) {
			return null;
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length < 3) {
			return result;
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {
			if ( i > 0 && num[i] == num[i - 1]) {
				continue;
			}

			int p = i + 1;
			int q = num.length - 1;

			while (p < q) {
				if (num[i] + num[p] + num[q] == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[p]);
					list.add(num[q]);
					result.add(list);

					do {
						p++;
					} while (p < q && num[p] == num[p - 1]);

					do {
						q--;
					} while (p < q && num[q] == num[q + 1]);

				} else if (num[i] + num[p] + num[q] > 0) {
					do {
						q--;
					} while (p < q && num[q] == num[q + 1]);
				} else {
					do {
						p++;
					} while (p < q && num[p] == num[p - 1]);
				}
			}
		}
		return result;

	}

}
