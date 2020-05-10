package entity;

import java.util.Date;

/**
 * used for both Work_card and Sales_card
 * value-> hour/amount
 */
public class Card {
    private Double value;
    private String date;

    public Card(Double value, String date) {
        this.value = value;
        this.date = date;
    }



    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", date='" + date + '\'' +
                '}';
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
