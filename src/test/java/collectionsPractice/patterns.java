package collectionsPractice;

public class patterns {
	
	public static void printbutterflyPattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i<=(n/2))
					if((i+j<n-1) && (i<j)) 
						System.out.print(" ");
					else
						System.out.print("*");
				else
					if((i+j>n-1) && (i>j)) 
						System.out.print(" ");
					else
						System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public static void printTrapeziodPattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<2*n;j++) {
				if( (i+j+1>n) && (i+j<2*n) )
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.print("\n");
		}
		
	}
	
	public static void printNumbersPattern(int n) {
		for (int i=1;i<=n;i++) {
			for(int j=1;j<2*n;j++) {
				if(i%2==0) {
					if(j+i-1>=n && j<n+i && j%2==0)
						System.out.print(i);
					else
						System.out.print(" ");
				}else {
					if(j+i-1>=n && j<n+i && j%2==1)
						System.out.print(i);
					else
						System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
	
	public static void printPalindromicPattern(int n) {
		for (int i=1;i<=n;i++) {
			for(int j=1;j<2*n;j++) {
				if(j+i-1>=n && j<n+i )
					System.out.print(Math.abs(n-j)+1);
				else
					System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	public static void printRhombusPattern(int n) {
		for (int i=1;i<2*n;i++) {
			for(int j=1;j<2*n;j++) {
				if(i<=n)
					if(j+i-1>=n && j<n+i )
						System.out.print("*");
					else
						System.out.print(" ");
				else {
					int cntr=i-n;
					if(j>cntr && j<2*n-cntr )
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		//patterns.printbutterflyPattern(8);
		//patterns.printTrapeziodPattern(5);
		//patterns.printNumbersPattern(5);
		//patterns.printPalindromicPattern(5);
		//patterns.printRhombusPattern(5);
	}

}
