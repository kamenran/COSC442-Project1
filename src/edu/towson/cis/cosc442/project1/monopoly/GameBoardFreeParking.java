
package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the GameBoardFreeParking component of the Monopoly application.
 */
public class GameBoardFreeParking extends GameBoard {
	public GameBoardFreeParking() {
		super();
		JailCell jail = new JailCell();
		FreeParkingCell freeParking = new FreeParkingCell();
		GoToJailCell goToJail = new GoToJailCell();
		addCell(jail);
		addCell(freeParking);
		addCell(goToJail);

	}
}
