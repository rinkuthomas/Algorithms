package algorithms.demo;

public class LinkedListAlgosNonJava {
	
	private class Node {
		int val;
		Node next, prev;
		
		public Node(int val){
			this.val = val;
			next = null;
			prev = null;
		}
	}
	
	//private int[] arr1 = new int[]{1,3,5,7,9};
	//private int[] arr2 = new int[]{2,4,6,8,10};
	
	private int[] arr1 = new int[]{1};
	private int[] arr2 = new int[]{2};
	
	
	private void mergeSortedLists() {
		
		Node headL1 = buildSortedList(arr1);
		Node headL2 = buildSortedList(arr2);
		
		int[] mergedarr = new int[10];
		int indx = 0;
		
		
		Node p1 = headL1;
		Node p2 = headL2;
		while(p1.next != null && p2.next != null){
			
				
				System.out.println("Comparing p1.val and p2.val : " + p1.val + " and " + p2.val);
				if(p2.val <= p1.val){
					mergedarr[indx++] = p2.val;
					p2 = p2.next;
					
				}
				else{
					mergedarr[indx++] = p1.val;
					p1 = p1.next;
					
				}
				
				
				
			
		}
		
		//Now the remaining elements
		while(p1.next != null){
			mergedarr[indx++] = p1.val;
			p1 = p1.next;
		}
		
		while(p2.next != null){
			mergedarr[indx++] = p2.val;
			p2 = p2.next;
		}
		
		//Now the last 2 elements
		if(p1.val != 0)
		{
			mergedarr[indx++] = p1.val;
		}
		
		if(p2.val != 0)
		{
			mergedarr[indx++] = p2.val;
		}
		
		Node mergedHead = buildSortedList(mergedarr);
		System.out.println("Printing out the merged sorted linked lists");
		printLinkedList(mergedHead);
	}
	
	private void printLinkedList(Node head){
		System.out.println("Printing the built linkedList : ");
		Node pointer = head;
		
		while(pointer.next != null){
			System.out.print(" " + pointer.val);
			pointer = pointer.next;
		}
		System.out.print(" " + pointer.val);
		
		System.out.println("");
	}
	
	private Node buildSortedList(int[] arr){
		
		Node head = new Node(arr[0]);
		Node pointer = head;
		
		for(int i=1; i<arr.length; i++){
			Node n = new Node(arr[i]);
			pointer.next = n;
			n.prev = pointer;
			pointer = n;
			
		}
		
		printLinkedList(head);
		
		return head;
		
	}
	
	public static void main(String[] args){
		
		LinkedListAlgosNonJava llanj = new LinkedListAlgosNonJava();
		llanj.mergeSortedLists();
	}

}
