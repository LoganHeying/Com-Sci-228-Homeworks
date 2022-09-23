package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ISPBusinessTest {

	@Test
	void testUpdatePlain() {
		Town t1 = new Town(2, 2);
		t1.randomInit(6541);
		
		String actualTown = "E R \nS E \n";
		
		assertEquals(actualTown, ISPBusiness.updatePlain(t1).toString(), "Method doesn't return the same town configuration");
	}

	@Test
	void testGetProfit() {
		Town t = new Town(2, 2);
		
		t.addCell(new Casual(t, 0,0), 0, 0);
		t.addCell(new Empty(t, 0,1), 0, 1);
		t.addCell(new Casual(t, 0,1), 1, 0);
		t.addCell(new Casual(t, 1,1), 1, 1);
		
		assertEquals(3, ISPBusiness.getProfit(t), "Method doesn't return 3 for 2x2 town with 3 C");
	}

}
