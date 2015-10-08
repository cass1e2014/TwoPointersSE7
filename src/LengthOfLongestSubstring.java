/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author cassie9082
 * 
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s){
		if(s == null || s.length() ==0){
            return 0;
        }
        
        boolean[] flag = new boolean[256];
        
        char[] charArray = s.toCharArray();
        
        int result = 0;
        int start = 0;
        for(int i = 0; i < charArray.length ; i++){
            char current = charArray[i];
            if(flag[current]){
                result = Math.max(result, i - start);
                //sliding window
                for(int j = start; j < i; j++){
                    if(charArray[j] == current){
                        start = j + 1;
                        break;
                    }
                    flag[charArray[j]] = false;
                }
            }else{
                flag[current] = true;
            }
        }
        result = Math.max (charArray.length - start, result);
        return result;
	}

}
