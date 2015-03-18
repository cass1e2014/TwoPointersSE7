/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */

public class RemoveDupicatesFromSortedArray {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17 };
		RemoveDupicatesFromSortedArray ex = new RemoveDupicatesFromSortedArray();
		int res = ex.removeDuplicates(A);
		System.out.print(res);
	}

	public int removeDuplicates(int[] A) {
		if(A.length < 2){
			return A.length;
		}
		
		//size 是记录array size的一个指针，所以当有不同数字的时候，size指针要移动
		//pointer是记录重复元素的一个指针
		int size = 0;
		int pointer = size + 1;
		
		while(size < A.length && pointer < A.length){
			if(A[size] == A[pointer]){
				pointer++;
			}else{
				A[++size] = A[pointer];//当遇到不同元素时，先把size指针移动到pointer指针所在的位置，再把pointer指针往后移。
				pointer++;
			}
		}
		return size + 1;
	}
}
