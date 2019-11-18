import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**.
 * Sorting using Insertion Sort technique
 */
public class Asst3 {
    public Card[] InsertionSort(Card[] deckSort) {
        for(int i = 1; i < deckSort.length;i++) {
            for(int j = i; (j > 0 && deckSort[j].compareTo(deckSort[j-1]) < 0); j--) {
                /**.
                 * for swapping
                 */
                Card tempCard = deckSort[j];
                deckSort[j] = deckSort[j-1];
                deckSort[j-1] = tempCard;
            }
        }
        return deckSort;
    }
    public static void main(String[] args) {
        String[] suitValue = {"1Spade", "2Diamond", "3Heart", "4Club"}; // suit values
        String[] faceValue = {"A","2","3","4","5","6","7","8","9","10","K","Q","J"}; // face values
        Card[] deckCards = new Card[52]; // creating array of 52 cards.
        int size = 0;
        for(int i = 0; i < suitValue.length; i++) {
            for(int j = 0; j < faceValue.length; j++) {
                deckCards[size++] = new Card(faceValue[j], suitValue[i]);// Card with suit value and face value
            }
        }
        Asst3 a3 = new Asst3();
        List<Card> deck = Arrays.asList(deckCards);
        Collections.shuffle(deck); //to shuffle the cards
        deck.toArray(deckCards); // to change into array
        System.out.println("Shuffled Cards");
        System.out.println("------------------------------------");
        System.out.println(Arrays.toString(deckCards)); // to change into string
        System.out.println();
        a3.InsertionSort(deckCards); // to sort deckcards 
        System.out.println("Sorted Cards");
        System.out.println("------------------------------------");
        System.out.println(Arrays.toString(deckCards)); // to change into string

    }
}