package src.card;

import java.util.Objects;

public class Card {
    private String rank;
    private String color;

    public Card(String rank, String color) {
        this.rank = rank;
        this.color = color;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return Objects.equals(getRank(),card.getRank()) && Objects.equals(getColor(), card.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRank(), getColor());
    }

    @Override
    public String toString() {
        return rank + " of " + color;
    }
}
