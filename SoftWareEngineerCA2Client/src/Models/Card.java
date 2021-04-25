/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Objects;

/**
 *
 * @author micha
 */
public class Card {
    private String name;
    private int number;
    private String expDate;
    private String cvc;

    public Card() {
    }

    public Card(String name, int number, String expDate, String cvc) {
        this.name = name;
        this.number = number;
        this.expDate = expDate;
        this.cvc = cvc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.number;
        hash = 53 * hash + Objects.hashCode(this.expDate);
        hash = 53 * hash + Objects.hashCode(this.cvc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.expDate, other.expDate)) {
            return false;
        }
        if (!Objects.equals(this.cvc, other.cvc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Card{" + "name=" + name + ", number=" + number + ", expDate=" + expDate + ", cvc=" + cvc + '}';
    }
    
    
    
}
