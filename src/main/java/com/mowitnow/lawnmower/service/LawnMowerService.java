package com.mowitnow.lawnmower.service;

import java.util.List;
import java.util.stream.Stream;

public interface LawnMowerService {

	List<String> execute(Stream<String> input);

}
