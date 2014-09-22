//Abraham Arce
//Abdullah AL-Sinaidi
// Jon Garcia
// Fatemah Sedigh
// Zulfiqar Salahuddin
package MainPackage;

import java.util.ArrayList;
import java.util.Collections;

public class Play {

	public static void main(String[] args) {

		for (int i = 0; i <= 0; i++) {
			ArrayList<Hand> Hands = new ArrayList<Hand>();
			Deck d = new Deck();

			for (int y = 0; y <= 2; y++) {
				Hand HandCompare = new Hand(d);
				HandCompare.card_eva();
				Hands.add(HandCompare);
			}
			Collections.sort(Hands, Hand.RankOfHand);

			System.out.println("Hand Strength: "
					+ Hands.get(0).getHandStrength());
			System.out.println(" High Hand: " + Hands.get(0).getHighHand());
			System.out.println(" Low Hand: " + Hands.get(0).getLowHand());
			System.out.println(" Kicker: " + Hands.get(0).getKicker());

			System.out.println("\n");

			System.out.println("Hand Strength: "
					+ Hands.get(1).getHandStrength());
			System.out.println(" High Hand: " + Hands.get(1).getHighHand());
			System.out.println(" Low Hand: " + Hands.get(1).getLowHand());
			System.out.println(" Kicker: " + Hands.get(1).getKicker());

			System.out.print("\n");

			if (Hands.get(0).getHandStrength() == Hands.get(1)
					.getHandStrength()) {

				System.out
						.println("HandStrength Equal, Checking HighHand Strength......"
								+ "\n");

				if (Hands.get(0).getHighHand() == Hands.get(1).getHighHand()) {

					System.out
							.println("HighHand Strength Equal, Checking LowLand Strenth......"
									+ "\n");

					if (Hands.get(0).getLowHand() == Hands.get(1).getLowHand()) {

						System.out
								.println("LowHand Strength Equal, Checking Kicker Strength......."
										+ "\n");

						if (Hands.get(0).getKicker() == Hands.get(1)
								.getKicker()) {

							System.out
									.println("It's A Draw!");

						}

						else if (Hands.get(0).getKicker() > Hands.get(1)
								.getKicker()) {

							System.out.println("Player 1 Wins!");
						}

						else {
							System.out.println("Player 2 Wins");
						}
					}
					
					else if (Hands.get(0).getLowHand() > Hands.get(0)
							.getLowHand()) {

						System.out.println("Player 1 Wins!");
					}

					else {
						System.out.println("Player 2 Wins!");
					}
				}

				else if (Hands.get(0).getHighHand() > Hands.get(1)
						.getHighHand()) {

					System.out.println("Player 1 Wins!");
				}

				else {
					System.out.println("Player 2 Wins!");
				}
			}
			
			else if (Hands.get(0).getHandStrength() > Hands.get(1)
					.getHandStrength()) {
				
				System.out.println("Player 1 Wins!");
			}
			
			else {
				System.out.println("Player 2 Wins!");
			}
		}
	}
}
