package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the Card component of the Monopoly application.
 */
public abstract class Card {

    public static int TYPE_CHANCE = 1;
    public static int TYPE_CC = 2;

    public abstract String getLabel();
    public abstract void applyAction();
    public abstract int getCardType();
}
