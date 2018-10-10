package com.mowitnow.lawnmower.domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

enum Command {

	G("Left"), D("Right"), A("Forward");

	private String label;

	Command(String label) {
		this.label = label;
	}

	static Queue<Command> buildFrom(String commands) {
		if (commands == null || commands.length() == 0)
			return null;

		return commands.chars().mapToObj(e -> Command.valueOf(String.valueOf((char) e)))
			.collect(Collectors.toCollection(LinkedList::new));
	}
}
