package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TownCellTest {
	public Town getTestTown()
	{
		Town tester = new Town(3,3);
		
		tester.addCell(new Casual(tester, 0, 0), 0, 0);
		tester.addCell(new Streamer(tester, 1, 0), 1, 0);
		tester.addCell(new Casual(tester, 2, 0), 2, 0);
		tester.addCell(new Streamer(tester, 0, 1), 0, 1);
		tester.addCell(new Outage(tester, 1, 1), 1, 1);
		tester.addCell(new Empty(tester, 2, 1), 2, 1);
		tester.addCell(new Reseller(tester, 0, 2), 0, 2);
		tester.addCell(new Empty(tester, 1, 2), 1, 2);
		tester.addCell(new Outage(tester, 2, 2), 2, 2);
		
		return tester;
	}
	
	@Test
	@DisplayName("Testing census() when centered cell")
	void testCensus1() {
		Town t1 = getTestTown();
		int[] actualCensus = {1, 2, 2, 1, 2};
		t1.getTown()[1][1].census(t1.getTown()[1][1].nCensus);
		int[] recievedCensus = t1.getTown()[1][1].nCensus;
		assertArrayEquals(actualCensus, recievedCensus , "Method didn't count census correctly");
	}
	
	@Test
	@DisplayName("Testing census() when corner cell")
	void testCensus2() {
		Town t1 = getTestTown();
		int[] actualCensus = {0, 0, 0, 1, 2};
		t1.getTown()[0][0].census(t1.getTown()[0][0].nCensus);
		int[] recievedCensus = t1.getTown()[0][0].nCensus;
		assertArrayEquals(actualCensus, recievedCensus , "Method didn't count census correctly");
	}
	
	@Test
	@DisplayName("Testing census() when wall cell")
	void testCensus3() {
		Town t1 = getTestTown();
		int[] actualCensus = {1, 1, 1, 1, 1};
		t1.getTown()[0][1].census(t1.getTown()[0][1].nCensus);
		int[] recievedCensus = t1.getTown()[0][1].nCensus;
		assertArrayEquals(actualCensus, recievedCensus , "Method didn't count census correctly");
	}

	@Test
	void testGetRow() {
		Town t = new Town(1039, 1891);
		Empty c1 = new Empty(t, 389, 1093);
		
		assertEquals(389, c1.getRow(), "Didn't return the correct number of rows");
	}
	
	@Test
	void testGetCol() {
		Town t = new Town(1389, 3289);
		Empty c2 = new Empty(t, 230, 3239);
		
		assertEquals(3239, c2.getCol(), "Didn't return the correct number of rows");
	}
	
	@Test
	void testPrintCensus() {
		Town t = new Town(3819, 24098); 
		Empty c3 = new Empty(t, 190, 3289);
		
		c3.nCensus[0] = 6;
		c3.nCensus[1] = 1;
		c3.nCensus[2] = 0;
		c3.nCensus[3] = 0;
		c3.nCensus[4] = 1;
		
		String actualString = "Reseller - " + TownCell.nCensus[0] 
				+ "\nEmpty - " + TownCell.nCensus[1] 
				+ "\nCasual - " + TownCell.nCensus[2] 
				+ "\nOutage - " + TownCell.nCensus[3]
				+ "\nStreamer - " + TownCell.nCensus[4];
		
		assertEquals(actualString, c3.printCensus(), "Method didn't correctly print census");
	}	
}
