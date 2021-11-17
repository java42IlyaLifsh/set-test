package telran.util;
//HW_12 IlyaL
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

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
	
	
	
	private <T> T[] getArrayFromSet(Set<T> set) {
		T[] resArr = (T[]) new Object[set.size()];
		Iterator<T> itr = set.iterator();
		int index = 0;
		//[YG] the while loop for iterating usually used only if there is removing inside. If no removing for-each construction is more professional
		while(itr.hasNext()) {
			resArr[index++] = itr.next();
		}
		return resArr;
	}
	private <T> Set<T> createSetFromArray(T[] array) {
		Set<T> resSet = new TreeSet<>();
		for(T value : array) {
			resSet.add(value);
		}
		return resSet;
	}
	
	
	@Test
	
	void iteratorTreeSetTest() {
		
		set.add(-11);
		set.add(17);
		set.add(-7);
		
		
		Integer arr1[] = { -11, 17, -7, 10, 20, 40, 60};
		Arrays.sort(arr1); //[YG] no sense to sort expected arr1 (you might define it already sorted)
		assertArrayEquals(arr1, getArrayFromSet(set));
		
		Integer arr2[] = { -11, 17, -7, 10, 20, 40 , 60};
		Set<Integer> setTemp = createSetFromArray(arr2);
		Arrays.sort(arr2);
		assertArrayEquals(arr2, getArrayFromSet(setTemp));
		
	}
	
}
