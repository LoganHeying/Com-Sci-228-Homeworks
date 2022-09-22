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
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Test next() in situation of rule 1.b")
	void testNext2() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Test next() in situation of rule 6.a")
	void testNext3() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Test next() in situation of rule 6.b")
	void testNext4() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Test next() in situation of rule 6.b")
	void testNext5() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Test next() with no change in cell")
	void testNext6() {
		fail("Not yet implemented");
	}
}
