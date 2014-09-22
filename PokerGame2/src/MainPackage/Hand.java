//Abraham Arce
//Abdullah AL-Sinaidi
// Jon Garcia
// Fatemah Sedigh
// Zulfiqar Salahuddin
package MainPackage;

import java.util.ArrayList;
import java.util.Comparator;

public class Hand {
	private ArrayList<Card> cards;
	private int HandStrength;
	private int HighHand;
	private int LowHand;
	private int Kicker;
	private boolean Ace;
	private boolean Flush;
	private boolean Straight;

	public Hand(Deck d) {
		ArrayList<Card> GetFiveCards = new ArrayList<Card>();
		for (int x = 1; x < 6; x++) {
			GetFiveCards.add(d.draw());
		}
		cards = GetFiveCards;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public int getHandStrength() {
		return HandStrength;
	}


	public int getHighHand() {
		return HighHand;
	}

	public int getLowHand() {
		return LowHand;
	}
	public int getKicker() {
		return Kicker;
	}

	public boolean isAce() {
		return Ace;
	}

	public void card_eva() {

		// Ace evaluation
		if (cards.get(4).getValue() == (short) 0) {
			Ace = true;
		}

		// flush evaluation 	

		if (cards.get(0).getSuit() == cards.get(1).getSuit()
				&& cards.get(0).getSuit() == cards.get(2).getSuit()
				&& cards.get(0).getSuit() == cards.get(3).getSuit()
				&& cards.get(0).getSuit() == cards.get(4).getSuit()) {
			Flush = true;
		} else {
			Flush = false;
		}

		// straight evaluation
		// from ace to 10
		if (Ace) {
			if ((cards.get(0).getValue() == (short) 12)
					&& (cards.get(1).getValue() == (short) 11)
					&& (cards.get(2).getValue() == (short) 11)
					&& (cards.get(3).getValue() == (short) 10)) {
				Straight = true;
			}

			//from ace to 5
			else if ((cards.get(0).getValue() == (short) 5)
					&& (cards.get(1).getValue() == (short) 4)
					&& (cards.get(2).getValue() == (short) 3)
					&& (cards.get(3).getValue() == (short) 2)) {
				Straight = true;
			} else {
				Straight = false;
			}
		}

		//straight without ace
		else if ((cards.get(0).getValue() == cards.get(1).getValue() + 1)
				&& (cards.get(0).getValue() == cards.get(2).getValue() + 2)
				&& (cards.get(0).getValue() == cards.get(3).getValue() + 3)
				&& (cards.get(0).getValue() == cards.get(4).getValue() + 4)) {
			Straight = true;
		} else {
			Straight = false;
		}

		// royal flush
		if ((Ace == true) && (cards.get(0).getValue() == 12)
				&& (Straight == true) && (Flush == true)) {
			HandStrength = 10;
		}

		// Straight Flush
		else if ((Straight == true) && (Flush == true)) {
			HandStrength = 9;
			Kicker = 0;
		}

		// four of a kind
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(0).getValue() == cards.get(2).getValue())
				&& (cards.get(0).getValue() == cards.get(3).getValue())) {
			HandStrength = 8;
			Kicker = cards.get(4).getValue();
			HighHand = cards.get(0).getValue();
		} else if ((cards.get(4).getValue() == cards.get(1).getValue())
				&& (cards.get(4).getValue() == cards.get(2).getValue())
				&& (cards.get(4).getValue() == cards.get(3).getValue())) {
			HandStrength = 8;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(4).getValue();
		}

		// full house
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(0).getValue() == cards.get(2).getValue())
				&& (cards.get(3).getValue() == cards.get(4).getValue())) {
			HandStrength = 7;
			Kicker = 0;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(3).getValue();
		}

		else if ((cards.get(2).getValue() == cards.get(3).getValue())
				&& (cards.get(2).getValue() == cards.get(4).getValue())
				&& (cards.get(0).getValue() == cards.get(1).getValue())) {
			HandStrength = 7;
			Kicker = 0;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(2).getValue();
		}

		// flush
		else if (Flush) {
			HandStrength = 6;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(4).getValue();
		}

		// Straight
		else if (Straight) {
			HandStrength = 5;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(4).getValue();
		}

		// three of a kind
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(0).getValue() == cards.get(2).getValue())) {
			HandStrength = 4;
			Kicker = 0;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(4).getValue();
		}

		else if ((cards.get(1).getValue() == cards.get(2).getValue())
				&& (cards.get(1).getValue() == cards.get(3).getValue())) {
			HandStrength = 4;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(1).getValue();
			LowHand = cards.get(4).getValue();
		}

		else if ((cards.get(2).getValue() == cards.get(3).getValue())
				&& (cards.get(2).getValue() == cards.get(4).getValue())) {
			HandStrength = 4;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(2).getValue();
			LowHand = 0;
		}

		// two pair
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(2).getValue() == cards.get(3).getValue())) {
			HandStrength = 3;
			Kicker = 0;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(2).getValue();
		}

		else if ((cards.get(1).getValue() == cards.get(2).getValue())
				&& (cards.get(3).getValue() == cards.get(4).getValue())) {
			HandStrength = 3;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(1).getValue();
			LowHand = cards.get(3).getValue();
		} else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(4).getValue() == cards.get(3).getValue())) {
			HandStrength = 3;
			Kicker = 0;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(3).getValue();
		}

		// pair

		else if (cards.get(0).getValue() == cards.get(1).getValue()) {
			HandStrength = 2;
			Kicker = 0;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(4).getValue();
		} else if (cards.get(1).getValue() == cards.get(2).getValue()) {
			HandStrength = 2;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(1).getValue();
			LowHand = cards.get(4).getValue();
		} else if (cards.get(2).getValue() == cards.get(3).getValue()) {
			HandStrength = 2;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(2).getValue();
			LowHand = cards.get(4).getValue();
		}

		else if (cards.get(3).getValue() == cards.get(4).getValue()) {
			HandStrength = 2;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(3).getValue();
			LowHand = 0;
		}

		else {
			HandStrength = 0;
			Kicker = cards.get(0).getValue();
		}
	}

	//Below Method will Compare the Hand, for Strength
	//Which ever one had a large Strength is declared the Winner

	public static Comparator<Hand> RankOfHand = new Comparator<Hand>() {

		public int CompareStrength(Hand Hd1, Hand Hd2) {

			int FinalResult = 0;

			FinalResult = Hd2.getHandStrength() - Hd1.getHandStrength();

			//Check if FinalResult Does Not to Yield to 0, 
			//then Return the Strength by Subtracting the second hand 
			//Strength from the first hand Strength

			if (FinalResult != 0) {

				return FinalResult;
			}

			//Return the Strength of High Pair

			FinalResult = Hd2.getHighHand() - Hd1.getHighHand();

			if (FinalResult != 0) {

				return FinalResult;

			}

			//Return the Strength of Low Pair

			FinalResult = Hd2.getLowHand() - Hd1.getLowHand();

			if (FinalResult != 0) {

				return FinalResult;

			}

			//Return the Kicker Strength

			FinalResult = Hd2.getKicker() - Hd1.getKicker();

			if (FinalResult != 0) {

				return FinalResult;

			}

			return 0;

		}

		@Override
		public int compare(Hand o1, Hand o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	};
}
