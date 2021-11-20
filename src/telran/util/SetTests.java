package telran.util;
//HW_13 IlyaL


import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTests {
private static final int N_RANDOM_NUMBERS = 10000;
Integer[] initialNumbers = {
	10, 20, 40, 60, 5, 25, 3, 2, 4, 1	
};
Set<Integer> set;
	@BeforeEach
	void setUp() throws Exception {
		set = new TreeSet<>();
		fillSet();
	}

	private  void fillSet() {
		fillSetFromArray(set, initialNumbers);
		
		
	}
	@Test
	void removeRoot() {
		Integer expected[] = {
				1, 2, 3, 4, 5, 20, 25, 40, 60
		};
		set.remove(10);
		//assertArrayEquals(expected, getArrayFromSet(set));
	}
	
	@Test
	void removeJunction() {
		Integer expected[] = {
				1, 2,  4, 5, 10, 20, 25, 40, 60
		};
		set.remove(3);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeLeaf() {
		Integer expected[] = {
				 2, 3, 4, 5, 10, 20, 25, 40, 60
		};
		set.remove(1);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeNonJunctionRight() {
		Integer expected[] = {
				1, 2, 3, 4, 5, 10,  25, 40, 60
		};
		set.remove(20);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeNonJunctionLeft() {
		Integer expected[] = {
				1, 2, 3, 4,  10, 20, 25, 40, 60
		};
		set.remove(5);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeIfTest() {
		Integer randomNumbers[] = getRandomNumbers();
		Set<Integer> setNumbers = new TreeSet<>();
		fillSetFromArray(setNumbers, randomNumbers);
		setNumbers.removeIf(n -> n % 2 == 0);
		for(Integer num: setNumbers) {
			assertFalse(num % 2 == 0);
		}
	}
 
	private <T> void fillSetFromArray(Set<T> res, T[] array) {
		
		for(T num: array) {
			res.add(num);
		}
		
	}
	
	private Integer[] getRandomNumbers() {
		Integer[] res = new Integer[N_RANDOM_NUMBERS];
		for (int i = 0; i < res.length; i++) {
			res[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		return res;
		
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
	@Test
	void iteratorNoRemoveTest() {
		Integer[] randomNumbers = getRandomNumbers();
		Set<Integer> numbersSet = new TreeSet<>();
		fillSetFromArray(numbersSet, randomNumbers);
		Arrays.sort(randomNumbers);
		assertArrayEquals(randomNumbers, getArrayFromSet(numbersSet));
	}
	@Test
	void treeSetInsensitiveOrderTest () {
		 String strings[] = {"Boris", "Asaf", "android", "band"};
		 String expected[] = {"android", "Asaf", "band", "Boris"};
		 TreeSet<String> treeSet = new TreeSet<>((s1, s2)-> s1.compareToIgnoreCase(s2));
		 fillSetFromArray(treeSet, strings);
		 assertArrayEquals(expected, getArrayFromSet(treeSet));
	}
	@SuppressWarnings("unchecked")
	private <T> T[] getArrayFromSet(Set<T> set) {
		T res[] = (T[]) new Object[set.size()];
		int ind = 0;
		for(T obj: set) {
			res[ind++] = obj;
		}
		return res;
	}
	@Test
	void removeAllTest () {
		Set <Integer> others = new TreeSet <> ();
		others.add(4);
		others.add(25);
		Integer expected[]= {1,2,3,5,10,20,40,60};
		set.removeAll(others);
		assertArrayEquals (expected, getArrayFromSet(set));
		
	}
	@Test
	void removeAllSameTest() {
		assertTrue (set.removeAll(set));
		assertArrayEquals (new Integer[0], getArrayFromSet(set));
	}
	@Test
	void clearTest() {
		set.clear();
		assertArrayEquals (new Integer[0], getArrayFromSet(set));
	}
	
	@Test
	void retainAllTest() {
		Set<Integer> other = new TreeSet<>();
		other.add(10);
		other.add(20);
		Integer expected[] = {10, 20};
		set.retainAll(other);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	
	@Test
	void retainAllSameTest() {
		Arrays.sort(initialNumbers);
		set.retainAll(set);
		assertArrayEquals(initialNumbers, getArrayFromSet(set));
	}
 
}