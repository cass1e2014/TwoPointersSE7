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
	
	public int removeDuplicates(int[] A) {
        	if(A.length < 2){
        		return A.length;
        	}
        	
        	int size = 0;
        	int pointer = size + 1;
        	int count = 0;
        	
        	//多了一個count來記錄有沒有額外的重複元素。
        	//遇到重複元素時，只有count為零的時候，size和pointer都要移動。
        	while(size < A.length && pointer < A.length){
        		if(A[size] == A[pointer]){
        			if(count == 0){
        				size ++;
        				pointer ++;
        				count ++;
        				System.out.println("find duplicates, count == 0, the size is: " + size + " , the pointer: " + pointer + ", count: " + count );
        			}else{
        				pointer ++;
        				System.out.println("find duplicates, but count != 0, the pointer is = " + pointer);
        			}
        		}else{
        			count = 0;
        			A[++ size] = A[pointer];
        			pointer ++;
        			System.out.println("not duplicates: after move, the pointer is = " + pointer);
        		}
        	}
        	return size + 1;
    }

}
