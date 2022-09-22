package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CasualTest {
	
	@Test
	@DisplayName("Test the return of who()")
	void testWho() {
		Casual c = new Casual (new Town(1,1), 0, 0);
		assertEquals(State.CASUAL, c.who(), "Method doesn't return CASUAL");
	}

	@Test
	@DisplayName("Test next() in situation of rule 1.a")
	void testNext1() {
		Town t1 = new Town(1, 2);
		Casual c1 = new Casual(t1, 0, 0);
		t1.addCell(c1, c1.getRow(), c1.getCol());
		
		t1.addCell(new Reseller(t1, 0, 1), 0, 1);
		
		c1.census(c1.nCensus);
		
		assertEquals(State.OUTAGE, c1.next(new Town(1,2)).who(), "Method deosn't return OUTAGE");
	}
	
	@Test
	@DisplayName("Test next() in situation of rule 1.b")
	void testNext2() {
		Town t2 = new Town(1, 2);
		Casual c2 = new Casual(t2, 0, 0);
		t2.addCell(c2, c2.getRow(), c2.getCol());
		
		t2.addCell(new Streamer(t2, 0, 1), 0, 1);
		
		c2.census(c2.nCensus);
		
		assertEquals(State.STREAMER, c2.next(new Town(1,2)).who(), "Method deosn't return STREAMER");
	}
	
	@Test
	@DisplayName("Test next() in situation of rule 6.a")
	void testNext3() {
		Town t3 = new Town(2, 2);
		
		Casual c3 = new Casual(t3, 0, 0);
		t3.addCell(c3, c3.getRow(), c3.getCol());
		
		t3.addCell(new Casual(t3, 1, 0), 1, 0);
		t3.addCell(new Casual(t3, 0, 1), 0, 1);
		t3.addCell(new Casual(t3, 1, 1), 1, 1);
		c3.census(c3.nCensus);
		assertEquals(State.RESELLER, c3.next(new Town(2,2)).who(), "Method doesn't return RESELLER");
	}
	
	@Test
	@DisplayName("Test next() in situation of rule 6.b")
	void testNext4() {
		Town t4 = new Town(3,3);
		Casual c4 = new Casual(t4, 1, 1);
		t4.addCell(c4, c4.getRow(), c4.getCol());
		t4.addCell(new Outage(t4, 0, 0), 0, 0);
		t4.addCell(new Outage(t4, 0, 1), 0, 1);
		t4.addCell(new Outage(t4, 0, 2), 0, 2);
		
		t4.addCell(new Casual(t4, 1, 0), 1, 0);
		t4.addCell(new Casual(t4, 1, 2), 1, 2);
		t4.addCell(new Casual(t4, 2, 0), 2, 0);
		t4.addCell(new Casual(t4, 2, 1), 2, 1);
		t4.addCell(new Casual(t4, 2, 2), 2, 2);

		
		c4.census(c4.nCensus);
		assertEquals(State.STREAMER, c4.next(new Town(3,3)).who(), "Method doesn't return STREAMER");
	}
	
	@Test
	@DisplayName("Test next() with no change in cell")
	void testNext6() {
		Town t5 = new Town(1, 2);
		Empty c5 = new Empty(t5, 0, 0);
		t5.addCell(new Outage(t5, 0, 1), 0, 1);
		
		c5.census(c5.nCensus);
		assertEquals(State.CASUAL, c5.next(new Town (1,2)).who(), "Method doesn't return CASUAL");
	}
}
