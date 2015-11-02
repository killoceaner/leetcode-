import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tire {
	final int SIZE = 26;
	private TireNode root;

	Tire() {
		root = new TireNode();
	}

	public class TireNode {
		private int num;
		private TireNode[] son;
		private char val;
		private boolean isEnd;

		TireNode() {
			son = new TireNode[SIZE];
			isEnd = false;
			num = 0;
		}
	}

	// 建立字典树
	public void insert(String str) {

		if (str == null || str.length() == 0) {
			return;
		} else {
			TireNode node = root;// 插入根节点，根节点是不存字母的；
			int i = 0;
			for (; i < str.length(); i++) {
				int pos = str.charAt(i) - 'a';
				// System.out.println(str.charAt(i));
				// System.out.println(pos);
				if (node.son[pos] == null) {
					node.son[pos] = new TireNode();
					node.son[pos].val = str.charAt(i);
					node.son[pos].num++;
				} else {
					node.son[pos].num++;
				}
				node = node.son[pos];
			}
			node.isEnd = true;
		}
	}

	// 计算字典树的前缀
	public int countPreix(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		TireNode node = root;
		char[] str_char = str.toCharArray();
		for (int i = 0; i < str_char.length; i++) {
			int pos = str_char[i] - 'a';
			if (node.son[pos].val == str_char[i]) {
				node = node.son[pos];
			} else {
				return node.num;
			}
		}
		return node.num;
	}

	// 判断字典树中是否有我需要查询的单词
	public boolean hasWord(String str) {
		if (str == null || str.length() == 0) {
			return false;
		} else {
			TireNode node = root;
			char[] str_char = str.toCharArray();
			for (int i = 0; i < str_char.length; i++) {
				int pos = str_char[i] - 'a';
				if (node.son[pos].val == str_char[i]) {
					node = node.son[pos];
				} else {
					return false;
				}
			}
			return node.isEnd;
		}
	}

	// 二叉树的节点；
	class TreeNode {
		String name;
		TreeNode leftChild;
		TreeNode rightChild;
	}

	public static void main(String[] args) {
		Tire tree = new Tire();
		int count = 10;
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		Map<String, Integer> familyMap = new HashMap<String, Integer>();
		count <<= 3;

		while (in.hasNextLine()) {
			String tmp_name = in.nextLine();
			if (tmp_name.equals(""))
				break;
			char[] tmp_char = tmp_name.toCharArray();
			int i = 0;
			while (tmp_char[i] == ' ') {
				i++;
			}
			String name = tmp_name.trim().toLowerCase();
			tree.insert(name);// 开始构建家族姓名的字典书
			familyMap.put(name, i);
		}
		// 循环输出familyMap的值；
		for (Map.Entry<String, Integer> entry : familyMap.entrySet()) {
			System.out.println(entry.getKey() + "------" + entry.getValue());
		}
	}
}
