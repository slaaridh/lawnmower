package com.mowitnow.lawnmower.domain;

import java.util.Objects;
import java.util.Queue;

final public class LawnMower {

	private final Position maxPosition;
	private Position currentPosition;

	private LawnMower(Position currentPosition, Position maxPosition) {
		// Check indexes
		// if positions are null, throw RuntimeException
		Objects.checkIndex(currentPosition.getX(), maxPosition.getX());
		Objects.checkIndex(currentPosition.getY(), maxPosition.getY());
		//
		this.currentPosition = currentPosition;
		this.maxPosition = maxPosition;
	}

	public LawnMower(int x, int y, char orientation, int maxX, int maxY) {
		this(Position.create(x, y, orientation), new Position(maxX, maxY, null));
	}

	public String execute(String commands) {
		if (commands == null || commands.length() == 0)
			return this.currentPosition.getPositionAsString(); // Nothing to do.

		//Throw runtime exception if not valid command.
		Queue<Command> listOfCommands = Command.buildFrom(commands);
		for (; ; ) {
			Command command = listOfCommands.poll();
			if (command == null)
				return this.currentPosition.getPositionAsString();
			this.move(command);
		}
	}

	private void move(Command command) {
		switch (command) {
		case D:
			turnRight();
			break;
		case G:
			turnLeft();
			break;
		case A:
			this.currentPosition = forward();
			break;
		default: //
			throw new IllegalArgumentException("Command " + command + " Not a valid");
		}
	}

	private void turnLeft() {
		this.currentPosition = new Position(currentPosition.getX(), currentPosition.getY(),
											this.currentPosition.getOrientation().left());
	}

	private void turnRight() {
		this.currentPosition = new Position(currentPosition.getX(), currentPosition.getY(),
											this.currentPosition.getOrientation().right());
	}

	private Position forward() {

		int currentX = currentPosition.getX();
		int currentY = currentPosition.getY();
		Orientation orientation = currentPosition.getOrientation();

		switch (orientation) {
		case N:
			currentY = currentY < maxPosition.getY() ? ++currentY : currentY;
			break;
		case E:
			currentX = currentX < maxPosition.getX() ? ++currentX : currentX;
			break;
		case S:
			currentY = currentY == 0 ? currentY : --currentY;
			break;
		case W:
			currentX = currentX == 0 ? currentX : --currentX;
			break;
		}
		return new Position(currentX, currentY, orientation);
	}

}
