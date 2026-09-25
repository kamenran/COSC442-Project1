package edu.towson.cis.cosc442.project1.monopoly;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Represents the Monopoly game board and manages its cells and card decks.
 */
public class GameBoard {

    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private ArrayList<Card> chanceCards = new ArrayList<Card>();

    // The key of colorGroups is the name of the color group.
    private Hashtable<String, Integer> colorGroups =
            new Hashtable<String, Integer>();

    private ArrayList<Card> communityChestCards = new ArrayList<Card>();

    /**
     * Constructs a new game board and initializes it with a Go cell.
     */
    public GameBoard() {
        Cell go = new GoCell();
        addCell(go);
    }

    /**
     * Adds a card to the appropriate deck based on its type.
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        if (card.getCardType() == Card.TYPE_CC) {
            communityChestCards.add(card);
        } else {
            chanceCards.add(card);
        }
    }

    /**
     * Adds a cell to the game board.
     *
     * @param cell the cell to add
     */
    public void addCell(Cell cell) {
        cells.add(cell);
    }

    /**
     * Adds a property cell and updates the number of properties
     * in its color group.
     *
     * @param cell the property cell to add
     */
    public void addCell(PropertyCell cell) {
        String colorGroup = cell.getColorGroup();
        int propertyNumber = getPropertyNumberForColor(colorGroup);
        colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
        cells.add(cell);
    }

    /**
     * Draws the top community chest card and moves it to the bottom
     * of the deck.
     *
     * @return the community chest card drawn
     */
    public Card drawCCCard() {
        Card card = (Card) communityChestCards.get(0);
        communityChestCards.remove(0);
        addCard(card);
        return card;
    }

    /**
     * Draws the top chance card and moves it to the bottom of the deck.
     *
     * @return the chance card drawn
     */
    public Card drawChanceCard() {
        Card card = (Card) chanceCards.get(0);
        chanceCards.remove(0);
        addCard(card);
        return card;
    }

    /**
     * Returns the cell at the specified index.
     *
     * @param newIndex the index of the cell
     * @return the cell at the given index
     */
    public Cell getCell(int newIndex) {
        return (Cell) cells.get(newIndex);
    }

    /**
     * Returns the number of cells on the game board.
     *
     * @return the number of cells
     */
    public int getCellNumber() {
        return cells.size();
    }

    /**
     * Returns all properties in the specified color group.
     *
     * @param color the color group
     * @return the properties belonging to the color group
     */
    public PropertyCell[] getPropertiesInMonopoly(String color) {
        PropertyCell[] monopolyCells =
                new PropertyCell[getPropertyNumberForColor(color)];

        int counter = 0;

        for (int i = 0; i < getCellNumber(); i++) {
            Cell c = getCell(i);

            if (c instanceof PropertyCell) {
                PropertyCell pc = (PropertyCell) c;

                if (pc.getColorGroup().equals(color)) {
                    monopolyCells[counter] = pc;
                    counter++;
                }
            }
        }

        return monopolyCells;
    }

    /**
     * Returns the number of properties tracked for a color group.
     *
     * @param name the color group name
     * @return the number of properties in the color group
     */
    public int getPropertyNumberForColor(String name) {
        Integer number = (Integer) colorGroups.get(name);

        if (number != null) {
            return number.intValue();
        }

        return 0;
    }

    /**
     * Finds a cell by its name.
     *
     * @param string the name of the cell
     * @return the matching cell, or null if none is found
     */
    public Cell queryCell(String string) {
        for (int i = 0; i < cells.size(); i++) {
            Cell temp = (Cell) cells.get(i);

            if (temp.getName().equals(string)) {
                return temp;
            }
        }

        return null;
    }

    /**
     * Finds the index of a cell by its name.
     *
     * @param string the name of the cell
     * @return the cell index, or -1 if none is found
     */
    public int queryCellIndex(String string) {
        for (int i = 0; i < cells.size(); i++) {
            Cell temp = (Cell) cells.get(i);

            if (temp.getName().equals(string)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Removes all community chest cards from the deck.
     */
    public void removeCards() {
        communityChestCards.clear();
    }
}