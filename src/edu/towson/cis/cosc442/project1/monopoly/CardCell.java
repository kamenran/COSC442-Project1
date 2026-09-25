package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a board cell associated with a card type.
 */
public class CardCell extends Cell {

    private int type;

    /**
     * Constructs a card cell with the specified type and name.
     *
     * @param type the type of card associated with this cell
     * @param name the name of the cell
     */
    public CardCell(int type, String name) {
        setName(name);
        this.type = type;
    }

    /**
     * Performs the action for this cell.
     */
    @Override
    public void playAction() {
    }

    /**
     * Returns the card type associated with this cell.
     *
     * @return the card type
     */
    public int getType() {
        return type;
    }
}