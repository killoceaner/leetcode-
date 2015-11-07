package bin;
/**
 * 
 * @author houxiang
 *
 */
public class Test20 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p1 = head ;
		ListNode p2 = head ;
		ListNode removeNode = head ;
		int i = 0 ;
		while(i<n){
			p1 = p1.next;
			i++;
		}
		if (p1 == null) {
			return p1.next ;
		}
		while (p1.next!=null) {
			p1 = p1.next ;
			removeNode = removeNode.next;
			p1 = removeNode ;
		}
		
		if (p2 == removeNode) {
			return head.next;
		}else{
			p2.next = removeNode.next ;
		}
		return head ;
	}

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		
		//n1.next = n2;

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