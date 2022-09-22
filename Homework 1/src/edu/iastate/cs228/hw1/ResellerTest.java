package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResellerTest {

	@Test
	void testWho() {
		Reseller testCell = new Reseller(new Town(1, 1), 0, 0);
		
		assertEquals(State.RESELLER, testCell.who(), "Method doesn't return RESELLER");
	}

	@Test
	@DisplayName("Testing rule 3.a")
	void testNext1() {
		Town t1 = new Town(2, 2);
		Reseller r1 = new Reseller(t1, 0, 0);
		t1.addCell(r1, r1.getRow(), r1.getCol());
		
		t1.addCell(new Empty(t1, 1, 0), 1, 0);
		t1.addCell(new Casual(t1, 1, 1), 1, 1);
		t1.addCell(new Casual(t1, 0, 1), 0, 1);
		
		r1.census(r1.nCensus);
		
		assertEquals(State.EMPTY, r1.next(new Town(2, 2)).who(), "Method doesn't return EMPTY");
	}
	
	@Test
	@DisplayName("Testing rule 3.b EMPTY only")
	void testNext2a() {
		Town t2 = new Town(2, 2);
		Reseller r2 = new Reseller(t2, 0, 0);
		t2.addCell(r2, r2.getRow(), r2.getCol());
		
		t2.addCell(new Empty(t2, 1, 0), 1, 0);
		t2.addCell(new Empty(t2, 1, 1), 1, 1);
		t2.addCell(new Empty(t2, 0, 1), 0, 1);
		
		r2.census(r2.nCensus);
		
		assertEquals(State.EMPTY, r2.next(new Town(2, 2)).who(), "Method doesn't return EMPTY");
	}
	
	@Test
	@DisplayName("Testing rule 3.b OUTAGE only")
	void testNext2b() {
		Town t3 = new Town(2, 2);
		Reseller r3 = new Reseller(t3, 0, 0);
		t3.addCell(r3, r3.getRow(), r3.getCol());
		
		t3.addCell(new Outage(t3, 1, 0), 1, 0);
		t3.addCell(new Outage(t3, 1, 1), 1, 1);
		t3.addCell(new Outage(t3, 0, 1), 0, 1);
		
		r3.census(r3.nCensus);
		
		assertEquals(State.EMPTY, r3.next(new Town(2, 2)).who(), "Method doesn't return EMPTY");
	}
	
	@Test
	@DisplayName("Testing rule 3.b MIXED")
	void testNext2c() {
		Town t4 = new Town(2, 2);
		Reseller r4 = new Reseller(t4, 0, 0);
		t4.addCell(r4, r4.getRow(), r4.getCol());
		
		t4.addCell(new Empty(t4, 1, 0), 1, 0);
		t4.addCell(new Outage(t4, 1, 1), 1, 1);
		t4.addCell(new Empty(t4, 0, 1), 0, 1);
		
		r4.census(r4.nCensus);
		
		assertEquals(State.EMPTY, r4.next(new Town(2, 2)).who(), "Method doesn't return EMPTY");
	}
	
	@Test
	@DisplayName("Testing rule 6.b")
	void testNext3() {
		Town t5 = new Town(3,3);
		Reseller r5 = new Reseller(t5, 1, 1);
		t5.addCell(r5, r5.getRow(), r5.getCol());
		t5.addCell(new Streamer(t5, 0, 0), 0, 0);
		t5.addCell(new Casual(t5, 0, 1), 0, 1);
		t5.addCell(new Streamer(t5, 0, 2), 0, 2);
		
		t5.addCell(new Casual(t5, 1, 0), 1, 0);
		t5.addCell(new Casual(t5, 1, 2), 1, 2);
		t5.addCell(new Casual(t5, 2, 0), 2, 0);
		t5.addCell(new Casual(t5, 2, 1), 2, 1);
		t5.addCell(new Casual(t5, 2, 2), 2, 2);

		
		r5.census(r5.nCensus);
		assertEquals(State.STREAMER, r5.next(new Town(3,3)).who(), "Method doesn't return STREAMER");
	}
	
	@Test
	@DisplayName("Testing default")
	void testNext4() {
		Town t6 = new Town(2, 2);
		Reseller r6 = new Reseller(t6, 0, 0);
		t6.addCell(r6, r6.getRow(), r6.getCol());
		
		t6.addCell(new Casual(t6, 1, 0), 1, 0);
		t6.addCell(new Casual(t6, 1, 1), 1, 1);
		t6.addCell(new Casual(t6, 0, 1), 0, 1);
		
		r6.census(r6.nCensus);
		
		assertEquals(State.EMPTY, r6.next(new Town(2, 2)).who(), "Method doesn't return STREAMER");
	}
}
