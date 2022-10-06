/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] rank = {"A", "2", "3", "4", "5", "K", "Q"};
		String[] suit = {"heart", "diamond", "diamond", "club", "spade", "club", "heart"};
		int [] value = {2, 5, 6, 3, 1, 1, 5};
		Deck d1 = new Deck(rank, suit, value);
		
		String[] rank2 = {"Q", "5", "3", "2", "5", "A", "J", "3"};
		String[] suit2 = {"heart", "club", "diamond", "heart", "spade", "diamond", "heart", "spade"};
		int [] value2 = {1, 4, 6, 3, 2, 1, 7, 2};
		Deck d2 = new Deck(rank2, suit2, value2);
		
		String[] rank3 = {"J", "K", "2", "7", "10", "A", "Q"};
		String[] suit3 = {"club", "diamond", "heart"};
		int [] value3 = {2, 7, 6, 7, 1, 2, 8};
		Deck d3 = new Deck(rank3, suit3, value3);
		
		String[] rank4 = {};
		String[] suit4 = {};
		int [] value4 = {};
		Deck d4 = new Deck(rank4, suit4, value4);
		
		System.out.println(d1.isEmpty());
		System.out.println(d4.isEmpty());
		
		System.out.println(d1.size());
		System.out.println(d2.size());
		
		System.out.println(d1.size());
		System.out.println(d1.deal());
		System.out.println(d1.deal());
		System.out.println(d1.size());
		
		System.out.println(d1);
		
	}
}
