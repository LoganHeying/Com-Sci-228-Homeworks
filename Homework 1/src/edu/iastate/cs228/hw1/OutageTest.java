package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutageTest {

	@Test
	void testWho() {
		Outage testCell = new Outage(new Town(1, 1), 0, 0);
		assertEquals(State.OUTAGE, testCell.who(), "Method doesn't return OUTAGE");
	}

	@Test
	void testNext() {
		Town t = new Town(1, 1);
		
		Outage o = new Outage(t, 0, 0);
		
		assertEquals(State.EMPTY, o.next(new Town(1, 1)).who(), "Method doesn't return EMPTY");
	}

}
