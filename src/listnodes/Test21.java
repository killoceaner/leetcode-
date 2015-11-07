package listnodes;
/**
 * Merge Two Sorted Lists
 * @author houxiang
 *
 */
public class Test21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1 ;
		ListNode p2 = l2 ;
		
		ListNode fakehead = new ListNode(0);
		ListNode result = fakehead ;
		
		while(p1.next!= null && p2.next!=null ){
			if (p1.val < p2.val) {
				result.next = p1;
				p1 = p1.next;
			}else if(p2.val < p1.val){
				result.next = p2;
				p2 = p2.next;
			}else{
				result.next = p1 ;
				p1 = p1.next ;
				result.next = p2 ;
				p2 = p2.next ;
			}
			result = result.next ;
		}
		
		if (p1!= null) {
			result.next = p1;
		}else if (p2!= null){
			result.next = p2 ;
		}
		
		return fakehead.next ;
	}
	
	public static void main(String[] args) {
		
	}
}

