//Abraham Arce
//Abdullah AL-Sinaidi
// Jon Garcia
// Fatemah Sedigh
// Zulfiqar Salahuddin
package MainPackage;


public class Card {

	private short CardValue;//attributes / the rank of card

	private short CardSuit;//attributes

	private int CardNumber;//attributes

	private static String[] Suit = { "Spades", "Hearts", "Clubs", "Diamonds" };

	private static String[] Value = { "A", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "J", "Q", "K" };

	public Card() {

	}

	public Card(short Cardvalue, short Cardsuit) {

		CardValue = Cardvalue;

		CardSuit = Cardsuit;
	}

	public short getValue() {

		return CardValue;

	}

	public short getSuit() {

		return CardSuit;

	}


}