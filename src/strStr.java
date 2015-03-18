/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author cassie9082
 * 
 */

public class strStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}

		if(haystack.length() < needle.length()){
            return -1;
        }
		
		int i, j;
		// 外圈for loop是控制赫needle一样长度的string再haystack会出现多少次，即分为i格
		// 内圈for loop是跑needle的长度次数，和上面的每一个一个个比较，当出现不同当字母时，就不用再比那个格子来，break，再到外圈for
		// loop换一格
		for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}
}
