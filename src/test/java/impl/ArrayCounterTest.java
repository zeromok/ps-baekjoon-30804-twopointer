package impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayCounterTest {

	@Test
	void 문제_예제() {
		// G
		int[] fruits1 = {5, 1, 1, 2, 1};
		int[] fruits2 = {1, 1, 1};
		int[] fruits3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		// W
		int result1 = ArrayCounter.getMaxLength(fruits1);
		int result2 = ArrayCounter.getMaxLength(fruits2);
		int result3 = ArrayCounter.getMaxLength(fruits3);

		// T
		assertEquals(4, result1);
		assertEquals(3, result2);
		assertEquals(2, result3);
	}

	@Test
	void 타입_한개() {
		// G
		int[] fruits = {1, 1, 1, 1};

		// W
		int result = ArrayCounter.getMaxLength(fruits);

		// T
		assertEquals(4, result);
	}

	@Test
	void 타입_두개() {
		// G
		int[] fruits = {1, 2, 1, 2, 1, 2};

		// W
		int result = ArrayCounter.getMaxLength(fruits);

		// T
		assertEquals(6, result);
	}

	@Test
	void 과일_하나() {
		// G
		int[] fruits = {1};

		// W
		int result = ArrayCounter.getMaxLength(fruits);

		// T
		assertEquals(1, result);
	}
}