package edu.towson.cis.cosc442.project1.monopoly;

/**
 * Represents the Die component of the Monopoly application.
 */
public class Die {
	public int getRoll() {
		return (int)(Math.random() * 6) + 1;
	}
}
