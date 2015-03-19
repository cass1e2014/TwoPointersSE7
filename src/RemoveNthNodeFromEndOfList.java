/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author cassie9082
 * 
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n <= 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode preDelete = dummy;

		for (int i = 0; i < n; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}

		while (head != null) {
			head = head.next;// head会移动到最后一个node＋1处，即null
			preDelete = preDelete.next;
		}
		preDelete.next = preDelete.next.next;
		return dummy.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
