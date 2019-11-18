import java.util.*;
class Card implements Comparable<Card> {
    String faceValue;
    String suitValue;
    Card(String faceValue, String suitValue) {
        this.faceValue = faceValue;
        this.suitValue = suitValue;
    }
    /**.
     * To print the cards with face value and suit value
     */
    public String toString() {
        return this.faceValue +"-" + this.suitValue;
    }
    /**.
     * To compare cards with suit values and face values
     */
    public int compareTo(Card card) {
        if(this.suitValue.compareTo(card.suitValue) > 0) {
            return 1;
        }
        else if(this.suitValue.compareTo(card.suitValue) < 0 ) {
            return -1;
        }
        else {
            if(this.faceValue.compareTo(card.faceValue) > 0) {
            return 1;
        }
        else if(this.faceValue.compareTo(card.faceValue) < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
}
