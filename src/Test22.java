/**
 * Swap Nodes in Pairs
 * @author houxiang
 *
 */

public class Test22 {
	public ListNode swapPairs(ListNode head) {
		if (head == null ) {
			return null ;
		}
		
		ListNode fakeNode = new ListNode(0);
		fakeNode.next = head ;
		
		ListNode pre = fakeNode ;
		ListNode ptr = head;
		//分别注意节点个数为奇数和偶数的两种情况
		while(pre.next!=null&&pre.next.next!=null){	
			ListNode nextStart = ptr.next.next;
			
			ptr.next.next = ptr;
			pre.next = ptr.next;
			ptr.next = nextStart;
			pre = ptr;
			ptr = nextStart;
		}
		
		return fakeNode.next;
	}
	
	public static void main(String[] args) {
		Test22 t = new Test22();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		//l5.next = l6;
		ListNode result = t.swapPairs(l1);
		while(result!=null){
			System.out.println(result.val);
			result = result.next;
		}
	}
}
