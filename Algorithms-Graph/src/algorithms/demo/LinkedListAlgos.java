package algorithms.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LinkedListAlgos {
	
	private  List<Integer> ll1 ;
	private  List<Integer> ll2 ;
	
	public  void popuateLinkedList() {
		Integer[] arr1 = new Integer[]{4,5,1,57,34,23,76,46};
		Integer[] arr2 = new Integer[]{40, 32, 64, 12, 23, 57, 7, 3};
		
		ll1 = new LinkedList<Integer>(Arrays.asList(arr1));
		ll2 = new LinkedList<Integer>(Arrays.asList(arr2));
		
	}
	
	public void javaSort() {
		   this.ll1.addAll(this.ll2);
		   this.ll1.sort(null);
		   printContents(this.ll1);
		   
	}
	
	public void removeDups() {
		Set<Integer> llset = new LinkedHashSet<>();
		llset.addAll(this.ll1);
		
		printContents(llset);
	}
	
	public void printContents(Collection<Integer> c){
		
 
		   for(Integer i : c) {
			   System.out.print(i + " " );
		   }
		   
		   System.out.println("");
		
	}
	
   public static void main(String[] args){
	   
	   
	   LinkedListAlgos llalgo = new LinkedListAlgos();
	   llalgo.popuateLinkedList();
	   llalgo.javaSort();
	   llalgo.removeDups();
	   
	   
   }
	

}
