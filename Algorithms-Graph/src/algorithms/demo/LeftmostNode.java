package algorithms.demo;


public class LeftmostNode {
	
	//private static LinkedList<Node> binTree = new LinkedList<>();
	
	private static void populateTree(Node root){
		//Node root = new Node(10);
		
		int[] arrayOfNum = new int[]{4,15,3,2,11,13,5};
		
		for(int i=0; i<arrayOfNum.length; i++) {
			System.out.println("Processing index " + i + " for value " + arrayOfNum[i]);
			Node child = new Node(arrayOfNum[i]);
			
			addChildNode(root,child );
			   
		}
       
		
	}
	
	
	private static void addChildNode(Node root, Node child) {
		// TODO Auto-generated method stub
		if(child.elem <= root.elem){
			if(root.left != null){
				addChildNode(root.left, child);
			}
			else {
				root.addLeftNode(root, child);
			}
		}
		else {
			if(root.right != null) {
				addChildNode(root.right, child);
			}
			else {
				root.addRightNode(root, child);
			}
		}
		
	}


	
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
		populateTree(root);
		
		System.out.println("Starting the find for Leftmost node");
		Node leftMost = findLeftMostNode(root);
		System.out.println("Leftmost node is " + leftMost.elem );
		
		System.out.println("Starting the find for rightmost node");
		Node rightMost = findRightMostNode(root);
		System.out.println("Rightmost node is " + rightMost.elem );
		
	}


	private static Node findRightMostNode(Node root) {
		System.out.println("We are finding out the right of " + root.elem);
		
		while( root.right != null) {
			//System.out.println("Current node is " + root.elem + " and it's left is " + root.left.elem );
			 root = root.right;
		}
		return root;
	}


	private static Node findLeftMostNode(Node root) {
		
		System.out.println("We are finding out the left of " + root.elem);
		
		while( root.left != null) {
			//System.out.println("Current node is " + root.elem + " and it's left is " + root.left.elem );
			 root = root.left;
		}
		return root;
	}


	private static class Node {
		
		private Integer elem = 0;
		private Node left, right;
		
		public Node(int elem){
			this.elem = elem;
			left = null;
			right = null;
		}
		
		public  void addLeftNode(Node parent, Node child){
			System.out.println("Adding left child " + child.elem + " to parent " + parent.elem );
			parent.left = child;
		}
		
		public  void addRightNode(Node parent, Node child){
			System.out.println("Adding right child " + child.elem + " to parent " + parent.elem );
			parent.right = child;
		}
		
	}

}
