package org.example;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() { return rank; }
    public Suit getSuit() {return suit; }

    //Card 객체를 문자열로 표현하는 방법 정의
    @Override
    public String toString() {
        return suit + " " + rank;
    }
}
