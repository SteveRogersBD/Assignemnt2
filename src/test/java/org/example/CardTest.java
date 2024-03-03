package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    public void testRank() {
        // This test evaluates whether the
        // getRank function has been implemented correctly

        Card c = new Card("Ace", "Heart");
        int actual = c.getRankValue();
        int expected = 14;

        assertEquals(expected, actual);

    }

    @Test
    public void testRankString() {
        // This test evaluates whether the
        // getRankString function has been implemented correctly
        Card c = new Card("Jack", "Diamonds");
        String actual = c.getRankString();
        String expected = "Jack";


        assertEquals(expected, actual);

    }

    @Test
    public void testSuit() {
        // This test evaluates whether the getSuit function
        // has been implemented correctly for different suits
        Card c = new Card("King", "Spades"); // Changing the card to "King" of "Spades"
        String actual = c.getSuit();
        String expected = "Spades";

        assertEquals(expected, actual);
    }

    @Test
    public void testCompareNegative() {
        // Create two Card objects with ranks such that the comparison results in a negative value
        Card lowerRankCard = new Card("3", "Hearts"); // Considered lower
        Card higherRankCard = new Card("Ace", "Hearts"); // Considered higher

        // Use the compareTo function to compare the two card objects
        int comparisonResult = lowerRankCard.compareTo(higherRankCard);

        // The expected outcome is negative, indicating the first card is lower than the second
        if (comparisonResult >= 0) {
            fail("Expected a negative value but got " + comparisonResult);
        }
    }

    @Test
    public void testComparePositive() {
        // Create a Card object representing a lower rank, "10 of Diamonds"
        Card lower = new Card("10", "Diamonds");
        // Create another Card object representing a higher rank, "Queen of Diamonds"
        Card higher = new Card("Queen", "Diamonds");

        // Compare the two Card objects using the compareTo method, expecting the 'higher' card
        // to be greater than the 'lower' card, which should result in a positive comparison value
        int result = higher.compareTo(lower);

        // Check the comparison result. A positive result indicates the 'higher' card is correctly
        // identified as being greater than the 'lower' card. If the result is not positive,
        // the test fails with a message indicating the unexpected result.
        if (result <= 0) {
            fail("Expected a positive value but got " + result);
        }
    }


    @Test
    public void testPrintObjectName() {
        // Initialize a Card object to represent the "Ace of Hearts".
        Card c = new Card("Ace", "Hearts");

        // Call the toString method to get the card's string representation.
        String actual = c.toString();

        // The expected format is "14H", indicating the Ace of Hearts.
        String expected = "14H";

        // Assert that the card's toString output matches the expected format.
        assertEquals(expected, actual);
    }


    @Test
    public void testPrintObjectInvalidCard() {
        // Create a Card object with a valid rank but an invalid suit to test the toString method's handling of invalid inputs
        Card invalid = new Card("11", "Start"); // Assuming "Flowers" is not a recognized suit
        String actual = invalid.toString();
        String expected = "invalid card"; // The expected output for a card with invalid parameters
        assertEquals(expected, actual);
    }

    @Test
    public void testJoker() {
        // Create a Card object representing a Joker, where both the rank and the suit are specified as "Joker".
        Card joker = new Card("Joker", "Joker");

        // Verify that the getSuit method correctly identifies the Joker's suit as "Joker".
        // This ensures that the suit of a Joker card is properly recognized and handled.
        assertEquals("Joker", joker.getSuit());

        // Check that the getRankValue method assigns the correct special rank value (15) to the Joker.
        // This test confirms that the Joker has a unique rank value, distinguishing it from other cards.
        assertEquals(15, joker.getRankValue());

        // Ensure that the getRankString method returns "Joker" as the rank string for the Joker card.
        // This step verifies that the Joker's rank is accurately represented as a string.
        assertEquals("Joker", joker.getRankString());
    }


    @Test
    public void testCompareJoker() {
        // Creating a Joker card, assumed to have the highest rank in the game
        Card joker = new Card("Joker", "Joker");
        // Creating a King of Hearts, a high-ranking card but expected to be lower than Joker
        Card kingOfHearts = new Card("King", "Hearts");

        // Compare the rank values directly, expecting the Joker to have a higher rank
        int rankComparison = Integer.compare(joker.getRankValue(), kingOfHearts.getRankValue());
        // Fail the test if the Joker's rank is not higher than the King of Hearts
        if (rankComparison <= 0) {
            fail("Expected Joker to have a higher rank value than King of Hearts.");
        }

        // Compare the two cards using the compareTo method, expecting the Joker to be considered greater
        int comparisonResult = joker.compareTo(kingOfHearts);
        // Fail the test if comparing the Joker to the King of Hearts does not yield a positive result
        if(comparisonResult <= 0) {
            fail("Expected comparing Joker to any card to result in a positive value but got " + comparisonResult);
        }
    }


}