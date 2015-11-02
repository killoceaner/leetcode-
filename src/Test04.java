import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test04 {
	/**
	 * public String replaceSpace(String iniString, int length) { // write code
	 * here char[] chars = iniString.toCharArray(); String str = iniString;
	 * StringBuilder builder = new StringBuilder(); int index = 0; int i = 0;
	 * for (; i < chars.length; i++) { char c = chars[i]; if (c == ' ') {
	 * builder.append(str.substring(index+1, i)); builder.append("20%"); index =
	 * i; } } if (index==0) { builder.append(str.substring(index, i)); }else{
	 * builder.append(str.substring(index+1, i)); } return builder.toString(); }
	 * 
	 * 
	 * 
	 * public String zipString(String iniString) { // write code here char[] c =
	 * iniString.toCharArray(); Map<Character,Integer> map = new
	 * TreeMap<Character, Integer>(); for(int i= 0; i<c.length;i++){ if
	 * (map.containsKey(c[i])) { map.put(c[i], ((int)map.get(c[i]))+1); }else{
	 * map.put(c[i], 1); } }
	 * 
	 * StringBuilder builder = new StringBuilder(); for(Map.Entry<Character,
	 * Integer> entry : map.entrySet() ){ String key =
	 * String.valueOf(entry.getKey()); String value =
	 * String.valueOf(entry.getValue()); builder.append(key+value); } return
	 * builder.toString(); }
	 * 
	 * 
	 * public String zipString(String iniString){ char[] c =
	 * iniString.toCharArray(); //List<Character> list = new
	 * ArrayList<Character>(); StringBuilder builder = new StringBuilder(); int
	 * count = 1 ; for(int i = 1 ; i<c.length;i++){ if(c[i]==c[i-1]){ count ++;
	 * }else if(i==c.length-1&&c[i]==c[i-1]){
	 * 
	 * } else{ builder.append(c[i-1]); builder.append(count); count=1; } }
	 * return builder.toString(); }
	 * 
	 * 
	 * public ListNode deleteDuplucates(ListNode head){ ListNode list = head; if
	 * (head.next==null) { return head; } ListNode index = head ; Map<Integer,
	 * Integer> map = new LinkedHashMap<Integer, Integer>();
	 * while(index.next!=null){ map.put(index.val, 1); }
	 * Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
	 * while(itr.hasNext()){ ListNode node = new ListNode(itr.next().getKey());
	 * list.next = node ; } return head; }
	 * 
	 * public List<Integer> getRow(int rowIndex) { List<Integer> res = new
	 * ArrayList<Integer>();
	 * 
	 * if(rowIndex < 0 ){ return null; } int i = 0; for( ; i<= rowIndex ;i++){
	 * res.add(1); for(int j = i -1 ; j>0 ; j--){ res.set(j,
	 * res.get(j)+res.get(j-1)); } }
	 * 
	 * return res ; }
	 * 
	 * 
	 * public int findMin(int[] nums) { if (nums.length == 0 ) { return
	 * (Integer) null; } for(int i = 0 ; i < nums.length ; i++){
	 * if(nums[i]>nums[i+1]) return nums[i+1]; } return nums[nums.length-1]; }
	 * 
	 * public String replaceSpace(String iniString, int length){
	 * if(iniString==null||iniString.length()==0) return iniString; char[] c =
	 * iniString.toCharArray(); int count = 0 ; for(int i = 0 ; i<c.length;i++){
	 * if(c[i]==' '){ count++; } } char[] d = new char[length+count*2]; int
	 * index =0 ; for(int i =0 ; i<c.length;i++){ if(c[i]==' '){ d[index]='2';
	 * d[index+1]='0'; d[index+2]='%'; index += 3; }else { d[index]=c[i]; index
	 * ++ ; } } return String.valueOf(d); }
	 **/
	public static void main(String[] args) {
		Test04 t = new Test04();
		// String ans =
		// t.replaceSpace("ArcCNxjNaviToUsSN QiTtx j bgUhhIoiSfszja QfFkxk JwYOoFSg dhdMKgTxjRrcATfkb ELqIebLGZk kAESkrNJxbmci nyojZqX vawG kxvqf moWAA m aMuilydRRNvVuh Uss mJtnZb zA oF cx hUQD V dSLSLcbjXLydl V dReEozdi ZO IxbW CgcTeobRrmco ELs cQh K xlg Pj cGaO yXKXy hs kmJaSdNV Z InShcp AxoM hHLTsIMhcHKnArxgRVjh MclqtzFpl yzaWlhLfYlfxNFgb",331);
		// String ans = t.zipString("aabcccccaaa");
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node15 = new TreeNode(15, null, null);
		TreeNode node20 = new TreeNode(20, node7, node15);
		TreeNode node9 = new TreeNode(9, null, null);
		TreeNode node3 = new TreeNode(3, node9, node20);

//		List<List<Integer>> ans = t.zigzagLevelOrder(node3);
//		System.out.println(ans);
		t.hIndex();
	}
	
	public void hIndex() {
				
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("a", null);
		map.put("d", "e");
		System.out.println(map.size());
		
		
		Set<ListNode> set = new TreeSet<ListNode>(new Comparator<ListNode>() {
			
			
			public int compare(ListNode o1, ListNode o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1.val, o2.val);
		}
		}); 
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if (root == null) {
			return ans;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = 0;
		queue.add(root);
		boolean flag = false;
		while (!queue.isEmpty()) {
			num = queue.size();
			list.clear();
			for (int i = 0; i < num; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (flag) {
				Collections.reverse(list);
				flag = false;
			} else {
				flag = true;
			}

			ans.add(new ArrayList<Integer>(list));

		}
		return ans;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}