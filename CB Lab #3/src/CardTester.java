/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card c1 = new Card("4", "heart", 3);
		Card c2 = new Card("4", "heart", 3);
		Card c3 = new Card("King", "diamond", 2);
		
		System.out.println(c1.suit());
		System.out.println(c1.rank());
		System.out.println(c1.pointValue());
		
		System.out.println(c1.matches(c2));
		System.out.println(c1.matches(c3));
		
		System.out.println(c1);
	}
}
