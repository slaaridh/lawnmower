package com.mowitnow.lawnmower.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;

public class TestCommand {

	@Test
	public void testListOfCommands() {

		String str = "GAGAGAGAA";
		Queue<Command> commands = Command.buildFrom(str);
		StringBuilder stringBuilder = new StringBuilder();
		for (; ; ) {
			Command command = commands.poll();
			if (command == null)
				break;
			stringBuilder.append(command.name());
		}
		Assert.assertEquals(str, stringBuilder.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCommand() {
		String str = "GAFAGAGAA";
		Command.buildFrom(str);
	}
}
