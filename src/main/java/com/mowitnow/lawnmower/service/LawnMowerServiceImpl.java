package com.mowitnow.lawnmower.service;

import com.mowitnow.lawnmower.domain.LawnMower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class LawnMowerServiceImpl implements LawnMowerService {

	private final static String SEP = " ";

	/**
	 * Returns a list of lawnmowers positions. If input list is empty, no lawnmowers will be created.
	 *
	 * @param input entries data used to create/execute lawnmowers.
	 * @return a list of positions
	 * @throws IndexOutOfBoundsException, if the first element of the queue is empty or contains only one data.
	 * @throws NumberFormatException,     if the elements of the first element of the queue are not of type int (int,int)
	 * @throws IndexOutOfBoundsException, if the initial position is empty or not valid (int,int,char)
	 * @throws NumberFormatException,     if the initial position is empty or not valid (int,int,char)
	 */
	@Override
	public List<String> execute(Queue<String> input) {
		if (input == null || input.isEmpty())
			return Collections.emptyList();

		List<String> list = new ArrayList<>();
		String[] dim = input.poll().split(SEP);
		int maxX = Integer.valueOf(dim[0]);
		int maxY = Integer.valueOf(dim[1]);

		for (; ; ) {
			String position = input.poll();
			if (position == null)
				return list;
			String[] pos = position.split(SEP);
			int x = Integer.valueOf(pos[0]);
			int y = Integer.valueOf(pos[1]);
			char orientation = pos[2].charAt(0);
			list.add(new LawnMower(x, y, orientation, maxX, maxY).execute(input.poll()));
		}

	}

}
