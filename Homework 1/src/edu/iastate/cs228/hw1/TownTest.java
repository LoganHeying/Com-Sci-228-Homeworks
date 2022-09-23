package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TownTest {

	@Test
	void testGetTown() {
		Town t = new Town(1893,2389);
		
		assertArrayEquals(new TownCell[1893][2389], t.getTown(), "Method didn't return the grid correctly");
	}
	
	@Test
	void testGetWidth() {
		Town t = new Town(1893,2389);
		
		assertEquals(2389, t.getWidth(), "Method didn't return the width");
	}
	
	@Test
	void testGetLength() {
		Town t = new Town(1893,2389);
		
		assertEquals(1893, t.getLength(), "Method didn't return the length");
	}

	@Test
	void testRandomInit() {
		Town t = new Town(4, 4);
		
		t.randomInit(10);
		Town actual = new Town(4,4);
		
		actual.addCell(new Outage(actual, 0, 0), 0, 0);
		actual.addCell(new Reseller(actual, 0, 1), 0, 1);
		actual.addCell(new Outage(actual, 0, 2), 0, 2);
		actual.addCell(new Reseller(actual, 0, 3), 0, 3);
		
		actual.addCell(new Empty(actual, 1, 0), 1, 0);
		actual.addCell(new Empty(actual, 1, 1), 1, 1);
		actual.addCell(new Casual(actual, 1, 2), 1, 2);
		actual.addCell(new Outage(actual, 1, 3), 1, 3);
		
		actual.addCell(new Empty(actual, 2, 0), 2, 0);
		actual.addCell(new Streamer(actual, 2, 1), 2, 1);
		actual.addCell(new Outage(actual, 2, 2), 2, 2);
		actual.addCell(new Streamer(actual, 2, 3), 2, 3);
		
		actual.addCell(new Empty(actual, 3, 0), 3, 0);
		actual.addCell(new Outage(actual, 3, 1), 3, 1);
		actual.addCell(new Reseller(actual, 3, 2), 3, 2);
		actual.addCell(new Reseller(actual, 3, 3), 3, 3);
		
		assertEquals(actual.toString(), t.toString(), "Method doesn't match proven town layout");

	}

	@Test
	void testToString() {
		Town t = new Town(2,2);
		t.addCell(new Casual(t, 0, 0), 0, 0);
		t.addCell(new Empty(t, 1, 0), 1, 0);
		t.addCell(new Reseller(t, 0, 1), 0, 1);
		t.addCell(new Outage(t, 1, 1), 1, 1);
		
		String actualString = "C R \nE O \n";
		
		assertEquals(actualString, t.toString(), "Didn't correctly create a string representation");
	}

}
