package com.mowitnow.lawnmower.domain;

final class Position {

	final private int x;
	final private int y;
	final private Orientation orientation;

	Position(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	/**
	 * Create a Position
	 *
	 * @param x
	 * @param y
	 * @param orientation
	 * @return a position
	 * @throws IllegalArgumentException if the @param orientation van not be mapped to an object of type Orientation.
	 */
	static Position create(int x, int y, char orientation) {
		return new Position(x, y, Orientation.valueOf(Character.toString(orientation)));
	}

	Orientation getOrientation() {
		return orientation;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	String getPositionAsString() {
		return x + " " + y + " " + orientation;
	}

}
