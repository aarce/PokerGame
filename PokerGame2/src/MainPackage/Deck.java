//Abraham Arce
//Abdullah AL-Sinaidi
// Jon Garcia
// Fatemah Sedigh
// Zulfiqar Salahuddin
package MainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck_of_cards;

	public Deck() {
		ArrayList<Card> deckofcards = new ArrayList<Card>();
		for (short x = 0; x < 4; x++) {
			

			for (short y = 0; y < 13; y++) {

				Card append_new = new Card((short) x, (short) y );
				deckofcards.add(append_new);
			}
		}
		deck_of_cards = deckofcards;
		
		Collections.shuffle(deck_of_cards);
		
}

	public Card draw() {
		Card get_first_card = deck_of_cards.get(0);
		deck_of_cards.remove(0);
		return get_first_card;
	}

	public int remaining_cards() {

		return deck_of_cards.size();

	}

}