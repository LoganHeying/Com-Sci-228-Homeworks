package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmptyTest {

	@Test
	void testWho() {
		Empty testCell = new Empty(new Town(1, 1), 0, 0);
		
		assertEquals(State.EMPTY, testCell.who(), "Method doesn't return EMPTY");
	}

	@Test
	@DisplayName("Testing rule 6.a")
	void testNext1() {
		Town t1 = new Town(2, 2);
		
		Empty e1 = new Empty(t1, 0, 0);
		t1.addCell(e1, e1.getRow(), e1.getCol());
		
		t1.addCell(new Casual(t1, 1, 0), 1, 0);
		t1.addCell(new Casual(t1, 0, 1), 0, 1);
		t1.addCell(new Casual(t1, 1, 1), 1, 1);
		e1.census(e1.nCensus);
		assertEquals(State.RESELLER, e1.next(new Town(2,2)).who(), "Method doesn't return RESELLER");
	}
	
	@Test
	@DisplayName("Testing rule 6.b")
	void testNext2() {
		Town t2 = new Town(3,3);
		Empty e2 = new Empty(t2, 1, 1);
		t2.addCell(e2, e2.getRow(), e2.getCol());
		t2.addCell(new Outage(t2, 0, 0), 0, 0);
		t2.addCell(new Outage(t2, 0, 1), 0, 1);
		t2.addCell(new Outage(t2, 0, 2), 0, 2);
		
		t2.addCell(new Casual(t2, 1, 0), 1, 0);
		t2.addCell(new Casual(t2, 1, 2), 1, 2);
		t2.addCell(new Casual(t2, 2, 0), 2, 0);
		t2.addCell(new Casual(t2, 2, 1), 2, 1);
		t2.addCell(new Casual(t2, 2, 2), 2, 2);

		
		e2.census(e2.nCensus);
		assertEquals(State.STREAMER, e2.next(new Town(3,3)).who(), "Method doesn't return STREAMER");
	}
	
	@Test
	@DisplayName("Testing default")
	void testNext3() {
		Town t3 = new Town(1, 2);
		Empty e3 = new Empty(t3, 0, 0);
		t3.addCell(new Outage(t3, 0, 1), 0, 1);
		
		e3.census(e3.nCensus);
		assertEquals(State.CASUAL, e3.next(new Town (1,2)).who(), "Method doesn't return CASUAL");
	}
}
