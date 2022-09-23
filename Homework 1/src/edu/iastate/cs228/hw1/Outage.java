package edu.iastate.cs228.hw1;

/**
 * @author Logan Heying
 *	The outage town cell type
 *  holds the rules for the next iteration of the cell
 */
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
		//default, Cell becomes E
		return new Empty(tNew, super.row, super.col);
	}

}
