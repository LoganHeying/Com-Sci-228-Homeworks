package edu.iastate.cs228.hw1;

public class Outage extends TownCell{

	public Outage(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) {
		//Rule 6.b, nCensus[CASUAL] >= 5, Cell becomes S
		//default, Cell becomes E
		return null;
	}

}
