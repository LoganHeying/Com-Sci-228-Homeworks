package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{

	public Reseller(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		// TODO Auto-generated method stub
		return null;
	}

}
