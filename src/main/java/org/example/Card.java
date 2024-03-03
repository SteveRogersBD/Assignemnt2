package org.example;

public class Card extends AbstractCard
{
    private int rank;
    private String suit;
    public Card(String rank, String suit)
    {
        this.rank = checkRankValidity(rank);
        this.suit = checkSuitValidity(suit);
    }

    public Card(int rank, String suit)
    {
        this.rank = rankValidity(rank);
        this.suit = checkSuitValidity(suit);
    }

    /**
     * Checks the validity of a card suit.
     * <p>
     * This method iterates over a predefined array of valid suits (defined in the SUITS array)
     * to determine if the provided card suit matches any of them. If a match is found, the
     * card suit itself is returned, indicating its validity. If no match is found, the method
     * returns the string "invalid", indicating the card suit is not recognized.
     *
     * @param cardSuit The card suit to be validated.
     * @return The original card suit if it's valid, or "invalid" if it's not recognized.
     */
    private static String checkSuitValidity(String cardSuit) {
        for (String validSuit : SUITS) {
            // Check if the current suit in the array matches the provided card suit
            if (validSuit.equals(cardSuit)) {
                return cardSuit;
            }
        }
        return "invalid";
    }


    /**
     * Checks the validity of a card rank and returns its adjusted otherCarderical value.
     * <p>
     * This method iterates over a predefined array of valid ranks (defined in the RANKS array)
     * to find the provided rank. If found, it returns the rank's adjusted otherCarderical value, which
     * is the index in the RANKS array plus two. This adjustment assumes the first rank starts
     * with a otherCarderical value of 2. If the rank is not found, it returns 0, indicating an invalid rank.
     *
     * @param cardRank The card rank to be validated.
     * @return The adjusted otherCarderical value of the rank if valid, or 0 if invalid.
     */
    private static int checkRankValidity(String cardRank) {
        for (int i = 0; i < RANKS.length; i++) {
            if (RANKS[i].equals(cardRank)) {
                return i + 2;
            }
        }
        return 0;
    }


    /**
     * Validates the given rank is within the allowed range.
     *
     * @param rank The rank to validate, expected to be between 2 and 15 inclusive.
     * @return The same rank if valid; otherwise, 0 to indicate an invalid rank.
     */
    private int rankValidity(int rank) {
        // Check if rank is within the valid range and return it; otherwise, return 0.
        return (rank >= 2 && rank <= 15) ? rank : 0;
    }


    @Override
    /**
     * Retrieves the rank value of the card.
     *
     * @return The rank value associated with this card instance.
     */
    public int getRankValue() {
        return this.rank;
    }


    @Override
    /**
     * Converts the otherCarderical rank of a card to its string representation.
     * <p>
     * If the rank is within the valid range (2 to 15), it retrieves the corresponding
     * string representation from a predefined array of rank strings. Otherwise, it returns
     * "Invalid" indicating that the rank is outside the valid range.
     *
     * @return The string representation of the card's rank if valid, otherwise "Invalid".
     */
    public String getRankString() {
        if (this.rank >= 2 && this.rank <= 15) {
            return this.RANKS[rank - 2];
        }
        return "Invalid";
    }


    /**
     * Retrieves the suit of the card.
     * <p>
     * This method returns the suit of the card, with a special case for the "Joker" card.
     * If the card's rank is identified as 15, which is reserved for the Joker, it returns "Joker"
     * as both the rank and suit. Otherwise, it returns the card's actual suit.
     *
     * @return The suit of the card, or "Joker" if the card is a Joker.
     */
    @Override
    public String getSuit() {
        if (this.rank == 15) {
            // Special handling for Joker cards
            return "Joker";
        }
        // Return the actual suit for non-Joker cards
        return this.suit;
    }


    /**
     * Compares this card with another card for order.
     * <p>
     * Cards are compared based on their rank and suit. Joker cards are considered
     * higher than any other card. If two cards have the same rank, their suits are
     * compared to determine the order. If the suits are also the same, the cards
     * are considered equal.
     *
     * @param otherCard The card to be compared.
     * @return A negative integer, zero, or a positive integer as this card is less
     *         than, equal to, or greater than the specified card.
     */
    @Override
    public int compareTo(AbstractCard otherCard)
    {
        if (!(otherCard instanceof Card))
        {
            return -1; // 
        }
        Card other = (Card) otherCard;
        if (this.rank == 15 && other.rank != 15)
        {
            return 1; // Joker is higher than any other card
        }
        if (this.rank != 15 && other.rank == 15)
        {
            return -1; // Any card is lower than Joker
        }
        int suitComparison = this.suit.compareTo(other.getSuit());

        if (suitComparison != 0)
        {
            if (suitComparison < 0)
            {
                return -1; // return -1 for a lesser suit
            }
            else
            {
                return 1; // return 1 for a greater suit
            }
        }

        // Adjusting this part to return -1 or 1 based on rank comparison
        if (this.rank < other.rank)
        {
            return -1; // return -1 for a lesser rank
        }
        else if (this.rank > other.rank)
        {
            return 1; // return 1 for a greater rank
        }
        else
        {
            return 0; // Equal ranks
        }
    }
    

    public static void main(String[] args)
    {
        Card queen = new Card("Queen", "Diamonds");
        System.out.println( queen.getRankValue() ); //prints 12
        System.out.println( queen.getRankString() ); //prints Queen
        System.out.println( queen.getSuit() ); //prints "Diamonds"
        System.out.println( queen ); //prints 12D
        Card four = new Card("4", "Spades");
        System.out.println( queen.compareTo(four) ); //prints negative int value
        System.out.println( four.compareTo(queen) ); //prints a positive int value
        Card jack = new Card("Jack", "Spades");
        System.out.println( four.compareTo(jack) ); //prints a negative int value
        System.out.println( jack.compareTo(jack) ); //prints 0
        System.out.println( jack.getRankValue() ); //prints 11
        System.out.println( jack.getSuit() ); //prints "Spades"
        Card joker = new Card("Joker", "Joker");
        System.out.println( joker ); //prints 15J
        System.out.println( joker.getRankValue() ); //prints 15
        System.out.println( joker.getSuit() ); //prints "Joker"
        System.out.println( jack.compareTo(joker) ); //prints a negative int value
    }
}
