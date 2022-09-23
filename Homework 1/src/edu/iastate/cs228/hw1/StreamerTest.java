package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StreamerTest {

	@Test
	void testWho() {
		Streamer testCell = new Streamer(new Town(1, 1), 0, 0);
		
		assertEquals(State.STREAMER, testCell.who(), "Method doesn't return STREAMER");
	}

	@Test
	@DisplayName("Testing rule 2.a")
	void testNext1() {
		Town t1 = new Town(2, 2);
		Streamer s1 = new Streamer(t1, 0, 0);
		t1.addCell(s1, s1.getRow(), s1.getCol());
		
		t1.addCell(new Reseller(t1, 0, 1), 0, 1);
		t1.addCell(new Empty(t1, 1, 1), 1, 1);
		t1.addCell(new Empty(t1, 1, 0), 1, 0);
		
		s1.census(s1.nCensus);
		
		assertEquals(State.OUTAGE, s1.next(new Town(2,2)).who(), "Method deosn't return OUTAGE");
	}

	@Test
	@DisplayName("Testing rule 2.b")
	void testNext2() {
		Town t2 = new Town(2, 2);
		Streamer s2 = new Streamer(t2, 0, 0);
		t2.addCell(s2, s2.getRow(), s2.getCol());
		
		t2.addCell(new Outage(t2, 0, 1), 0, 1);
		t2.addCell(new Empty(t2, 1, 1), 1, 1);
		t2.addCell(new Empty(t2, 1, 0), 1, 0);
		
		s2.census(s2.nCensus);
		
		assertEquals(State.EMPTY, s2.next(new Town(2,2)).who(), "Method deosn't return EMPTY");
	}
	
	@Test
	@DisplayName("Testing rule 6.a")
	void testNext3() {
		Town t3 = new Town(2, 2);
		Streamer s3 = new Streamer(t3, 0, 0);
		t3.addCell(s3, s3.getRow(), s3.getCol());
		
		t3.addCell(new Casual(t3, 1, 0), 1, 0);
		t3.addCell(new Casual(t3, 0, 1), 0, 1);
		t3.addCell(new Casual(t3, 1, 1), 1, 1);
		s3.census(s3.nCensus);
		
		assertEquals(State.RESELLER, s3.next(new Town(2,2)).who(), "Method doesn't return RESELLER");
	}
	
	@Test
	@DisplayName("Testing rule 6.b")
	void testNext4() {
		Town t4 = new Town(3,3);
		Streamer s4 = new Streamer(t4, 1, 1);
		t4.addCell(s4, s4.getRow(), s4.getCol());
		t4.addCell(new Empty(t4, 0, 0), 0, 0);
		t4.addCell(new Empty(t4, 0, 1), 0, 1);
		t4.addCell(new Streamer(t4, 0, 2), 0, 2);
		
		t4.addCell(new Casual(t4, 1, 0), 1, 0);
		t4.addCell(new Casual(t4, 1, 2), 1, 2);
		t4.addCell(new Casual(t4, 2, 0), 2, 0);
		t4.addCell(new Casual(t4, 2, 1), 2, 1);
		t4.addCell(new Casual(t4, 2, 2), 2, 2);

		
		s4.census(s4.nCensus);
		assertEquals(State.STREAMER, s4.next(new Town(3,3)).who(), "Method doesn't return STREAMER");
	}
	
	@Test
	@DisplayName("Testing default")
	void testNext5() {
		Town t5 = new Town(2, 2);
		Streamer s5 = new Streamer(t5, 0, 0);
		t5.addCell(s5, s5.getRow(), s5.getCol());
		
		t5.addCell(new Empty(t5, 0, 1), 0, 1);
		t5.addCell(new Empty(t5, 1, 1), 1, 1);
		t5.addCell(new Streamer(t5, 1, 0), 1, 0);
		
		s5.census(s5.nCensus);
		
		assertEquals(State.STREAMER, s5.next(new Town(3,3)).who(), "Method doesn't return Streamer");
	}
}
