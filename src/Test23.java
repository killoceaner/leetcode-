import java.util.Stack;
/**
 * Reverse Nodes in k-Group
 * @author houxiang
 *
 */
public class Test23 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null|| k == 1) {
			return head ;
		}
		
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head ;
		ListNode pre =fakeHead ;
		ListNode p = fakeHead.next;
		int count = 0 ;
		while(p!=null){
			count ++ ;
			ListNode next = p.next;
			if (count == k) {
				pre = reverse(pre, next);
				count = 0 ;
				p=pre;
			}
			p=p.next;
		}
		
		return fakeHead.next ;
	}
	
	private ListNode reverse(ListNode pre ,ListNode end ) {
		if (pre == null) {
			return pre ;
		}
		ListNode head = pre.next;
		ListNode cur = pre.next.next ;		
		while(cur != end){
			ListNode tmp = cur.next ;
			cur.next = pre.next;
			pre.next = cur;
			cur = tmp ;
		}
		head.next = end;
		return head ;
	}
	public static void main(String[] args) {
		Test23 t = new Test23();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ListNode result = t.reverseKGroup(l1, 4);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
