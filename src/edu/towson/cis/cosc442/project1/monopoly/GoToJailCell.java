package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the GoToJailCell component of the Monopoly application.
 */
public class GoToJailCell extends Cell {
	
	public GoToJailCell() {
		setName("Go to Jail");
	}

	public void playAction() {
		Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
	}
}
