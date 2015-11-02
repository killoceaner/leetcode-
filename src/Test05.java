import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;



public class Test05 {
	public static void main(String[] args) {
		
	}
    





//建立字典书
public void insert(String str) {
	Tire tree = new Tire();
	if (!str.isEmpty() || str.length() == 0) {
		return;
	} else {
		Test05.Tire.TireNode node = tree.root;
		for (int i = 0; i < str.length(); i++) {
			char tmp_str = str.charAt(i);
			int pos = tmp_str-'a';
			if(node.son[pos]==null){
			}
			
	
		}
	}
}
class Tire {
	private int SIZE = 26;// 每一层的节点数最多为26个字母
	private TireNode root;// 树的根节点

	Tire() {
		root = new TireNode();
	}

	public class TireNode {
		private int num;// 有多少的单词通过这个节点
		private TireNode[] son;// 该节点所有的子节点
		private boolean isEnd;// 判断是不是叶节点

		TireNode() {
			this.num = 1;
			this.son = new TireNode[SIZE];
			isEnd = false;
		}
	}
}
}
