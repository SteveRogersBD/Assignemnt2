package org.example;
public abstract class AbstractCard implements Comparable<AbstractCard>{

    /* handy arrays for ranks and suits    */
    /* do NOT change the following values  */
    public final static String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace", "Joker", "Invalid"};

    public final static String[] SUITS = { "Diamonds", "Clubs", "Hearts", "Spades", "Joker", "Invalid"};



    /** the numerical representation of the rank of the current card
     * <p>
     * ranks have the numerical values
     * 2 = 2, 3 = 3, ..., 10 = 10
     * Jack = 11, Queen = 12, King = 13, Ace = 14
     * Joker = 15
     * for and invalid card return a value x, where 15<x or x<2
     * @return the numerical rank of this card
     */
    public abstract int getRankValue();



    /** the string representation of the rank of the current card
     *
     * @return the string representation of the rank of this card
     * (must be a string from Card.RANKS)
     */
    public abstract String getRankString();


    /** the suit of the current card
     *
     * @return the suit of this card (must be a string from Card.SUITS)
     */
    public abstract String getSuit();



    @Override
    public final String toString(){
        // outputs a string representation of a card object
        int r = getRankValue();
        if( r >= 2 && r <= 15 ){
            return r + getSuit().substring(0,1); // First character of the suit
        }
        // otherwise,
        return "invalid card";
    }
}
