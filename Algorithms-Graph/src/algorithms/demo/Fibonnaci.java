package algorithms.demo;

public class Fibonnaci {
	
	public static int getFibonacci(int n){
		int pprev = 0;
		int prev = 1;
		int retVal = 0;
		
		if( n == 0 || n == 1){
			return n;
		}
		
		for(int i=2; i<=n; i++){
			
			retVal = prev + pprev;
			pprev = prev;
			prev = retVal;
		}
		
		return retVal;
	}
	
	public static void main(String[] args){
		//Test with 7
		int n = 7;
		int fib = getFibonacci(n);
		System.out.println("The fibonacci number for " + n + " is " + fib);
		
	}

}
