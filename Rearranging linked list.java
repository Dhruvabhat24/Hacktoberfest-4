import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure
    
    class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	    }
   }

************************************************************/

public class Solution {
	public static Node reverse(Node head) {
		Node curr =  head;
		Node prev = null;
		Node Next = null;
		while(curr != null)
		{
			Next  = curr.next;
			curr.next = prev;
			prev = curr;
			curr = Next;
		}
		return prev;
	}
	public static Node rearrangeList(Node head)
	{
		// Write your code here.
		if (head == null || head.next == null)	return head;

		Node slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node partTwo = reverse(slow);
		Node partOne = head;

		while (partTwo.next!=null) {
			Node partOneNext = partOne.next;
			partOne.next = partTwo;

			Node partTwoNext = partTwo.next;
			partTwo.next = partOneNext;

			partOne = partOneNext;
			partTwo = partTwoNext;
		}

		return head;
	}
}
