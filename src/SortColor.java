import java.util.Arrays;

/*
 * Given an array with n objects colored red, white or blue, sort them so that objects 
 * of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * 1. 計算出現頻率
 * 2. 類似 quick sort, front pointer 對應 0, back pointer 對應 2, i 在中間跑對應 1
 */
public class SortColor {

	public static void main(String[] args) {
		int[] A = { 0, 2, 1, 2, 0, 2, 0, 2, 0, 2, 0, 1, 1, 0, 2, 1 };
		SortColor s = new SortColor();
		s.sortColors(A);
		System.out.println(Arrays.toString(A));
	}

	public void sortColors(int[] A) {
		int i = 0, front = 0, back = A.length - 1;
		while (i < A.length) {
			if (i > back || i < front) {
				break;
			}

			switch (A[i]) {
			case 1:
				i++;// 略过
				break;
			case 2:
				swap(A, i, back);
				i++;
				back--;
				break;
			case 0:
				swap(A, i, front);
				i++;
				front++;
				break;
			}
		}
	}
	
	public void swap(int[] c, int j, int toSwap){
		int temp = c[j];
		c[j] = c[toSwap];
		c[toSwap] = temp;
	}
}
