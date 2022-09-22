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
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Testing rule 6.b")
	void testNext2() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Testing default")
	void testNext3() {
		fail("Not yet implemented");
	}
}
