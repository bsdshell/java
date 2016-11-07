import java.io.*;
import java.lang.String;
import java.util.*;

class Card
{
	String suits;
	int rank;
	public Card(int rank, String suits)
	{ this.suits = suits; this.rank = rank;}
}
class Deck
{
	final int SIZE=52;
	Card[] deck = null;
	public Deck()
	{
		int c=0;
		deck = new Card[52];
		if( deck != null)
		{
			for(int i=0; i<13; i++)
			{
				deck[c++] = new Card(i+1, "Diamonts");		
				deck[c++] = new Card(i+1, "Clubs");		
				deck[c++] = new Card(i+1, "Hearts");		
				deck[c++] = new Card(i+1, "Spades");		
			}
		}
		System.out.println("c="+c);
	}
	public void Shuttle()
	{
		Random ran = new Random();
		for(int i=0; i<SIZE; i++)
		{
			int r = ran.nextInt(SIZE);
			System.out.println("r="+r);
			Card tmp = deck[r];	
			deck[r] = deck[SIZE-1-i];
			deck[SIZE-1-i] = tmp;
		}
	}
	public void show()
	{
		for(int i=0; i<SIZE; i++)
		{
			System.out.print(deck[i].suits+" "+deck[i].rank+" ");
			if( (i+1)%4==0)
				System.out.println();
		}
	}

}
class DeckCard 
{
	public static void main(String args[])
	{
		Deck d = new Deck();
		d.Shuttle();
		d.show();
	}
}
