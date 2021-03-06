import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */

public class FourSum {

	public static void main(String[] args) {
		int[] num = {1, 0, -1, 0, -2, 2};
		int target = 0;
		FourSum fs = new FourSum();
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		temp = fs.fourSum(num, target);
		
		

	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		 if(num == null){
				return null;
			}
			
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if(num.length < 4){
				return result;
			}
			
			Arrays.sort(num);
			
			for(int i = 0; i < num.length - 3; i++){
				if(i > 0 && num[i] == num[i - 1]){
					continue;
				}
				
				int sum = 0;
				for(int j = i + 1; j < num.length - 2; j++){
					if(j > i + 1 && num[j] == num[j - 1]){
						continue;
					}
					
					int p = j + 1;
					int q = num.length - 1;
					
					while(p < q){
						sum = num[i] + num[j] + num[p] + num[q];
						if(sum == target){
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(num[i]);
							list.add(num[j]);
							list.add(num[p]);
							list.add(num[q]);
							result.add(list);
							
							do{
								p ++;
							}while(num[p] == num[p - 1] && p < q);
							do{
								q--;
							}while(num[q] == num[q + 1] && p < q);
						}else if(sum < target){
							do{
								p ++;
							}while(num[p] == num[p - 1] && p < q);
						}else if(sum > target){
						    do{
						    	q --;
						    }while(num[q] == num[q + 1] && p < q);
						}
					}
				}
			}
			return result;
	}

}
