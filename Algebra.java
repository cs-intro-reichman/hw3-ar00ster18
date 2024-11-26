// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0){
			for (int i = 0; i < x2; i++){
				x1++;
			}
		} else {
			for (int i = x2; i < 0; i++){
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 > 0){
			for (int i = 0; i < x2; i++){
				x1--;
			}
		} else {
			for (int i = x2; i < 0; i++){
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int product = 0;
		if(x2 > 0){
			for (int i = 0; i < x2; i++){
				product = plus(product, x1);
			}
		} else {
			for (int i = x2; i < 0; i++){
				product = minus(product, x1);
			}
		}
		return product;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int product = 1;
		for(int j = 0; j < n; j++){
			product = times(product, x);
		}
		return product;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int quotient = 0;
		if (x1 > 0 && x2 > 0){
			while(x1 >= x2){
				x1 = minus(x1, x2);
				quotient++;
			}
		} else if (x1 > 0 && x2 < 0){
			while(x1 >= times(-1, x2)){
				x1 = plus(x1, x2);
				quotient++;
			}
		} else if (x1 < 0 && x2 > 0){
			while(x1 <= times(-1, x2)){
				x1 = plus(x1, x2);
				quotient++;
			}
		} else if (x1 < 0 && x2 < 0){
			while (x1 <= x2){
				x1 = plus(x1, x2);
				quotient++;
			}
		}
		return quotient;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int remainder = minus(x1, times(div(x1, x2), x2));
		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int root = 1;
		if(x != 0){
			while (root < div(x, root)){
				root++;
			}
		} else {
			root = 0;
		}
		return root;
	}	  	  
}