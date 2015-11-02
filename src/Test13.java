import java.util.*;
/**
 * Leetcode Word Ladder II
 * @author houxiang
 *
 */
class Pair {
	String str;
	ArrayList<String> path;
	HashSet<String> hash;

	public Pair(String str, ArrayList<String> path, HashSet<String> hash) {
		// TODO Auto-generated constructor stub
		this.str = str;
		this.path = path;
		this.hash = hash;
	}
}

public class Test13 {
	public List<List<String>> findLadders(String beginWord, String endWord,
			Set<String> wordList) {
		String begin = beginWord;
		List<String> list = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		ArrayList<String> path = new ArrayList<String>();
		HashSet<String> hash = new HashSet<String>();
		path.add(beginWord);
		hash.add(beginWord);
		Queue<Pair> queue = new LinkedList<Pair>();
		Pair node = new Pair(begin, path, hash);
		queue.add(node);
		int minLen = -1 ;
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			String str = pair.str;
			
			char[] strCharArr = str.toCharArray();
			for (int i = 0; i < strCharArr.length; i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (strCharArr[i]==ch) {
						continue;
					}
					strCharArr[i] = ch ;
					String newWord = new String(strCharArr);
					if (newWord.equals(endWord)) {
						path = pair.path ;
						if (minLen == -1 ) {
							minLen = newWord.length() ;
						}else if (minLen > newWord.length()){
							return result ;
						}else{
							result.add(path);
						}
					}else if(wordList.contains(newWord)&& !node.hash.contains(newWord)){
						ArrayList<String> newPath = new ArrayList<String>(node.path);
						HashSet<String> newHash = new HashSet<String>(node.hash);
						newPath.add(newWord);
						newHash.add(newWord);
						Pair newNode = new Pair(newWord, newPath , newHash);
						queue.add(newNode);
					}
				}
			}

		}
			return result ;
	}
	public static void main(String[] args) {
		Test13 test = new Test13() ;
		String beginWord = "hit";
		String endWord = "cog";
		String[] list ={"hot","dot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>();
		for(String str : list){
			wordList.add(str);
		}
		
		System.out.println(test.findLadders(beginWord, endWord, wordList));
	}
}
