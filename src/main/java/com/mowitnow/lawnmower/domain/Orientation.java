package com.mowitnow.lawnmower.domain;

enum Orientation {

	//The order of appearance of these enums is important.
	N(0, "North"), E(1, "Est"), S(2, "South"), W(3, "West");

	private int index;
	private String label;

	Orientation(int index, String label) {
		this.label = label;
	}

	Orientation left() {
		if (this.ordinal() == 0)
			return W;
		return Orientation.values()[this.ordinal() - 1];
	}

	Orientation right() {
		if (this.ordinal() == 3)
			return N;
		return Orientation.values()[this.ordinal() + 1];
	}

}
