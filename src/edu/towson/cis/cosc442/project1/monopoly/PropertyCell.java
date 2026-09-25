package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents a purchasable property cell on the Monopoly game board.
 * Stores information about the property's color group, house price,
 * number of houses, rent, and selling price.
 */
public class PropertyCell extends Cell {
    private String colorGroup;
    private int housePrice;
    private int numHouses;
    private int rent;
    private int sellPrice;

    /**
     * Returns the color group of this property cell.
     *
     * @return the color group associated with this property
     */
    public String getColorGroup() {
        return colorGroup;
    }

    /**
     * Returns the price of one house on this property.
     *
     * @return the cost to buy a single house
     */
    public int getHousePrice() {
        return housePrice;
    }

    /**
     * Returns the current number of houses on this property.
     *
     * @return the number of houses built on the property
     */
    public int getNumHouses() {
        return numHouses;
    }

    /**
     * Returns the selling price of this property.
     *
     * @return the selling price of the property
     */
    @Override
    public int getPrice() {
        return sellPrice;
    }

    /**
     * Calculates and returns the rent owed for this property.
     *
     * @return the rent amount to charge
     */
    public int getRent() {
        int rentToCharge = rent;
        String[] monopolies = theOwner.getMonopolies();
        rentToCharge = calculateMonopoliesRent(rentToCharge, monopolies);

        if (numHouses > 0) {
            rentToCharge = rent * (numHouses + 1);
        }

        return rentToCharge;
    }

    /**
     * Adjusts the rent when the owner has a monopoly matching this property's
     * color group.
     *
     * @param rentToCharge the current rent amount
     * @param monopolies the color groups owned as monopolies
     * @return the adjusted rent amount
     */
    private int calculateMonopoliesRent(int rentToCharge, String[] monopolies) {
        for (int i = 0; i < monopolies.length; i++) {
            if (monopolies[i].equals(colorGroup)) {
                rentToCharge = rent * 2;
            }
        }
        return rentToCharge;
    }

    /**
     * Performs the action associated with landing on this property.
     * Charges rent when the property is owned by another player.
     */
    @Override
    public void playAction() {
        Player currentPlayer = null;

        if (!isAvailable()) {
            currentPlayer = GameMaster.instance().getCurrentPlayer();

            if (theOwner != currentPlayer) {
                currentPlayer.payRentTo(theOwner, getRent());
            }
        }
    }

    /**
     * Sets the color group for this property.
     *
     * @param colorGroup the color group to assign
     */
    public void setColorGroup(String colorGroup) {
        this.colorGroup = colorGroup;
    }

    /**
     * Sets the price of a house on this property.
     *
     * @param housePrice the house price to assign
     */
    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    /**
     * Sets the number of houses on this property.
     *
     * @param numHouses the number of houses to assign
     */
    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }

    /**
     * Sets the selling price of this property.
     *
     * @param sellPrice the selling price to assign
     */
    public void setPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * Sets the base rent of this property.
     *
     * @param rent the base rent to assign
     */
    public void setRent(int rent) {
        this.rent = rent;
    }
}