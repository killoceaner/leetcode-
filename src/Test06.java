import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test06 {
	private final static int max = 10001;
	private static int n;
	private static int tree[];

	// 对并查集进行初始化
	public static void treeSet(int tree[]) {
		for (int i = 0; i < tree.length; i++) {
			tree[i] = -1;
		}
	}

	// 查找树的根元素
	public static int findSet(int x) {
		if (tree[x] == -1) {
			return x;
		}
		int root = x;
		while (tree[root] != -1) {
			root = tree[root];
		}
		int tmp = x;
		while (tmp != root) {
			int father = tree[tmp];
			tree[tmp] = root;
			tmp = father;
		}
		return root;
	}

	// 合并并查集
	public static int unionSet(int x, int y) {
		if (findSet(x) == findSet(y)) {
			return 0;
		} else {
			int xRoot = findSet(x);
			int yRoot = findSet(y);
			tree[xRoot] = yRoot;
			return 1;
		}
	}

	// 静态方法中不能调用动态方法；但是可以实例化对象
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nodeNum = in.nextInt();
		int edgeNum = in.nextInt();
		int minWeigh = 0;
		List<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < edgeNum; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			int distance = in.nextInt();
			Edge edge = new Edge(start, end, distance);

			edges.add(edge);
		}
		// 对边进行排序
		Collections.sort(edges);

		// 对并查集进行初始化
		n = nodeNum;
		tree = new int[n];
		treeSet(tree);

		//
		for (int i = 0; i < edges.size(); i++) {
			if (unionSet(edges.get(i).getSt(), edges.get(i).getEnd()) == 1) {
				minWeigh += edges.get(i).getDistance();
			}
		}
		
	    System.out.println("最小生成树的权值是"+minWeigh);
	}
}

class Edge implements Comparable {
	private int st;
	private int end;
	private int distance;

	public Edge() {

	}

	public Edge(int st, int end, int distance) {
		this.st = st;
		this.end = end;
		this.distance = distance;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.distance - ((Edge) o).distance;
	}
	
}
