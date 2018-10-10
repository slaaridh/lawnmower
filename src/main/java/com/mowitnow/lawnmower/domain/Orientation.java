package com.mowitnow.lawnmower.domain;

enum Orientation {

	//The order of appearance of these enums is important.
	N("North"), E("Est"), S("South"), W("West");

	private String label;

	Orientation(String label) {
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
