package nfa035.question2;

public class Mystere {
	
	
	public static void main(String[] args) {
		int x= 2;
		int y= 5;
		int r= mystere(x,y);
		System.out.println("Résultat "+ r);
	}

	private static int mystere(int a, int b) {
		int r= 1;
		while (b != 0) {
			if (b % 2 == 0) {
				a= a * a;
				b= b /2;
			} else {
				r= r*a;
				b= b -1;
			}
		}
		return r;
	}
}
