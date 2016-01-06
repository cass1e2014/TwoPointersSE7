import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not
 * matter).所以bar和foo或者foo和bar都可以的！！
 * 
 * 题目中0到5，9到14包含words中的所有单词，所以返回starting indices0和9
 * 
 * @author cassie9082
 * 
 */
public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args){
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		System.out.println(Arrays.toString(findSubstring(s, words).toArray()));
	}
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();
		// m记录words[]的长度，n记录words[]中每个string的长度
		int m = words.length;//2
		int n = words[0].length();//3
		// 过一遍words[]放到toFind的hashmap中，string在words[]中有可能出现多次，要统计次数
		for (int i = 0; i < m; i++) {
			if (!toFind.containsKey(words[i])) {
				toFind.put(words[i], 1);
			} else {
				toFind.put(words[i], toFind.get(words[i]) + 1);
			}
		}

		// 和Strstr()很像
		//在大string s上移动看能否找到连续的foobar，m*n+1=7， 因为s只需移动到foobar得开头第一个字母
		for (int i = 0; i < s.length() - m * n + 1; i++) {
			found.clear();
			int j;
			//j移动2次（words[] 单词的个数
			for (j = 0; j < m; j++) {
				int k = i + j * n; //j*n， 在i起始点的基础上每次3个3个移动，决定于words[]中每个单词的长度
				String stub = s.substring(k, k + n);
				if (!toFind.containsKey(stub)) {
					break;
				}
				if (!found.containsKey(stub)) {
					found.put(stub, 1);
				} else {
					found.put(stub, found.get(stub) + 1);
				}
				if (found.get(stub) > toFind.get(stub)) {
					break;
				}
			}
			//当找到words[]中所有的单词，返回开始的index
			if (j == m) {
				result.add(i);
			}
		}
		return result;
	}
	
	
	//解法二：
	//使用滑块的概念来解决问题。始终保持words集合中的字符串在滑块中都只出现过一次。当count等于words集合长度的时候，即找到了一段符合要求的字符串
	//left：记录滑块的左起点。
	//count: 保存当前滑块中的单词总数
	/**
	 * 
	 * 因为L中所有单词的长度是一样的，这样根据wordLen，可以将S分为wordLen组，实际意思是这样的。
	 * bar|foo|the|foo|bar|man
	 * ba|rfo|oth|efo|oba|rma|n
	 * b|arf|oot|hef|oob|arm|an
	 * @param S
	 * @param L
	 * @return
	 */
	
	public static List<Integer> findSubstringII (String S, String[] L){
		List<Integer> result = new ArrayList<Integer>();
		if(S == null || S.length() == 0 || L == null || L.length == 0){
			return result;
		}
		
		int strLen = S.length();
		int wordLen = L[0].length();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < L.length; i++){
			if(map.containsKey(L[i])){
				map.put(L[i], map.get(L[i]) + 1);
			}else{
				map.put(L[i], 1);
			}	
		}
		
		for(int i = 0; i < wordLen; i++){
			HashMap<String, Integer> curMap = new HashMap<String, Integer>();
			int count = 0, left = i;
			for(int j = i; j <= strLen - wordLen; j += wordLen){
				String curStr = S.substring(j, j + wordLen);
				if(map.containsKey(curStr)){
					if(curMap.containsKey(curStr)){
						curMap.put(curStr, curMap.get(curStr) + 1);
					}else{
						curMap.put(curStr, 1);
					}
					
					//检查该单词的计数是否小于等于总单词表中该单词的总数
					if(curMap.get(curStr) <= map.get(curStr)){
						count ++;
					}else{
						//当前滑块中有单词的出现次数超过了总单词表中单词的出现次数。需要收缩滑块来剔除这个单词
						//从滑块的左起点开始寻找该单词，把之前加入到curMap的其他单词要取出并且count--；找到之后，将该单词的右端点作为滑块新的左起点
						while(true){
							String tmp = S.substring(left, left + wordLen);
							curMap.put(tmp,  curMap.get(tmp) - 1);
							left += wordLen;
							//找到该单词后
							if(curStr.equals(tmp)){
								break;
							}else{
								count --;
							}
						}
					}
					if(count == L.length){
						result.add(left);
						String tmp = S.substring(left, left + wordLen);
						curMap.put(tmp, curMap.get(tmp) - 1);
						left += wordLen;
						count --;
					}
				}else{
					//如果单词不在总单词表(L[])里，则清空当前滑块的单词表，将count设置为零，将left移动到下一个位置。
					curMap.clear();
					count = 0;
					left = j + wordLen;
				}
			}
		}
		return result;		
	}
}
