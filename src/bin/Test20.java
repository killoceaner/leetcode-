package bin;

public class Test20 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}

		int count = 0;
		ListNode runner = head;
		ListNode walker = head;
		
		while (walker.next != null && count < n) {
			walker = walker.next;
			count++;
		}

		while (walker.next != null) {
			runner = runner.next;
			walker = walker.next;
		}
		if (runner.next.next != null) {
			runner.next = runner.next.next;
		}
		return head;
	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);

		n1.next = n2;

		Test20 t = new Test20();
		ListNode list = t.removeNthFromEnd(n1, 1);
		while (list.next != null) {
			System.out.println(list.val);
			list = list.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		// TODO Auto-generated constructor stub
		val = x;
	}
}