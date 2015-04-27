import java.util.Random;

public class Deck {
	private Card[] deck = new Card[52];

	public Deck()
	{
		int i = 0;
		for (int j = 1; j <= 4; j++)
		{
			for (int k = 1; k <= 13; k++)
			{
				//default card constructor invocation
				deck[i++] = new Card(k, j);   
				//TODO check to see repeats of cards 
			}
		}
	}

	protected void printDeck() {
		for (int i = 0; i < deck.length; i++) {
			System.out.println("Value: " + deck[i].getValue());
			System.out.println("Suit: " + deck[i].getSuit());
		}
	}

	protected Card getCard(int cardNum) {
		return deck[cardNum];
	}

	public void shuffle()
	{
		//length of the deck so it can shuffle the entire deck
		int deckLength = deck.length;
		Random random = new Random();
		
		for (int i = 0; i < deckLength; i++)
		{
			int swap = i + random.nextInt(deckLength - i);
			//the swapping/shuffling
			Card temp = deck[i];
			deck[i] = deck[swap];
			deck[swap] = temp;
		}
	}

	public boolean sameCard(Card card1, Card card2) {
		return (card1.getValue() == card2.getValue() && card1.getSuit() == card2
				.getSuit());
	}

}
