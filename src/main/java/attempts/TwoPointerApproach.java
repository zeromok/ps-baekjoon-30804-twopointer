package attempts;

import java.util.HashMap;
import java.util.Map;

import solution.Main;

/// ## 투포인터 접근법 구현
/// 투포인터 알고리즘의 기본 구현으로, 최종 솔루션({@link Main})과 동일한 로직을 사용
/// ### 시간복잡도: O(N)
/// ### 공간복잡도: O(K) (K 는 구간 내 최대 과일 종류 수)
public class TwoPointerApproach {


	/// 투포인터를 사용하여 최대 2종류의 과일을 포함하는 가장 긴 구간의 길이를 반환
	/// @param fruits 과일 배열
	/// @return 최대 2종류의 과일을 포함하는 가장 긴 구간의 길이 (최적해)
	public static int solve(int[] fruits) {
		Map<Integer, Integer> count = new HashMap<>();
		int left = 0;
		int maxLength = 0;

		for (int right = 0; right < fruits.length; right++) {
			count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);

			while (count.size() > 2) {
				int c = count.get(fruits[left]) - 1;
				if (c == 0) count.remove(fruits[left]);
				else count.put(fruits[left], c);
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}
}
