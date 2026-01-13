package attempts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GreedyApproachTest {
	@Test
	void 문제_예제() {
		// G
		int[] fruits1 = {5, 1, 1, 2, 1};
		int[] fruits2 = {1, 1, 1};
		int[] fruits3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		// W
		int result1 = GreedyApproach.solve(fruits1);
		int result2 = GreedyApproach.solve(fruits2);
		int result3 = GreedyApproach.solve(fruits3);

		// T
		assertEquals(4, result1);
		assertEquals(3, result2);
		assertEquals(2, result3);
	}


	@Test
	void 최적해_찾지못함() {
		// 이 케이스에서 그리디는 최적해를 찾지 못함
		// [1, 2, 3, 1, 2, 1]
		// 그리디: 양쪽 끝에서 제거 → [3, 1, 2, 1] (길이 4)
		// 투포인터: [1, 2, 1, 2, 1] 구간 선택 (길이 5)
		int[] fruits = {1, 2, 3, 1, 2, 1};

		int greedyResult = GreedyApproach.solve(fruits);
		int optimalResult = TwoPointerApproach.solve(fruits);

		System.out.println("그리디 결과: " + greedyResult);
		System.out.println("최적해: " + optimalResult);

		// 그리디는 최적해보다 작거나 같아야 함
		assertTrue(greedyResult <= optimalResult,
			"그리디는 최적해를 넘을 수 없음");

		// 이 케이스에서는 그리디가 최적해를 찾지 못함
		assertTrue(greedyResult < optimalResult,
			"그리디가 최적해를 찾지 못함: " + greedyResult + " < " + optimalResult);
	}

	@Test
	void 중간에_최적_구간() {
		// 중간에 최적 구간이 있는 경우
		// [1, 2, 3, 1, 1, 2, 1]
		// 그리디: 양쪽 끝 제거 → 중간 구간 놓침
		// 투포인터: [1, 1, 2, 1] 구간 (길이 4) 또는 [1, 2, 1, 1, 2, 1] (길이 6)
		int[] fruits = {1, 2, 3, 1, 1, 2, 1};

		int greedyResult = GreedyApproach.solve(fruits);
		int optimalResult = TwoPointerApproach.solve(fruits);

		System.out.println("그리디 결과: " + greedyResult);
		System.out.println("최적해: " + optimalResult);

		assertTrue(greedyResult < optimalResult,
			"중간 최적 구간을 놓침: " + greedyResult + " < " + optimalResult);
	}
}