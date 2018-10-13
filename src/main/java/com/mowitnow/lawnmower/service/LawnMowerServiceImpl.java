package com.mowitnow.lawnmower.service;

import com.mowitnow.lawnmower.domain.LawnMower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class LawnMowerServiceImpl implements LawnMowerService {

	public final static LawnMowerService instance = new LawnMowerServiceImpl();
	private final static String SEP = " ";

	private LawnMowerServiceImpl() { }

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

	public List<String> execute(Stream<String> input) {
		List<String> positions = new ArrayList<>();

		for (LawnMowerConfig config : input.collect(new WindowCollector())) {
			positions.add(config.getLawnMower().execute(config.getCommands()));
		}

		return positions;
	}

	private class LawnMowerConfig {
		private final LawnMower lawnMower;
		private final String commands;

		LawnMowerConfig(LawnMower lawnMower, String commands) {
			this.lawnMower = lawnMower;
			this.commands = commands;
		}

		LawnMower getLawnMower() {
			return lawnMower;
		}

		String getCommands() {
			return commands;
		}
	}

	private class WindowCollector implements Collector<String, List<List<String>>, List<LawnMowerConfig>> {

		int size = 2;
		int count = 0;
		int maxX;
		int maxY;

		@Override
		public Supplier<List<List<String>>> supplier() {
			return ArrayList::new;
		}

		@Override
		public BiConsumer<List<List<String>>, String> accumulator() {
			return (acc, value) -> {
				if (acc.size() == 0) {
					String[] dim = value.split(SEP);
					maxX = Integer.valueOf(dim[0]);
					maxY = Integer.valueOf(dim[1]);
					acc.add(new ArrayList<>());
				} else {
					List<String> last = acc.get(acc.size() - 1);
					if (last.size() < 2)
						last.add(value);
					else {
						List<String> newList = new ArrayList<>();
						newList.add(value);
						acc.add(newList);
					}
				}

			};
		}

		@Override
		public BinaryOperator<List<List<String>>> combiner() {
			return (left, righ) -> {throw new AssertionError(" // not supported");};
		}

		@Override
		public Function<List<List<String>>, List<LawnMowerConfig>> finisher() {
			return (acc) -> {
				List<LawnMowerConfig> configs = new ArrayList<>();
				for (List<String> list : acc) {
					String position = list.get(0);
					String[] pos = position.split(SEP);
					int x = Integer.valueOf(pos[0]);
					int y = Integer.valueOf(pos[1]);
					char orientation = pos[2].charAt(0);
					configs.add(new LawnMowerConfig(new LawnMower(x, y, orientation, maxX, maxY), list.get(1)));
				}
				return configs;
			};
		}

		@Override
		public Set<Characteristics> characteristics() {
			return Collections.EMPTY_SET;
		}

	}

}
