package com.mowitnow.lawnmower.domain;

enum Orientation {

	N("North") {
		Orientation left() {return W;}

		Orientation right() {return E;}
	}, E("Est") {
		Orientation left() {return N;}

		Orientation right() {return S;}
	}, S("South") {
		Orientation left() {return E;}

		Orientation right() {return W;}
	}, W("West") {
		Orientation left() {return S;}

		Orientation right() {return N;}
	};

	private String label;

	Orientation(String label) {
		this.label = label;
	}

	abstract Orientation left();

	abstract Orientation right();

}