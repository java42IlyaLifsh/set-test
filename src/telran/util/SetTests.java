package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTests {
Integer[] initialNumbers = {
	10, 20, 40, 60	
};
Set<Integer> set;
	@BeforeEach
	void setUp() throws Exception {
		set = new TreeSet<>();
		fillSet();
	}

	private void fillSet() {
		for(Integer num: initialNumbers) {
			set.add(num);
		}
		
	}

	@Test
	void addTest() {
		assertEquals(initialNumbers.length, set.size());
		for(Integer num: initialNumbers) {
			assertTrue(set.contains(num));
		}
		assertTrue(set.add(80));
		assertFalse(set.add(80));
		
	}
	@Test
	void containsTest() {
		assertTrue(set.contains(60));
		assertFalse(set.contains(80));
	}
	

}
