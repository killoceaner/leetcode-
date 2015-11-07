public class Test21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode p1 = l1 ;
		ListNode p2 = l2 ;
		
		ListNode result = null ;
		
		
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
		
		if (p1.next != null) {
			while(p1.next!=null){
				result.next = p1 ;
				result = p1;
				p1 = p1.next ;
			}
		}else if (p2.next!= null){
			while(p2.next!=null){
				result.next = p2 ;
				result = p2 ;
				p2 = p2.next ;
			}
		}
		
		return result ;
	}
	
	public static void main(String[] args) {
		
	}
}

class ListNode{
	int val ;
	ListNode next ;
	public ListNode(int i) {
		// TODO Auto-generated constructor stub
		this.val = val ;
	}
}