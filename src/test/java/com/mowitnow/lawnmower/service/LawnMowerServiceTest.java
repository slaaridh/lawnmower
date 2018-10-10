package com.mowitnow.lawnmower.service;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class LawnMowerServiceTest {

	private LawnMowerService lawnMowerService = new LawnMowerServiceImpl();

	@Test
	public void testExecute() throws IOException {

		// Get input commands from file
		String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("entries.txt")).getPath();
		Queue<String> queue = Files.lines(Paths.get(path)).collect(Collectors.toCollection(LinkedList::new));
		//
		List<String> positions = lawnMowerService.execute(queue);
		assertEquals(2, positions.size());
		assertEquals("1 3 N", positions.get(0));
		assertEquals("5 1 E", positions.get(1));
	}

}
