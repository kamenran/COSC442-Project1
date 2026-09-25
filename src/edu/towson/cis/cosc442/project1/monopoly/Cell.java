package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a cell on the Monopoly game board.
 * Provides common properties and behaviors shared by different cell types.
 */
public abstract class Cell {
    private boolean available = true;
    private String name;
    protected Player theOwner;

    /**
     * Returns the name of this cell.
     *
     * @return the name of the cell
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player who owns this cell.
     *
     * @return the owner of the cell, or null if unowned
     */
    public Player getTheOwner() {
        return theOwner;
    }

    /**
     * Returns the price of this cell.
     *
     * @return the price of the cell
     */
    public int getPrice() {
        return 0;
    }

    /**
     * Indicates whether this cell is available.
     *
     * @return true if the cell is available; false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Performs the action associated with this cell.
     */
    public abstract void playAction();

    /**
     * Sets the availability status of this cell.
     *
     * @param available the new availability status
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Sets the name of this cell.
     *
     * @param name the new name of the cell
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Assigns a player as the owner of this cell.
     *
     * @param owner the player to assign as owner
     */
    public void setTheOwner(Player owner) {
        this.theOwner = owner;
    }

    /**
     * Returns the name of this cell as a string.
     *
     * @return the name of the cell
     */
    @Override
    public String toString() {
        return name;
    }
}